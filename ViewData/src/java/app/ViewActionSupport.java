/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import entity.Product;
import java.util.Vector;
import model.DataProcess;

/**
 *
 * @author ngmin
 */
public class ViewActionSupport extends ActionSupport {
    private Vector<Product> items;

    public void setItems(Vector<Product> items) {
        this.items = items;
    }

    public Vector<Product> getItems() {
        DataProcess dt = new DataProcess();
        items = dt.getData();
        return items;
    }
    
    public ViewActionSupport() {
    }
    
    public String execute() throws Exception {
        return "success";
    }
    
}
