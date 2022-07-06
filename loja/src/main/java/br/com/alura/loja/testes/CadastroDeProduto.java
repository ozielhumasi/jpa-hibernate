package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {

		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
		List<Produto> p3 = produtoDao.buscarPorNome("Xiami Redmi");
		p3.forEach(pp -> System.out.println(pp.getNome()));
		
		List<Produto> p4 = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		p4.forEach(ppp -> System.out.println(ppp.getPreco()));
		
		BigDecimal precoProduto = produtoDao.buscarPrecoDoProdutoPorNome("Xiami Redmi");
		
		System.out.println("O preço do produto é: " + precoProduto);


	}

	public static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiami Redmi", "Muito Legal", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtil.getEntityManager();

		// Comando SQL para gerar tabela :
// create table produtos (id bigint not null auto_increment, nome varchar(255),descricao varchar(255), preco decimal(19,2), primary key (id)) 
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);

		em.getTransaction().commit();

		em.close();
	}

}
