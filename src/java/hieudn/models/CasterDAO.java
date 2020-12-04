/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.models;

import hieudn.db.MyConnection;
import hieudn.dtos.CasterDTO;
import hieudn.dtos.RegistrationDTOTake;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class CasterDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public CasterDAO() {
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

    public List<CasterDTO> findByLikeTime(String username) throws Exception {
        List<CasterDTO> result = null;
        String fullname, picture, part, shotname;
        Date start, end;
        CasterDTO dto;
        try {
            String sql = "SELECT A.Username, A.Fullname, A.Picture, AC.Part, T.ShotName, T.ShotStartDate, T.ShotEndDate"
                    + " FROM Take T, AccShot AC, Account A WHERE T.IdShot = AC.IdShot AND AC.Username = A.Username AND A.Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            System.out.println(result.toString() + "alabama");
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                picture = rs.getString("Picture");
                part = rs.getString("Part");
                shotname = rs.getString("ShotName");
                start = rs.getDate("ShotStartDate");
                end = rs.getDate("ShotEndDate");
                dto = new CasterDTO(username, fullname, picture, part, shotname, start, end);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
