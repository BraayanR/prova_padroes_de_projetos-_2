package questao3;

import java.math.BigDecimal;

public class Leite extends Complemento {

  private static final BigDecimal PRECO_LEITE = new BigDecimal("2.00");

  public Leite(Bebida bebida) {
    super(bebida, "Leite", PRECO_LEITE);
  }
}
