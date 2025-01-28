package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.io.Serializable;

public class Caveira extends Personagem implements Serializable{
    private int iContaIntervalos;
    
    public Caveira(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.bAtiravel=true;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER){
            this.iContaIntervalos = 0;
            Fogo f = new Fogo("fire.png");
            f.setPosicao(pPosicao.getLinha()+1,pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(f);
        }
    }    
}
