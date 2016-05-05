/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;

import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
   
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
     public ConexionBD conexionBD;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes)
    {
        
        
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        
        
        if(e.getActionCommand().equals("Agregar"))
        {
            
           if (conexionBD.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion()))
           {
               frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
               frm_MantenimientoEstudiantes.resetearGUI();
           }
           else 
           {
               frm_MantenimientoEstudiantes.mostrarMensaje("No se pudo registrar el estudiante");
           }
            
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
            
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(conexionBD.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion()))
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            else
                frm_MantenimientoEstudiantes.mostrarMensaje("No se pudo modificar el estudiante");
            
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(conexionBD.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
            }
            else
                frm_MantenimientoEstudiantes.mostrarMensaje("No se pudo eliminar");
            
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void buscar()
    {
        if(conexionBD.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            frm_MantenimientoEstudiantes.mostrarInformacion(conexionBD.getInfoEstudiante());
            frm_MantenimientoEstudiantes.habilitarEdicion();
                    
        }
        else
        {
           frm_MantenimientoEstudiantes.mostrarMensaje("No existe cedula");
           frm_MantenimientoEstudiantes.habilitarAgregar();
        }   
    }
    
    
    
    
    
    
    
    
    
    
    
}
