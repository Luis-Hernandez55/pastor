/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.pastor.entidades;

import java.sql.Date;
import mx.itson.pastor.enumerador.TipoMovimiento;

/**
 *
 * @author USUARIO
 */
public class Movimiento {
    
    private String concepto;
    private Date fecha;
    private double importe;
    private TipoMovimiento tipo;
    
}
