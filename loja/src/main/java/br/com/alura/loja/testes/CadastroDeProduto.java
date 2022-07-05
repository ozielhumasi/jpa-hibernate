package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Xiami Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));
		
		EntityManager em = JPAUtil.getEntityManager();
		
		// Comando SQL para gerar tabela :
// create table produtos (id bigint not null auto_increment, descricao varchar(255), nome varchar(255), preco decimal(19,2), primary key (id)) 
		ProdutoDAO dao = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
		
	}

}
