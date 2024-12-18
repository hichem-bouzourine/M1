import java.util.LinkedList;

public class main {

    public static void main(String[] args) {
        int maximum = 8;
        int cible = 4;
        int NB_PRODUCTEURS = 5;
        int NB_CONSOMMATEURS = 4;
        int cptTapis = NB_PRODUCTEURS * cible;
        Tapis tapis = new Tapis(maximum, cptTapis);

        LinkedList<Producteur> producteurs = new LinkedList<Producteur>();
        for (int i = 0; i < NB_PRODUCTEURS; i++) {
            String nomProd = i == 0 ? "Pomme" : "Orange";
            Producteur p = new Producteur(tapis, nomProd, cible);
            producteurs.add(p);
            p.start();
        }

        LinkedList<Consommateur> consumers = new LinkedList<Consommateur>();
        for (int i = 0; i < NB_CONSOMMATEURS; i++) {
            Consommateur c = new Consommateur(tapis, i);
            consumers.add(c);
            c.start();
        }

        try {
            for (Producteur p : producteurs)
                p.join();
            for (Consommateur c : consumers)
                c.join();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
