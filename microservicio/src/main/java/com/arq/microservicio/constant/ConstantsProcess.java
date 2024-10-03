package com.arq.microservicio.constant;

/**
 * @author : Freddy Torres
 * file :  ConstantsProcess
 * @since : 27/9/2024, vie
 **/

public final class ConstantsProcess {
    public static final String API_PATH_CLIENTES = "/clientes";
    public static final String API_PATH_CLIENTES_BY_IDENTIFICACION = "/{identificacion}";
    public static final String API_PATH_CLIENTES_DELETE_BY_ID = "/{clienteId}";
    public static final String API_PATH_CUENTA = "/cuenta";
    public static final String API_PATH_CUENTA_BY_NUMERO = "/{numero}";
    public static final String API_PATH_ESTADO_CUENTA = "/estadocuenta";
    public static final String API_PATH_MOVIMIENTO = "/movimiento";
    public static final String API_PATH_ESTADO_CUENTA_BY_IDENTIFICACION = "/{identificacion}";
    public static final String APERTURA_CUENTA_DESC = "APERTUTA DE CUENTA";
    public static final int ID_DEPOSITO = 2;
    public static final String FORMAT_DATE = "yyyy-MM-dd";
}
