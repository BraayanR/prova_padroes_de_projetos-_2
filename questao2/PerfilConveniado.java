package questao2;

import java.math.BigDecimal;

public class PerfilConveniado implements PerfilDeCobranca {

  private static final int MINUTOS_GRATUITOS = 30;
  private static final BigDecimal VALOR_HORA_INICIADA = new BigDecimal("8.00");
  private static final BigDecimal PERCENTUAL_DE_DESCONTO = new BigDecimal("0.25");

  @Override
  public String getNome() {
    return "Conveniado";
  }

  @Override
  public BigDecimal calcularValor(int minutosDePermanencia) {
    int minutosExcedentes = Math.max(0, minutosDePermanencia - MINUTOS_GRATUITOS);
    int horasCobradas = Tempo.horasIniciadas(minutosExcedentes);
    BigDecimal valorSemDesconto =
        VALOR_HORA_INICIADA.multiply(BigDecimal.valueOf(horasCobradas));
    return valorSemDesconto.multiply(BigDecimal.ONE.subtract(PERCENTUAL_DE_DESCONTO));
  }
}

