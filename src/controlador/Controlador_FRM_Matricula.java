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
public class Controlador_FRM_Matricula implements ActionListener{
   public ConexionBD conexionBD;
    
    FRM_Matricula frm_matricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos frm_MantenimientoCursos,FRM_Matricula frm_matricula)
    {
        this.frm_matricula=frm_matricula;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("ConsultaRapidaCedula"))
        {
           // if(metodosEstudiantes.consultarEstudiante(frm_matricula.devolverCedula()))
//            {
//               // String arreglo[]=metodosEstudiantes.getArregloInformacion();
//              //  frm_matricula.colocarNombreEstudiante(arreglo[0]);
//                encontroEstudiante=true;
//            }
//            //else
//            {
//                frm_matricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
//            }
            
        }
        if(e.getActionCommand().equals("ConsultaRapidaSigla"))
//        {
//          //  if(metodosCursos.consultarCurso(frm_matricula.devolverSigla()))
//            //{
//               // String arreglo[]=metodosCursos.getArregloInformacion();
//                //frm_matricula.colocarNombreCurso(arreglo[0]);
//                encontroCurso=true;
//            }
//           // else
//            {
//                frm_matricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
//            }
        //}
        if(e.getActionCommand().equals("Agregar"))
        {
            frm_matricula.agregarInformacionTabla();
            frm_matricula.limpiarSigla();
        }
        if(e.getActionCommand().equals("Finalizar"))
        {
            String arreglo[]=new String[3];
            for(int contador=0;contador<frm_matricula.getCantidadFilas();contador++)
            {
                arreglo[0]=frm_matricula.devolverCodigo();
                arreglo[1]=frm_matricula.devolverDato(contador,1);
                arreglo[2]=frm_matricula.devolverDato(contador,3);
              //  metodosMatricula.agregarMatricula(arreglo);
            }
            frm_matricula.colocarCodigo();
            frm_matricula.resetearVentana();
            encontroEstudiante=false;
            encontroCurso=false;
        }
        if(e.getActionCommand().equals("Consultar"))
        {
//           // if(metodosMatricula.consultarMatricula(frm_matricula.devolverCodigo()))
//            {
//
//            }
//           // else
//            {
//            
//            }
        
        }
        verificarConsultas();
    }
    public void verificarConsultas()
    {
        if(encontroEstudiante && encontroCurso)
        {
            this.frm_matricula.habilitarAgregar();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
