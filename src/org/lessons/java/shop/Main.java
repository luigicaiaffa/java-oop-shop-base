package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Prodotto prodotto = new Prodotto("Pallone", "Pallone da calcio in cuoio", new BigDecimal("10.50"), "22%");

        prodotto.stampaDettagli();
    }
}
