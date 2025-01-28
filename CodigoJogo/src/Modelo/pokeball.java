
package Modelo;

import java.io.Serializable;

/**
 *
 * @author rafael
 */
public class pokeball extends Personagem implements Serializable{
    
    public pokeball(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bPoint=true;
    }
    
}
