//Desafio 3 - Sitemas de Gerenciamento de Pedidos
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SistemaPedidos {

    public static Queue<String> registrarPedidos() {
        Scanner sc = new Scanner(System.in);
        Queue<String> filaDePedidos = new LinkedList<>();

        System.out.print("Quantos pedidos deseja registrar? ");
        int qtdPedidos = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= qtdPedidos; i++) {
            System.out.print("Digite a descrição do pedido " + i + ": ");
            String pedido = sc.nextLine();
            filaDePedidos.add(pedido);
        }

        return filaDePedidos;
    }

    public static Stack<String> prepararPratos(Queue<String> filaDePedidos) {
        Stack<String> pilhaDePratos = new Stack<>();

        while (!filaDePedidos.isEmpty()) {
            String pedido = filaDePedidos.poll();
            System.out.println("Cozinha preparando: [" + pedido + "]...");
            pilhaDePratos.push(pedido);
        }

        return pilhaDePratos;
    }


    public static void entregarPratos(Stack<String> pilhaDePratos) {
        while (!pilhaDePratos.isEmpty()) {
            String prato = pilhaDePratos.pop();
            System.out.println("Entregando o prato: [" + prato + "]");
        }
    }

    public static void main(String[] args) {
        Queue<String> pedidos = registrarPedidos();
        Stack<String> pratosProntos = prepararPratos(pedidos);
        entregarPratos(pratosProntos);

        System.out.println("\n✅ Fluxo de pedidos concluído!");
    }
}
