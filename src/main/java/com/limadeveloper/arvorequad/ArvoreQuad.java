/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.limadeveloper.arvorequad;

import com.limadeveloper.listaencadeada.Node;

/**
 *
 * @author Lima
 */
public class ArvoreQuad {
    private Quadrante quadrante;
    private boolean dividido;
    
    // se foi dividido, usa essas variaveis
    private ArvoreQuad esquerda_cima;
    private ArvoreQuad direita_cima;
    private ArvoreQuad esquerda_baixo;
    private ArvoreQuad direita_baixo;
    
    ArvoreQuad(int num_max_nodes, int x0, int y0, int largura, int altura){
        this.quadrante = new Quadrante(num_max_nodes, x0, y0, largura, altura);
    }
    
    public boolean taNoQuadrante(int x, int y){
        if(dividido){
            if (esquerda_cima.taNoQuadrante(x,y)){
                return esquerda_cima.taNoQuadrante(x,y);
            }else if (direita_cima.taNoQuadrante(x,y)){
                return direita_cima.taNoQuadrante(x,y);
            }else if (esquerda_baixo.taNoQuadrante(x,y)){
                return esquerda_baixo.taNoQuadrante(x,y);
            }else if (direita_baixo.taNoQuadrante(x,y)){
                return direita_baixo.taNoQuadrante(x,y);
            }else{
                System.out.println("não é aqui não");
                return false;
            }
        }else{
            return quadrante.taNoQuadrante(x,y);
        }
    }
    
    public boolean inserir(int x, int y){
        boolean retorno = false;
        if(dividido){
            if (esquerda_cima.taNoQuadrante(x,y)){
                retorno = esquerda_cima.inserir(x, y);
            }else if (direita_cima.taNoQuadrante(x,y)){
                retorno = direita_cima.inserir(x, y);
            }else if (esquerda_baixo.taNoQuadrante(x,y)){
                retorno = esquerda_baixo.inserir(x, y);
            }else if (direita_baixo.taNoQuadrante(x,y)){
                retorno = direita_baixo.inserir(x, y);
            }else{
                System.out.println("não é aqui não");
            }
        }else{
            retorno = quadrante.inserir(x,y);
            if (!retorno){
                if (quadrante.cheia()){
                    System.out.println("Dividir");
                    dividir();
                    retorno = inserir(x,y);
                    quadrante = null;
                }
            }
        }
        return retorno;
    }
    
    public void dividir(){
        if(dividido){
            System.out.println("ja ta dividido, loco");
            return; 
        }
        int num_max_nodes = quadrante.getNumMaxNodes();
        int x0 = quadrante.getX0();
        int y0 = quadrante.getY0();
        int largura = quadrante.getLargura();
        int altura = quadrante.getAltura();
        
        int metade_x = (int) (largura-x0)/2;
        int metade_y = (int) (altura-y0)/2;
        
        int esquerda_cima_x0 = x0;
        int esquerda_cima_y0 = y0;
        int esquerda_cima_largura = metade_x;
        int esquerda_cima_altura = metade_y;
        
        int direita_cima_x0 = metade_x;
        int direita_cima_y0 = y0;
        int direita_cima_largura = metade_x;
        int direita_cima_altura = metade_y;
        
        int esquerda_baixo_y0 = metade_y;
        int esquerda_baixo_x0 = x0;
        int esquerda_baixo_largura = metade_x;
        int esquerda_baixo_altura = metade_y;
        
        int direita_baixo_x0 = metade_x;
        int direita_baixo_y0 = metade_y;
        int direita_baixo_largura = metade_x;
        int direita_baixo_altura = metade_y;
        
        esquerda_cima = new ArvoreQuad(num_max_nodes,esquerda_cima_x0,esquerda_cima_y0,esquerda_cima_largura, esquerda_cima_altura);
        direita_cima = new ArvoreQuad(num_max_nodes,direita_cima_x0,direita_cima_y0,direita_cima_largura,direita_cima_altura);
        esquerda_baixo = new ArvoreQuad(num_max_nodes,esquerda_baixo_x0,esquerda_baixo_y0,esquerda_baixo_largura,esquerda_baixo_altura);
        direita_baixo = new ArvoreQuad(num_max_nodes,direita_baixo_x0,direita_baixo_y0,direita_baixo_largura,direita_baixo_altura);
        
        dividido = true;
        
        Node no = quadrante.removerPrimeiro();
        while(no!=null){
            inserir(no.getX(), no.getY());
            no = quadrante.removerPrimeiro();
        }
        
        
    }
    
    public void imprimir(){
        System.out.print("\t");
        int count = 1;
        imprimir(count);
    }
    
    public void imprimir(int count){
        System.out.print("\t".repeat(count));
        if(dividido){
            esquerda_cima.imprimir(count);
            direita_cima.imprimir(count);
            esquerda_baixo.imprimir(count);
            direita_baixo.imprimir(count);
        }else{
            quadrante.imprimir(count);
        }
    }
}
