package com.lh.lhzkc.data;

import com.lh.lhzkc.data.remote.MvpService;
import com.lh.lhzkc.exception.ClientRuntimeException;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by gxz
 */
@Singleton
public class MvpClient {

    public static final int TIME_HANDLER = 1;
    @SuppressWarnings("unchecked")
    private static ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return ((Observable<HttpResult>) upstream).subscribeOn(Schedulers.io())
                    .timeout(30, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(httpResult -> {

                        if (!httpResult.code.equals("200")) {
                            throw Exceptions.propagate(new ClientRuntimeException(httpResult.code,
                                    httpResult.msg));
                        }
                    });
        }
    };

    private MvpService mvpService;

    @Inject
    public MvpClient(MvpService mvpService) {
        this.mvpService = mvpService;
    }

    @SuppressWarnings("unchecked")
    private static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }


}
