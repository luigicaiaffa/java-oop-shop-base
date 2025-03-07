package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Prodotto prodotto = new Prodotto("Pallone", "Pallone da calcio in cuoio", new BigDecimal("10.50"), "22%");

        System.out.println("-----");
        System.out.println("Prodotto: " + prodotto.getNomeEsteso());
        System.out.println("Codice: " + prodotto.getCodice());
        System.out.println("Nome: " + prodotto.getNome());
        System.out.println("Descrizione: " + prodotto.getDescrizione());
        System.out.println("Prezzo base: " + prodotto.getPrezzo());
        System.out.println("IVA: " + prodotto.getIva());
        System.out.println("Prezzo con IVA: " + prodotto.getPrezzoConIva());
        System.out.println("-----");

        prodotto.setNome("Maglietta");
        prodotto.setDescrizione("Maglietta bianca in cotone con logo");
        prodotto.setIva("4%");
        prodotto.setPrezzo(new BigDecimal("17.50"));

        System.out.println("Prodotto: " + prodotto.getNomeEsteso());
        System.out.println("Codice: " + prodotto.getCodice());
        System.out.println("Nome: " + prodotto.getNome());
        System.out.println("Descrizione: " + prodotto.getDescrizione());
        System.out.println("Prezzo base: " + prodotto.getPrezzo());
        System.out.println("IVA: " + prodotto.getIva());
        System.out.println("Prezzo con IVA: " + prodotto.getPrezzoConIva());
        System.out.println("-----");

    }
}
