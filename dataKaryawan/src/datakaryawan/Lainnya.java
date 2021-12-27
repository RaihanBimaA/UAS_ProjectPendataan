/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public abstract class Lainnya {
    
    int indexdata;

    public abstract void hitungGaji();
    public abstract int hitungUmur(ArrayList<ArrayList<String>> data, int ke);
    
    public int indexData(ArrayList<ArrayList<String>> data, String kode) {
        
        for(int i = 0; i < data.size(); i++) {
            String dataKodeKaryawan = data.get(i).get(0);
            
            if(dataKodeKaryawan.equals(kode)){
                this.indexdata = i;
            } else {
                System.out.println("Data Tidak Terdeteksi");
            }
        }
        return this.indexdata;
    }
}
