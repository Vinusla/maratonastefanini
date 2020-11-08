package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.model.parser.CarroParser;
import br.com.stefanini.maratonadev.repository.CarroRepository;


@RequestScoped
public class CarroService {

    
    @Inject    
    CarroRepository carroRepository;


    public List<CarroDto> listar(){
    	return carroRepository.listAll().stream().map(CarroParser.get()::dto).collect(Collectors.toList());
    }
}
