/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.models;

import hieudn.db.MyConnection;
import hieudn.dtos.RegistrationDTO;
import hieudn.dtos.RegistrationDTOTool;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class RegistrationDAOTool implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    public RegistrationDAOTool() {
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

    public List<RegistrationDTOTool> findByLikeName(String search) throws Exception {
        List<RegistrationDTOTool> result = null;
        String idTool;
        String toolName;
        String toolDescript;
        String toolImg;
        int quantity;
        String status;
        RegistrationDTOTool dto;
        try {
            String sql = "Select IDTool, ToolName, ToolDescript, ToolImg, Quantity, Status From Tool Where ToolName LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                idTool = rs.getString("IDTool");
                toolName = rs.getString("ToolName");
                toolDescript = rs.getString("ToolDescript");
                toolImg = rs.getString("ToolImg");
                quantity = Integer.parseInt(rs.getString("Quantity"));
                status = rs.getString("Status");
                dto = new RegistrationDTOTool(idTool, toolName, toolDescript, toolImg, status, quantity);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String idtool) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From Tool Where IDTool = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idtool);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(RegistrationDTOTool dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Tool set ToolName = ?, ToolDescript = ?, ToolImg = ?, Quantity = ?, Status = ? Where IDTool = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getToolName());
            preStm.setString(2, dto.getToolDescript());
            preStm.setString(3, dto.getToolImg());
            preStm.setInt(4, dto.getQuantity());
            preStm.setString(5, dto.getStatus());
            preStm.setString(6, dto.getIdTool());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public RegistrationDTOTool findByPrimaryKey(String idtool) throws Exception {
        RegistrationDTOTool dto = null;
        try {
            String sql = "Select ToolName, ToolDescript, ToolImg, Quantity, Status From Tool Where IDTool = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idtool);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String toolname = rs.getString("ToolName");
                String tooldescript = rs.getString("ToolDescript");
                String toolimg = rs.getString("ToolImg");
                String quantity = rs.getString("Quantity");
                String status = rs.getString("Status");
                dto = new RegistrationDTOTool(idtool, toolname, tooldescript, toolimg, status, Integer.parseInt(quantity));
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insert(RegistrationDTOTool dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Tool(IDTool, ToolName, ToolDescript, ToolImg, Quantity, Status) values(?, ?, ?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getIdTool());
            preStm.setString(2, dto.getToolName());
            preStm.setString(3, dto.getToolDescript());
            preStm.setString(4, dto.getToolImg());
            preStm.setInt(5, dto.getQuantity());
            preStm.setString(6, dto.getStatus());
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

    public List<RegistrationDTOTool> findByLikeName() throws Exception {
        List<RegistrationDTOTool> result = null;
        String idTool;
        String toolName;
        String toolDescript;
        String toolImg;
        int quantity;
        String status;
        RegistrationDTOTool dto;
        try {
            String sql = "Select IDTool, ToolName, ToolDescript, ToolImg, Quantity, Status From Tool";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                idTool = rs.getString("IDTool");
                toolName = rs.getString("ToolName");
                toolDescript = rs.getString("ToolDescript");
                toolImg = rs.getString("ToolImg");
                quantity = Integer.parseInt(rs.getString("Quantity"));
                status = rs.getString("Status");
                dto = new RegistrationDTOTool(idTool, toolName, toolDescript, toolImg, status, quantity);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
