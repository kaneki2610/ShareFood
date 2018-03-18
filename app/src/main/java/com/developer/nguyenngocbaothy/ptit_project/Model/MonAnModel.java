package com.developer.nguyenngocbaothy.ptit_project.Model;

import java.io.Serializable;

/**
 * Created by Dell on 3/12/2018.
 */

public class MonAnModel  {
    private String TenMon;
    private int HinhAnh;
    public MonAnModel(){}
    public MonAnModel(String tenMon, int hinhAnh) {
        TenMon = tenMon;
        HinhAnh = hinhAnh;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
