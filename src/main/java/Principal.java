import com.manoelcampos.exportador.Coluna;
import com.manoelcampos.exportador.ExportadorListaProduto;
import com.manoelcampos.exportador.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Executa a aplicação Exportador Simple Factory.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("TV", "LG", "132-A", 120, 1000));
        produtos.add(new Produto("Notebook", "Asus", "New age", 341, 4000));
        produtos.add(new Produto("Smartphone", "Samsung", "Galaxy S10", 214, 2000));

        ExportadorListaProduto exportadorPadrao = ExportadorListaProduto.newInstance();
        System.out.println("Lista de Produtos em HTML\n");
        exportadorPadrao.addNewColuna(Principal::precoComDesconto, "Preço com desconto");
        System.out.println(exportadorPadrao.exportar(produtos));

        ExportadorListaProduto exportadorMarkdown = ExportadorListaProduto.newInstance("md");
        System.out.println("Lista de Produtos em Markdown\n");
        exportadorMarkdown.addNewColuna(Principal::precoComDesconto, "Preço com desconto");
        System.out.println(exportadorMarkdown.exportar(produtos));
    }

    private static double precoComDesconto(Produto produto) {
        return produto.getPreco() * 0.9;
    }

}
