package br.com.stefanini.maratonadev.rest;

import br.com.stefanini.maratonadev.dto.LocacaoDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.service.LocacaoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("locacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocacaoRest {

    @Inject
    LocacaoService service;

    @GET
    @Operation(summary = "Locação de carros",
            description = "Realiza a locação de carros para um cliente")
    @APIResponse(responseCode = "201",
            description = "locação",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = LocacaoDto.class))
            }
    )
    public Response realizaLocacao(Cliente cliente, Carro carro){

        this.service.realizaLocacao(cliente, carro);

        return Response
                .status(Response.Status.CREATED)
                .build();
    }

}