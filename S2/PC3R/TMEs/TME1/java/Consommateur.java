public class Consommateur extends Thread {

    private Tapis tapis;
    private int id;

    public Consommateur() {
    }

    public Consommateur(Tapis tapis, int id) {
        this.tapis = tapis;
        this.id = id;
    }

    @Override
    public void run() {
        while (tapis.getCompteur() > 0) {
            try {
                synchronized (tapis) {
                    Paquet pq = tapis.remove();
                    if (pq == null)
                        continue;
                    System.out.println("Consommateur " + id + " mange " + pq.getName() + " " + pq.getNumero());
                    notify();
                    Thread.sleep(1500);
                }
            } catch (Exception e) {
            }

        }
    }

}