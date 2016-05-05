/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;

import vista.FRM_MantenimientoCursos;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{

    FRM_MantenimientoCursos frm_mantenimientoCursos;
   
        public ConexionBD conexionBD;
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_mantenimientoCursos)
    {
        this.frm_mantenimientoCursos=frm_mantenimientoCursos;
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            
           if (conexionBD.registrarCurso(frm_mantenimientoCursos.devolverInformacion()))
           {
               frm_mantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
               frm_mantenimientoCursos.resetearGUI();
           }
           else 
           {
               frm_mantenimientoCursos.mostrarMensaje("No se pudo registrar el curso");
           }
            
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("ConsultaRapida"))
        {            
            buscar();
            
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(conexionBD.modificarCurso(frm_mantenimientoCursos.devolverInformacion()))
            {
                frm_mantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
                frm_mantenimientoCursos.resetearGUI();
            }
            else
                frm_mantenimientoCursos.mostrarMensaje("No se pudo modificar el curso");
            
            frm_mantenimientoCursos.resetearGUI();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(conexionBD.eliminarCurso(frm_mantenimientoCursos.devolverSigla()))
            {
            frm_mantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            frm_mantenimientoCursos.resetearGUI();
            }
            else
                frm_mantenimientoCursos.mostrarMensaje("No se pudo eliminar");
            
            frm_mantenimientoCursos.resetearGUI();
        }
    }
    public void buscar()
    {
        if(conexionBD.consultarCurso(frm_mantenimientoCursos.devolverSigla()))
        {
            frm_mantenimientoCursos.mostrarInformacion(conexionBD.getInfoCurso());
            frm_mantenimientoCursos.habilitarEdicion();
                    
        }
        else
        {
           frm_mantenimientoCursos.mostrarMensaje("No existe lasigla");
           frm_mantenimientoCursos.habilitarAgregar();
        }   
    }

    

    
}
