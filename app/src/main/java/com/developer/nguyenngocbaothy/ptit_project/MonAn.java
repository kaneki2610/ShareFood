package com.developer.nguyenngocbaothy.ptit_project;

/**
 * Created by HOME on 23-Feb-18.
 */

public class MonAn {
    private String tenMonAn;
    private int hinh;

    public MonAn(String tenMonAn, int hinh) {
        this.tenMonAn = tenMonAn;
        this.hinh = hinh;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
