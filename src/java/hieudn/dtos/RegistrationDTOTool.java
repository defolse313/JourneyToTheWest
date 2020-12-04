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
public class RegistrationDTOTool {
    private String idTool, toolName, toolDescript, toolImg, status;
    private int quantity;

    public RegistrationDTOTool(String idTool, String toolName, String toolDescript, String toolImg, String status, int quantity) {
        this.idTool = idTool;
        this.toolName = toolName;
        this.toolDescript = toolDescript;
        this.toolImg = toolImg;
        this.status = status;
        this.quantity = quantity;
    }

    public RegistrationDTOTool() {
    }

    
    public String getIdTool() {
        return idTool;
    }

    public void setIdTool(String idTool) {
        this.idTool = idTool;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolDescript() {
        return toolDescript;
    }

    public void setToolDescript(String toolDescript) {
        this.toolDescript = toolDescript;
    }

    public String getToolImg() {
        return toolImg;
    }

    public void setToolImg(String toolImg) {
        this.toolImg = toolImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
