package Controler;

import Modelo.Personagem;
import Modelo.Hero;
import auxiliar.Posicao;
import Auxiliar.Consts;
import static Auxiliar.Consts.*;
import Auxiliar.Desenho;
import Fases.Fases;
import Modelo.Heart;
import data.SaveLoad;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener{

    private ControleDeJogo cj = new ControleDeJogo();
    private SaveLoad saveLoad;
    private Fases fases;
    private int FPS;
    private int UPS;
    private Graphics g2;
    private int iTimer;
    private final int FPS_SET=15; //15
    private final int UPS_SET=10; //10
    private Hero hero;
    //SaveLoad:
    private ArrayList<Personagem> faseAtual;
    public String[] currentDialogue;
    private boolean GameOver=false;
    
    public Tela() {
        currentDialogue=new String[8];
        
        System.out.println("Bem vindo ao Jogo Estações do Ano");
        System.out.println("Para controlar seu personagem:mova-se no WASD ou nas setas");
        System.out.println("Para atirar use espaco");
        System.out.println("Para salvar utilize K e para dar Load utilize L");
        System.out.println("Para resetar a fase utilize R");
        System.out.println("Para pular a fase clique duas vezes no F");
        System.out.println("Foi Adicionado um ponto extra nas fases de 1 a 4 que fica teleportando.");
        
        iTimer = 0;
        FPS=0;
        UPS=0;
        saveLoad= new SaveLoad(this);
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this);
        /*mouse*/
        this.addKeyListener(this);
        /*teclado*/

        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RESy * Consts.CELL_SIDE + getInsets().left + getInsets().right,Consts.RESx * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<Personagem>();
        
        
        /*Cria faseAtual adiciona personagens*/
        hero = new Hero("small_image_0_0.png");
        
        this.addPersonagem(hero);
        //Inicializa Dialogos
        currentDialogue[0]="Jogo Estações do Ano";
        currentDialogue[1]="";
        currentDialogue[2]="Fase "+hero.getFase();
        currentDialogue[3]="Vida:"+hero.getLife()+"/5";
        currentDialogue[4]="Balas:"+hero.getBalas();
        currentDialogue[5]="Pontos:"+hero.getPoints()+"/"+pontosdaFase();
        currentDialogue[6]="Dica:";
        currentDialogue[7]="Pegue os pontos e mate as cobras";        
        hero.setPosicao(14, 5);
        UpdateHealth();
        Fases.Fase1(this);
        
    }
    
    private void LimpaTela(){
        Personagem pIesimoPersonagem;
            Hero h = (Hero)faseAtual.get(0);
            faseAtual.clear();
            faseAtual.add(h);
    }
    
    private void Reset() {
        LimpaTela();
        if(hero.getFase()==1){
            currentDialogue[7]="Pegue os pontos e mate as cobras";                
            UpdateHealth();
            
            hero.setBalas(0);
            hero.setLife(5);
            hero.setPoints(0);
            Fases.Fase1(this);
        }else if(hero.getFase()==2){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            UpdateHealth();
            
            hero.setBalas(0);
            hero.setLife(5);
            hero.setPoints(0);
            Fases.Fase2(this);
        }else if(hero.getFase()==3){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            UpdateHealth();
          
            hero.setBalas(0);
            hero.setLife(5);
            hero.setPoints(0);
            Fases.Fase3(this);
        }else if(hero.getFase()==4){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            UpdateHealth();
            
            hero.setBalas(0);
            hero.setLife(5);
            hero.setPoints(0);
            Fases.Fase4(this);
        }else if(hero.getFase()==5){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            UpdateHealth();
            
            hero.setBalas(0);
            hero.setLife(5);
            hero.setPoints(0);
            Fases.Fase5(this);
        
        }else if(hero.getFase()==6){
            GameOver=true;
            hero.setBalas(0);
            hero.setPoints(0);
            Fases.Fase6(this);
        }
        
    }
    public void UpdateHealth(){
        Heart[] h= new Heart[5];
        for(int i=0;i<5;i++){
            h[i] =new Heart("hearts_0_0.png",true);
            h[i].setPosicao(2,16+i);
            this.addPersonagem(h[i]);
        }
        
        
    }
    
    public int pontosdaFase(){
        if(hero.getFase()==2)
            return 6;
        else if(hero.getFase()==3){
            return 4;
        }else
            return 3;
    }
    public boolean ehPosicaoValida(Posicao p) {
        return cj.ehPosicaoValida(this.faseAtual, p);
    }

    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer() {
        return g2;
    }

    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /**
         * ***********Desenha cenário de fundo*************
         */
        hero.updateAnimationTick();
        BackGround();
        if(GameOver==false){
            drawDialogueScreen();
        }
        
        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            this.cj.processaTudo(faseAtual);
        }
        //Atualiza os Dialogos
        currentDialogue[2]="Fase "+hero.getFase();
        currentDialogue[3]="Vida:"+hero.getLife()+"/5";
        currentDialogue[4]="Balas:"+hero.getBalas();
        currentDialogue[5]="Pontos:"+hero.getPoints()+"/"+pontosdaFase();
        
        //hero.render(g);
        
        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
        if(hero.getLife()<=0){
            System.out.println("Voce Morreu!");
            System.out.println("Mas está tudo bem guerreiro, basta clicar R para reiniciar a fase que voce estava");
            LimpaTela();
            GameOver=true;
            hero.setPoints(0);
            hero.setBalas(0);
            Fases.GameOver(this);
            hero.setLife(5);
        }
        if(faseAtual.size()==1 && hero.getFase()==1){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            
            hero.setPoints(0);
            UpdateHealth();
            hero.setBalas(0);
            hero.setLife(5);
            Fases.Fase2(this);
            hero.setFase(2);
        }else if(faseAtual.size()==1 && hero.getFase()==2){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            
            hero.setPoints(0);
            UpdateHealth();
            hero.setLife(5);
            hero.setBalas(0);
            Fases.Fase3(this);
            hero.setFase(3);
            
        }else if(faseAtual.size()==1 && hero.getFase()==3){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            
            hero.setPoints(0);
            hero.setLife(5);
            hero.setBalas(0);
            UpdateHealth();
            Fases.Fase4(this);
            hero.setFase(4);
        }else if(faseAtual.size()==1 && hero.getFase()==4){
            currentDialogue[7]="Pegue os pontos e desvie dos monstros";
            
            hero.setPoints(0);
            UpdateHealth();
            hero.setBalas(0);
            hero.setLife(5);
            Fases.Fase5(this);
            hero.setFase(5);
        
        }else if(faseAtual.size()==1 && hero.getFase() ==5){
            System.out.println("Parabens!Voce voltou para casa!");
            System.out.println("Desenvolvido por:");
            System.out.println("Gabriela Passos de Andrade");
            System.out.println("Rafael Cunha Bejes Learth");
            GameOver=true;
            hero.setPoints(0);
            hero.setBalas(0);
            Fases.Fase6(this);
            hero.setFase(6);
        }
        if(hero.getFase()<=4){
            this.setTitle("Fase "+hero.getFase()+ "\tPontos :"+ hero.getPoints()+"/"+pontosdaFase()+"\tVida :"+hero.getLife()+"/5"+"\tBalas :"+hero.getBalas()+"\tFPS: "+FPS+" | UPS:"+UPS);
        }else if(hero.getFase()==5){
            this.setTitle("Fase Bonus!\tPontos :"+ hero.getPoints()+ "/"+pontosdaFase()+"\tVida:"+hero.getLife()+"/5"+"\tFPS: "+FPS+" | UPS:"+UPS);
        }else{
            this.setTitle("Game Over, Thanks for Playing!");
        
        }
    }
    
    public void keyPressed(KeyEvent e) {            
            if(e.getKeyCode() == KeyEvent.VK_R){
                Reset();
                if(GameOver==true && hero.getFase()!=6){
                    GameOver=false;
                }
            }else if(e.getKeyCode() == KeyEvent.VK_F){
                if(GameOver==false){
                    hero.setBalas(pontosdaFase());
                    hero.setPosicao(0, 8);
                    hero.setPoints(pontosdaFase());
                }
            }else if(e.getKeyCode()==KeyEvent.VK_K){
                saveLoad.save();
                System.out.println("O progresso do jogo foi salvo!");
            }else if(e.getKeyCode()==KeyEvent.VK_L){
                saveLoad.load();
                hero=(Hero)faseAtual.get(0);
                hero.setUp(false);
                hero.setRight(false);
                hero.setLeft(false);
                hero.setDown(false);
                System.out.println("Jogo foi carregado com sucesso!");
            }
            if(!hero.getPosicao().igual(new Posicao(0,8))){
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                        this.hero.Atirar();
                }else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    hero.setPlayerDir(UP);
                    hero.setUp(true);
                }else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                    hero.setPlayerDir(DOWN);
                    hero.setDown(true);
                }else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                    hero.setPlayerDir(LEFT);
                    hero.setLeft(true);

                }else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                    hero.setPlayerDir(RIGHT);
                    hero.setRight(true);

                }       
            }    
    }
    
    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
     
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W :
            case KeyEvent.VK_UP:    
                hero.setUp(false);
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                hero.setLeft(false);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                hero.setDown(false);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                hero.setRight(false);
                break;
        }
    }
    
    public void update(){
        hero.update();
    }
    
    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                double timePerFrame = 1000000000.0/FPS_SET;
                double timePerUpdate=1000000000.0/UPS_SET;

                long previousTime=System.nanoTime();


                int frames=0;
                int updates=0;
                long lastCheck=System.currentTimeMillis();

                double deltaU=0;
                double deltaF=0;
                while(true){
                    long currentTime=System.nanoTime();

                    deltaU+=(currentTime-previousTime)/timePerUpdate;
                    deltaF+=(currentTime-previousTime)/timePerFrame;

                    previousTime=currentTime;
                    if(deltaU>=1){
                        update();
                        updates++;
                        deltaU--;
                    }
                    if(deltaF>=1){
                        repaint();               
                        frames++;
                        deltaF--;
                    }
                    if(System.currentTimeMillis()- lastCheck >=1000){
                        lastCheck=System.currentTimeMillis();
                        FPS=frames;
                        UPS=updates;
                        //System.out.println("FPS: "+frames+" | UPS:"+updates);
                        frames=0;
                        updates=0;
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    public Hero getHero() {
        return hero;
    }
    public void drawDialogueScreen() {
        int x = (Consts.CELL_SIDE)*16;
        int y = (Consts.CELL_SIDE)*3;
        int width = (Consts.CELL_SIDE)*6;
        int height = (Consts.CELL_SIDE)*8;
        drawSubWindow(x, y, width, height);

        // Defina o tamanho da fonte desejado
        Font font = new Font("NomeDaFonte", Font.LAYOUT_RIGHT_TO_LEFT, 20);
        g2.setFont(font);

        Color c = new Color(255, 255, 255);
        g2.setColor(c);
        y += (CELL_SIDE);
        g2.drawString(currentDialogue[0], x, y);

        font = new Font("NomeDaFonte", Font.LAYOUT_RIGHT_TO_LEFT, 22);
        g2.setFont(font);

        for(int i=1;i<6;i++){
            y += (CELL_SIDE);
            g2.drawString(currentDialogue[i], x, y);
        }
        font = new Font("NomeDaFonte", Font.LAYOUT_RIGHT_TO_LEFT, 11);
        g2.setFont(font);
        y += (CELL_SIDE);
            
        for(int i=6;i<8;i++){
            g2.drawString(currentDialogue[i], x, y);
            y += (CELL_SIDE)/2;
        }
    }

    public ArrayList<Personagem> getFaseAtual() {
        return faseAtual;
    }

    public void setFaseAtual(ArrayList<Personagem> faseAtual) {
        this.faseAtual = faseAtual;
    }

    public boolean isGameOver() {
        return GameOver;
    }

    public void setGameOver(boolean GameOver) {
        this.GameOver = GameOver;
    }

    public String[] getCurrentDialogue() {
        return currentDialogue;
    }

    public void setCurrentDialogue(String[] currentDialogue) {
        this.currentDialogue = currentDialogue;
    }
    
    public void drawSubWindow(int x,int y,int width,int height){
        Color c=new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
    }
    private void BackGround() {
        String background;
                        
        for (int i = 0; i < Consts.RESx; i++) {
            for (int j = 0; j < Consts.RESy; j++) {
                try {
                    if(hero.getFase()==1 && GameOver==false){
                        String outono="backgroundAutumn.png";
                        background=outono;
                    }else if(hero.getFase()==2 && GameOver==false){
                        String inverno="backgroundWinter.png";
                        background=inverno;
                    }else if(hero.getFase()==3 && GameOver==false){
                        String primavera="backgroundSpring.png";
                        background=primavera;
                    }else if(hero.getFase()==4 && GameOver==false){
                        String verao="backgroundSummer.png";
                        background=verao;
                    }else{
                        background="grass1.png";
                    }
                    
                    if(hero.getFase()!=6){
                        if (j >= 16) {
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass1.png");
                            g2.drawImage(newImage,
                                    j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                        } else if(i==0 && j==8){
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "seta.png");
                            g2.drawImage(newImage,
                                    j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                        }else {
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + background);
                            g2.drawImage(newImage,
                                    j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                        }
                    }else{
                        if (i==2 
                            ||(i<=1 && i>=0 && j>=17 && j<=18)
                            ||(i<=4 && i>=3 && j>=17 && j<=18)    
                            ||(j>=16 && j<=19 && i==5)
                            ||(j==16 && i>=6 && i<=7)
                            ||(j==19 && i>=6 && i<=7)
                            ||(j>=16 && j<=19 && i==8)
                            ||(i<=11 && i>=9 && j>=17 && j<=18)
                            ||(i==5 && j>=0 && j<=14)) {
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "path.png");
                            g2.drawImage(newImage,
                                    j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                        }else {
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass1.png");
                            g2.drawImage(newImage,
                                    j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                        }
                    }
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
