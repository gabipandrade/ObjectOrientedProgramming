
package Modelo;

import Auxiliar.Consts;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author rafael
 */
public class Heart  extends Personagem implements Serializable{
    private int animation;
    private int clock;
    boolean active;
    public Heart(String sNomeImagePNG,boolean active) {
        super(sNomeImagePNG);
        this.bTransponivel=false;
        this.Life=true;
        animation=0;
        clock=0;
        this.active=active;
    }
    public void autoDesenho(){
        clock++;
        String name;
        if(active){
            if(clock==3){
                name="hearts_0_"+animation+".png";
                try {
                    this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + name);
                } catch (IOException ex) {
                    Logger.getLogger(Heart.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(animation==7){
                    animation=0;
                }else{
                    animation++;
                }
                clock=0;
            }
        }else{
            if(clock==3){
                name="deathHearts_0_"+animation+".png";
                try {
                    this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + name);
                } catch (IOException ex) {
                    Logger.getLogger(Heart.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(animation==7){
                    
                }else{
                    animation++;
                }
                clock=0;
            }
        }
        super.autoDesenho();        
    }

    
}
