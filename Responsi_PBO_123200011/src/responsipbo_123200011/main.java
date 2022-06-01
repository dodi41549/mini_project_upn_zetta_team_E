/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipbo_123200011;

/**
 *
 * @author USER
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        tampilan tn = new tampilan();
        koneksi kn = new koneksi();
        kontrol kl = new kontrol(kn, tn);
        
    }
    
}
