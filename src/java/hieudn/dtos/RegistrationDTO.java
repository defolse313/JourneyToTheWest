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
public class RegistrationDTO implements Serializable {

    private String userName, passwordAcc, fullname, descript, phone, email, picture, role;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String userName, String Fullname, String Descript, String Phone, String Email, String Picture, String role) {
        this.userName = userName;
        this.fullname = Fullname;
        this.descript = Descript;
        this.phone = Phone;
        this.email = Email;
        this.picture = Picture;
        this.role = role;
    }

    public RegistrationDTO(String userName, String Fullname, String Role) {
        this.userName = userName;
        this.fullname = Fullname;
        this.role = Role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordAcc() {
        return passwordAcc;
    }

    public void setPasswordAcc(String passwordAcc) {
        this.passwordAcc = passwordAcc;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    

}
