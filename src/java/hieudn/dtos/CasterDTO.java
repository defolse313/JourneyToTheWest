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
public class CasterDTO {

    private String username, fullname, picture, part, shotname;
    private Date start, end;

    public CasterDTO() {
    }

    public CasterDTO(String username, String fullname, String picture, String part, String shotname, Date start, Date end) {
        this.username = username;
        this.fullname = fullname;
        this.picture = picture;
        this.part = part;
        this.shotname = shotname;
        this.start = start;
        this.end = end;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getShotname() {
        return shotname;
    }

    public void setShotname(String shotname) {
        this.shotname = shotname;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
