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
    
    public int indexData(ArrayList<ArrayList<String>> data) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan kode karyawan : ");
        String kodeKaryawan = input.nextLine();
        
        for(int i = 0; i < data.size(); i++) {
            String dataKodeKaryawan = data.get(i).get(0);
            
            if(dataKodeKaryawan.equals(kodeKaryawan)){
                this.indexdata = i;
            } else {
                System.out.println("Data Tidak Ditemukan");
            }
        }
        return this.indexdata;
    }
}
