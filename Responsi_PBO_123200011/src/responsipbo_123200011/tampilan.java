/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo_123200011;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USER
 */
public class tampilan extends JFrame implements ActionListener{
    JLabel ltransaksi = new JLabel("Id transaksi");
    JLabel lbarang = new JLabel("Nama Barang");
    JLabel lkasir = new JLabel("Nama Kasir");
    JLabel lquantity = new JLabel("Quantity");
    JLabel lharga = new JLabel("Harga");
    JLabel ldiskon = new JLabel("Diskon");
    
    public JTextField tftransaksi = new JTextField();
    public JTextField tfbarang = new JTextField();
    public JTextField tfkasir = new JTextField();
    public JTextField tfquantity = new JTextField();
    public JTextField tfharga = new JTextField();
    public JTextField tfdiskon = new JTextField();
    
    public JButton btncreate = new JButton("create");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("delete");
    public JButton btnread = new JButton("read");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Id Transaksi", "Nama Barang", "Nama Kasir", "Quantity", "Harga", "Diskon", "Harga Setelah Diskon"};

    public tampilan() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(1150,500);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 900, 300);
        
        add(ltransaksi);
        ltransaksi.setBounds(1000, 20, 90, 20);
        add(tftransaksi);
        tftransaksi.setBounds(1000, 40, 120, 20);
        
        add(lbarang);
        lbarang.setBounds(1000, 60, 90, 20);
        add(tfbarang);
        tfbarang.setBounds(1000, 80, 120, 20);
        
        add(lkasir);
        lkasir.setBounds(1000, 100, 90, 20);
        add(tfkasir);
        tfkasir.setBounds(1000, 120, 120, 20);
        
        add(lquantity);
        lquantity.setBounds(1000, 140, 90, 20);
        add(tfquantity);
        tfquantity.setBounds(1000, 160, 120, 20);
        
        add(lharga);
        lharga.setBounds(1000, 180, 90, 20);
        add(tfharga);
        tfharga.setBounds(1000, 200, 120, 20);
        
        add(ldiskon);
        ldiskon.setBounds(1000, 220, 90, 20);
        add(tfdiskon);
        tfdiskon.setBounds(1000, 240, 120, 20);
        
        add(btncreate);
        btncreate.setBounds(1000, 270, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(1000, 300, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(1000, 330, 90, 20);
        
        add(btnread);
        btnread.setBounds(1000, 360, 90, 20);
        btnread.addActionListener(this);
    }
    
     public void actionPerformed(ActionEvent e) {
     if(e.getSource() == btnread){
            tftransaksi.setText("");
            tfbarang.setText("");
            tfkasir.setText("");
            tfquantity.setText("");
            tfharga.setText("");
            tfdiskon.setText("");
                
        }
     }
    
    
    
    public String gettransaksi(){
        return tftransaksi.getText();
    }
    
    public String getbarang(){
        return tfbarang.getText();
    }
    
    public String getkasir(){
        return tfkasir.getText();
    }
    
    public String getquantity(){
        return tfquantity.getText();
    }
    
    public String getharga(){
        return tfharga.getText();
    }
    
    public String getdiskon(){
        return tfdiskon.getText();
    }
}
