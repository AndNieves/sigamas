/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.usuario;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;
import uy.edu.ort.sigamas.seguridad.usuario.utils.UtilUsuario;

/**
 *
 * @author Pikachuss
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {

    @PersistenceContext(unitName = "Seguridad-PU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public boolean crearUsuario(String nombreUsuario, String claveUsuario, String primerNombre, String primerApellido, String segundoNombre, String segundoApellido, String emailUsuario, Date fechaNacimiento, String profesion, String sexo, String telefono) {
       return UtilUsuario.crearUsuario(em, nombreUsuario, claveUsuario, primerNombre, primerApellido, segundoNombre, segundoApellido, emailUsuario, fechaNacimiento, profesion, sexo, telefono);
    }

    @Override
    public Usuario modificarUsuario(Object nuevoUsuario) {
        return UtilUsuario.modificarUsuario(em, nuevoUsuario);
    }

    @Override
    public boolean eliminarUsuario(String nombreUsuario) {
        return UtilUsuario.eliminarUsuario(em, nombreUsuario);
    }
}
