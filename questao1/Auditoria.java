package questao1;

import java.util.ArrayList;
import java.util.List;

public class Auditoria implements AreaInteressada {

  private final List<String> registros = new ArrayList<>();

  @Override
  public void estoqueAlterado(String nomeProduto, int novaQuantidade) {
    registros.add("Estoque de " + nomeProduto + " alterado para " + novaQuantidade);
  }

  public List<String> getRegistros() {
    return List.copyOf(registros);
  }
}
