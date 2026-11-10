package questao3;

import java.math.BigDecimal;

public class Cha implements Bebida {

  private static final BigDecimal PRECO_CHA = new BigDecimal("5.00");

  @Override
  public String getDescricao() {
    return "Chá";
  }

  @Override
  public BigDecimal getPreco() {
    return PRECO_CHA;
  }
}
