package questao3;

import java.math.BigDecimal;

public class Chantilly extends Complemento {

  private static final BigDecimal PRECO_CHANTILLY = new BigDecimal("3.00");

  public Chantilly(Bebida bebida) {
    super(bebida, "Chantilly", PRECO_CHANTILLY);
  }
}
