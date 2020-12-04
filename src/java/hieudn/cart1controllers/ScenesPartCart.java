/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.cart1controllers;

import hieudn.dtos.ScenesPartDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author hp
 */
public class ScenesPartCart implements Serializable {

    private HashMap<String, ScenesPartDTO> cart;

    public HashMap<String, ScenesPartDTO> getCart() {
        return cart;
    }

    public ScenesPartCart() {
        cart = new HashMap<>();
    }

    public boolean addToCart(ScenesPartDTO dto) throws Exception {
        this.cart.put(dto.getIdAccShot(), dto);
        return true;
    }

    public void remove(String id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void clear() throws Exception
    {
        this.cart.clear();
    }

    public boolean updateCart(String id, String username, String idShot, String des, String role, String editor) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.get(id).setUsername(username);
            this.cart.get(id).setIdShot(idShot);
            this.cart.get(id).setDescript(des);
            this.cart.get(id).setPart(role);
            this.cart.get(id).setEditor(editor);
            return true;
        }
        return false;
    }
}
