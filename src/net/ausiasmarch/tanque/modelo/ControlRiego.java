/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ausiasmarch.tanque.modelo;

/**
 *
 * @author a022586153s
 */
public class ControlRiego {
    String mensaje;
    int sequia;
    int humedad;
    EstadoTanque estado;
    
    public ControlRiego(EstadoTanque estado){
        this.estado = estado;
    }
    public ControlRiego(){
        
    }
    
    public int permitidoLlenar(){
      
        if (sequia>10||sequia<0){
            mensaje="El valor de sequia no puede ser mayor que 10 o menor que 0";
            return 1;  
        }
        if(estado == EstadoTanque.LLENO){
            mensaje = "No se puede llenar el tanque si esta lleno";
            return 2;
        }
        if(sequia==10){
            mensaje="No se puede llenar si la sequia es 10";
            return 3;
        }
        if(estado == EstadoTanque.MEDIO){
            if(sequia>=7){
                mensaje="No se puede llenar mas de la mitad, si la sequia es mayor o igual a 7";
                return 4;
            }
            
        }
    //SI TODO VA BIEN
    return 0;
    }
    
    public int permitidoVaciar(){
        
        if (humedad>10||humedad<0){
            mensaje="La humedad del suelo no puede ser mayor que 10 o menor que 0";
            return 1;
        }
        if (estado == EstadoTanque.VACIO){
            mensaje="No se puede vaciar NADA para regar, si el tanque esta vacio";
            return 2;
        }
        if (humedad>=7){
            mensaje="No se puede vaciar nada para regar, si la humedad del suelo es mayor o igual que 7";
            return 3;
        }
        if(estado == EstadoTanque.MEDIO){
            if(humedad>=3 || humedad<=7){
                mensaje="No se puede vaciar más allá de la mitadp ara regar si la humedad del suelo es mayor o igual a 3 y menor que 7";
                return 4;
            }
        }
        //SI TODO VA BIEN
        return 0;
    }
    public String getMensaje(){
        
        return mensaje;
    }
    
    public int getSequia(){
        return sequia;
    }
    
    public int getHumedad(){
        return humedad;
    }
    public EstadoTanque getEstado(){
        return estado;
    }
    
    public void setSequia(int seq){
        sequia=seq; 
    }
    public void setHumedad(int hum){
        humedad=hum;
    }
    public void setEstado(EstadoTanque est){
        estado=est;
    }
    
}
