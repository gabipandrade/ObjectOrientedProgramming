
package Modelo;

import Auxiliar.Desenho;
import auxiliar.Posicao;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author rafael
 */
public class Bichinhoteleporta  extends Personagem  implements Serializable{
    private boolean bRight;
    Random rand=new Random();
    private int contaFrames;
    public Bichinhoteleporta(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
        contaFrames=0;
        this.bPoint=true;
        
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
        if(contaFrames==5){
            contaFrames=0;
            int NovaColuna=rand.nextInt(15);
            int NovaLinha=rand.nextInt(15);
            
            if(validaPosicao(new Posicao(NovaLinha,NovaColuna))){
                this.setPosicao(NovaLinha, NovaColuna);
            }
            //aparece=!aparece;
        }
        super.autoDesenho();
        bRight = !bRight;
    }
}
