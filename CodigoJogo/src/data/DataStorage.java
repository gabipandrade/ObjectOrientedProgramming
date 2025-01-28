package data;

import Modelo.Personagem;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author rafael
 */
public class DataStorage implements Serializable{
    //GameInfo
    ArrayList<Personagem> faseAtual;
    boolean GameOver;
    String[] currentDialogue;
}
