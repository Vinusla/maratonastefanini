package br.com.stefanini.maratonadev.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "cliente")
@NamedNativeQueries({
	@NamedNativeQuery(name="INSERIR_CLIENTE", query = ""
			+ "INSERT INTO cliente (nome, cpf, email, endereco, contato) values "
			+ "(:nome, :cpf, :endereco, :email,:contato)"),
	@NamedNativeQuery(name="EXCLUIR_CLIENTE", query = "DELETE cliente WHERE cpf = :cpf"),
	@NamedNativeQuery(name="CONSULTAR_CLIENTE_ID", query = ""
			+ "SELECT id, nome, cpf FROM todo where id = :id", resultClass = Cliente.class),
	@NamedNativeQuery(name="CONSULTAR_CLIENTE_CPF", query = ""
			+ "SELECT id, nome, cpf FROM c where cpf = :cpf", resultClass = Cliente.class),
	@NamedNativeQuery(name="ATUALIZAR_CLIENTE", query="UPDATE cliente "
			+ "set nome = :nome, cpf = :cpf WHERE id = :id"),
})

public class Cliente extends PanacheEntityBase{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	

	@Column(name = "nome", nullable = false)
	@Length(max = 100, min = 3)
	private String nome;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id")
 	private Endereco endereco;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
 
	private String contato;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}
