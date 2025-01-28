package Controler;

import Modelo.Personagem;
import Modelo.Hero;
import Modelo.Heart;
import auxiliar.Posicao;
import java.util.ArrayList;

public class ControleDeJogo {
    private boolean perdeVida=false;
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Personagem> umaFase){
        Hero hero = (Hero)umaFase.get(0);
        Personagem tiro= umaFase.get(umaFase.size()-1);
        Personagem pIesimoPersonagem;
        if(perdeVida){
            for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            
            //Controle de Vida
            if(pIesimoPersonagem.isLife() && pIesimoPersonagem.getPosicao().igual(new Posicao(2,20)) && hero.getLife()==4 ){
                umaFase.remove(pIesimoPersonagem);
                Heart h1 =new Heart("deathHearts_0_0.png",false);
                h1.setPosicao(2,20);
                umaFase.add(h1);
            }else if(pIesimoPersonagem.isLife() && pIesimoPersonagem.getPosicao().igual(new Posicao(2,19)) && hero.getLife()==3){
                umaFase.remove(pIesimoPersonagem);
                Heart h2 =new Heart("deathHearts_0_0.png",false);
                h2.setPosicao(2,19);
                umaFase.add(h2);
            }else if(pIesimoPersonagem.isLife() && pIesimoPersonagem.getPosicao().igual(new Posicao(2,18)) && hero.getLife()==2){
                umaFase.remove(pIesimoPersonagem);
                Heart h3 =new Heart("deathHearts_0_0.png",false);
                h3.setPosicao(2,18);
                umaFase.add(h3);
            }else if(pIesimoPersonagem.isLife() && pIesimoPersonagem.getPosicao().igual(new Posicao(2,17)) && hero.getLife()==1){
                umaFase.remove(pIesimoPersonagem);
                Heart h4 =new Heart("deathHearts_0_0.png",false);
                h4.setPosicao(2,17);
                umaFase.add(h4);
            }
            perdeVida=false;
        }
        
        }
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(tiro.getPosicao().igual(pIesimoPersonagem.getPosicao()) && tiro.isbProjetil() && pIesimoPersonagem.isbAtiravel()){
                umaFase.remove(pIesimoPersonagem);
                umaFase.remove(umaFase.size()-1);
                
            }
            if(tiro.getPosicao().igual(pIesimoPersonagem.getPosicao()) && tiro.isbProjetil() && !pIesimoPersonagem.isbTransponivel()&& !pIesimoPersonagem.isbAtiravel()){
                umaFase.remove(umaFase.size()-1);
                
            }
            
            if(pIesimoPersonagem.getPosicao().igual(new Posicao(0,8))){
                if(hero.getFase()==1 && hero.getPoints()==3
                ||hero.getFase()==2 && hero.getPoints()==6
                ||hero.getFase()==3 && hero.getPoints()==4
                ||hero.getFase()==4 && hero.getPoints()==3
                ||hero.getFase()==5 && hero.getPoints()==3){
                    umaFase.remove(pIesimoPersonagem);
                }
            }
            
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao()))
                if(pIesimoPersonagem.isbTransponivel()){
                    /*TO-DO: verificar se o personagem eh mortal antes de retsasirar*/                    
                    if(pIesimoPersonagem.isbPoint()){
                        hero.setPoints(hero.getPoints()+1);
                        hero.setBalas(hero.getBalas()+1);
                        umaFase.remove(pIesimoPersonagem);
                        System.out.println("Voce coletou um ponto!");
                        System.out.println("Voce recebeu uma bala!");
                    }else if(pIesimoPersonagem.isbMortal()){
                        hero.setLife(hero.getLife()-1);
                        perdeVida=true;
                        System.out.println("-1Life");
                    }
                }
            
            
            if(hero.getPosicao().igual(new Posicao(0,8)) && hero.getPoints()>=3){
                if(i!=0){      
                    for(int a=0;a<240;a++){         
                    }
                umaFase.remove(pIesimoPersonagem);
             
                }
            }
            
        }
    }
     
    /*Retorna true se a posicao p é válida para Hero com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p){
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(!pIesimoPersonagem.isbTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
    
}
