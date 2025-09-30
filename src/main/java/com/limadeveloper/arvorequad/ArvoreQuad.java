/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.limadeveloper.arvorequad;

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
    
    public void inserir(int x, int y){
        if(dividido){
            if (esquerda_cima.taNoQuadrante(x,y)){
                esquerda_cima.inserir(x, y);
            }else if (direita_cima.taNoQuadrante(x,y)){
                direita_cima.inserir(x, y);
            }else if (esquerda_baixo.taNoQuadrante(x,y)){
                esquerda_baixo.inserir(x, y);
            }else if (direita_baixo.taNoQuadrante(x,y)){
                direita_baixo.inserir(x, y);
            }else{
                System.out.println("não é aqui não");
            }
        }else{
            quadrante.inserir(x,y);
        }
    }
    
    public void imprimir(){
        if(dividido){
            esquerda_cima.imprimir();
            direita_cima.imprimir();
            esquerda_baixo.imprimir();
            direita_baixo.imprimir();
        }else{
            quadrante.imprimir();
        }
    }
}
