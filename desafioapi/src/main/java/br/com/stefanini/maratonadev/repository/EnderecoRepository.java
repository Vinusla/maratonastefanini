package br.com.stefanini.maratonadev.repository;

import br.com.stefanini.maratonadev.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.Optional;

@RequestScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

//    @Transactional
//    public void save(Endereco endereco) {
//        this.save(endereco);
//    }

    public Optional<Endereco> getEnderecoByCep(String cep) {
        return this.find("cep", cep).firstResultOptional();
    }

}
