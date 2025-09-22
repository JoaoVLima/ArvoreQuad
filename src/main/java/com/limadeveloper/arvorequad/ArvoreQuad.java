/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.limadeveloper.arvorequad;

import com.limadeveloper.listaencadeada.ListaEncadeada;

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
        this.quadrante.inserir(0, 0);
        this.quadrante.imprimir();
        this.quadrante.remover(0, 0);
        this.quadrante.imprimir();
        this.quadrante.inserir(0, 0);
        this.quadrante.imprimir();
        this.quadrante.inserir(10, 10);
        this.quadrante.imprimir();
        this.quadrante.inserir(20, 20);
        this.quadrante.imprimir();
        this.quadrante.inserir(30, 30);
        this.quadrante.imprimir();
        this.quadrante.inserir(100, 100);
        this.quadrante.imprimir();
        this.quadrante.inserir(33, 41);
        this.quadrante.imprimir();
        this.quadrante.inserir(33, 40);
        this.quadrante.imprimir();
        this.quadrante.inserir(20, 40);
        this.quadrante.imprimir();
        this.quadrante.inserir(20, 30);
        this.quadrante.imprimir();
        this.quadrante.inserir(10, 30);
        this.quadrante.imprimir();
        this.quadrante.inserir(10, 40);
        this.quadrante.imprimir();
        this.quadrante.remover(10, 40);
        this.quadrante.imprimir();
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
