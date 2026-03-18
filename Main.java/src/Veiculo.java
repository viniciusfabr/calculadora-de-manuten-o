public class Veiculo {
    String marca;
    String modelo;
    int kmAtual;
    int kmMediaDiaria;
    int intervaloOleo;
    int intervaloSincronismo; // Nome genérico para servir para ambos
    String tipoSincronismo;   // Aqui você escreve "Correia Dentada" ou "Corrente de Comando"

    public Veiculo(String marca, String modelo, int km, int media, int intOleo, int intSinc, String tipoSinc) {
        this.marca = marca;
        this.modelo = modelo;
        this.kmAtual = km;
        this.kmMediaDiaria = media;
        this.intervaloOleo = intOleo;
        this.intervaloSincronismo = intSinc;
        this.tipoSincronismo = tipoSinc;
    }
}