/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.models;

import hieudn.db.MyConnection;
import hieudn.dtos.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class RegistrationDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;
    HttpSession session;
    public RegistrationDAO() {
    }

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrationDTO checkLogin(String username, String password) throws Exception {
        RegistrationDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select Fullname, Part From Account Where Username = ? and PasswordAcc = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);

            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Part");
                dto = new RegistrationDTO(username, fullname, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<RegistrationDTO> findByLikeName(String search) throws Exception {
        List<RegistrationDTO> result = null;
        String username = null;
        String fullname = null;
        String descript = null;
        String phone = null;
        String email = null;
        String pic = null;
        String role = null;
        RegistrationDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Descript, Phone, Email, Picture, Part From Account Where Fullname LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                descript = rs.getString("Descript");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                pic = rs.getString("Picture");
                role = rs.getString("Part");
                dto = new RegistrationDTO(username, fullname, descript, phone, email, pic, role);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<RegistrationDTO> findByLikeRole(String search) throws Exception {
        List<RegistrationDTO> result = null;
        String username = null;
        String fullname = null;
        String descript = null;
        String phone = null;
        String email = null;
        String pic = null;
        String role = null;
        RegistrationDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Descript, Phone, Email, Picture, Part From Account Where Part LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                descript = rs.getString("Descript");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                pic = rs.getString("Picture");
                role = rs.getString("Part");
                dto = new RegistrationDTO(username, fullname, descript, phone, email, pic, role);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Account(Username, PasswordAcc, Fullname, Descript, Phone, Email, Picture, Part) values(?, ?, ?, ?, ?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUserName());
            preStm.setString(2, dto.getPasswordAcc());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getDescript());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getEmail());
            preStm.setString(7, dto.getPicture());
            preStm.setString(8, dto.getRole());
            check = preStm.executeUpdate() > 0;
        } finally {
            try {
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public boolean delete(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From Account Where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public RegistrationDTO findByPrimaryKey(String username) throws Exception {
        RegistrationDTO dto = null;
        try {
            String sql = "Select Fullname, Descript, Phone, Email, Picture, Part From Account Where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("Fullname");
                String descript = rs.getString("Descript");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String pic = rs.getString("Picture");
                String role = rs.getString("Part");
                dto = new RegistrationDTO(username, fullname, descript, phone, email, pic, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(RegistrationDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Account set PasswordAcc = ?, Fullname = ?, Descript = ?, Phone = ?, Email = ?, Picture = ?, Part = ? Where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPasswordAcc());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getDescript());
            preStm.setString(4, dto.getPhone());
            preStm.setString(5, dto.getEmail());
            preStm.setString(6, dto.getPicture());
            preStm.setString(7, dto.getRole());
            preStm.setString(8, dto.getUserName());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<RegistrationDTO> findByRoleCaster() throws Exception {
        List<RegistrationDTO> result = null;
        String username = null;
        String fullname = null;
        String descript = null;
        String phone = null;
        String email = null;
        String pic = null;
        String role = null;
        RegistrationDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Descript, Phone, Email, Picture, Part From Account Where Part = 'caster'";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                descript = rs.getString("Descript");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                pic = rs.getString("Picture");
                role = rs.getString("Part");
                dto = new RegistrationDTO(username, fullname, descript, phone, email, pic, role);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
