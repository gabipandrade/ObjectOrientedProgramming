/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import auxiliar.Posicao;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author rafael
 */
public class BichinhoSeguidor extends Personagem  implements Serializable{
    Hero h;
    private int contaFramesx;
    private int contaFramesy;
    private int Cooldown=5;
    private int animation;
    private int clock;
    
    public BichinhoSeguidor(String sNomeImagePNG, Hero h) {
        super(sNomeImagePNG);
        this.h=h;
        this.bMortal=true;
        this.bAtiravel=true;
        clock=0;
        animation=0;
    }
    private boolean validaPosicao(Posicao p){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(p)) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }


    public void autoDesenho(){
        contaFramesx++;
        contaFramesy++;
        String name;
        clock++;
        int y=this.pPosicao.getLinha()-h.pPosicao.getLinha();
        int x=this.pPosicao.getColuna()-h.pPosicao.getColuna();
        
        if(y>0 && contaFramesy>=Cooldown){
            if(validaPosicao(new Posicao(pPosicao.getLinha()-1,pPosicao.getColuna()))){
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
                contaFramesy=0; 
            }
        }
        else if(y<0 && contaFramesy>=Cooldown){
            if(validaPosicao(new Posicao(pPosicao.getLinha()+1,pPosicao.getColuna()))){

                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());           
                contaFramesy=0;         
            }
        }
        if(x>0 && contaFramesx>=Cooldown){
            if(validaPosicao(new Posicao(pPosicao.getLinha(),pPosicao.getColuna()-1))){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
                contaFramesx=0; 
            }
        }
        else if(x<0 && contaFramesx>=Cooldown){
            if(validaPosicao(new Posicao(pPosicao.getLinha(),pPosicao.getColuna()+1))){

                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);           
                contaFramesx=0;         
            }
        }if(clock==3){
            
            name="slimesRed_0_"+animation+".png";
            try {
                this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + name);
            } catch (IOException ex) {
                Logger.getLogger(BichinhoVaiVemHorizontal.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(animation==8){
                animation=0;
            }else{
                animation++;
            }
            clock=0;
        }
        
        super.autoDesenho();
    }
    
}
