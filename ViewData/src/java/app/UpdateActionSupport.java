/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import entity.Product;
import model.DataProcess;

/**
 *
 * @author ngmin
 */
public class UpdateActionSupport extends ActionSupport {
    private String id;
    private String name;
    private float price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public UpdateActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dt = new DataProcess();
        Product p = dt.getById(id);
        setId(id);
        setName(name);
        setPrice(price);
        return "success";
    }
    
}
