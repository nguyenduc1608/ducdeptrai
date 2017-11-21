/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import model.DataProcess;

/**
 *
 * @author ngmin
 */
public class DeleteActionSupport extends ActionSupport {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public DeleteActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dt = new DataProcess();
        int i = Integer.parseInt(id);
        if(dt.deleteData(i))
            return "success";
        return "failed";
    }
    
}
