package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {

    // Variabili di istanza
    public int codice;
    public String nome;
    public String descrizione;
    public BigDecimal prezzo;
    public String iva;

    // Costruttore
    public Prodotto(String nome, String descrizione, BigDecimal prezzo, String iva) {

        // Genera un codice casuale
        Random random = new Random();
        this.codice = random.nextInt(100);

        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    // Metodo per stampare dettagli del prodotto
    public void stampaDettagli() {
        System.out.println("Codice: " + codice);
        System.out.println("Nome: " + nome);
        System.out.println("Descrizione: " + descrizione);
        System.out.println("Prezzo: " + prezzo);
        System.out.println("IVA: " + iva);
    }

    // Metodo per avere il prezzo base
    public void getPrezzo() {
        System.out.println("Prezzo senza IVA: " + prezzo);
    }

    // Metodo per calcolare prezzo con IVA
    public void getPrezzoConIva() {
        BigDecimal ivaDecimale = new BigDecimal(iva.replace("%", ""))
                .divide(new BigDecimal("100"));

        BigDecimal prezzoConIva = prezzo.multiply(ivaDecimale).add(prezzo).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("Prezzo con IVA: " + prezzoConIva);
    }

    // Metodo per avere nome esteso (codice-nome)
    public void getNomeEsteso() {
        System.out.println("Nome esteso: " + codice + "-" + nome);
    }
}
