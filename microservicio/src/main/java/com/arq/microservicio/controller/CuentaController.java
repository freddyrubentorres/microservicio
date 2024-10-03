package com.arq.microservicio.controller;

import com.arq.microservicio.dto.cuenta.CuentaDto;
import com.arq.microservicio.entity.CuentaEntity;
import com.arq.microservicio.exception.ControllerHandler;
import com.arq.microservicio.service.implementation.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = API_PATH_CUENTA_BY_NUMERO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCuentaByNumero(@PathVariable("numero") String numero) {
        List<CuentaDto> cuentaDto = cuentaService.getCuentaByNumero(numero);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", cuentaDto);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postCuenta(@RequestBody CuentaEntity cuentaEntity) {
        CuentaEntity createdCuenta = cuentaService.saveCuenta(cuentaEntity);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", createdCuenta);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> putCuenta(@RequestBody CuentaEntity cuentaEntity) {
        CuentaEntity updateCuenta = cuentaService.putCuenta(cuentaEntity);
        return ControllerHandler.generateResponse(HttpStatus.OK, "SUCCESS", updateCuenta);
    }

}
