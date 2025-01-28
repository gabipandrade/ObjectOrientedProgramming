package Modelo;
import java.io.Serializable;


/**
 *
 * @author rafael
 */
public class snake extends Personagem implements Serializable{
    
    public snake(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel=false;
        this.bAtiravel=true;
    }
    
}
