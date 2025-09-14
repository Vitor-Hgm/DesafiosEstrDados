package Clinica;

import java.util.Scanner;

public class GerenciadorClinica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FilaDeAtendimento fila = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();

        boolean executando = true;

        while (executando) {
            System.out.println("\n===================================================");
            System.out.println("1. Adicionar novo paciente à fila");
            System.out.println("2. Atender próximo paciente");
            System.out.println("3. Exibir fila de atendimento");
            System.out.println("4. Exibir histórico de atendimentos");
            System.out.println("5. Sair");
            System.out.println("===================================================");
            System.out.print("Escolha uma opção: ");

            if (!sc.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número de 1 a 5.");
                sc.next(); // descarta entrada inválida
                continue;
            }

            int opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            if (opcao == 1) {
                System.out.print("Nome do paciente: ");
                String nome = sc.nextLine();

                int idade;
                while (true) {
                    System.out.print("Idade: ");
                    if (sc.hasNextInt()) {
                        idade = sc.nextInt();
                        sc.nextLine(); // consumir quebra
                        break;
                    } else {
                        System.out.println("Idade inválida! Digite um número inteiro.");
                        sc.next(); // descarta entrada inválida
                    }
                }

                System.out.print("Sintoma: ");
                String sintoma = sc.nextLine();

                Paciente novoPaciente = new Paciente(nome, idade, sintoma);
                fila.adicionarPaciente(novoPaciente);
                System.out.println("Paciente adicionado com sucesso!");

            } else if (opcao == 2) {
                Paciente atendido = fila.atenderPaciente();
                if (atendido != null) {
                    System.out.println("Atendendo paciente: " + atendido.exibirInfo());
                    historico.adicionarAoHistorico(atendido);
                } else {
                    System.out.println("Nenhum paciente na fila.");
                }

            } else if (opcao == 3) {
                System.out.println("Fila de Atendimento:");
                fila.mostrarFila();

            } else if (opcao == 4) {
                System.out.println("Histórico de Atendimentos:");
                historico.mostrarHistorico();

            } else if (opcao == 5) {
                System.out.println("Encerrando o sistema...");
                executando = false;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }
}
