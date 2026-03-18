import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== SELECIONE O VEÍCULO ===");
        System.out.println("1 - VW Polo Track (Motor MPI)");
        System.out.println("2 - Chevrolet Onix (Correia Banhada a Óleo)");
        System.out.println("3 - Hyundai HB20 (Motor Kappa)");
        System.out.print("Escolha uma opção: ");
        int opcao = entrada.nextInt();

        System.out.print("Digite a KM atual do carro: ");
        int km = entrada.nextInt();

        System.out.print("Média de KM rodados por dia: ");
        int media = entrada.nextInt();

        // Variável que vai guardar o carro selecionado
        Veiculo carroSelecionado = null;

        // "Banco de Dados" manual com as informações técnicas
        switch (opcao) {
            case 1:
                // Polo: Óleo 10k / Correia 120k
                carroSelecionado = new Veiculo("Volkswagen", "Polo Track", km, media, 10000, 120000, "Correia dentada!");
                break;
            case 2:
                // Onix: Óleo 10k / Correia 240k (Mas recomendação técnica de 100k no Brasil)
                carroSelecionado = new Veiculo("Chevrolet", "Onix", km, media, 10000, 100000, "Correia dentada!");
                break;
            case 3:
                // HB20: Óleo 10k / Corrente de comando (Intervalo muito longo, ex: 200k)
                carroSelecionado = new Veiculo("Hyundai", "HB20", km, media, 10000, 200000, "Corrente de comando!");
                break;
            default:
                System.out.println("Opção inválida!");
        }

        if (carroSelecionado != null) {
            exibirRelatorio(carroSelecionado);
        }

        entrada.close();
    }

    public static void exibirRelatorio(Veiculo v) {
        System.out.println("\n--- FICHA DE MANUTENÇÃO: " + v.marca + " " + v.modelo + " ---");

        // Lógica de cálculo (usando o resto % que aprendemos)
        int faltaOleo = v.intervaloOleo - (v.kmAtual % v.intervaloOleo);

        System.out.println("-> Troca de Óleo em: " + (v.kmAtual + faltaOleo) + " km (Faltam " + faltaOleo + " km)");

        if (v.kmMediaDiaria > 0) {
            System.out.println("-> Estimativa: Próxima parada em " + (faltaOleo / v.kmMediaDiaria) + " dias.");
        }
        System.out.println("-------------------------------------------------");
        int faltaSincronismo = v.intervaloSincronismo - (v.kmAtual % v.intervaloSincronismo);

        if (v.tipoSincronismo.equals("Corrente de Comando")) {
            System.out.println("-> " + v.tipoSincronismo + ": Revisar tensão/ruído em " + (v.kmAtual + faltaSincronismo) + " km");
            System.out.println("   (Correntes duram mais, mas exigem inspeção)");
        } else {
            System.out.println("-> " + v.tipoSincronismo + " Troca OBRIGATÓRIA em " + (v.kmAtual + faltaSincronismo) + " km");
        }
    }
}