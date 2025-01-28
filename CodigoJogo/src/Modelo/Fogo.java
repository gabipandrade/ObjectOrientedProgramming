package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

public class Fogo extends Personagem implements Serializable{
            
    public Fogo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
    }
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveDown()){
            Desenho.acessoATelaDoJogo().removePersonagem(this);
        }
        
    }
    
}
