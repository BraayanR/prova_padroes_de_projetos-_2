package questao3;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Complemento implements Bebida {

  private final Bebida pedidoBase;
  private final String nome;
  private final BigDecimal valorAdicional;

  protected Complemento(Bebida pedidoBase, String nome, BigDecimal valorAdicional) {
    this.pedidoBase = Objects.requireNonNull(pedidoBase, "pedidoBase");
    if (nome == null || nome.isBlank()) {
      throw new IllegalArgumentException("O nome do complemento é obrigatório");
    }
    this.nome = nome;
    this.valorAdicional = Objects.requireNonNull(valorAdicional, "valorAdicional");
    if (valorAdicional.signum() < 0) {
      throw new IllegalArgumentException("O preço do complemento não pode ser negativo");
    }
  }

  @Override
  public String getDescricao() {
    return pedidoBase.getDescricao() + " + " + nome;
  }

  @Override
  public BigDecimal getPreco() {
    return pedidoBase.getPreco().add(valorAdicional);
  }
}
