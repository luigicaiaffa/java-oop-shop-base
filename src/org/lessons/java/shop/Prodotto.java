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
        System.out.println("Prodotto: " + getNomeEsteso());
        System.out.println("Descrizione: " + descrizione);
        System.out.println("Prezzo Senza IVA: " + getPrezzo());
        System.out.println("IVA: " + iva);
        System.out.println("Prezzo con IVA: " + getPrezzoConIva());
    }

    // Metodo per avere il prezzo base
    public BigDecimal getPrezzo() {
        return prezzo.setScale(2, RoundingMode.HALF_EVEN);
    }

    // Metodo per calcolare prezzo con IVA
    public BigDecimal getPrezzoConIva() {
        BigDecimal ivaDecimale = new BigDecimal(iva.replace("%", ""))
                .divide(new BigDecimal("100"));

        BigDecimal prezzoConIva = prezzo.multiply(ivaDecimale).add(prezzo).setScale(2, RoundingMode.HALF_EVEN);
        return prezzoConIva;
    }

    // Metodo per avere nome esteso (codice-nome)
    public String getNomeEsteso() {
        return codice + "-" + nome;
    }
}
