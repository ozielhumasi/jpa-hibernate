package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * A classe Produto está mapeando uma tabela na DB
 * A anotação @Table é necessária pq o nome
 * da tabela é diferente do nome da Entity;
 */
@Entity
@Table(name = "produtos")
public class Produto {

	/*
	 * A anotação '@Id' evidencia para a JPA que o atributo é a chave primária
	 * 
	 * A anotação "@generatedValue" indica que a chave primária será gerada pela DB;
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
