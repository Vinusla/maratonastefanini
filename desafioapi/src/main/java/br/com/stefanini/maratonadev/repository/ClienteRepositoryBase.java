package br.com.stefanini.maratonadev.repository;

import br.com.stefanini.maratonadev.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ClienteRepositoryBase extends PanacheRepository<Cliente>{

}
