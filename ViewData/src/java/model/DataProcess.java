/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngmin
 */
public class DataProcess {
    public static Connection getConnection()
    {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=java4";
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public static boolean checkLogin(String u,String p)
    {
        boolean result=false;
        String sql="SELECT * FROM tblAccount WHERE _user=? and _pass=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, u);
            prst.setString(2, p);
            ResultSet rs=prst.executeQuery();
            result = rs.next();
            rs.close();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public Vector<Product> getData(){
        Vector v = new Vector();
        String sql = "SELECT * FROM tblProduct";
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            while(rs.next())
            {
                v.add(new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3)));
            } 
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
    public boolean deleteData(int id) {
        int result = 0;
        String sql = "DELETE FROM tblProduct WHERE prodId=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setInt(1, id);
            result = prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    public Product getById(String id)
    {
        Product temp=null;
        String sql="SELECT * FROM tblProduct WHERE prodId=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, id);
            ResultSet rs = prst.executeQuery();
            while(rs.next())
            {
                temp=new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    
      public boolean updateData(String id) {
        int result = 0;
        String sql = "DELETE FROM tblProduct WHERE prodId=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, id);
            result = prst.executeUpdate();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
}
