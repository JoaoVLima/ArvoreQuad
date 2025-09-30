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
public class Quadrante {
    private int num_max_nodes;
    private ListaEncadeada nodes;
    private int x0;
    private int y0;
    private int largura;
    private int altura;
    
    public Quadrante(int x0, int y0, int largura, int altura){
        this.nodes = new ListaEncadeada();
        this.x0 = x0;
        this.y0 = y0;
        this.largura = largura;
        this.altura = altura;
    }
    
    public Quadrante(int num_max_nodes, int x0, int y0, int largura, int altura){
        this.num_max_nodes = num_max_nodes;
        this.nodes = new ListaEncadeada(num_max_nodes);
        this.x0 = x0;
        this.y0 = y0;
        this.largura = largura;
        this.altura = altura;
    }
    
    public boolean taNoQuadrante(int x, int y){
        return (x>x0 && x<largura) && (y>y0 && y<altura);
    }
    
    public int getX0(){
        return x0;
    }
    
    public int getY0(){
        return y0;
    }
    
    public void inserir(int x, int y){
        if(nodes.cheia()){
            System.out.println("ta cheia");
            return;
        }
        if(!taNoQuadrante(x,y)){
            System.out.println("não é aqui não");
            return;
        }
        nodes.insereOrdenado(x, y);
        num_max_nodes++;
        
        
    }
    
    public void remover(int x, int y){
        nodes.remove(x, y);
    }
    
    public void imprimir(){
        nodes.imprime();
    }
    
    
}
