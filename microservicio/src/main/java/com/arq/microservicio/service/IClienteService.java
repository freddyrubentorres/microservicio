package com.arq.microservicio.service;

import com.arq.microservicio.dto.cliente.ClienteDto;
import com.arq.microservicio.entity.ClienteEntity;

import java.util.List;

/**
 * @author : Freddy Torres
 * file :  IClienteService
 * @since : 30/9/2024, lun
 **/

public interface IClienteService {
    List<ClienteDto> getClientes();
    List<ClienteDto> getClientesByIdentificacion(String identificacion);
    ClienteEntity saveCliente(ClienteEntity clienteEntity);
    boolean deleteCliente(Long clienteId);
    ClienteEntity putCliente(ClienteEntity clienteEntity);
}
