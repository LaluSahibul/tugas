package com.example.myapplication;

import android.content.Context;


import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.model.Anjing;
import com.example.myapplication.model.Hewan;
import com.example.myapplication.model.Kucing;
import com.example.myapplication.model.Reptil;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Kucing> initDataKucing(Context ctx) {
        List<Kucing> kucings = new ArrayList<>();
        kucings.add(new Kucing("Angora", "Turki",
                "Aslinya berasal dari Ankara, Turki dengan ciri khas berbulu panjang dan lembut", R.drawable.cat_angora));
        kucings.add(new Kucing("Bengal", "Inggris",
                "Merupakan hasil persilangan antara Kucing Leopard Asia dengan kucing domestik Inggris", R.drawable.cat_bengal));
        return kucings;
    }

    private static List<Anjing> initDataAnjing(Context ctx) {
        List<Anjing> anjings = new ArrayList<>();
        anjings.add(new Anjing("Bulldog", "Inggris",
                "Anjing populer yang dikenal dengan badan yang gemuk berotot, wajah seperti kain kusut, dan hidung yang pesek", R.drawable.dog_bulldog));
        anjings.add(new Anjing("Husky", "Alaska,Siberia,Finlandia (daerah bersalju) ",
                "Anjing jenis khusus yang awalnya digunakan untuk menarik kereta salju", R.drawable.dog_husky));
        return anjings;

    }

    private static List<Reptil> initDataReptil(Context ctx) {
        List<Reptil> reptils = new ArrayList<>();
        reptils.add(new Reptil("Piton/Sanca Bola", "Afrika",
                "Piton Bola(Sanca Bola) adalah suatu spesies Ular tidak berbisa yang ditemukan di Afrika. Spesies ini merupakan spesies Sanca terkecil di Afrika dan populer sebagai hewan peliharaan dikarenakan wataknya yang jinak. Saat ini tidak ada subspesies yang diketahui. Nama lainnya adalah Sanca raja.", R.drawable.reptile_pitonbola));
        reptils.add(new Reptil("Bearded Dragon", "Australia Bagian Tengah",
                "Bearded Dragon adalah kadal yang memiliki duri yang tersusun dalam barisan di lehernya. Menarik sekali penampilan kadal ini, hingga banyak orang yang memeliharanya.", R.drawable.reptile_beardeddragon));
        reptils.add(new Reptil("Bunglon", "Asia Selatan",
                "Bunglon cukup sulit dirawat karena mudah stres dan tidak menyukai sentuhan manusia.\n" +
                        "\n" +
                        "Namun, mekanisme pertahanan yang bisa membuatnya berubah warna adalah salah satu daya tarik yang membuat banyak orang jatuh cinta dengan bunglon.", R.drawable.reptile_bunglon));
        return reptils;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataKucing(ctx));
        hewans.addAll(initDataAnjing(ctx));
        hewans.addAll(initDataReptil(ctx));
    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}
