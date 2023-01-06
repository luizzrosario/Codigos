import Estruturas.Stack;

public class PilhaQ5 {
  public static boolean validaExpressao(String expression) {
    Stack<Character> expressao = new Stack<>();

    // Verifica cada char convertendo a string em uma array de chars
    for (char c : expression.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        expressao.push(c);
      } else if (c == ')') {
        if (expressao.isEmpty() || expressao.pop() != '(') {
          return false;
        }
      } else if (c == ']') {
        if (expressao.isEmpty() || expressao.pop() != '[') {
          return false;
        }
      } else if (c == '}') {
        if (expressao.isEmpty() || expressao.pop() != '{') {
          return false;
        }
      }
    }
    return expressao.isEmpty();
  }

  public static void main(String[] args) {
    String a = "{[(5 * 7)/5] * 4 - [(5 * 7) * 2]} /(3 * 6)";
    if (validaExpressao(a)) {
      System.out.println("Expressão A é válida");
    } else {
      System.out.println("Expressão A não é válida");
    }

    String b = "{2 + [(16 + 2 ∧ 3) - 4)} * 3";
    if (validaExpressao(b)) {
      System.out.println("Expressão B é válida");
    } else {
      System.out.println("Expressão B não é válida");
    }

    String c = "){}[](";
    if (validaExpressao(c)) {
      System.out.println("Expressão C é válida");
    } else {
      System.out.println("Expressão C não é válida");
    }
  }
}
