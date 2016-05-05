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
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;

/**
 *
 * @author tecnologiamultimedia
 */


    
public class Controlador_FRM_VentanaPrincipal implements ActionListener{

    FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes;
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    ConexionBD conexionBD;
    FRM_Matricula frm_Matricula;
    
    public Controlador_FRM_VentanaPrincipal()
    {
        conexionBD = new ConexionBD();
        frm_MantenimientoEstufiantes= new FRM_MantenimientoEstudiantes();
        frm_MantenimientoCursos= new FRM_MantenimientoCursos();
        frm_Matricula =new FRM_Matricula(frm_MantenimientoEstufiantes,frm_MantenimientoCursos);
        
        frm_MantenimientoEstufiantes.controlador_FRM_MantenimientoEstudiantes.conexionBD=this.conexionBD;
        frm_MantenimientoCursos.controlador.conexionBD=conexionBD;
        frm_Matricula.controlador.conexionBD= conexionBD;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            frm_MantenimientoEstufiantes.setVisible(true);    
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            frm_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            frm_Matricula.setVisible(true);
            frm_Matricula.colocarCodigo();
        }
    
    }
    
    
    
    
    
}












