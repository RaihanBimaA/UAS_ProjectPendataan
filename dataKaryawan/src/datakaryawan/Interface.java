/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public interface Interface {
    
    public abstract void tambahKaryawan(ArrayList<ArrayList<String>> data);
    public abstract void hapusKaryawan (ArrayList<ArrayList<String>> data);
    public abstract void cariKaryawan (ArrayList<ArrayList<String>> data);
    public abstract void printKaryawan (ArrayList<ArrayList<String>> data);
}
