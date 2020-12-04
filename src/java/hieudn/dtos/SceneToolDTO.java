/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.dtos;

/**
 *
 * @author hp
 */
public class SceneToolDTO {
    private String idShotTool, idShot, idTool,  descript;
    private int numOfUse;
    public SceneToolDTO() {
    }

    public SceneToolDTO(String idShot, String idTool) {
        this.idShot = idShot;
        this.idTool = idTool;
    }
    
    

    public SceneToolDTO(String idShotTool, String idShot, String idTool, int numOfUse, String descript) {
        this.idShotTool = idShotTool;
        this.idShot = idShot;
        this.idTool = idTool;
        this.numOfUse = numOfUse;
        this.descript = descript;
    }

    public String getIdShotTool() {
        return idShotTool;
    }

    public void setIdShotTool(String idShotTool) {
        this.idShotTool = idShotTool;
    }

    public String getIdShot() {
        return idShot;
    }

    public void setIdShot(String idShot) {
        this.idShot = idShot;
    }

    public String getIdTool() {
        return idTool;
    }

    public void setIdTool(String idTool) {
        this.idTool = idTool;
    }

    public int getNumOfUse() {
        return numOfUse;
    }

    public void setNumOfUse(int numOfUse) {
        this.numOfUse = numOfUse;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
    
    
}
