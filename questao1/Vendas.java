package questao1;

import java.util.HashSet;
import java.util.Set;

public class Vendas implements AreaInteressada {

  private final Set<String> produtosSemEstoque = new HashSet<>();

  @Override
  public void estoqueAlterado(String nomeProduto, int novaQuantidade) {
    if (novaQuantidade == 0) {
      produtosSemEstoque.add(nomeProduto);
      return;
    }

    // O alerta só faz sentido se esta área tiver observado o produto zerar antes.
    if (produtosSemEstoque.remove(nomeProduto)) {
      System.out.println(
          "[Vendas] ALERTA: " + nomeProduto + " voltou ao estoque (" + novaQuantidade + " un.)");
    }
  }
}
