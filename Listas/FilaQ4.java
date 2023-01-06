import Estruturas.Stack;

/* Aqui é mais fácil utilizar uma pilha. Pois, como estamos lidando com fatoração e precisamos colocar em ordem DESCRESCENTE, o ultimo numero a entrar na pilha será o maior, e o primeiro, o menor. Sendo assim, quando retirar-mos da fila para imprimir na tela, a ordem estará correta */

public class FilaQ4 {
    public static void main(String[] args) {
        int n = 3960;
        Stack<Integer> stack = new Stack<>();
        // Enquanto o resultado de N não for 1, repetir.
        while (n > 1) {
            // Encontra o menor fator para N (o fator sempre vai ser primo)
            int d = encontraFator(n);
            // Adiciona o fator na pilha
            stack.push(d);
            // Atualiza o valor de n para o resultado de n/d
            n /= d;
        }
        // Imprime a fatoração prima em ordem decrescente
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " * ");
        }
    }

    // Encontra o próximo fator primo de n
    private static int encontraFator(int n) {
        // Começa a verificar os fatores a partir de 2
        int d = 2;
        // Enquanto não for divisão exata, soma 1 ao divisor
        while (n % d != 0) {
            d++;
        }
        return d;
    }
}
