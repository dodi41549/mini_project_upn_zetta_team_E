/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo_123200011;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class koneksi {
    String DBurl = "jdbc:mysql://localhost/trans_db";
    String DBUsername = "root";
    String DBPassword = "";
    Connection koneksi;
    Statement statement;
    

    public koneksi() {
    try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBUsername, DBPassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] TransaksiList(){
    
    try{
            int jmlData = 0;
            
            String data[][] = new String[getBykData()][7]; //baris, kolom nya ada 6
            
            String query = "Select * from transactions"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_trans"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("nama_barang");                
                data[jmlData][2] = resultSet.getString("nama_kasir");
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void inserttransaksi(String transaksi, String barang, String kasir, String quantity, String harga, String diskon){
     int jmlData=0;
     double fharga=Float.parseFloat(harga);
     double fdiskon=Float.parseFloat(diskon);
     double dharga = (fharga)/fdiskon;
        try {
           String query = "Select * from transactions WHERE id_trans = '" + transaksi + "' "; 
           System.out.println(transaksi + " " + barang + " " + kasir + " " + quantity + " " + fharga + " " + fdiskon + " " + dharga);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO transactions VALUES('"+transaksi+"','"+barang+"','"+kasir+"','"+quantity+"','"+fharga+"','"+fdiskon+"','"+dharga+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    
    
    }
    
    public void updatetransaksi(String transaksi, String barang, String kasir, String quantity, String harga, String diskon){
        int jmlData=0;
        double fharga=Float.parseFloat(harga);
     double fdiskon=Float.parseFloat(diskon);
     double dharga = (fharga)/fdiskon; 
        try {
           String query = "Select * from transactions WHERE id_trans= '" + transaksi + "' "; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE transactions SET nama_barang='" + barang + "', nama_kasir='" + kasir + "', price_total'" + dharga + "', qty = '" + quantity +"', price_per_qty='" + fharga + "', discount='" + fdiskon + "' WHERE id_trans='" + transaksi +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

public int getBykData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

 public void deletetransaksi (String transaksi) {
        try{
            String query = "DELETE FROM transactions WHERE id_trans = '"+transaksi+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }



}
