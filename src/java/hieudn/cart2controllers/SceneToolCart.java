/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieudn.cart2controllers;

import hieudn.dtos.SceneToolDTO;
import hieudn.dtos.ScenesPartDTO;
import java.util.HashMap;

/**
 *
 * @author hp
 */
public class SceneToolCart {

    private HashMap<String, SceneToolDTO> cart;

    public HashMap<String, SceneToolDTO> getCart() {
        return cart;
    }

    public SceneToolCart() {
        cart = new HashMap<>();
    }

    public boolean addToCart(SceneToolDTO dto) throws Exception {
        this.cart.put(dto.getIdShotTool(), dto);
        return true;
    }

    public void clear() throws Exception {
        this.cart.clear();
    }

    public void remove(String id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
}
