/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;


/**
 *
 * @author TOSHIBA
 */
public class Action extends Lainnya implements Interface {
    
    int jumlahAnak, gajiPokok, tunjanganKel, tunjanganPegawai, tunjanganAnak, gajiKotor, statusMenikah, usia;
    double potongan, gajiBersih;
    String menikah, golongan, status;

    @Override
    public int hitungUmur(ArrayList<ArrayList<String>> data, int ke) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date tgl = formatter.parse(data.get(ke).get(3));
            LocalDate lahir = tgl.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            Period period = Period.between(lahir, LocalDate.now());
            this.usia = period.getYears();
        } catch (ParseException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usia;
    }
    
    @Override
    public void hitungGaji() {
        if(null != golongan) switch (golongan) {
            case "A":
                gajiPokok = 5000000;
                break;
            case "B":
                gajiPokok = 6000000;
                break;
            case "C":
                gajiPokok = 7000000;
                break;
            default:
                break;
        }
        System.out.println(gajiPokok);
        
        //tunjangan menikah
        if(menikah == "Telah Menikah") {
            tunjanganKel = (gajiPokok * 10) / 100;
        } else {
            tunjanganKel = 0;
        }
        
        //tunjangan pegawai
        if(this.usia > 30) {
            tunjanganPegawai = (gajiPokok * 15) / 100;
        } else {
            tunjanganPegawai = 0;
        }
        
        //tunjangan anak
        if(jumlahAnak > 0) {
            tunjanganAnak = (gajiPokok * 5 / 100) * jumlahAnak;
        } else {
            tunjanganAnak = 0;
        }
        
        //gaji kotor
        gajiKotor = gajiPokok + tunjanganKel + tunjanganPegawai + tunjanganAnak;
        
        //potongan
        potongan = (gajiKotor * 2.5) / 100;
        
        //gaji bersih
        gajiBersih = gajiKotor - potongan;
    }

    @Override
    public void tambahKaryawan(ArrayList<ArrayList<String>> data) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Masukkan Kode Karyawan : ");
        String kodeKaryawan = input.nextLine();
        
        System.out.print("Masukkan Nama Karyawan : ");
        String namaKaryawan = input.nextLine();
        
        System.out.print("Masukkan Alamat : ");
        String alamat = input.nextLine();
        
        System.out.print("Masukkan Tanggal Lahir : ");
        String tglLahir = input.nextLine();
        
        System.out.print("Masukkan Golongan (A, B, C) : ");
        golongan = input.nextLine();
        switch(golongan) {
            case "A" :
                break;
            case "B" :
                break;
            case "C" :
                break;
            default :
                System.out.println("\n");
                System.out.println("Status Menikah Tidak Valid, Ulangi Input Data");
                tambahKaryawan(data);
        }
        
        System.out.print("Pilih Status Menikah ( 0 = belum, 1 = sudah) : ");
        status = input.nextLine();
        if(Integer.parseInt(status) == 0) {
            data.add(new ArrayList<String>(
                Arrays.asList(kodeKaryawan, namaKaryawan, alamat, tglLahir, golongan, status)
            ));
        } else if(Integer.parseInt(status) == 1) {
            System.out.print("Berapa Jumlah Anak : ");
            jumlahAnak = input.nextInt();
            
            data.add(new ArrayList<String>(
                Arrays.asList(kodeKaryawan, namaKaryawan, alamat, tglLahir, golongan, status, Integer.toString(jumlahAnak))
            ));
        } else {
            System.out.println("\n");
            System.out.println("Status Menikah Tidak Valid, Ulangi Input Data");
            tambahKaryawan(data);
        }
    }

    @Override
    public void hapusKaryawan(ArrayList<ArrayList<String>> data) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Kode Karyawan yang hendak dihapus : ");
        String kodeKaryawan = input.nextLine();
        
        int indexKaryawan = indexData(data, kodeKaryawan);
        
        if(indexKaryawan > -1) {
            data.remove(indexKaryawan);
            System.out.println("Data Karyawan " + kodeKaryawan + " telah dihapus");
        } else {
            System.out.println("Data Karyawan gagal dihapus karna tidak ditemukan");
        }
    }

    @Override
    public void cariKaryawan(ArrayList<ArrayList<String>> data) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan kode karyawan : ");
        String kodeKaryawan = input.nextLine();
        
        int indexKaryawan = indexData(data, kodeKaryawan);
        hitungUmur(data, indexKaryawan);
        hitungGaji();
        
        if(indexKaryawan > -1) {
            System.out.println("\n");
            System.out.println("                  DATA PROFIL KARYAWAN                   ");
            System.out.println("---------------------------------------------------------");

            System.out.println("Kode Karyawan           : " + data.get(indexKaryawan).get(0));
            System.out.println("Nama Karyawan           : " + data.get(indexKaryawan).get(1));
            System.out.println("Golongan                : " + golongan);
            System.out.println("Usia                    : " + usia);

            switch(Integer.parseInt(status)){
                case 0 :
                    System.out.println("Status Menikah          : Belum Menikah");
                    System.out.println("---------------------------------------------------------");
                    break;

                case 1 :
                    System.out.println("Status Menikah          : Telah Menikah");
                    System.out.println("Jumlah Anak             : " + jumlahAnak);
                    System.out.println("---------------------------------------------------------");
            }
            System.out.println("Gaji Pokok              : Rp" + gajiPokok);

            if(Integer.parseInt(status) == 1){
                System.out.println("Tunjangan Suami/Istri   : Rp" + tunjanganKel );
            }if(usia > 30){
                System.out.println("Tunjangan Pegawai       : Rp" + tunjanganPegawai);
            }if(jumlahAnak > 0){
                System.out.println("Tunjangan Anak          : Rp" + tunjanganAnak); 
            }
            System.out.println("Gaji Kotor              : Rp" + gajiKotor);
            System.out.println("Potongan                : Rp" + potongan);
            System.out.println("--------------------------------------------------------- ");
            System.out.println("Gaji Bersih             : Rp" + gajiBersih);
            
        } else {
            System.out.println("Data Karyawan tidak terdeteksi");
        }
    }

    @Override
    public void printKaryawan(ArrayList<ArrayList<String>> data) {
        String leftAlign = "| %-8s | %-27s | %-8s | %-8s | %-20s | %-13s |%n";
        
        System.out.println("\n");
        System.out.println("                                   DATA KARYAWAN");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf(leftAlign, "KODE", "NAMA", "GOLONGAN", "USIA", "STATUS", "JUMLAH ANAK");
        

            for(int i=0; i < data.size(); i++){  
                
                String kdKaryawan = data.get(i).get(0);
                String nmKaryawan = data.get(i).get(1);
                hitungUmur(data, i);

                if( Integer.parseInt(status) == 1){
                    menikah = "Telah Menikah";
                    jumlahAnak = Integer.parseInt(data.get(i).get(6));
                }else if( Integer.parseInt(status) == 0){
                    menikah = "Belum Menikah";
                    jumlahAnak = 0;
                }

                System.out.printf(leftAlign, kdKaryawan, nmKaryawan, golongan, usia, menikah, jumlahAnak );
        }
    }
}
