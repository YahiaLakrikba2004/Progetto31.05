package Archivio;

import Catalogo.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestoreArchivio {
    private List<ElementoCatalogo> elementi = new ArrayList<>();

    // Aggiunta di un elemento
    public void aggiungiElemento(ElementoCatalogo elemento) {
        elementi.add(elemento);
    }

    // Rimozione di un elemento dato un codice ISBN
    public void rimuoviElemento(String isbn) {
        elementi.removeIf(e -> e.getCodiceISBN().equals(isbn));
    }

    // Ricerca per ISBN
    public ElementoCatalogo ricercaPerISBN(String ISBN) {
        return elementi.stream()
                .filter(e -> e.getCodiceISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    // Ricerca per anno pubblicazione
    public List<ElementoCatalogo> ricercaPerAnnoDiPubblicazione(int anno) {
        return elementi.stream()
                .filter(e -> e.getAnnoPubblicazione() == e.getAnnoPubblicazione())
                .collect(Collectors.toList());
    }

    // Ricerca per autore
    public List<ElementoCatalogo> ricercaPerAutore(String autore) {
        return elementi.stream()
                .filter(e -> e instanceof Libro && ((Libro) e).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    // Salvataggio su disco
    public void salvataggioSulDisco(String filePath) {
        try {
            List<String> lines = elementi.stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            Files.write(Path.of(filePath), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Archivio salvato correttamente su disco!");
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante il salvataggio dell'archivio su disco: " + e.getMessage());
        }
    }

    public void caricamentoDalDisco(String filePath) {
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            elementi = lines.map(line -> {
                        String[] parts = line.split(",");
                        switch (parts[0]) {
                            case "Libro":
                                return new Libro(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), parts[5], parts[6]);
                            case "Rivista":
                                return new Rivista(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Rivista.Periodicita.valueOf(parts[5]));
                            default:
                                return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            System.out.println("Archivio caricato correttamente dal disco!");
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante il caricamento dell'archivio dal disco: " + e.getMessage());
        }
    }





    public List<ElementoCatalogo> getElementi() {
        return elementi;
    }
}
