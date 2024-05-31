package Catalogo;

public class Rivista extends ElementoCatalogo {
    public enum Periodicita {
        Semestrale, Mensile, Settimanale
    }

    private Periodicita periodicita;

    public Rivista(String titolo, String codiceISBN, int numeroPagine, int annoPubblicazione, Periodicita periodicita) {
        super(titolo, codiceISBN, numeroPagine, annoPubblicazione);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}