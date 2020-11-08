package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.dto.ClienteNewDto;
import br.com.stefanini.maratonadev.exception.ServiceException;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Endereco;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;
import br.com.stefanini.maratonadev.repository.ClienteRepository;

@RequestScoped
public class ClienteService {
	
	
	@Inject
	ClienteRepository clienteRepository;
	
	@Transactional
	public void create(@Valid ClienteNewDto clienteNewDto) throws ServiceException {
		
		clienteByCpf(clienteNewDto.getCpf());
		
		Endereco endereco = new Endereco(clienteNewDto.getBairro(), clienteNewDto.getCep(), clienteNewDto.getCidade(), clienteNewDto.getComplemento(), 
				clienteNewDto.getLogradouro(), clienteNewDto.getNumero(), clienteNewDto.getUf());
		ClienteDto clienteDto = ClienteParser.get().clienteDto(clienteNewDto);
		clienteDto.setEndereco(endereco);
		
		Cliente cliente = ClienteParser.get().cliente(clienteDto);
		
		this.clienteRepository.persist(cliente);
	}
    
    public List<Cliente> listar(){
		return clienteRepository.listAll();
    }

	private Optional<Cliente> clienteByCpf(String cpf) throws ServiceException {
		Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
		if(cliente.isPresent())
			throw new ServiceException("Cpf já cadastado.");		
				
		return cliente;
	}

}
