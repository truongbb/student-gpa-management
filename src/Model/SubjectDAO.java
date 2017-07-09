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
public class SubjectDAO {

    public boolean addMonHoc(Subject monHoc) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            String sql = "INSERT INTO monhoc (`MaMonHoc`, `TenMonHoc`, `Khoa`, `SoTinChi`) VALUES(?,?,?,?)";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, monHoc.getMaMon());
                ps.setString(2, monHoc.getTenMon());
                ps.setString(3, monHoc.getKhoa());
                ps.setInt(4, monHoc.getSoTinChi());
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

    public ArrayList<Subject> layDanhSachMonHoc() {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection != null) {
            String sql = "SELECT * FROM monhoc";
            try {
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();
                ArrayList<Subject> dsMH = new ArrayList<>();
                while (rs.next()) {
                    String ma = rs.getString("MaMonHoc");
                    String tenM = rs.getString("TenMonHoc");
                    int soTC = rs.getInt("SoTinChi");
                    String khoa = rs.getString("Khoa");
                    Subject monHoc = new Subject(ma, tenM, khoa, soTC);
                    dsMH.add(monHoc);
                }
                return dsMH;
            } catch (SQLException ex) {
                Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, rs, ps);
            }
        }
        return null;
    }

    public boolean xoaMH(String ma) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            String sql = "DELETE FROM `monhoc` WHERE  MaMonHoc = ?";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, ma);
                int soDongBiThayDoi = ps.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, null, ps);
            }
        }
        return false;
    }

    public Subject layMHTheoMa(String ma) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection != null) {
            String sql = "SELECT * FROM `monhoc` WHERE  MaMonHoc = ?";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, ma);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String mamh = rs.getString("MaMonHoc");
                    String tenMH = rs.getString("TenMonHoc");
                    String khoa = rs.getString("Khoa");
                    int soTinChi = rs.getInt("SoTinChi");
                    Subject monHoc = new Subject(mamh, tenMH, khoa, soTinChi);
                    return monHoc;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DatabaseConnection.closeDatabase(connection, rs, ps);
            }
        }
        return null;
    }

    public boolean update(Subject monHoc) {
        Connection connection = DatabaseConnection.openDatabase();
        PreparedStatement ps = null;
        if (connection != null) {
            try {
                String sql = "UPDATE `monhoc` SET `TenMonHoc`=?,`Khoa`=?,`SoTinChi`=? WHERE `MaMonHoc`=?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, monHoc.getTenMon());
                ps.setString(2, monHoc.getKhoa());
                ps.setInt(3, monHoc.getSoTinChi());
                ps.setString(4, monHoc.getMaMon());
                int soDongBiThayDoi = ps.executeUpdate();
                return soDongBiThayDoi > 0;
            } catch (SQLException ex) {
                Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
