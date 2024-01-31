public class Paquet {
    private String name;
    private int numero;

    public Paquet(String name, int numero) {
        this.name = name;
        this.numero = numero;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getName() {
        return this.name;
    }

}
