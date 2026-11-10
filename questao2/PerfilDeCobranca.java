package questao2;

import java.math.BigDecimal;

public interface PerfilDeCobranca {

  String getNome();

  BigDecimal calcularValor(int minutosDePermanencia);
}

