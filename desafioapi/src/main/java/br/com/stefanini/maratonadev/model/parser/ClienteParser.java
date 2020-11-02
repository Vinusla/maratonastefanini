package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.dto.ClienteNewDto;
import br.com.stefanini.maratonadev.model.Cliente;

public class ClienteParser {

	public static ClienteParser get(){
        return  new ClienteParser();
    }

    public ClienteDto dto(Cliente entidade){
        ClienteDto dto = new ClienteDto();

        dto.setNome(entidade.getNome());;
        dto.setCpf(entidade.getCpf());
        dto.setContato(entidade.getContato());;
        dto.setEmail(entidade.getEmail());
        dto.setEndereco(entidade.getEndereco());        
        return dto;
    }
    
    public Cliente cliente(ClienteDto dto){
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());;
        cliente.setCpf(dto.getCpf());
        cliente.setContato(dto.getContato());;
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(dto.getEndereco());        
        return cliente;
    }
    
    public ClienteDto clienteDto(ClienteNewDto dto){
    	ClienteDto clienteDto = new ClienteDto();

    	clienteDto.setNome(dto.getNome());;
    	clienteDto.setCpf(dto.getCpf());
    	clienteDto.setContato(dto.getContato());;
    	clienteDto.setEmail(dto.getEmail());                
        return clienteDto;
    }
    
    
}
