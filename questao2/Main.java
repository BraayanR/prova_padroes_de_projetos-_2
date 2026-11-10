package questao2;

import java.util.List;
import java.util.Locale;

public class Main {

  private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");
  private static final int MINUTOS_DE_PERMANENCIA = 150;

  public static void main(String[] args) {
    mostrarMesmoTempoEmTodosOsPerfis();
    mostrarTrocaDePerfilNoMesmoTicket();
  }

  private static void mostrarMesmoTempoEmTodosOsPerfis() {
    System.out.println("Permanência de " + MINUTOS_DE_PERMANENCIA + " minutos:");
    List<PerfilDeCobranca> perfis =
        List.of(new PerfilRotativo(), new PerfilMensalista(), new PerfilConveniado());
    for (PerfilDeCobranca perfil : perfis) {
      Ticket ticket = new Ticket("ABC-1234", MINUTOS_DE_PERMANENCIA, perfil);
      imprimir(ticket);
    }
  }

  private static void mostrarTrocaDePerfilNoMesmoTicket() {
    System.out.println("\nTroca de perfil no mesmo ticket:");
    Ticket ticket = new Ticket("XYZ-9876", MINUTOS_DE_PERMANENCIA, new PerfilRotativo());
    imprimir(ticket);

    ticket.setPerfil(new PerfilConveniado());
    imprimir(ticket);

    ticket.setPerfil(new PerfilMensalista());
    imprimir(ticket);
  }

  private static void imprimir(Ticket ticket) {
    System.out.println(
        String.format(
            PT_BR,
            "  %s | %-10s | R$ %.2f",
            ticket.getPlaca(),
            ticket.getPerfil().getNome(),
            ticket.valorAPagar()));
  }
}
