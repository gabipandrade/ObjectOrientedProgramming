package Fases;
import Controler.Tela;
import Modelo.BichinhoSeguidor;
import Modelo.BichinhoVaiVemCima;
import Modelo.BichinhoVaiVemHorizontal;
import Modelo.Bichinhoteleporta;
import Modelo.Caveira;
import Modelo.Muro;
import Modelo.pokeball;
import Modelo.snake;


/**
 *
 * @author rafael
 */
public class Fases {

    public static void Fase1(Tela t){
        t.getHero().setPosicao(14, 5);
        
        
        pokeball pb1 = new pokeball("pokeballb.png");
        pb1.setPosicao(3, 2);
        t.addPersonagem(pb1);

        pokeball pb2 = new pokeball("pokeball.png");
        pb2.setPosicao(10, 3);
        t.addPersonagem(pb2);

        pokeball pb3 = new pokeball("pokeball.png");
        pb3.setPosicao(3, 12);
        t.addPersonagem(pb3);

        pokeball pb4 = new pokeball("pokeball.png");
        pb4.setPosicao(12, 12);
        t.addPersonagem(pb4);

        snake s1 = new snake("snake.png");
        s1.setPosicao(3, 7);
        t.addPersonagem(s1);

        snake s2 = new snake("snake.png");
        s2.setPosicao(5, 14);
        t.addPersonagem(s2);

        snake s3 = new snake("snake.png");
        s3.setPosicao(10, 6);
        t.addPersonagem(s3);

        Bichinhoteleporta bt = new Bichinhoteleporta("pokeball.png");
        bt.setPosicao(2, 2);
        t.addPersonagem(bt);

        Muro[] muros2 = new Muro[60];
        
        Muro[] muros1 = new Muro[75];
        int a = 0;
        int c=0;
        // Preencher o vetor com imagens "muro.png" nas posições especificadas
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if ((i == 2 && j != 2 && j != 5 && j != 6 && j <= 12)
                        || (i == 4 && j >= 6 && j <= 12)
                        || (i == 9 && j >= 2 && j <= 8)
                        || (j == 13 && i >= 2 && i <= 5)
                        || (i == 11 && j >= 2 && j <= 7)
                        || (j == 11 && i >= 8 && i <= 13)
                        || (j == 13 && i >= 9 && i <= 13)
                        || (j == 9 && i >= 6 && i <= 10)
                        || (i == 1 && j == 7)
                        || (i == 3 && (j == 1 || j == 3))
                        || ((i == 4) && (j == 2))
                        || (i == 5 && j == 6)
                        || (i == 6 && (j == 6 || j == 8 || j == 9))
                        || (i == 7 && (j == 6 || j == 2 || j == 4 || j == 13 || j == 14))
                        || (i == 8 && (j == 2 || j == 4 || j == 10))
                        || (i == 10 && j == 2)
                        || (i == 13 && ((j >= 2 && j <= 4) || (j == 8) || (j == 12)))
                        || (i == 12 && j == 7)
                        || (i == 14 && (j == 2 || j == 9))) {
                    switch(c){
                        case 0:
                            muros1[a] = new Muro("tree1.png");
                            c++;
                            break;
                        case 1:
                            muros1[a] = new Muro("tree3.png");
                            c++;
                            break;
                        case 2:
                            muros1[a] = new Muro("tree3.png");
                            c=0;
                            break;
                    }
                    muros1[a].setPosicao(i, j);
                    t.addPersonagem(muros1[a]);
                    a++;
                }
            }

        }

        int b = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (j == 15 || j == 0 || i == 0 || i == 15) {
                    muros2[b] = new Muro("muro.png");
                    muros2[b].setPosicao(i, j);

                    t.addPersonagem(muros2[b]);
                    b++;
                }
            }
        }
        
    }
    public static void Fase2(Tela t){
        t.getHero().setPosicao(13,5);
        /*Cria faseAtual adiciona personagens*/
        snake s1 = new snake("snake.png");
        s1.setPosicao(12, 11);
        t.addPersonagem(s1);

        snake s2 = new snake("snake.png");
        s2.setPosicao(12, 10);
        t.addPersonagem(s2);
        
        snake s3 = new snake("snake.png");
        s3.setPosicao(4, 5);
        t.addPersonagem(s3);

        snake s4 = new snake("snake.png");
        s4.setPosicao(3, 5);
        t.addPersonagem(s4);
        
        snake s5 = new snake("snake.png");
        s5.setPosicao(2, 5);
        t.addPersonagem(s5);
        
        snake s7 = new snake("snake.png");
        s7.setPosicao(3, 7);
        t.addPersonagem(s7);

        BichinhoVaiVemHorizontal bBichinhoH = new BichinhoVaiVemHorizontal("slimesRed_0_0.png");
        bBichinhoH.setPosicao(14, 1);
        t.addPersonagem(bBichinhoH);

        BichinhoVaiVemCima bc1 = new BichinhoVaiVemCima("slimesRed_0_0.png");
        bc1.setPosicao(1, 1);
        t.addPersonagem(bc1);

        BichinhoVaiVemCima bc2 = new BichinhoVaiVemCima("slimesRed_0_0.png");
        bc2.setPosicao(1, 14);
        t.addPersonagem(bc2);

        
        Bichinhoteleporta bt = new Bichinhoteleporta("pokeball.png");
        bt.setPosicao(2, 2);
        t.addPersonagem(bt);
        
        pokeball pb1 = new pokeball("pokeball.png");
        pb1.setPosicao(1, 5);
        t.addPersonagem(pb1);

        pokeball pb2 = new pokeball("pokeball.png");
        pb2.setPosicao(5, 7);
        t.addPersonagem(pb2);

        pokeball pb3 = new pokeball("pokeball.png");
        pb3.setPosicao(7, 11);
        t.addPersonagem(pb3);
        
        pokeball pb4 = new pokeball("pokeball.png");
        pb4.setPosicao(4, 7);
        t.addPersonagem(pb4);
        
        pokeball pb5 = new pokeball("pokeball.png");
        pb5.setPosicao(11, 10);
        t.addPersonagem(pb5);

        pokeball pb6 = new pokeball("pokeball.png");
        pb6.setPosicao(11, 11);
        t.addPersonagem(pb6);

        
        Muro[] muros2 = new Muro[60];
        Muro[] muros1 = new Muro[60];
        
        int a = 0;
        int c=0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (((j==4||j==3) && (i>=1 && i<=4))
                    ||(j==6 &&(i>=1 && i<=6))
                    //||(j==13 && (i==1 ||i==2))
                    ||((j==8||j==9)&&(i>=3 && i<=6))
                    ||(j==12 &&((i>=5 &&i<=12 )||i==1 ||i==2))
                    ||(i==10 &&(j>=2 &&j<=5))
                    ||(i==11 &&(j==2 || j==5))
                    ||(j==8 &&(i>=9 &&i<=12))
                    ||(j==9 && (i>=11 && i<=13))
                    ||(j==11 && i==4)
                    ||(i==12 && (j>=5 &&j<=7))
                    ||(i==6 && j==7)
                    ||(i==3 && j==10)
                    ||(i==10 && (j>=10 && j<=11))) {
                    switch(c){
                        case 0:
                            muros1[a] = new Muro("arvore1.png");
                            c++;
                            break;
                        case 1:
                            muros1[a] = new Muro("arvore2.png");
                            c=0;
                            break;
                    }
                    muros1[a].setPosicao(i, j);

                    t.addPersonagem(muros1[a]);
                    a++;
                }
            }
        }
        
        // Preencher o vetor com imagens "muro.png" nas posições especificada
        int b = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (j == 15 || j == 0 || i == 0 || i == 15) {
                    muros2[b] = new Muro("muro.png");
                    muros2[b].setPosicao(i, j);

                    t.addPersonagem(muros2[b]);
                    b++;
                }
            }
        }
            
    }
    public static void Fase3(Tela t){
        t.getHero().setPosicao(14,5);
        /*Cria faseAtual adiciona personagens*/
        
        Caveira bV1 = new Caveira("caveira.png");
        bV1.setPosicao(1, 1);
        t.addPersonagem(bV1);
        
        Caveira bV2 = new Caveira("caveira.png");
        bV2.setPosicao(4, 3);
        t.addPersonagem(bV2);
        
        Caveira bV3 = new Caveira("caveira.png");
        bV3.setPosicao(1, 14);
        t.addPersonagem(bV3);
        
        Caveira bV4 = new Caveira("caveira.png");
        bV4.setPosicao(4, 12);
        t.addPersonagem(bV4);
        
        BichinhoVaiVemCima bc1 = new BichinhoVaiVemCima("slimesRed_0_0.png");
        bc1.setPosicao(5, 6);
        t.addPersonagem(bc1);
        
        BichinhoVaiVemCima bc2 = new BichinhoVaiVemCima("slimesRed_0_0.png");
        bc2.setPosicao(9, 9);
        t.addPersonagem(bc2);
       
        Bichinhoteleporta bt = new Bichinhoteleporta("pokeball.png");
        bt.setPosicao(2, 2);
        t.addPersonagem(bt);
        
        pokeball pb1 = new pokeball("pokeballb.png");
        pb1.setPosicao(4, 4);
        t.addPersonagem(pb1);
        
        pokeball pb2 = new pokeball("pokeball.png");
        pb2.setPosicao(13, 7);
        t.addPersonagem(pb2);
        
        pokeball pb3 = new pokeball("pokeball.png");
        pb3.setPosicao(2, 12);
        t.addPersonagem(pb3);

        pokeball pb4 = new pokeball("pokeball.png");
        pb4.setPosicao(1, 5);
        t.addPersonagem(pb4);
        
        pokeball pb5 = new pokeball("pokeball.png");
        pb5.setPosicao(13, 9);
        t.addPersonagem(pb5);
        
        Muro[] muros2 = new Muro[60];
        // Preencher o vetor com imagens "muro.png" nas posições especificada
        Muro[] muros1 = new Muro[99];
        int a = 0;
        // Preencher o vetor com imagens "muro.png" nas posições especificadas
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (j==2 &&(i==3||i==6||i==9)
                        ||(j==13 &&(i==6||i==8||i==10||i==13))
                        ||(i==4&&(j>=4&&j<=11))
                        ||(i==11&&(j>=4&&j<=11))
                        ||(j==6&&(i>=1&&i<=3))
                        ||(j==7&&((i>=5&&i<=7)||i==9||i==10))
                        ||(j==8&&((i>=5&&i<=7)||i==9||i==10||i==12||i==13||i==14))
                        
                        ){
                    muros1[a] = new Muro("tree.png");
                    muros1[a].setPosicao(i, j);
                    t.addPersonagem(muros1[a]);
                    a++;
                }
            }     
        }
        // Preencher o vetor com imagens "muro.png" nas posições especificada
        int b = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (j == 15 || j == 0 || i == 0 || i == 15) {
                    muros2[b] = new Muro("muro.png");
                    muros2[b].setPosicao(i, j);

                    t.addPersonagem(muros2[b]);
                    b++;
                }
            }
        }
        
    }
    public static void Fase4(Tela t){
       t.getHero().setPosicao(14,7);
        /*Cria faseAtual adiciona personagens*/
        Bichinhoteleporta bt = new Bichinhoteleporta("pokeball.png");
        bt.setPosicao(2, 2);
        t.addPersonagem(bt);
        pokeball pb1 = new pokeball("pokeballb.png");
        pb1.setPosicao(3, 8);
        t.addPersonagem(pb1);

        pokeball pb2 = new pokeball("pokeball.png");
        pb2.setPosicao(4, 5);
        t.addPersonagem(pb2);

        pokeball pb3 = new pokeball("pokeball.png");
        pb3.setPosicao(9, 1);
        t.addPersonagem(pb3);

        pokeball pb4 = new pokeball("pokeball.png");
        pb4.setPosicao(12, 12);
        t.addPersonagem(pb4);
        
        Muro m1=new Muro("muro.png");
        m1.setPosicao(10, 4);
        t.addPersonagem(m1);
        
        Muro m2=new Muro("muro.png");
        m2.setPosicao(4, 10);
        t.addPersonagem(m2);
        
        Muro m3=new Muro("muro.png");
        m3.setPosicao(14, 5);
        t.addPersonagem(m3);
        
        Muro m4=new Muro("muro.png");
        m4.setPosicao(14, 9);
        t.addPersonagem(m4);
        
        Muro[] muros2 = new Muro[60];
        BichinhoVaiVemHorizontal[]bH=new BichinhoVaiVemHorizontal[14]; 
        int c=0;
        for(int i=1;i<15;i++){
            bH[c] = new BichinhoVaiVemHorizontal("slimesRed_0_0.png");
            bH[c].setPosicao(i, 0);
            t.addPersonagem(bH[c]);
            c++;
        }
        
        BichinhoVaiVemHorizontal bH2 =new BichinhoVaiVemHorizontal("slimesRed_0_0.png"); 
        bH2.setPosicao(14, 10);
        t.addPersonagem(bH2);
            
        // Preencher o vetor com imagens "muro.png" nas posições especificada
        int b = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (j == 15 || j == 0 || i == 0 || i == 15) {
                    muros2[b] = new Muro("muro.png");
                    muros2[b].setPosicao(i, j);

                    t.addPersonagem(muros2[b]);
                    b++;
                }
            }
        }
        
    }
    public static void Fase5(Tela t){
       t.getHero().setPosicao(14,5);
        /*Cria faseAtual adiciona personagens*/
        Bichinhoteleporta bt = new Bichinhoteleporta("pokeball.png");
        bt.setPosicao(2, 2);
        t.addPersonagem(bt);
        
        Bichinhoteleporta bt1 = new Bichinhoteleporta("pokeball.png");
        bt.setPosicao(5, 1);
        t.addPersonagem(bt1);
        
        Bichinhoteleporta bt2 = new Bichinhoteleporta("pokeball.png");
        bt.setPosicao(1, 5);
        t.addPersonagem(bt2);
        
        BichinhoSeguidor b1=new BichinhoSeguidor("slimesRed_0_0.png",t.getHero());
        b1.setPosicao(6, 6);
        t.addPersonagem(b1);
        
        BichinhoSeguidor b2=new BichinhoSeguidor("slimesRed_0_0.png",t.getHero());
        b2.setPosicao(1, 14);
        t.addPersonagem(b2);
                
        
        Muro[] muros2 = new Muro[60];
        // Preencher o vetor com imagens "muro.png" nas posições especificada
        int b = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (j == 15 || j == 0 || i == 0 || i == 15) {
                    muros2[b] = new Muro("muro.png");
                    muros2[b].setPosicao(i, j);

                    t.addPersonagem(muros2[b]);
                    b++;
                }
            }
        }
        
    }
    public static void Fase6(Tela t){
        t.getHero().setPosicao(7,15);

        Muro []casa1=new Muro[4];
        int b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa1[b] = new Muro("small_house1_"+i+"_"+j+".png");
                casa1[b].setPosicao(i, 4+j);
                
                t.addPersonagem(casa1[b]);    
            }
        }
        
        Muro []casa2=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa2[b] = new Muro("small_house2_"+i+"_"+j+".png");
                casa2[b].setPosicao(i, j+1);
                
                t.addPersonagem(casa2[b]);    
            }
        }
        Muro []casa3=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa3[b] = new Muro("small_house3_"+i+"_"+j+".png");
                casa3[b].setPosicao(i, 7+j);
                
                t.addPersonagem(casa3[b]);    
            }
        }
        Muro []casa4=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa4[b] = new Muro("small_house5_"+i+"_"+j+".png");
                casa4[b].setPosicao(i, 10+j);
                
                t.addPersonagem(casa4[b]);    
            }
        }
        Muro []casa5=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa5[b] = new Muro("small_house6_"+i+"_"+j+".png");
                casa5[b].setPosicao(i, 13+j);
                
                t.addPersonagem(casa5[b]);    
            }
        }
        Muro []casa6=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa6[b] = new Muro("small_house1_"+i+"_"+j+".png");
                casa6[b].setPosicao(i, 19+j);
                
                t.addPersonagem(casa6[b]);    
            }
        }
        Muro []casa7=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa7[b] = new Muro("small_house4_"+i+"_"+j+".png");
                casa7[b].setPosicao(3+i, 1+j);
                
                t.addPersonagem(casa7[b]);    
            }
        }
        Muro []casa8=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa8[b] = new Muro("small_house7_"+i+"_"+j+".png");
                casa8[b].setPosicao(3+i, 4+j);
                
                t.addPersonagem(casa8[b]);    
            }
        }
        Muro []casa9=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa9[b] = new Muro("small_house8_"+i+"_"+j+".png");
                casa9[b].setPosicao(3+i, 7+j);
                
                t.addPersonagem(casa9[b]);    
            }
        }
        Muro []casa10=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa10[b] = new Muro("small_house9_"+i+"_"+j+".png");
                casa10[b].setPosicao(3+i, 10+j);
                
                t.addPersonagem(casa10[b]);    
            }
        }
        
        Muro []casa11=new Muro[4];
        b=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                casa11[b] = new Muro("small_house2_"+i+"_"+j+".png");
                casa11[b].setPosicao(3+i, j+13);
                
                t.addPersonagem(casa11[b]);    
            }
        }
        Muro []Fim=new Muro[28];
        b=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<7;j++){
                Fim[b] = new Muro("Fim_"+i+"_"+j+".png");
                Fim[b].setPosicao(12+i, j);
                
                t.addPersonagem(Fim[b]);    
            }
        }
        int a = 0;    
        // Preencher o vetor com imagens "muro.png" nas posições especificadas
        Muro[] muros1 = new Muro[134];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 22; j++) {
                if ((j==12 && i>=7 && i<=10)
                    ||(j==10 && i>=7 && i<=10)
                    ||(j==8 && i>=7 && i<=10)
                    ||(j==6 && i>=7 && i<=10)
                    ||(i==7 && j==7)
                    ||(i==10 && j==7)
                    ||(i==10 && j==11)
                    ||((j==0 ||j==4)&&i==7)
                    ||((j==1 ||j==3)&&i==8)
                    ||(i>=9 && i<=10 && j==2)
                    ||(j==16 && i>=12 && i<=15)
                    ||(j==18 && i>=12 && i<=15)
                    ||(j==21 && i>=12 && i<=15)    
                    ||((j==8 ||j==14)&&i==13)
                    ||((j==9 ||j==13||j==11)&&i==14)
                    ||((j==10 ||j==12)&&i==15)
                    ||(j==19 && i==13)
                    ||(j==20 && i==14)
                    ||((j==8 ||j==14)&&i==12)    
                        ){
                    muros1[a] = new Muro("muro.png");
                    muros1[a].setPosicao(i, j);

                    t.addPersonagem(muros1[a]);
                    a++;
                }
            }
        }
    }
    public static void GameOver(Tela t){
        t.getHero().setPosicao(14,5);
       
        Muro[] muros1 = new Muro[134];
        int a = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 22; j++) {
                if ((i == 0 && j<=22 && j!=5 && j!=11 &&j!=14 &&j!=17)
                        ||(i==1&&(j==0||j==6||j==10||j==12||j==14||j==16||j==18))
                        ||(i==2&&(j==0||j==6||j==10||j==12||j==14||j==16||j==18||j==19||j==20||j==21))
                        ||(i==3 && j<=22 && j!=1 && j!=5 && j!=11 &&j!=13 &&j!=14 &&j!=15 &&j!=17 &&j<=18)
                        ||(i==4&&(j==0||j==4||j==6||j==10||j==12||j==16||j==18))
                        ||(i== 5 && j<=22 && j!=5 && j!=11 &&j!=14 &&j!=17 &&j!=7&&j!=8&&j!=9&&j!=13&&j!=14&&j!=15)
                        ||(i == 8 && j<=22 && j!=5 && !(j>=7 && j<=9)&& j!=11 &&j!=16&&j!=7&&j!=8&&j!=9)
                        ||(i==9&&(j==0||j==4||j==6||j==10||j==12||j==17||j==21))
                        ||(i==10&&(j==0||j==4||j==6||j==10||j==12||j==13||j==14||j==15||j==17||j==21))
                        ||(i==11 && j<=22 && j!=5 && !(j>=7 && j<=9)&&!(j>=1 &&j<=3)&&!(j>=13 &&j<=16)&& j!=11&& j!=7&&j!=8&&j!=9)
                        ||(i==12&&(j==0||j==4||j==6||j==10||j==12||j==17||j==20))
                        ||(i==13&&j<=22&&j!=5&&j!=11&&j!=16&&j!=18 && j!=19)
                        ){
                    muros1[a] = new Muro("muro.png");
                    muros1[a].setPosicao(i, j);

                    t.addPersonagem(muros1[a]);
                    a++;
                }
            }
        }
    }
    
}
