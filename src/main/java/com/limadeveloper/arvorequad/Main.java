/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limadeveloper.arvorequad;

import com.limadeveloper.listaencadeada.Node;

/**
 *
 * @author Lima
 */
public class Main {
    
    public static void main(String[] args) {
        ArvoreQuad arvore = new ArvoreQuad(4, 0, 0, 100, 100);
        arvore.inserir(10,10);
        arvore.inserir(20,20);
        arvore.inserir(60,60);
        arvore.inserir(70,70);
        arvore.inserir(0,50);

        arvore.inserir(80,70);
        arvore.inserir(80,80);
        arvore.inserir(90,90);
        arvore.imprimir();
        
        Node a = arvore.buscarNode(70, 70);
        a.imprime();
        
        a = arvore.remover(60,60);
        a.imprime();
        a = arvore.remover(70,70);
        a.imprime();
        a = arvore.remover(80,70);
        a.imprime();
        a = arvore.remover(80,80);
        a.imprime();
        
        arvore.imprimir();
        
        
        a = arvore.remover(90,90);
        a.imprime();
        
        arvore.imprimir();
    }
}
