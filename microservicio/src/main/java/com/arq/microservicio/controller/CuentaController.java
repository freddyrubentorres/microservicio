package com.arq.microservicio.controller;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.dto.movimiento.MovimientoDto;
import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.entity.MovimientoEntity;
import com.arq.microservicio.exception.ControllerHandler;
import com.arq.microservicio.service.implementation.CuentaService;
import com.arq.microservicio.service.implementation.MovimientoService;
import jakarta.validation.Valid;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.arq.microservicio.constant.ConstantsProcess.*;

/**
 * @author : Freddy Torres
 * file :  CuentaController
 * @since : 1/10/2024, mar
 **/

@RestController
@RequestMapping(API_PATH_CUENTA)
public class CuentaController {
    @Autowired
    CuentaService cuentaService;

    @Autowired
    MovimientoService movimientoService;


    @RequestMapping(value = API_PATH_CUENTA_BY_NUMERO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCuentaByNumero(@PathVariable("numero") String numero) {
        List<CuentaDto> cuentaDto = cuentaService.getCuentaByNumero(numero);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", cuentaDto);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postCuenta(@RequestBody @Valid CuentaEntity cuentaEntity) {
        CuentaEntity createdCuenta = cuentaService.saveCuenta(cuentaEntity);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", createdCuenta);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> putCuenta(@RequestBody CuentaEntity cuentaEntity) {
        CuentaEntity updateCuenta = cuentaService.putCuenta(cuentaEntity);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", updateCuenta);
    }

    @RequestMapping(value = API_PATH_ESTADO_CUENTA + API_PATH_ESTADO_CUENTA_BY_IDENTIFICACION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getEstadoCuenta(@PathVariable("identificacion") String identificacion
            , @QueryParam("fechainicio") String fechainicio
            , @QueryParam("fechafin") String fechafin) throws ParseException {
        List<MovimientoDto> movimiento = movimientoService.getEstadoCuenta(identificacion, fechainicio, fechafin);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", movimiento);
    }

    @RequestMapping(value = API_PATH_MOVIMIENTO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postMovimiento(@RequestBody @Valid MovimientoEntity movimientoEntity) {
        MovimientoEntity createdMovimiento = movimientoService.saveMovimiento(movimientoEntity);

        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", createdMovimiento);
    }

}
