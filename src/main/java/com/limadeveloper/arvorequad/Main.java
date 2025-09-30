/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limadeveloper.arvorequad;

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
        arvore.imprimir();
    }
}
