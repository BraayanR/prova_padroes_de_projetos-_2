package questao1;

public class Main {

  public static void main(String[] args) {
    Produto notebook = new Produto("Notebook", 10);
    Compras compras = new Compras();
    Vendas vendas = new Vendas();
    Auditoria auditoria = new Auditoria();

    notebook.incluirAreaInteressada(compras);
    notebook.incluirAreaInteressada(vendas);
    notebook.incluirAreaInteressada(auditoria);

    demonstrarAlteracoesDeEstoque(notebook);
    demonstrarRemocaoDeArea(notebook, compras);
    exibirAuditoria(auditoria);
  }

  private static void demonstrarAlteracoesDeEstoque(Produto produto) {
    alterarEstoque(produto, 8);
    alterarEstoque(produto, 4);
    alterarEstoque(produto, 4); // Quantidade igual: não deve gerar nova notificação.
    alterarEstoque(produto, 0);
    alterarEstoque(produto, 7);
  }

  private static void demonstrarRemocaoDeArea(Produto produto, Compras compras) {
    System.out.println("\n--- Compras removida do produto ---");
    produto.removerAreaInteressada(compras);
    alterarEstoque(produto, 2);
    alterarEstoque(produto, 0);
    alterarEstoque(produto, 12);
  }

  private static void exibirAuditoria(Auditoria auditoria) {
    System.out.println("\n--- Registro da Auditoria ---");
    auditoria.getRegistros().forEach(System.out::println);
  }

  private static void alterarEstoque(Produto produto, int novaQuantidade) {
    System.out.println(
        "\n> "
            + produto.getNome()
            + ": "
            + produto.getQuantidadeEmEstoque()
            + " -> "
            + novaQuantidade);
    produto.alterarQuantidade(novaQuantidade);
  }
}
