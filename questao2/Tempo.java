package questao2;

final class Tempo {

  private static final int MINUTOS_POR_HORA = 60;

  private Tempo() {}

  static int horasIniciadas(int minutos) {
    if (minutos <= 0) {
      return 0;
    }
    // Divisão e resto evitam somar 59 ao valor, o que poderia estourar para tempos grandes.
    return minutos / MINUTOS_POR_HORA + (minutos % MINUTOS_POR_HORA == 0 ? 0 : 1);
  }
}
