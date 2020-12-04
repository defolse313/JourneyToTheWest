/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.dtos;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class ScenesPartDTO implements Serializable {

    private String username, idShot, part, idAccShot, descript, editor;

    public ScenesPartDTO() {
    }

    public ScenesPartDTO(String username, String idShot, String part, String idAccShot, String descript, String editor) {
        this.username = username;
        this.idShot = idShot;
        this.part = part;
        this.idAccShot = idAccShot;
        this.descript = descript;
        this.editor = editor;
    }

    public ScenesPartDTO(String username, String idShot) {
        this.username = username;
        this.idShot = idShot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdShot() {
        return idShot;
    }

    public void setIdShot(String idShot) {
        this.idShot = idShot;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getIdAccShot() {
        return idAccShot;
    }

    public void setIdAccShot(String idAccShot) {
        this.idAccShot = idAccShot;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "username=" + username + ", idShot=" + idShot;
    }

}
