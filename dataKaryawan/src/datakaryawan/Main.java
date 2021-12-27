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
public class Main {
    
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    
    public static void main(String [] args) {
        
        //objek dari kelas Action
        Action ac = new Action();
        
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int jumlahAnak, gajiPokok, tunjanganKel, tunjanganPegawai, tunjanganAnak, gajiKotor;
        double potongan, gajiBersih;
        
        while( true ){    
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Lihat Data");
            System.out.println("5. Exit");
            System.out.print("Menu pilihan                  : ");
            int memilih = input.nextInt();
            
            switch(memilih){
                case 1 : 
                    boolean loop = true;
                    while( loop ){
                        System.out.println("                      Menu Tambah Data                      \n");                       
                        
                        ac.tambahKaryawan(data);
                        
                        
                        System.out.println("\n");
                        subMenu();
                        System.out.println("2. Tambah Data Lagi");
                        
                        System.out.println("");
                        int pilihan = memilih();
                        
                        if( pilihan == 1 ){
                            loop = false;
                        }else if(pilihan != 2) {
                            System.out.println("pilihan sub menu tidak ada");
                        }  
                    }
                    break;
                
                    
                case 2 : 
                    loop = true;
                    while( loop ) {
                        System.out.println("");
                        System.out.println("============================================================");
                        System.out.println("                         Hapus Data                         ");
                        System.out.println("------------------------------------------------------------");
                        String cb = input.nextLine();
                       
                        ac.hapusKaryawan(data);

                        //input submenu
                        System.out.println("");
                        subMenu();
                        System.out.println("2. Hapus Data Lagi");
                        
                        System.out.println("");
                        int pilihan = memilih();
                        
                        if( pilihan == 1 ){
                            loop = false;
                        } else if(pilihan != 2) {
                            System.out.println("pilihan sub menu tidak ada");
                        }
                        
                    }
                    break;
                
                case 3 :                     
                    loop = true;
                    while( loop ){
                        System.out.println("");
                        System.out.println("============================================================");
                        System.out.println("                         Cari Data                          ");
                        System.out.println("------------------------------------------------------------");
                        
                        ac.cariKaryawan(data);

                        //input submenu
                        System.out.println("");
                        subMenu();
                        
                        System.out.println("");
                        int pilihan = memilih();
                        
                        if( pilihan == 1 ){
                            loop = false;
                        } else{
                            System.out.println("pilihan sub menu tidak ada");
                        }
                    }
                    break;
                
                case 4 : 
                    loop = true;
                    while( loop ){

                        ac.printKaryawan(data);
   
                        System.out.println("\n");
                        subMenu();
                        
                        System.out.println("");
                        int pilihan = memilih();
                        
                        if( pilihan == 1 ){
                            loop = false;
                        }else{
                            System.out.println("pilihan sub menu tidak ada");
                        }
                    }
                    break;

                    
                case 5 : 
                    keluar();
                
                default: 
                    System.out.println("Menu yang anda pilih tidak ada");
                    System.out.println("");
                
            }   
            
        }
        
    }
    
    public static void subMenu() {
        System.out.println("Sub Menu");
        System.out.println("1. Kembali ke Menu Utama");
    }
    
    public static int memilih() {
        Scanner input = new Scanner(System.in);
        int pilihan;
        
        System.out.print("Pilihan Menu : ");
        pilihan = Integer.parseInt(input.nextLine());
        
        return pilihan;
    }
    
    public static void keluar() {
        System.out.println("Anda Telah Keluar");
        System.exit(0);
    }
}
