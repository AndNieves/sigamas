/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.cuenta;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.cuenta.excepciones.CreacionCuentaInvalidaException;
import uy.edu.ort.sigamas.seguridad.cuenta.utils.UtilCuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class CuentaBean implements CuentaBeanLocal {
    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;            
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Cuenta crearCuenta(String nombre, String empresa, String rut) throws CreacionCuentaInvalidaException{
        return UtilCuenta.crearCuenta(em, nombre, empresa, rut);        
    }
}