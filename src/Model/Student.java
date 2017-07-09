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
public class Student {

    private String MaSV;
    private String TenSV;
    private String MatKhau;
    private String NgaySinh;
    private String NoiSinh;
    private String Lop;
    private String Khoa;
    private int quyenTruyCap;

    public Student() {
    }

    public Student(String MaSV, String TenSV, String MatKhau, String NgaySinh, String NoiSinh, String Lop, String Khoa) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.MatKhau = MatKhau;
        this.NgaySinh = NgaySinh;
        this.Lop = Lop;
        this.Khoa = Khoa;
        this.NoiSinh = NoiSinh;
    }

    public Student(String MaSV, String TenSV, String MatKhau, String NgaySinh, String NoiSinh, String Lop, String Khoa, int quyenTruyCap) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.MatKhau = MatKhau;
        this.NgaySinh = NgaySinh;
        this.NoiSinh = NoiSinh;
        this.Lop = Lop;
        this.Khoa = Khoa;
        this.quyenTruyCap = quyenTruyCap;
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getLop() {
        return Lop;
    }

    public String getKhoa() {
        return Khoa;
    }

    public String getNoiSinh() {
        return NoiSinh;
    }

    public int getQuyenTruyCap() {
        return quyenTruyCap;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "MaSV=" + MaSV + ", TenSV=" + TenSV + ", MatKhau=" + MatKhau + ", NgaySinh=" + NgaySinh + ", Lop=" + Lop + ", Khoa=" + Khoa + ", NoiSinh=" + NoiSinh + '}';
    }

}
