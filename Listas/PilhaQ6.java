import Estruturas.*;
import java.util.Scanner;

public class PilhaQ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> estacionamento = new Stack<>();
        int manobras = 0;

        // Processa as entradas
        while (sc.hasNextLine()) {
            String[] entrada = sc.nextLine().split(" "); // Pega a linha divitada e divide em uma array
            if (entrada.length < 2) {// Se só tiver 1 item ele invalida
                System.out.println("Entrada inválida");
                continue;
            }

            // Só pega o item 1 e 2 da array
            String operacao = entrada[0];
            String placa = entrada[1];

            if (operacao.equals("E")) {
                if (estacionamento.size() < 10) {
                    // Há vaga, adiciona o carro no estacionamento
                    estacionamento.push(placa);
                    System.out.println("Carro " + placa + " entrou no estacionamento. Espaço livre: "
                            + (10 - estacionamento.size()));
                } else {
                    // Não há vaga, o carro sai sem entrar no estacionamento
                    System.out.println("Carro " + placa + " saiu sem entrar no estacionamento.");
                }
            } else if (operacao.equals("S")) {
                // Cria uma lista temporária para armazenar os carros enquanto são realizadas as
                // manobras
                List<String> temp = new List<>();

                // Percorre a pilha até encontrar o carro da placa especificada
                while (!estacionamento.isEmpty() && !estacionamento.topo().equals(placa)) {
                    // Adiciona o carro à lista temporária
                    temp.add(estacionamento.pop());
                    manobras++;
                }

                // Verifica se o carro foi encontrado
                if (estacionamento.isEmpty()) {
                    // O carro não está no estacionamento
                    System.out.println("Carro " + placa + " não encontrado no estacionamento.");
                } else {
                    // Remove o carro do estacionamento
                    estacionamento.pop();
                    System.out.println("Carro " + placa + " saiu do estacionamento. Número de manobras: " + manobras);
                    manobras = 0;
                }

                // Adiciona os carros da lista temporária de volta à pilha
                for (int i = temp.size() - 1; i >= 0; i--) {
                    estacionamento.push(temp.get(i));
                }
            }
        }
    }
}