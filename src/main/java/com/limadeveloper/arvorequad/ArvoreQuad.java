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
    private int num_max_nodes;
    private ListaEncadeada nodes;
    private boolean dividido;
    
    private ArvoreQuad esquerda_cima;
    private ArvoreQuad direita_cima;
    private ArvoreQuad esquerda_baixo;
    private ArvoreQuad direita_baixo;
    
    ArvoreQuad(){
        System.out.println("sou uma arvore multiway");
    }
}
