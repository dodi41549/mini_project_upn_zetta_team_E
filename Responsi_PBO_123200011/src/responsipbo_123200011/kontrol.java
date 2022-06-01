/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo_123200011;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author USER
 */
public class kontrol {
     koneksi koneksi;
     tampilan tampilan;
     
     public String dataterpilih;
     
    public kontrol(koneksi koneksi, tampilan tampilan) {
        this.koneksi = koneksi;
        this.tampilan = tampilan;
    
        
        if (koneksi.getBykData()!=0) {
            String data[][] = koneksi.TransaksiList();
            tampilan.tabel.setModel((new JTable(data, tampilan.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
         tampilan.btncreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String transaksi = tampilan.gettransaksi();
                String barang = tampilan.getbarang();
                String kasir = tampilan.getkasir();
                String quantity = tampilan.getquantity();
                String harga = tampilan.getharga();
                String diskon = tampilan.getdiskon();
                koneksi.inserttransaksi(transaksi, barang, kasir, quantity, harga, diskon);
         
            String data[][] = koneksi.TransaksiList();
            tampilan.tabel.setModel((new JTable(data, tampilan.namaKolom)).getModel());
            }
        });
    
          tampilan.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 String transaksi = tampilan.gettransaksi();
                String barang = tampilan.getbarang();
                String kasir = tampilan.getkasir();
                String quantity = tampilan.getquantity();
                String harga = tampilan.getharga();
                String diskon = tampilan.getdiskon();
                koneksi.updatetransaksi(transaksi, barang, kasir, quantity, harga, diskon);
                
                String data[][] = koneksi.TransaksiList();
            tampilan.tabel.setModel((new JTable(data, tampilan.namaKolom)).getModel());
            }
        });
    
    
    tampilan.tabel.addMouseListener(new MouseAdapter(){    
        public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = tampilan.tabel.getSelectedRow();

                dataterpilih = tampilan.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
    }
            
 });
    
    tampilan.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus Transaksi " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    koneksi.deletetransaksi(dataterpilih);
                    String data[][] = koneksi.TransaksiList();
                    tampilan.tabel.setModel((new JTable(data, tampilan.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
    
    
}
}