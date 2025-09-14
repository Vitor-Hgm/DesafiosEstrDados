package Desafios;

import java.util.Scanner;

public class LojaVendas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos produtos deseja cadastrar? ");
        int qtdProdutos = sc.nextInt();
        sc.nextLine();

        String[] nomes = new String[qtdProdutos];
        double[] precosCusto;
        double[] precosVenda;
        double[] quantidades;
        double[] lucros;
        String[] status;

        for (int i = 0; i < qtdProdutos; i++) {
            System.out.print("Digite o nome do produto " + (i + 1) + ": ");
            nomes[i] = sc.nextLine();
        }

        precosCusto = coletarDadosNumericos(sc, nomes, "Preço de Custo");
        precosVenda = coletarDadosNumericos(sc, nomes, "Preço de Venda");
        quantidades = coletarDadosNumericos(sc, nomes, "Quantidade Vendida");
        lucros = calcularLucros(precosCusto, precosVenda, quantidades);
        status = definirStatus(lucros);
        apresentarRelatorio(nomes, lucros, status);

        sc.close();
    }


    public static double[] coletarDadosNumericos(Scanner sc, String[] nomes, String tipoDado) {
        double[] valores = new double[nomes.length];

        for (int i = 0; i < nomes.length; i++) {
            double valor = -1;
            boolean valido = false;

            while (!valido) {
                System.out.print("Digite o [" + tipoDado + "] para o produto [" + nomes[i] + "]: ");
                if (sc.hasNextDouble()) {
                    valor = sc.nextDouble();
                    if (valor < 0) {
                        System.out.println("Valor inválido! Digite novamente (>= 0).");
                    } else {
                        valido = true;
                    }
                } else {
                    System.out.println("Entrada inválida! Digite apenas números.");
                    sc.next();
                }
            }
            valores[i] = valor;
        }
        return valores;
    }


    public static double[] calcularLucros(double[] precosCusto, double[] precosVenda, double[] quantidades) {
        double[] lucros = new double[precosCusto.length];

        for (int i = 0; i < precosCusto.length; i++) {
            lucros[i] = (precosVenda[i] - precosCusto[i]) * quantidades[i];
        }
        return lucros;
    }


    public static String[] definirStatus(double[] lucros) {
        String[] status = new String[lucros.length];

        for (int i = 0; i < lucros.length; i++) {
            if (lucros[i] > 0) {
                status[i] = "Lucro";
            } else if (lucros[i] < 0) {
                status[i] = "Prejuízo";
            } else {
                status[i] = "Equilíbrio";
            }
        }
        return status;
    }

    public static void apresentarRelatorio(String[] nomes, double[] lucros, String[] status) {
        System.out.println("\n===== RELATÓRIO DE VENDAS =====");
        System.out.printf("%-20s %-15s %-10s%n", "Produto", "Lucro Total", "Status");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("%-20s R$ %-13.2f %-10s%n", nomes[i], lucros[i], status[i]);
        }
    }
}
