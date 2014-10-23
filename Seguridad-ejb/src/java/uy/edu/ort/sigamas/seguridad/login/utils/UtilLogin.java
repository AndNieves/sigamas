/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.seguridad.login.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import uy.edu.ort.sigamas.seguridad.entidades.Cuenta;
import uy.edu.ort.sigamas.seguridad.entidades.Usuario;

import uy.edu.ort.sigamas.seguridad.login.excepciones.ClaveInvalidaException;
import uy.edu.ort.sigamas.seguridad.login.excepciones.UsuarioInvalidoException;

/**
 *
 * @author Mattahari
 */
public class UtilLogin {

    public static boolean verificarUsuario(EntityManager em, String nombreUsuario, String claveUsuario) throws UsuarioInvalidoException, ClaveInvalidaException {

        Query queryUsuario = em.createNamedQuery("Usuario.findByNombreUsuario");
        List<Usuario> listaCoincidenciasUsuario = queryUsuario.getResultList();
        if (listaCoincidenciasUsuario.isEmpty()) {
            throw new UsuarioInvalidoException();
        } else if (!listaCoincidenciasUsuario.get(0).getClaveUsuario().equals(claveUsuario)) {
            throw new ClaveInvalidaException();
        }
        return true;
    }

    public static List<Cuenta> obtenerCuentas(EntityManager em, String nombreUsuario) {
        Query q = em.createNamedQuery("Usuario.findByNombreUsuario");
        List<Usuario> usuario = q.getResultList();
        Map<Integer, String> cuentasUsuario = new HashMap<>();
        if (!usuario.isEmpty()) {
            return usuario.get(0).getCuentaList();
        }
        return null;
    }
}
