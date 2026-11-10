package questao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produto {

  private final String nome;
  private int quantidadeEmEstoque;
  private final List<AreaInteressada> areasInteressadas = new ArrayList<>();

  public Produto(String nome, int quantidadeEmEstoque) {
    if (nome == null || nome.isBlank()) {
      throw new IllegalArgumentException("O nome do produto é obrigatório");
    }
    this.nome = nome;
    this.quantidadeEmEstoque = validarQuantidade(quantidadeEmEstoque);
  }

  public String getNome() {
    return nome;
  }

  public int getQuantidadeEmEstoque() {
    return quantidadeEmEstoque;
  }

  public void incluirAreaInteressada(AreaInteressada area) {
    AreaInteressada areaValida = Objects.requireNonNull(area, "area");
    if (!areasInteressadas.contains(areaValida)) {
      areasInteressadas.add(areaValida);
    }
  }

  public void removerAreaInteressada(AreaInteressada area) {
    areasInteressadas.remove(area);
  }

  public void alterarQuantidade(int novaQuantidade) {
    int quantidadeValidada = validarQuantidade(novaQuantidade);
    if (quantidadeValidada == quantidadeEmEstoque) {
      return;
    }

    quantidadeEmEstoque = quantidadeValidada;
    notificarAreasInteressadas();
  }

  private void notificarAreasInteressadas() {
    // A cópia mantém esta notificação estável se uma área se inscrever ou sair durante o aviso.
    for (AreaInteressada area : List.copyOf(areasInteressadas)) {
      area.estoqueAlterado(nome, quantidadeEmEstoque);
    }
  }

  private static int validarQuantidade(int quantidade) {
    if (quantidade < 0) {
      throw new IllegalArgumentException(
          "A quantidade em estoque não pode ser negativa: " + quantidade);
    }
    return quantidade;
  }
}
