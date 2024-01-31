import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Tapis extends Thread {
    private LinkedList<Paquet> paquets;
    private int maximum, currentCount, compteur;

    public Tapis(int maximum, int compteur) {
        this.paquets = new LinkedList<Paquet>();
        this.maximum = maximum;
        this.currentCount = 0;
        this.compteur = compteur;
    }

    public void setPaquets(LinkedList<Paquet> paquets) {
        this.paquets = paquets;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public LinkedList<Paquet> getPaquets() {
        return this.paquets;
    }

    public int getMaximum() {
        return this.maximum;
    }

    public int getNombreElement() {
        return this.currentCount;
    }

    public int getCompteur() {
        return this.compteur;
    }

    public void add(Paquet pq) {
        this.paquets.add(pq);
        this.currentCount++;
    }

    public Paquet remove() {
        try {
            Paquet pq = getPaquets().remove();
            this.currentCount--;
            this.compteur--;
            return pq;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
