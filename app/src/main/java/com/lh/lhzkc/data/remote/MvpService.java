package com.lh.lhzkc.data.remote;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lh.lhzkc.BuildConfig;
import com.lh.lhzkc.utils.Coder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gxz
 */
public interface MvpService {


    final String URLIP = "192.168.31.180";
    final String ENDPOINT = "http://" + URLIP + "/api/";

    final String TIME_STAMP_HEADER = "timestamp";
    final String CLIENT_ID_HEADER = "clientId";
    final String CLIENT_ID_KEY = "client_id";
    final String CLIENT_ID = "SWQxcGJxM2RrRkoyOTAxNGU";
    final String APPKEY_TOKEN = "S2V5MzY3MDg5YTBkMWRiNDlmZmI0NzY4Yzg3MzdjMzlkOWU";
    final String ACCEPT_HEADER = "Accept: application/json";
    final String UA_HEADER = "User-Agent: Retrofit-ecampus-App";
    final String SIGNSEAT_HEADER = "signSeat: HEADER";
    final String SIGN_HEADER = "sign";


    final String CONTENT_CHECKSUM_HEADER = "Content-Checksum";
    final String SKIP_SIGN_HEADER_NAME = "X-SkipSign";
    final String SKIP_SIGN_HEADER = "X-SkipSign: true";
    static final String JSON_CONTENT_TYPE = "application/json";


    final String TOKEN_HEADER = "X-Token";
    final String DEVICEID_HEADER = "X-DeviceId";


    /********
     * Factory class that sets up a new ribot services
     *******/
    class Factory {
        static final int CONNECTION_TIMEOUT_MS = 60 * 1000;
        static final int SOCKET_READ_TIMEOUT_MS = 60 * 1000;

        public static void setDeviceId(int deviceId) {
            MvpService.Factory.HeaderSignagureInterceptor.setDeviceId(deviceId);
        }

        public static MvpService makeRibotService(Context context) {
            OkHttpClient.Builder builer = new OkHttpClient.Builder()
                    .connectTimeout(CONNECTION_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                    .readTimeout(SOCKET_READ_TIMEOUT_MS, TimeUnit.MILLISECONDS);

            // add auth header
            builer.interceptors().add(new MvpService.Factory.HeaderSignagureInterceptor());


            //okHttpClient.interceptors().add();

            // add log interceptor
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                    : HttpLoggingInterceptor.Level.NONE);
            builer.interceptors().add(logging);

            OkHttpClient okHttpClient = builer.build();


            Gson gson = new GsonBuilder()
                    .disableHtmlEscaping()
                    .setPrettyPrinting()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MvpService.ENDPOINT)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(MvpService.class);
        }

        static final class HeaderSignagureInterceptor implements Interceptor {

            static int deviceId;
            //static String token = "";

            public static void setDeviceId(int dvId) {
                deviceId = dvId;
            }

            private static String generateQueryString(Map<String, String> params) {
                if (params == null || params.isEmpty()) {
                    return null;
                }
                StringBuffer buffer = new StringBuffer();
                List<String> keys = new ArrayList<String>(params.keySet());
                Collections.sort(keys);
                for (String key : keys) {
                    String value = params.get(key);
                    if (null == value) {
                        value = "";
                    }
                    value = getUtf8EscapedString(value);
                    buffer.append("&").append(key).append("=").append(value);
                }
                return buffer.substring(1);
            }

            public static String getUtf8EscapedString(String input) {
                String result = null;
                try {
                    result = URLEncoder.encode(input, "utf8");
                } catch (UnsupportedEncodingException e) {
                    return null;
                }
                return result;
            }

            private static String mapToCheckSum(Map<String, String> querys) {
                String queryString = generateQueryString(querys) + APPKEY_TOKEN;
                try {
                    return Coder.hashMD5(queryString.getBytes("utf8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            }

            private static String bodyCheckSum(final Request request) {
                String returnVal = "";
                final Buffer buffer = new Buffer();
                try {
                    request.body().writeTo(buffer);
                    InputStream input = buffer.inputStream();
                    MessageDigest md5Hash = MessageDigest.getInstance("MD5");
                    int numRead = 0;
                    byte[] buf = new byte[1024];
                    while (numRead != -1) {
                        numRead = input.read(buf);
                        if (numRead > 0) {
                            md5Hash.update(buf, 0, numRead);
                        }
                    }
                    input.close();

                    byte[] md5Bytes = md5Hash.digest();
                    for (int i = 0; i < md5Bytes.length; i++) {
                        returnVal += Integer.toString((md5Bytes[i] & 0xff) + 0x100, 16).substring(1);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return returnVal;
            }

            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();

                final Request req = chain.request();
                final String timeStamp = String.valueOf(System.currentTimeMillis() / 1000l);

                Map<String, String> queryParameters = new HashMap<>();
                queryParameters.put(TIME_STAMP_HEADER, timeStamp);
                newBuilder.addHeader(TIME_STAMP_HEADER, timeStamp);

                queryParameters.put(CLIENT_ID_KEY, CLIENT_ID);
                newBuilder.addHeader(CLIENT_ID_HEADER, CLIENT_ID);

                if (null == req.header(SKIP_SIGN_HEADER_NAME)) {
                    final HttpUrl httpUrl = req.url();
                    // put query parameter in map
                    final int queryParameterCounts = httpUrl.querySize();
                    for (int i = 0; i < queryParameterCounts; i++) {
                        final String key = httpUrl.queryParameterName(i);
                        final String value = httpUrl.queryParameterValue(i);
                        queryParameters.put(key, value);
                    }
                    newBuilder.addHeader(SIGN_HEADER, mapToCheckSum(queryParameters));
                } else {
                    newBuilder.removeHeader(SKIP_SIGN_HEADER_NAME);
                }

                return chain.proceed(newBuilder.build());
            }


        }


    }
}
