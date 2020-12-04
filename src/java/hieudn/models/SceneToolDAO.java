/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.models;

import hieudn.cart2controllers.SceneToolCart;
import hieudn.db.MyConnection;
import hieudn.dtos.SceneToolDTO;
import hieudn.dtos.ScenesPartDTO;
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
public class SceneToolDAO implements Serializable {

    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;
    HttpSession session;

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

    public List<SceneToolDTO> findByLikeName() throws Exception {
        List<SceneToolDTO> result = null;
        String idshottool;
        String idshot;
        String idtool;
        int numOfUse;
        String descript;
        SceneToolDTO dto;
        try {
            String sql = "Select IdShotTool, IdShot, IdTool, NumberUsing, Description From ShotTool";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                idshottool = rs.getString("IdShotTool");
                idshot = rs.getString("IdShot");
                idtool = rs.getString("IdTool");
                numOfUse = rs.getInt("NumberUsing");
                descript = rs.getString("Description");
                dto = new SceneToolDTO(idshottool, idshot, idtool, numOfUse, descript);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<SceneToolDTO> getToolScene() throws Exception {
        List<SceneToolDTO> result;
        try {
            String sql = "Select IdShot, IdTool From ShotTool";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            SceneToolDTO dto;
            result = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String idshot = rs.getString("IdShot");
                String idtool = rs.getString("IdTool");
                dto = new SceneToolDTO(idshot, idtool);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(SceneToolCart cart) throws Exception {
        String sql = "Insert Into ShotTool(IdShotTool, IdShot, IdTool, NumberUsing, Description) values (?, ?, ?, ?, ?)";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
//            for (int i = 0; i < cart.size(); i++) {
            for (SceneToolDTO value : cart.getCart().values()) {
                preStm.setString(1, value.getIdShotTool());
                preStm.setString(2, value.getIdShot());
                preStm.setString(3, value.getIdTool());
                preStm.setInt(4, value.getNumOfUse());
                preStm.setString(5, value.getDescript());
                preStm.addBatch();
            }
            int[] result = preStm.executeBatch();
            for (int i = 0; i < result.length; i++) {
                if (result[i] > 0) {
                    return true;
                }

            }
            return false;
        } finally {
            closeConnection();
        }
    }

    public boolean delete(String idacctool) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From ShotTool Where IdShotTool = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idacctool);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
