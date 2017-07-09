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
public class TempMarks {

    private Student sinhVien;
    private Subject monHoc;
    private float diem;

    public TempMarks() {
    }

    public TempMarks(Student sinhVien, Subject monHoc, float diem) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = diem;
    }

    public Student getSinhVien() {
        return sinhVien;
    }

    public Subject getMonHoc() {
        return monHoc;
    }

    public float getDiem() {
        return diem;
    }

    public void setSinhVien(Student sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void setMonHoc(Subject monHoc) {
        this.monHoc = monHoc;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

}
