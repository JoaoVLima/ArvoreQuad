/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limadeveloper.arvorequad;

import com.limadeveloper.listaencadeada.ListaEncadeada;

/**
 *
 * @author Lima
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListaEncadeada lista = new ListaEncadeada();
        lista.imprime();
        lista.insereOrdenado(0, 0);
        lista.imprime();
        lista.insereOrdenado(10, 10);
        lista.imprime();
        lista.insereOrdenado(20, 20);
        lista.imprime();
        lista.insereOrdenado(30, 30);
        lista.imprime();
        lista.insereDepois(1, 5, 5);
        lista.imprime();
        lista.inserePrimeiro(0, 0);
        lista.imprime();
        lista.insereUltimo(100, 100);
        lista.imprime();
    }
}
