package questao2;

import java.math.BigDecimal;

public class PerfilMensalista implements PerfilDeCobranca {

  private static final BigDecimal VALOR_MENSAL = new BigDecimal("300.00");

  @Override
  public String getNome() {
    return "Mensalista";
  }

  @Override
  public BigDecimal calcularValor(int minutosDePermanencia) {
    return VALOR_MENSAL;
  }
}
