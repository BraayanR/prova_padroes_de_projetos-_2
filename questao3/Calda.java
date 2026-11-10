package questao3;

import java.math.BigDecimal;

public class Calda extends Complemento {

  private static final BigDecimal PRECO_CALDA = new BigDecimal("2.50");

  public Calda(Bebida bebida) {
    super(bebida, "Calda", PRECO_CALDA);
  }
}
