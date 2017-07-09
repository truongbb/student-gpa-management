/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.MarksForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nhom4
 */
public class MarksDAO extends JFrame {

    public static int maBangDiemTemp;
    public int maBangDiem;

    public MarksDAO() {
        maBangDiem = maBangDiemTemp;
        maBangDiemTemp++;
    }

    public boolean InsertDiem(Marks bangDiem) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement pre = null;
        ResultSet res = null;
        if (connection != null) {
            String sql = "INSERT INTO bangdiem VALUES (?, ?, ?, ?)";
            try {
                pre = connection.prepareStatement(sql);
                pre.setInt(1, maBangDiem);
                pre.setString(2, bangDiem.getSinhVien().getMaSV());
                for (int i = 0; i < bangDiem.getPairDMH().size(); i++) {
                    pre.setString(3, bangDiem.getPairDMH().get(i).getFirst().getMaMon());
                    pre.setFloat(4, bangDiem.getPairDMH().get(i).getSecond());
                }
                int soDongBiThayDoi = pre.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new MarksForm(), "Problems with database!");
            } finally {
                DatabaseConnection.closeDatabase(connection, res, pre);
            }
        }
        return false;
    }

    public TempMarks layThongTinTheoMa(String maSV, String maMH) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                String sql = "SELECT * FROM `bangdiem` WHERE MaSV = ? AND MaMonHoc = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, maSV);
                ps.setString(2, maMH);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String maSinhVien = rs.getString("MaSV");
                    String maMonHoc = rs.getString("MaMonHoc");
                    float diem = rs.getFloat("Diem");
                    TempMarks bangDiemTemp = new TempMarks(new StudentDAO().laySVTheoMa(maSinhVien),
                            new SubjectDAO().layMHTheoMa(maMonHoc), diem);
                    return bangDiemTemp;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new MarksForm(), "Problems with database!");
            } finally {
                DatabaseConnection.closeDatabase(connection, rs, ps);
            }
        }
        return null;
    }

    public boolean update(TempMarks bangDiemTemp) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            try {
                String sql = "UPDATE `bangdiem` SET `Diem` = ? WHERE `MaSV` = ? AND `MaMonHoc` = ?";
                ps = connection.prepareStatement(sql);
                ps.setFloat(1, bangDiemTemp.getDiem());
                ps.setString(2, bangDiemTemp.getSinhVien().getMaSV());
                ps.setString(3, bangDiemTemp.getMonHoc().getMaMon());
                int soDongBiThayDoi = ps.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new MarksForm(), "Problems with database!");
            } finally {
                DatabaseConnection.closeDatabase(connection, null, ps);
            }
        }
        return false;
    }

    public boolean xoa(TempMarks bangDiemTemp) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            try {
                String sql = "DELETE FROM `bangdiem` WHERE MaSV = ? AND MaMonHoc = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, bangDiemTemp.getSinhVien().getMaSV());
                ps.setString(2, bangDiemTemp.getMonHoc().getMaMon());
                int soDongBiThayDoi = ps.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new MarksForm(), "Problems with database!");
            } finally {
                DatabaseConnection.closeDatabase(connection, null, ps);
            }
        }
        return false;
    }

    public ArrayList<Marks> LayDanhSachChiTietDiem() {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement pre = null;
        ResultSet res = null;
        if (connection != null) {
            ArrayList<TempMarks> dsBangDiemTemp = new ArrayList<>();
            String sql = "SELECT * FROM bangdiem";
            try {
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()) {
                    String maSV = res.getString("MaSV");
                    StudentDAO sinhVienDAO = new StudentDAO();
                    Student sinhVien = sinhVienDAO.laySVTheoMa(maSV);
                    String maMH = res.getString("MaMonHoc");
                    SubjectDAO monHocDAO = new SubjectDAO();
                    Subject monHoc = monHocDAO.layMHTheoMa(maMH);
                    float diem = res.getFloat("Diem");
                    TempMarks chiTietDiemTemp = new TempMarks(sinhVien, monHoc, diem);
                    dsBangDiemTemp.add(chiTietDiemTemp);
                }
                maBangDiemTemp = dsBangDiemTemp.size() + 1;
                ArrayList<Marks> dsBangDiem = new ArrayList<>();
                for (int i = 0; i < dsBangDiemTemp.size(); i++) {
                    String maSV = dsBangDiemTemp.get(i).getSinhVien().getMaSV();
                    boolean coTrongDSChua = false;
                    for (int j = 0; j < dsBangDiem.size(); j++) {
                        if (maSV.equals(dsBangDiem.get(j).getSinhVien().getMaSV())) {// neu ma sinh vien trung thi them mon hoc va diem
                            coTrongDSChua = true;
                            Subject monHoc = dsBangDiemTemp.get(i).getMonHoc();
                            float diem = dsBangDiemTemp.get(i).getDiem();
                            Pair<Subject, Float> pairTemp = new Pair<>(monHoc, diem);
                            dsBangDiem.get(j).addMonHocVaDiem(monHoc, diem);

                        }
                    }
                    if (!coTrongDSChua) {
                        Marks bangDiem = new Marks();
                        bangDiem.setSinhVien(dsBangDiemTemp.get(i).getSinhVien());
                        bangDiem.addMonHocVaDiem(dsBangDiemTemp.get(i).getMonHoc(), dsBangDiemTemp.get(i).getDiem());
                        dsBangDiem.add(bangDiem);
                    }
                    dsBangDiemTemp.remove(i);// remove dong vua them
                    i = -1;// chay lai tu dau list
                }
                return dsBangDiem;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new MarksForm(), "Problems with database!");
            } finally {
                DatabaseConnection.closeDatabase(connection, res, pre);
            }
        }
        return null;
    }

    public ArrayList<TempMarks> LayDanhSachChiTietDiemTheoMa(String maSinhVien) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement pre = null;
        ResultSet res = null;
        if (connection != null) {
            ArrayList<TempMarks> dsBangDiemTemp = new ArrayList<>();
            try {
                String sql = "SELECT * FROM bangdiem WHERE MaSV = ?";
                pre = connection.prepareStatement(sql);
                pre.setString(1, maSinhVien);
                res = pre.executeQuery();
                while (res.next()) {
                    String maSV = res.getString("MaSV");
                    StudentDAO sinhVienDAO = new StudentDAO();
                    Student sinhVien = sinhVienDAO.laySVTheoMa(maSV);
                    String maMH = res.getString("MaMonHoc");
                    SubjectDAO monHocDAO = new SubjectDAO();
                    Subject monHoc = monHocDAO.layMHTheoMa(maMH);
                    float diem = res.getFloat("Diem");
                    TempMarks chiTietDiemTemp = new TempMarks(sinhVien, monHoc, diem);
                    dsBangDiemTemp.add(chiTietDiemTemp);
                }
                return dsBangDiemTemp;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new MarksForm(), "Problems with database!");
            } finally {
                DatabaseConnection.closeDatabase(connection, res, pre);
            }
        }
        return null;
    }

    public ArrayList<Pair<Student, Float>> tinhDiemTB() {
        ArrayList<Marks> dsDiem = LayDanhSachChiTietDiem();
        ArrayList<Pair<Student, Float>> dsDiemTB = new ArrayList<>();
        for (int i = 0; i < dsDiem.size(); i++) {
            float diemTB = 0;
            for (int j = 0; j < dsDiem.get(i).getPairDMH().size(); j++) {
                diemTB += dsDiem.get(i).getPairDMH().get(j).getSecond();
            }
            diemTB /= dsDiem.get(i).getPairDMH().size();
            Pair<Student, Float> newPair = new Pair<>(dsDiem.get(i).getSinhVien(), diemTB);
            dsDiemTB.add(newPair);
        }
        return dsDiemTB;
    }
}
