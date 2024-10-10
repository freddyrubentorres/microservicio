package com.arq.microservicio.service.implementation;

import com.arq.microservicio.dto.cliente.ClienteDto;
import com.arq.microservicio.entity.ClienteEntity;
import com.arq.microservicio.exception.ResourceNotFoundException;
import com.arq.microservicio.mapper.cliente.ClienteMapper;
import com.arq.microservicio.repository.IClienteRepository;
import com.arq.microservicio.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Freddy Torres
 * file :  ClienteService
 * @since : 27/9/2024, vie
 **/

@Service
public class ClienteService implements IClienteService {
    @Autowired
    IClienteRepository iClienteRepository;

    @Override
    public List<ClienteDto> getClientes() {
        List<ClienteEntity> clienteEntity = iClienteRepository.findAll();
        return clienteEntity.stream().map(ClienteMapper::mapToClienteDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClienteDto> getClientesByIdentificacion(String identificacion) {
        List<ClienteEntity> cliente = iClienteRepository.findByIdentificacion(identificacion);
        if (cliente.isEmpty()) {
            throw new ResourceNotFoundException("Cliente con identificacion : " + identificacion + ", no  encontrado.");
        }
        return cliente.stream().map(ClienteMapper::mapToClienteDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteEntity saveCliente(ClienteEntity clienteEntity) {
        return iClienteRepository.save(clienteEntity);
    }

    @Override
    public boolean deleteCliente(Long clienteId) {
        Optional<ClienteEntity> clients = iClienteRepository.findById(clienteId);
        if (clients.isEmpty()) {
            throw new ResourceNotFoundException("Cliente con id : " + clienteId + ", no  encontrado.");
        }
        iClienteRepository.deleteById(clienteId);
        return true;
    }

    @Override
    public ClienteEntity putCliente(final ClienteEntity clienteEntity) {
        Optional<ClienteEntity> clients = iClienteRepository.findById(clienteEntity.getId());
        if (clients.isEmpty()) {
            throw new ResourceNotFoundException("Cliente con id : " + clienteEntity.getId() + ", no  encontrado.");
        }
        return iClienteRepository.save(clienteEntity);
    }
}
