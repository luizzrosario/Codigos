package Listas;

import java.util.Scanner;

import Listas.Estruturas.List;

// Criando a classe carro
class Carro {
    private String placa;

    public Carro(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
}

public class PilhaQ6 {
    public static void main(String[] args) {
        // Cria uma lista para armazenar os carros no estacionamento
        List<Carro> estacionamento = new List<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] partes = linha.split(" ");
            String operacao = partes[0];
            String placa = partes[1];

            if (operacao.equals("E")) {
                // Chegada de um carro
                Carro carro = new Carro(placa);
                if (estacionamento.size() < 10) {
                    // Existe vaga no estacionamento, adiciona o carro
                    estacionamento.add(carro);
                    System.out.println("Carro " + placa + " entrou no estacionamento");
                } else {
                    // Não existe vaga, o carro parte sem entrar
                    System.out.println("Carro " + placa + " saiu sem entrar no estacionamento");
                }
            } else if (operacao.equals("S")) {
                // Saída de um carro
                int manobras = 0;
                while (!estacionamento.get(0).getPlaca().equals(placa)) {
                    // O carro a ser retirado não está no topo da fila, remove todos os carros da
                    // frente
                    estacionamento.remove(0);
                    manobras++;
                }
                // Remove o carro a ser retirado
                estacionamento.remove(0);
                System.out.println("Carro " + placa + " saiu do estacionamento com " + manobras + " manobras");
            }
        }
        scanner.close();
    }
}
