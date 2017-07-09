/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author nhom4
 */
public class Marks {

    private Student sinhVien;
    private ArrayList<Pair<Subject, Float>> pairDMH = new ArrayList<>();

    public Marks() {

    }

    public Marks(Student sinhVien, ArrayList<Pair<Subject, Float>> dsMHD) {
        this.sinhVien = sinhVien;
        this.pairDMH = dsMHD;

    }

    public Student getSinhVien() {
        return sinhVien;
    }

    public ArrayList<Pair<Subject, Float>> getPairDMH() {
        return pairDMH;
    }

    public void setSinhVien(Student sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void addMonHocVaDiem(Subject monHoc, float diem) {
        Pair<Subject, Float> pairTemp = new Pair<>(monHoc, diem);
        pairDMH.add(pairTemp);
    }

}
