/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jaki
 */
public class TextoYNumeros 
{
    public TextoYNumeros()
    {
//        String texto="25";
//        int numero = Integer.parseInt(texto.trim());
//        System.out.println("El numero se comvirtio bien y es "+numero);
        
        if(verificarNumero("123"))
        {
            System.out.println("Solo cobtiene numeros");
        }
        else 
        {
            System.out.println("Contiene lettras");
        }  
        
          if(verificarSimbolo("jaki@hola.com"))
        {
            System.out.println("Si contien @ y .");
        }
        else 
        {
            System.out.println("No Contiene alguno de los dos");
        }    


    }//fin del constructor
    
    public boolean verificarNumero(String texto)
    {
        boolean esNumero= true;
        for (int contador =0; contador<texto.length();contador++)
        {
            if (Character.isLetter(texto.charAt(contador)))
            {
                esNumero= false;
            }
            
        }
        return esNumero;
    }// fin de verificar numero
    
    public boolean verificarSimbolo(String texto)
    {
        if (texto.contains("@")&&texto.contains("."))
        {
            return true;

        }
        else 
        {
        return false;
        }
       }//fin de vrificar simbolo
        
    public boolean verificarTexto(String texto)
    {
        boolean text= true;
        
        for (int contador =0; contador<texto.length();contador++)
        {
            if (Character.isLetter(texto.charAt(contador)))
            {
                text= false;
            }
            
        }
        return text;
    
    }//fin de texto 
   
    public static void main(String[] arg)
    { new TextoYNumeros();
        
    }
    
    
}//fin de clase 
