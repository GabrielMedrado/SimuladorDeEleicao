public class Partido {
    private String nome;
    private int votos;

    public Partido(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public int getVotos() {
        return this.votos;
    }

    public void adicionarVoto() {
        this.votos++;
    }
}
