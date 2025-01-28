package Modelo;

import Auxiliar.Consts;

import Auxiliar.Desenho;
import auxiliar.Posicao;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Hero extends Personagem implements Serializable{
    //PONTOS DA FASE
    private int Points;
    //CONTROLE
    private int aniTick,aniIndex,aniSpeed=2;
    private int playerDir=-1;
    private boolean moving=false;
    private boolean left,up,right,down;
    //ATRIBUTOS
    private int Life;
    private int Fase;
    private int Balas;
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        Life=5;
        Points=0;
        Fase=1;
        Balas=0;
    }

   
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }

    public int getPoints() {
        return Points;
    }

    public int getLife() {
        return Life;
    }

    public void setLife(int Life) {
        this.Life = Life;
    }

    public int getBalas() {
        return Balas;
    }

    public void setBalas(int Balas) {
        this.Balas = Balas;
    }
    
    
    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }

    /*TO-DO: este metodo pode ser interessante a todos os personagens que se movem*/
    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public boolean moveUp() {
        if(super.moveUp()){
            if(moving){
                switch (aniIndex) {
                case 0:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_3_0.png");//small_image_2_0btrainer41 
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 1:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_3_1.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 2:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_3_2.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 3:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_3_3.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                default:
                    break;
                }
            }
            return validaPosicao();
        }
            
        return false;
    }
 
    public boolean moveDown() {
        if(super.moveDown()){
            if(moving){
                switch (aniIndex) {
                case 0:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_0_0.png");//small_image_1_1btrainer11
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 1:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_0_1.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 2:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_0_2.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 3:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_0_3.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                default:
                    break;
                }
            }
            return validaPosicao();
        }
            
        return false;
    }

    public boolean moveRight() {
        if(super.moveRight()){
            if(moving){
                switch (aniIndex) {
                case 0:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_2_0.png");//btrainer31
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 1:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_2_1.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 2:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_2_2.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 3:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_2_3.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                default:
                    break;
                }
            }
            return validaPosicao();
        }
        
        return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft()){
            if(moving){
                switch (aniIndex) {
                case 0:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_1_0.png");//"btrainer23.png"
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 1:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_1_1.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 2:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_1_2.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                case 3:
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_1_3.png");
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    break;
                default:
                    break;
                }
            }
            return validaPosicao();
        }
        return false;
    }  
    
    
    public void Atirar() {
        if(Balas>0){
            switch (playerDir) {
                case 0:
                    {
                        Tiro f = new Tiro("tiro0.png",0);
                        f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
                        Desenho.acessoATelaDoJogo().addPersonagem(f);
                        break;
                    }
                case 1:
                    {
                        Tiro f = new Tiro("tiro11.png",1);
                        f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
                        Desenho.acessoATelaDoJogo().addPersonagem(f);
                        break;
                    }
                case 2:
                    {
                        Tiro f = new Tiro("tiro1.png",2);
                        f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
                        Desenho.acessoATelaDoJogo().addPersonagem(f);
                        break;
                    }
                case 3:
                    {
                        Tiro f = new Tiro("tiro3.png",3);
                        f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
                        Desenho.acessoATelaDoJogo().addPersonagem(f);
                        break;
                    }
            }
            Balas--;
        }
        
    }
    
    
    public void updateAnimationTick() {
        
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick=0;
            aniIndex++;
            if(aniIndex>=4){
                aniIndex=0;
            }
        }
        
    }
    
    
    
    
    
    
    private void updatePos() {
        moving=false;
        if(!this.getPosicao().igual(new Posicao(0,8))){
            if(left &&!right){
                moving=true;
                moveLeft();
            }else if(right &&!left){
                moving=true;
                moveRight();
            }
            if(up &&!down){
                moving=true;
                moveUp();
            }else if(down &&!up){
                moving=true;
                moveDown();
            }
            if(moving==false){
                if(playerDir==3){
                   try {
                            this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_1_2.png");//btrainer23
                    } catch (IOException ex) {
                            Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }else if(playerDir==2){
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_2_2.png");//btrainer33
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(playerDir==1){
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_0_2.png");//btrainer13
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(playerDir==0){
                    try {
                        this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + "small_image_3_2.png");//btrainer43
                    } catch (IOException ex) {
                        Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }    
        }
        
    }
    
    
    
    public void resetDirBooleans() {
        left=false;
        up=false;
        down=false;
        right=false;
    }
    
    public boolean isLeft() {
        return left;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isDown() {
        return down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setPlayerDir(int playerDir) {
        this.playerDir = playerDir;
    }

    public void update() {
        updatePos();
        updateAnimationTick();
    }

    public int getFase() {
        return Fase;
    }

    public void setFase(int Fase) {
        this.Fase = Fase;
    }
    
    
}
