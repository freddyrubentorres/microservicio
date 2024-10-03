package com.arq.microservicio.controller;

import com.arq.microservicio.entity.MovimientoEntity;
import com.arq.microservicio.exception.ControllerHandler;
import com.arq.microservicio.service.implementation.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import static com.arq.microservicio.constant.ConstantsProcess.API_PATH_MOVIMIENTO;

/**
 * @author : Freddy Torres
 * file :  MovimientoController
 * @since : 2/10/2024, mié
 **/

@RestController
@RequestMapping(API_PATH_MOVIMIENTO)
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postMovimiento(@RequestBody MovimientoEntity movimientoEntity) {
        MovimientoEntity createdMovimiento = movimientoService.saveMovimiento(movimientoEntity);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", createdMovimiento);
    }
}
