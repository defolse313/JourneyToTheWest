/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.models;

import hieudn.dtos.RegistrationDTO;
import hieudn.dtos.RegistrationDTOTake;
import hieudn.dtos.RegistrationDTOTool;
import hieudn.dtos.ScenesPartDTO;
import java.io.Serializable;

/**
 *
 * @author hp
 */
public class RegistrationBean implements Serializable {

    private String username, password, idtool, idshot, idaccshot;
    RegistrationDAO dao;
    RegistrationDTO dto;
    RegistrationDAOTool daotool;
    RegistrationDTOTool dtotool;
    RegistrationDAOTake daotake;
    RegistrationDTOTake dtotake;
    ScencesPartDAO daosp;
    ScenesPartDTO dtosp;

    public RegistrationDTO checklogin() throws Exception {
        return dao.checkLogin(username, password);
    }

    public boolean insert() throws Exception {
        return dao.insert(dto);
    }

    public boolean toolInsert() throws Exception {
        return daotool.insert(dtotool);
    }
    
    public boolean takeInsert() throws Exception {
        return daotake.insert(dtotake);
    }

    public boolean delete() throws Exception {
        return dao.delete(username);
    }

    public boolean toolDelete() throws Exception {
        return daotool.delete(idtool);
    }

    public boolean takedelete() throws Exception {
        return daotake.delete(idshot);
    }

    public boolean update() throws Exception {
        return dao.update(dto);
    }

    public boolean toolUpdate() throws Exception {
        return daotool.update(dtotool);
    }
    
    public boolean takeupdate() throws Exception {
        return daotake.update(dtotake);
    }

    public RegistrationDTO findByPrimaryKey() throws Exception {
        return dao.findByPrimaryKey(username);
    }

    public RegistrationBean() {
        dao = new RegistrationDAO();
        dto = new RegistrationDTO();
        daotool = new RegistrationDAOTool();
        dtotool = new RegistrationDTOTool();
        daotake = new RegistrationDAOTake();
        dtotake = new RegistrationDTOTake();
        daosp = new ScencesPartDAO();
        dtosp = new ScenesPartDTO();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegistrationDAO getDao() {
        return dao;
    }

    public void setDao(RegistrationDAO dao) {
        this.dao = dao;
    }

    public RegistrationDTO getDto() {
        return dto;
    }

    public void setDto(RegistrationDTO dto) {
        this.dto = dto;
    }

    public RegistrationDAOTool getDaotool() {
        return daotool;
    }

    public void setDaotool(RegistrationDAOTool daotool) {
        this.daotool = daotool;
    }

    public RegistrationDTOTool getDtotool() {
        return dtotool;
    }

    public void setDtotool(RegistrationDTOTool dtotool) {
        this.dtotool = dtotool;
    }

    public String getIdtool() {
        return idtool;
    }

    public void setIdtool(String idtool) {
        this.idtool = idtool;
    }

    public String getIdshot() {
        return idshot;
    }

    public void setIdshot(String idshot) {
        this.idshot = idshot;
    }

    public RegistrationDAOTake getDaotake() {
        return daotake;
    }

    public void setDaotake(RegistrationDAOTake daotake) {
        this.daotake = daotake;
    }

    public RegistrationDTOTake getDtotake() {
        return dtotake;
    }

    public void setDtotake(RegistrationDTOTake dtotake) {
        this.dtotake = dtotake;
    }

    public String getIdaccshot() {
        return idaccshot;
    }

    public void setIdaccshot(String idaccshot) {
        this.idaccshot = idaccshot;
    }

    public ScencesPartDAO getDaosp() {
        return daosp;
    }

    public void setDaosp(ScencesPartDAO daosp) {
        this.daosp = daosp;
    }

    public ScenesPartDTO getDtosp() {
        return dtosp;
    }

    public void setDtosp(ScenesPartDTO dtosp) {
        this.dtosp = dtosp;
    }

    
    
}
