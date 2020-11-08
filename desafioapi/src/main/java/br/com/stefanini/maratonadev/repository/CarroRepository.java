package br.com.stefanini.maratonadev.repository;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Carro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@RequestScoped
public class CarroRepository implements PanacheRepository<Carro>{

}
