/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nhom4
 */
public class Subject {

    private String maMon;
    private String tenMon;
    private String khoa;
    private int soTinChi;

    public Subject() {
    }

    public Subject(String maMon, String tenMon, String khoa, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.khoa = khoa;
        this.soTinChi = soTinChi;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getKhoa() {
        return khoa;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "maMon=" + maMon + ", tenMon=" + tenMon + ", khoa=" + khoa + ", soTinChi=" + soTinChi + '}';
    }

}
