package questao2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Ticket {

  private static final int CASAS_DECIMAIS = 2;

  private final String placa;
  private final int minutosDePermanencia;
  private PerfilDeCobranca perfil;

  public Ticket(String placa, int minutosDePermanencia, PerfilDeCobranca perfil) {
    if (placa == null || placa.isBlank()) {
      throw new IllegalArgumentException("A placa do veículo é obrigatória");
    }
    if (minutosDePermanencia < 0) {
      throw new IllegalArgumentException(
          "O tempo de permanência não pode ser negativo: " + minutosDePermanencia);
    }
    this.placa = placa;
    this.minutosDePermanencia = minutosDePermanencia;
    this.perfil = Objects.requireNonNull(perfil, "perfil");
  }

  public String getPlaca() {
    return placa;
  }

  public int getMinutosDePermanencia() {
    return minutosDePermanencia;
  }

  public PerfilDeCobranca getPerfil() {
    return perfil;
  }

  public void setPerfil(PerfilDeCobranca perfil) {
    this.perfil = Objects.requireNonNull(perfil, "perfil");
  }

  public BigDecimal valorAPagar() {
    return perfil.calcularValor(minutosDePermanencia).setScale(CASAS_DECIMAIS, RoundingMode.HALF_UP);
  }
}

