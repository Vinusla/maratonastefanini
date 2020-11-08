package br.com.stefanini.maratonadev.service;

import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Locacao;
import br.com.stefanini.maratonadev.repository.LocacaoRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class LocacaoService {

    @Inject
    LocacaoRepository locacaoRepository;

    @Transactional
    public void realizaLocacao(Cliente cliente, Carro carro) {
        Locacao locacao = new Locacao();
        locacao.setCarro(carro);
        locacao.setCliente(cliente);

        this.locacaoRepository.persistAndFlush(locacao);
    }





}