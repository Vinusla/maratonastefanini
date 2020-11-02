package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.repository.ClienteRepository;

@RequestScoped
public class ClienteDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	ClienteRepository clienteRepository;
	
	@Transactional
	public void save(Cliente cliente) {
		cliente.persistAndFlush();		
	}
	
	public List<Cliente> listar(){
		return Cliente.listAll();
    }
	
	public <Optional>Cliente getClienteByCpf(String cpf){		
		return clienteRepository.findByCpf(cpf);		
    }
	
}
