package questao2;

import java.math.BigDecimal;

public class PerfilRotativo implements PerfilDeCobranca {

  static final BigDecimal VALOR_HORA_INICIADA = new BigDecimal("8.00");

  @Override
  public String getNome() {
    return "Rotativo";
  }

  @Override
  public BigDecimal calcularValor(int minutosDePermanencia) {
    return VALOR_HORA_INICIADA.multiply(
        BigDecimal.valueOf(Tempo.horasIniciadas(minutosDePermanencia)));
  }
}

