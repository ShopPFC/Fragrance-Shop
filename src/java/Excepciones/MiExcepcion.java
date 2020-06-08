/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Javier
 */
public class MiExcepcion extends Exception{
    private int codigoError;
    
    public MiExcepcion (int codigoError){
        this.codigoError = codigoError;
    }
    
    public int getCodigoError(){
        return codigoError;
    }
    
}



































