/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhom4
 */
public class StudentDAO {

    public boolean addSinhVien(Student sinhVien) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            String sql = "INSERT INTO sinhvien (`MaSV`, `TenSV`, `MatKhau`, `NgaySinh`, `NoiSinh`, `Lop`, `Khoa`, `MaQuyenTruyCap`) VALUES(?,?,?,?,?,?,?,?)";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, sinhVien.getMaSV());
                ps.setString(2, sinhVien.getTenSV());
                ps.setString(3, sinhVien.getMatKhau());
                ps.setString(4, sinhVien.getNgaySinh());
                ps.setString(5, sinhVien.getNoiSinh());
                ps.setString(6, sinhVien.getLop());
                ps.setString(7, sinhVien.getKhoa());
                ps.setInt(8, sinhVien.getQuyenTruyCap());
                int soDongBiThayDoi = ps.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, null, ps);
            }
        }
        return false;
    }

    public Student dangNhap(String maSVDangNhap, String matKhauDangNhap) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection != null) {
            String sql = "SELECT * FROM sinhvien WHERE MaSV = ? AND MatKhau =?";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, maSVDangNhap);
                ps.setString(2, matKhauDangNhap);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String ma = rs.getString(1);
                    String ten = rs.getString(2);
                    String matKhau = rs.getString(3);
                    String ngaySinh = rs.getString(4);
                    String noiSinh = rs.getString(5);
                    String lop = rs.getString(6);
                    String khoa = rs.getString(7);
                    int maQuyen = rs.getInt(8);
                    Student sinhVien = new Student(ma, ten, matKhau, ngaySinh, noiSinh, lop, khoa, maQuyen);
                    return sinhVien;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, rs, ps);
            }
        }
        return null;
    }

    public ArrayList<Student> layDanhSachSinhVien() {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection != null) {
            ArrayList<Student> dsSV = new ArrayList<>();
            String sql = "SELECT * FROM sinhvien";
            try {
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String ma = rs.getString("MaSV");
                    if (ma.equals("admin")) {
                        continue;
                    }
                    String matKhau = rs.getString("MatKhau");
                    String ten = rs.getString("TenSV");
                    String ngaySinh = rs.getString("NgaySinh");
                    String noiSinh = rs.getString("NoiSinh");
                    String lop = rs.getString("Lop");
                    String khoa = rs.getString("Khoa");
                    int maQuyenTruyCap = rs.getInt("MaQuyenTruyCap");
                    Student sinhVien = new Student(ma, ten, matKhau, ngaySinh, noiSinh, lop, khoa, maQuyenTruyCap);
                    dsSV.add(sinhVien);
                }
                return dsSV;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, rs, ps);
            }
        }
        return null;
    }

    public boolean updateSV(Student sinhVien) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            String sql = "UPDATE `sinhvien` SET `TenSV`=?,`MatKhau`=?,`NgaySinh`=?,`NoiSinh`=?,`Lop`=?,`Khoa`=? WHERE MaSV=?";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, sinhVien.getTenSV());
                ps.setString(2, sinhVien.getMatKhau());
                ps.setString(3, sinhVien.getNgaySinh());
                ps.setString(4, sinhVien.getNoiSinh());
                ps.setString(5, sinhVien.getLop());
                ps.setString(6, sinhVien.getKhoa());
                ps.setString(7, sinhVien.getMaSV());
                int soDongBiThayDoi = ps.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, null, ps);
            }
        }
        return false;
    }

    public boolean xoaSV(String ma) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            String sql = "DELETE FROM `sinhvien` WHERE  sinhvien.MaSV = ?";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, ma);
                int soDongBiThayDoi = ps.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, null, ps);
            }
        }
        return false;
    }

    public Student laySVTheoMa(String ma) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                String sql = "SELECT * FROM `sinhvien` WHERE  MaSV = ?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, ma);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String masv = rs.getString("MaSV");
                    String tenSV = rs.getString("TenSV");
                    String mk = rs.getString("MatKhau");
                    String ngaysinh = rs.getString("NgaySinh");
                    String noisinh = rs.getString("NoiSinh");
                    String lop = rs.getString("Lop");
                    String khoa = rs.getString("Khoa");
                    Student sinhVien = new Student(masv, tenSV, mk, ngaysinh, noisinh, lop, khoa);
                    return sinhVien;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, rs, ps);
            }
        }
        return null;
    }

}
