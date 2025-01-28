
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
public class BichinhoVaiVemCima extends Personagem  implements Serializable{
    private boolean bRight;
    private int contaFrames;
    private int clock;
    private int animation;
    public BichinhoVaiVemCima(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
        this.bMortal=true;
        this.bAtiravel=true;
        contaFrames=0;
        animation=0;
        clock=0;
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
        contaFrames++;
        clock++;
        String name;
        
        if(bRight && contaFrames==2){
            if(validaPosicao(new Posicao(pPosicao.getLinha()+1,pPosicao.getColuna()))){
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
                contaFrames=0; 
            }else{
                bRight=false;
                contaFrames=0;
            }
        }
        else if(!bRight && contaFrames==2){
            if(validaPosicao(new Posicao(pPosicao.getLinha()-1,pPosicao.getColuna()))){

                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());           
                contaFrames=0;         
            }else{
                bRight=true;
                contaFrames=0;
            }
        }
        if(clock==3){
            
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
