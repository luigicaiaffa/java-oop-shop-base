package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {

    // # Variabili di istanza
    private int codice;
    private String nome;
    private String descrizione;
    private BigDecimal prezzo;
    private String iva;

    // # Costruttore
    public Prodotto(String nome, String descrizione, BigDecimal prezzo, String iva) {

        // Genera un codice casuale
        Random random = new Random();
        this.codice = random.nextInt(100);

        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    // # Costruttore senza parametri
    public Prodotto() {

        // Genera un codice casuale
        Random random = new Random();
        this.codice = random.nextInt(100);

        this.nome = "Prodotto senza nome";
        this.descrizione = "Nessuna descrizione inserita";
        this.prezzo = new BigDecimal("0.00");
        this.iva = "0%";
    }

    // # Metodi getter e setter

    // codice
    public int getCodice() {
        return this.codice;
    }

    // nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome.length() >= 2) {
            this.nome = nome;
        } else {
            this.nome = "Prodotto senza nome";
        }
    }

    // descrizione
    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        if (descrizione != null && descrizione.length() >= 2) {
            this.descrizione = descrizione;
        } else {
            this.descrizione = "Nessuna descrizione inserita";
        }
    }

    // IVA
    public String getIva() {
        return this.iva;
    }

    public void setIva(String iva) {
        if (iva != null) {
            this.iva = iva;
        } else {
            this.iva = "0%";
        }
    }

    // prezzo
    public BigDecimal getPrezzo() {
        return this.prezzo.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setPrezzo(BigDecimal prezzo) {
        if (prezzo != null && prezzo.compareTo(BigDecimal.ZERO) > 0) {
            this.prezzo = prezzo;
        } else {
            this.prezzo = new BigDecimal("0.00");
        }
    }

    // # Metodi di istanza

    // stampare dettagli del prodotto
    public void stampaDettagli() {
        System.out.println("Prodotto: " + getNomeEsteso());
        System.out.println("Descrizione: " + this.descrizione);
        System.out.println("Prezzo base: " + getPrezzo());
        System.out.println("IVA: " + this.iva);
        System.out.println("Prezzo con IVA: " + getPrezzoConIva());
    }

    // calcolare prezzo con IVA
    public BigDecimal getPrezzoConIva() {
        BigDecimal ivaDecimale = new BigDecimal(this.iva.replace("%", ""))
                .divide(new BigDecimal("100"));

        BigDecimal prezzoConIva = this.prezzo.multiply(ivaDecimale).add(this.prezzo).setScale(2,
                RoundingMode.HALF_EVEN);
        return prezzoConIva;
    }

    // generare nome esteso (codice-nome)
    public String getNomeEsteso() {
        return this.codice + "-" + this.nome;
    }
}
