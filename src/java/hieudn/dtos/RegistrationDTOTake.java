/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.dtos;

import java.sql.Date;



/**
 *
 * @author hp
 */
public class RegistrationDTOTake {
    private String idShot, shotName, shotLocation, shotDescript;
    Date shotStartDate, shotEndDate;
    int shotTimes;
    public RegistrationDTOTake(String idShot, String shotName, String shotLocation, int shotTimes, Date shotStartDate, Date shotEndDate, String shotDescript) {
        this.idShot = idShot;
        this.shotName = shotName;
        this.shotLocation = shotLocation;
        this.shotTimes = shotTimes;
        this.shotStartDate = shotStartDate;
        this.shotEndDate = shotEndDate;
        this.shotDescript = shotDescript;
    }

    public RegistrationDTOTake() {
    }

    public String getShotDescript() {
        return shotDescript;
    }

    public void setShotDescript(String shotDescript) {
        this.shotDescript = shotDescript;
    }

    public String getIdShot() {
        return idShot;
    }

    public void setIdShot(String IdShot) {
        this.idShot = IdShot;
    }

    public String getShotName() {
        return shotName;
    }

    public void setShotName(String shotName) {
        this.shotName = shotName;
    }

    public String getShotLocation() {
        return shotLocation;
    }

    public void setShotLocation(String shotLocation) {
        this.shotLocation = shotLocation;
    }

    public int getShotTimes() {
        return shotTimes;
    }

    public void setShotTimes(int shotTimes) {
        this.shotTimes = shotTimes;
    }

    public Date getShotStartDate() {
        return shotStartDate;
    }

    public void setShotStartDate(Date shotStartDate) {
        this.shotStartDate = shotStartDate;
    }

    public Date getShotEndDate() {
        return shotEndDate;
    }

    public void setShotEnđate(Date shotEndDate) {
        this.shotEndDate = shotEndDate;
    }
    
    
}
