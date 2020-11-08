package br.com.stefanini.maratonadev.repository;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

@RequestScoped
public class ClienteRepository implements PanacheRepository<Cliente>{
	
//	@QueryParam("Select * from Cliente c where c.cpf = :cpf")
//	Cliente getClienteByCpf(@Param String cpf);

	public Optional<Cliente> findByCpf(String cpf) {
		return find("cpf", cpf).firstResultOptional();
	};
	
	

}
