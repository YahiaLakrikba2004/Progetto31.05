package Archivio;

import Catalogo.*;

public class Main {
    public static void main(String[] args) {
        // Creazione di un gestore di archivio
        GestoreArchivio gestoreArchivio = new GestoreArchivio();

        // Caricamento dell'archivio dal disco
        gestoreArchivio.caricamentoDalDisco("archivio.txt");

        // Stampa degli elementi presenti nell'archivio
        System.out.println("Elementi presenti nell'archivio:");
        gestoreArchivio.getElementi().forEach(System.out::println);

        System.out.println("------------------------------------");

        // Aggiunta di alcuni elementi di esempio all'archivio
        aggiungiElementiDiEsempio(gestoreArchivio);


        // Salvataggio dell'archivio su disco dopo l'aggiunta degli elementi
        gestoreArchivio.salvataggioSulDisco("archivio.txt");

        // Rimozione di un elemento dall'archivio
        gestoreArchivio.rimuoviElemento("987654");
        System.out.println("------------------------------------");
        // Ricerca per ISBN
        ElementoCatalogo libro = gestoreArchivio.ricercaPerISBN("456789");
        System.out.println("Ricerca per ISBN: " + gestoreArchivio.ricercaPerISBN("456789"));
        System.out.println("------------------------------------");
        // Ricerca per anno di pubblicazione
        System.out.println("Ricerca per anno di pubblicazione: " + gestoreArchivio.ricercaPerAnnoDiPubblicazione(1949));
        System.out.println("------------------------------------");
        // Ricerca per autore
        System.out.println("Ricerca per autore " + gestoreArchivio.ricercaPerAutore("George Orwell"));



    }
    private static void aggiungiElementiDiEsempio(GestoreArchivio gestoreArchivio) {
        gestoreArchivio.aggiungiElemento(new Libro("1984", "456789", 328, 1949, "George Orwell", "Distopia"));
        gestoreArchivio.aggiungiElemento(new Rivista("Scientific American", "987654", 80, 2023, Rivista.Periodicita.MENSILE));
        gestoreArchivio.aggiungiElemento(new Libro("Cronache del ghiaccio e del fuoco", "321654", 694, 1996, "George R. R. Martin", "Fantasy"));
        gestoreArchivio.aggiungiElemento(new Rivista("Wired", "456123", 184, 2022, Rivista.Periodicita.MENSILE));

    }
}
