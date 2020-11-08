package br.com.stefanini.maratonadev.repository;

import br.com.stefanini.maratonadev.model.Locacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class LocacaoRepository implements PanacheRepository<Locacao> {
}
