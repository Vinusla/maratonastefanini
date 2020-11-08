package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.dto.ClienteNewDto;
import br.com.stefanini.maratonadev.exception.ServiceException;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
	
	
	@Inject
    ClienteService clienteService;
	
	@POST
	@Path("")
	@Operation(summary =  "Cadastrar Cliente", 
	description = "Cadastrar um Cliente")
	@APIResponse(responseCode = "201",
	description = "Cria um Cliente",
	content = {
			@Content(mediaType = "application/json",
			schema = @Schema(implementation = ClienteNewDto.class))
	})
	public Response create(ClienteNewDto clienteNewDto) throws ServiceException {
		
		this.clienteService.create(clienteNewDto);
		
		return Response
				.status(Response.Status.CREATED)
				.build();
		
	}

    @GET
    @Operation(summary = "Listar clientes",
            description = "Lista de cliente")
    @APIResponse(responseCode = "201",
            description = "cliente",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ClienteDto.class))
            }
    )
    public Response listar(){
        return Response
                .status(Response.Status.OK)
                .entity(clienteService.listar())
                .build();
    }

}
