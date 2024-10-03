package com.arq.microservicio.controller;

import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.exception.ControllerHandler;
import com.arq.microservicio.service.implementation.MovimientoService;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

import static com.arq.microservicio.constant.ConstantsProcess.API_PATH_ESTADO_CUENTA;
import static com.arq.microservicio.constant.ConstantsProcess.API_PATH_ESTADO_CUENTA_BY_IDENTIFICACION;

/**
 * @author : Freddy Torres
 * file :  EstadoCuentaController
 * @since : 1/10/2024, mar
 **/

@RestController
@RequestMapping(API_PATH_ESTADO_CUENTA)
public class EstadoCuentaController {

    @Autowired
    MovimientoService movimientoService;

    @RequestMapping(value = API_PATH_ESTADO_CUENTA_BY_IDENTIFICACION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getEstadoCuenta(@PathVariable("identificacion") String identificacion
            , @QueryParam("fechainicio") String fechainicio
            , @QueryParam("fechafin") String fechafin) throws ParseException {
        List<MovimientoDto> movimiento = movimientoService.getEstadoCuenta(identificacion, fechainicio, fechafin);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", movimiento);
    }

}
