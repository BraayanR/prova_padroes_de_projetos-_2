package questao3;

import java.util.List;
import java.util.Locale;

public class Main {

  private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

  public static void main(String[] args) {
    List<Bebida> pedidos = criarPedidosDeDemonstracao();
    imprimirPedidos(pedidos);
  }

  private static List<Bebida> criarPedidosDeDemonstracao() {
    return List.of(
        new Espresso(),
        new Chantilly(new Leite(new Espresso())),
        new Calda(new Calda(new Cha())),
        new Chantilly(new Leite(new Leite(new Cha()))));
  }

  private static void imprimirPedidos(List<Bebida> pedidos) {
    for (int indice = 0; indice < pedidos.size(); indice++) {
      imprimirPedido(indice + 1, pedidos.get(indice));
    }
  }

  private static void imprimirPedido(int numeroPedido, Bebida bebidaSolicitada) {
    System.out.println(
        String.format(
            PT_BR,
            "Pedido %d: %s | R$ %.2f",
            numeroPedido,
            bebidaSolicitada.getDescricao(),
            bebidaSolicitada.getPreco()));
  }
}
