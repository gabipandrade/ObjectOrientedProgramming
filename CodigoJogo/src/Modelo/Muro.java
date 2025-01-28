/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;


public class Muro extends Personagem implements Serializable{
    public Muro(String sNomeImagePNG){
        super(sNomeImagePNG);
        this.bTransponivel=false;
    }
    
    
}
