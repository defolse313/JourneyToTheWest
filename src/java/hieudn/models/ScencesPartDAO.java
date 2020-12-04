    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.models;

import hieudn.cart1controllers.ScenesPartCart;
import hieudn.db.MyConnection;
import hieudn.dtos.ScenesPartDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class ScencesPartDAO implements Serializable {

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

    public List<ScenesPartDTO> findByLikeName() throws Exception {
        List<ScenesPartDTO> result = null;
        String username;
        String idshot;
        String role;
        String idaccshot;
        String descript;
        String editor;
        ScenesPartDTO dto;
        try {
            String sql = "Select IdAccShot, Username, IdShot, Part, Description, Editor From AccShot";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                idaccshot = rs.getString("IdAccShot");
                username = rs.getString("Username");
                idshot = rs.getString("IdShot");
                role = rs.getString("Part");
                descript = rs.getString("Description");
                editor = rs.getString("Editor");
                dto = new ScenesPartDTO(username, idshot, role, idaccshot, descript, editor);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ScenesPartDTO> getAccScene() throws Exception {
        List<ScenesPartDTO> result;
        try {
            String sql = "Select Username, IdShot From AccShot";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            ScenesPartDTO dto;
            result = new ArrayList<>();
            rs = preStm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("Username");
                String idshot = rs.getString("IdShot");
                dto = new ScenesPartDTO(username, idshot);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean insert(ScenesPartCart cart) throws Exception {
        String sql = "Insert Into AccShot(IdAccShot, Username, IdShot, Part, Description, Editor) values (?, ?, ?, ?, ?, ?)";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
//            for (int i = 0; i < cart.size(); i++) {
            for (ScenesPartDTO value : cart.getCart().values()) {
                preStm.setString(1, value.getIdAccShot());
                preStm.setString(2, value.getUsername());
                preStm.setString(3, value.getIdShot());
                preStm.setString(4, value.getPart());
                preStm.setString(5, value.getDescript());
                preStm.setString(6, value.getEditor());
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
    
    
    public boolean delete(String idaccshot) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From AccShot Where IdAccShot = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, idaccshot);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
