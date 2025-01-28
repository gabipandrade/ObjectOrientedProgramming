package data;

import Controler.Tela;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class SaveLoad {
    Tela t;
    public SaveLoad(Tela t){
        this.t=t;
    }
    public void save(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
        } catch (IOException ex) {
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataStorage ds=new DataStorage();   
        ds.faseAtual=t.getFaseAtual();
        ds.GameOver=t.isGameOver();
        ds.currentDialogue=t.getCurrentDialogue();
        //escreve no arquivo
        try {
            oos.writeObject(ds);
        } catch (IOException ex) {
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void load() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
        } catch (IOException ex) {
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Leitura de arquivo
        DataStorage ds = null;
        try {
            ds = (DataStorage)ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.setFaseAtual(ds.faseAtual);
        t.setGameOver(ds.GameOver);
        t.setCurrentDialogue(ds.currentDialogue);

        
    }
}
