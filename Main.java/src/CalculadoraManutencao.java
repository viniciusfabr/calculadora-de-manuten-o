import java.time.LocalDate;

public class CalculadoraManutencao {

    // Constantes para os intervalos (facilita a manutenção do código)
    public static final int INTERVALO_OLEO = 10000;
    public static final int INTERVALO_CORREIA = 50000;

    public void verificarComponentes(Veiculo carro) {
        System.out.println("--- Relatório de Manutenção: " + carro.modelo + " ---");

        // Lógica para o Óleo
        int restoOleo = carro.kmAtual % INTERVALO_OLEO;
        int kmParaTrocaOleo = INTERVALO_OLEO - restoOleo;

        System.out.println("Troca de Óleo em: " + kmParaTrocaOleo + " km.");

        // Exemplo de uso da data (Diferencial)
        if (carro.kmMediaDiaria > 0) {
            long diasParaTroca = kmParaTrocaOleo / carro.kmMediaDiaria;
            LocalDate dataEstimada = LocalDate.now().plusDays(diasParaTroca);
            System.out.println("Data estimada da troca: " + dataEstimada);
        }
    }
}
