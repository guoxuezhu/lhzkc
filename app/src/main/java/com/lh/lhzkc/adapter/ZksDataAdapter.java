package com.lh.lhzkc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lh.lhzkc.R;
import com.lh.lhzkc.data.ZksInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZksDataAdapter extends RecyclerView.Adapter<ZksDataAdapter.ZksInfoViewHolder> {

    private Context mContext;
    private List<ZksInfo> datas;
    private CallBack mCallBack;

    public ZksDataAdapter(Context context, List<ZksInfo> data, CallBack callBack) {
        this.datas = data;
        this.mContext = context;
        this.mCallBack = callBack;
    }

    @NonNull
    @Override
    public ZksInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zks_info_item, parent, false);
        return new ZksInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZksInfoViewHolder holder, int position) {
        ZksInfo zksInfo = datas.get(position);
        holder.tv_zks_name.setText(zksInfo.zkname);
        holder.tv_zks_ip.setText(zksInfo.zkip);
        holder.tv_zks_status.setText(zksInfo.zkstatus);
        holder.setItem(zksInfo);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void setDatas(List<ZksInfo> zksInfos) {
        datas = zksInfos;
        notifyDataSetChanged();
    }

    public interface CallBack {
        void OnClickItem(ZksInfo zksInfo, boolean isNeiwang);
    }

    public class ZksInfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_zks_name)
        TextView tv_zks_name;
        @BindView(R.id.tv_zks_ip)
        TextView tv_zks_ip;
        @BindView(R.id.tv_zks_status)
        TextView tv_zks_status;

        private ZksInfo item;

        public ZksInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setItem(ZksInfo zksInfo) {
            item = zksInfo;
        }

        @OnClick(R.id.btn_nei_wang)
        public void btn_nei_wang() {
            mCallBack.OnClickItem(item, true);
        }

        @OnClick(R.id.btn_wai_wang)
        public void btn_wai_wang() {
            mCallBack.OnClickItem(item, false);
        }


    }
}
