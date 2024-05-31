package Catalogo;

public class Rivista extends ElementoCatalogo {
    public enum Periodicita {
        Semestrale, Mensile, MENSILE, Settimanale
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


    @Override
    public String toString() {
        return  "codiceISBN=" + getCodiceISBN() + ", titolo=" + getTitolo() +
                ", annoPubblicazione=" + getAnnoPubblicazione() + ", numeroPagine=" + getNumeroPagine() +
                ", periodicita=" + periodicita;
    }
}