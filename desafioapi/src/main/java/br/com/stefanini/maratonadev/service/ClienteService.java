package br.com.stefanini.maratonadev.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.dto.ClienteNewDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Endereco;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

@RequestScoped
public class ClienteService {
	
	@Inject
    ClienteDao clienteDao;
	
	public void create(@Valid ClienteNewDto clienteNewDto) {
		
		clienteByCpf(clienteNewDto.getCpf());
		
		Endereco endereco = new Endereco(clienteNewDto.getBairro(), clienteNewDto.getCep(), clienteNewDto.getCidade(), clienteNewDto.getComplemento(), 
				clienteNewDto.getLogradouro(), clienteNewDto.getNumero(), clienteNewDto.getUf());
		ClienteDto clienteDto = ClienteParser.get().clienteDto(clienteNewDto);
		clienteDto.setEndereco(endereco);
		
		Cliente cliente = ClienteParser.get().cliente(clienteDto);
		
		this.clienteDao.save(cliente);		
		
	}
    
    public List<Cliente> listar(){
        return clienteDao.listar();
    }
    
    private Cliente clienteByCpf(String cpf) {
    	Cliente cliente = clienteDao.getClienteByCpf(cpf);
		if(cliente != null) {
			throw new NotFoundException();
		}
		return cliente;
	}

}
