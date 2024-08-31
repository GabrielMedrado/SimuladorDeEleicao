import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();
        boolean loop = true;

        while (loop) {
            System.out.println("Menu: ");
            System.out.println("1. Criar Partido: ");
            System.out.println("2. Criar Candidato");
            System.out.println("3. Votar");
            System.out.println("4. Exibir Resultados");
            System.out.println("5. Sair");
            System.out.println("Digite uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do partido: ");
                    String nomePartido = scanner.nextLine();
                    Partido partido = new Partido(nomePartido);
                    sistema.adicionarPartido(partido);
                System.out.println("Partido " + nomePartido + " foi criado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o nome do candidato: ");
                    String nomeCanditado = scanner.nextLine();
                    System.out.println("Digite o nome do partido do candidato: ");
                    String nomePartidoDoCandidato = scanner.nextLine();
                    System.out.println("Digite o número do candidato: ");
                    int numeroCandidato = scanner.nextInt();

                    Partido partidoCandidato = sistema.buscarPartidoPorNome(nomePartidoDoCandidato);

                    if(partidoCandidato != null) {
                        Candidato candidato = new Candidato(nomeCanditado, partidoCandidato, numeroCandidato);
                        sistema.adicionarCandidato(candidato);
                        System.out.println("Candidato " + nomeCanditado + " foi criado com sucesso.");
                    } else {
                        System.out.println("Partido não encontrado. Crie um partido primeiro.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o número do candidato para votar: ");
                    int numeroVotoCandidato = scanner.nextInt();
                    sistema.votar(numeroVotoCandidato);
                    break;

                case 4:
                    sistema.exibirResultados();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
