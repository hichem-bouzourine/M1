public class Producteur extends Thread {
    private String name;
    private int cible;
    private Tapis tapis;

    public Producteur() {
    }

    public Producteur(Tapis tapis, String name, int cible) {
        this.name = name;
        this.cible = cible;
        this.tapis = tapis;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < cible) {
            try {
                while (tapis.getMaximum() == tapis.getNombreElement()) {
                    wait();
                }
                synchronized (tapis) {
                    Paquet pq = new Paquet(this.name, i);
                    tapis.add(pq);
                    System.out.println(name + "  " + i);
                    i++;
                    notify();
                    Thread.sleep(2200);
                }
            } catch (Exception e) {

            }

        }
    }
}
