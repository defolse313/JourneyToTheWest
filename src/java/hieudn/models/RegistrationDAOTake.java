/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.models;

import hieudn.db.MyConnection;
import hieudn.dtos.RegistrationDTOTake;
import hieudn.dtos.RegistrationDTOTool;
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
public class RegistrationDAOTake implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public RegistrationDAOTake() {
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

    public List<RegistrationDTOTake> findByLikeName(String search) throws Exception {
        List<RegistrationDTOTake> result = null;
        String idShot;
        String shotName;
        String shotDescript;
        String shotLocation;
        int shotTimes;
        Date ShotStartDate, ShotEndDate;
        RegistrationDTOTake dto;
        try {
            String sql = "Select IdShot, ShotName, ShotDescript, ShotLocation, ShotStartDate, ShotEndDate, ShotTimes From Take Where ShotName LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                idShot = rs.getString("IdShot");
                shotName = rs.getString("ShotName");
                shotDescript = rs.getString("ShotDescript");
                shotLocation = rs.getString("ShotLocation");
                ShotStartDate = rs.getDate("ShotStartDate");
                ShotEndDate = rs.getDate("ShotEndDate");
                shotTimes = Integer.parseInt(rs.getString("ShotTimes"));
                shotDescript = rs.getString("ShotDescript");
                dto = new RegistrationDTOTake(idShot, shotName, shotLocation, shotTimes, ShotStartDate, ShotEndDate, shotDescript);
                result.add(dto);
                System.out.println(ShotEndDate);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String idtake) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From Take Where IdShot = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idtake);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(RegistrationDTOTake dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Take set shotName = ?, shotDescript = ?, ShotLocation = ?, ShotStartDate = ?, ShotEndDate = ?, ShotTimes = ? Where IdShot = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getShotName());
            preStm.setString(2, dto.getShotDescript());
            preStm.setString(3, dto.getShotLocation());
            preStm.setDate(4, (Date) dto.getShotStartDate());
            preStm.setDate(5, (Date) dto.getShotEndDate());
            preStm.setInt(6, dto.getShotTimes());
            preStm.setString(7, dto.getIdShot());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public RegistrationDTOTake findByPrimaryKey(String idtake) throws Exception {
        RegistrationDTOTake dto = null;
        try {
            String sql = "Select ShotName, ShotDescript, ShotLocation, ShotStartDate, ShotEndDate, ShotTimes From Take Where IdShot = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idtake);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String shotname = rs.getString("ShotName");
                String shotdescript = rs.getString("ShotDescript");
                String shotlocation = rs.getString("ShotLocation");
                Date shotstartdate = rs.getDate("ShotStartDate");
                Date shotenddate = rs.getDate("ShotEndDate");
                int shottimes = rs.getInt("ShotTimes");
                dto = new RegistrationDTOTake(idtake, shotname, shotlocation, shottimes, shotstartdate, shotenddate, shotdescript);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insert(RegistrationDTOTake dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Take(IdShot, ShotName, ShotDescript, ShotLocation, ShotStartDate, ShotEndDate, ShotTimes) values(?, ?, ?, ?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getIdShot());
            preStm.setString(2, dto.getShotName());
            preStm.setString(3, dto.getShotDescript());
            preStm.setString(4, dto.getShotLocation());
            preStm.setDate(5, (Date) dto.getShotStartDate());
            preStm.setDate(6, (Date) dto.getShotEndDate());
            preStm.setInt(7, dto.getShotTimes());
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
    
    public List<RegistrationDTOTake> findByLikeName() throws Exception {
        List<RegistrationDTOTake> result = null;
        String idShot;
        String shotName;
        String shotDescript;
        String shotLocation;
        int shotTimes;
        Date ShotStartDate, ShotEndDate;
        RegistrationDTOTake dto;
        try {
            String sql = "Select IdShot, ShotName, ShotDescript, ShotLocation, ShotStartDate, ShotEndDate, ShotTimes From Take";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                idShot = rs.getString("IdShot");
                shotName = rs.getString("ShotName");
                shotDescript = rs.getString("ShotDescript");
                shotLocation = rs.getString("ShotLocation");
                ShotStartDate = rs.getDate("ShotStartDate");
                ShotEndDate = rs.getDate("ShotEndDate");
                shotTimes = Integer.parseInt(rs.getString("ShotTimes"));
                shotDescript = rs.getString("ShotDescript");
                dto = new RegistrationDTOTake(idShot, shotName, shotLocation, shotTimes, ShotStartDate, ShotEndDate, shotDescript);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
