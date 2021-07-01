package com.lh.lhzkc.data;

public class ZksInfo {

    public String zkname;

    public String zkip;

    public String zkstatus;

    public ZksInfo(String zkname, String zkip, String zkstatus) {
        this.zkname = zkname;
        this.zkip = zkip;
        this.zkstatus = zkstatus;
    }

    @Override
    public String toString() {
        return "ZksInfo{" +
                "zkname='" + zkname + '\'' +
                ", zkip='" + zkip + '\'' +
                ", zkstatus='" + zkstatus + '\'' +
                '}';
    }
}
