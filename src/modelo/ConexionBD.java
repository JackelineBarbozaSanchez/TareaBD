package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaki
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    String[] arregloEstudiante;
    String [] arregloCurso;
    public ConexionBD()
    {
        realizarConexion();
        
        arregloEstudiante = new String [2];
        arregloCurso= new String [3];
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "Jaki0365!";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean registrarEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement st= null;
        boolean existe=false;
        try
        {
            st=con.createStatement();
            rs= st.executeQuery("SELECT * FROM `estudiantes` WHERE cedula='"+cedula+"'");
            if(rs.next())
            {
                arregloEstudiante[0]= rs.getString("nombre");
                arregloEstudiante[1]=rs.getString("direccion");
                existe=true;
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error en consultar estudiante "+e.getMessage());
            existe=false;
        } 
        return existe;
    }//fin de consultar
    public String[] getInfoEstudiante()
    {
       return arregloEstudiante; 
    }//Fin de getInfoEstudiante
    
    public boolean modificarEstudiante(String[] arreglo)
    {
        ResultSet resultSet=null;
        Statement statement=null;
        try 
        {
            statement=con.createStatement();
            statement.executeUpdate("UPDATE `estudiantes` SET `nombre`='"+arreglo[1]+"',`direccion`='"+arreglo[2]+"' WHERE cedula='"+arreglo[0]+"'");
            return true;
        } catch (Exception e) 
        {
            return false;
        }
    }//Fin de modificarEstudiante
    public boolean eliminarEstudiante(String cedula)
    {
        Statement statement=null;
        try 
        {
            statement=con.createStatement();
            statement.executeUpdate("DELETE FROM `estudiantes` WHERE cedula='"+cedula+"'");
            return true;
        } catch (Exception e) 
        {
            return false;
        }
    }//Fin de modificarEstudiante
    
    
    
    
    public boolean registrarCurso(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try 
        {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `cursos`(`sigla`, `nombre`, `creditos`, `horario`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement st= null;
        boolean existe=false;
        try
        {
            st=con.createStatement();
            rs= st.executeQuery("SELECT * FROM `cursos` WHERE sigla='"+sigla+"'");
            if(rs.next())
            {
                arregloCurso[0]= rs.getString("nombre");
                arregloCurso[1]=rs.getString("creditos");
                arregloCurso[2]=rs.getString("horario");
                existe=true;
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error en consultar curso "+e.getMessage());
            existe=false;
        } 
        return existe;
    }//fin de consultar
   
    public String[] getInfoCurso()
    {
       return arregloCurso; 
    }//Fin de getInfoEstudiante
    
    public boolean modificarCurso(String[] arreglo)
    {
        ResultSet resultSet=null;
        Statement statement=null;
        try 
        {
            statement=con.createStatement();
            statement.executeUpdate("UPDATE `cursos` SET `nombre`='"+arreglo[1]+"',`creditos`='"+arreglo[2]+"',`horario`='"+arreglo[3]+"' WHERE sigla='"+arreglo[0]+"'");
            return true;
        } catch (Exception e) 
        {
            return false;
        }
    }//Fin de modificarEstudiante
    public boolean eliminarCurso(String sigla)
    {
        Statement statement=null;
        try 
        {
            statement=con.createStatement();
            statement.executeUpdate("DELETE FROM `cursos` WHERE sigla='"+sigla+"'");
            return true;
        } catch (Exception e) 
        {
            return false;
        }
    }//Fin de modificarEstudiante
    
}//fin d clase 
