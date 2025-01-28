
package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

/**
 *
 * @author rafael
 */
public class Tiro extends Personagem implements Serializable {
    private int Facing;
    public Tiro(String sNomeImagePNG,int Facing) {
        super(sNomeImagePNG);
        this.Facing=Facing;
        this.bMortal = true;
        this.bProjetil=true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
        if(this.Facing==0 && !this.moveUp()){
            this.moveUp();
            Desenho.acessoATelaDoJogo().removePersonagem(this);
        }else if(this.Facing==1 && !this.moveDown()){
            this.moveDown();
            Desenho.acessoATelaDoJogo().removePersonagem(this);
            
        }else if(this.Facing==2 && !this.moveRight()){
            this.moveRight();
            Desenho.acessoATelaDoJogo().removePersonagem(this);
            
        }else if(this.Facing==3 && !this.moveLeft()){
            this.moveLeft();
            Desenho.acessoATelaDoJogo().removePersonagem(this);
            
        }
        
    }
    
}


