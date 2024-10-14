package com.arq.microservicio.controller;

import com.arq.microservicio.dto.cliente.ClienteDto;
import com.arq.microservicio.entity.ClienteEntity;
import com.arq.microservicio.exception.ControllerHandler;
import com.arq.microservicio.service.implementation.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arq.microservicio.constant.ConstantsProcess.*;

/**
 * @author : Freddy Torres
 * file :  ClienteController
 * @since : 27/9/2024, vie
 **/

@RestController
@RequestMapping(API_PATH_CLIENTES)
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCliente() {
        List<ClienteDto> cliente = clienteService.getClientes();
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", cliente);
    }

    @RequestMapping(value = API_PATH_CLIENTES_BY_IDENTIFICACION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getClienteByIdentificacion(@PathVariable("identificacion") String identificacion) {
        List<ClienteDto> clienteDto = clienteService.getClientesByIdentificacion(identificacion);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", clienteDto);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postCliente(@RequestBody @Valid ClienteEntity clienteEntity) {
        ClienteEntity createdCliente = clienteService.saveCliente(clienteEntity);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", createdCliente);
    }

    @RequestMapping(value = API_PATH_CLIENTES_DELETE_BY_ID, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteCliente(@PathVariable("clienteId") Long clienteId) {
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", clienteService.deleteCliente(clienteId));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> putCliente(@RequestBody ClienteEntity clienteEntity) {
        ClienteEntity createdCliente = clienteService.putCliente(clienteEntity);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", createdCliente);
    }

}

