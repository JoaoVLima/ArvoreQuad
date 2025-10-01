/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limadeveloper.arvorequad;

import com.limadeveloper.listaencadeada.ListaEncadeada;
import com.limadeveloper.listaencadeada.Node;

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
    
    public Quadrante(int num_max_nodes, int x0, int y0, int largura, int altura){
        this.num_max_nodes = num_max_nodes;
        this.nodes = new ListaEncadeada(num_max_nodes);
        this.x0 = x0;
        this.y0 = y0;
        this.largura = largura;
        this.altura = altura;
    }
    
    public boolean cheia(){
        return nodes.cheia();
    }
    
    public boolean taNoQuadrante(int x, int y){
        return (x>=x0 && x<=x0+largura) && (y>=y0 && y<=y0+altura);
    }
    
    public int getX0(){
        return x0;
    }
    
    public int getY0(){
        return y0;
    }
    
    public int getLargura(){
        return largura;
    }
    
    public int getAltura(){
        return altura;
    }
    
    public int getNumMaxNodes(){
        return num_max_nodes;
    }
    
    public Node removerPrimeiro(){
        return nodes.removePrimeiro();
    }
    
    public boolean inserir(int x, int y){
        if(nodes.cheia()){
            System.out.println("ta cheia");
            return false;
        }
        if(!taNoQuadrante(x,y)){
            System.out.println("não é aqui não");
            return false;
        }
        nodes.insereOrdenado(x, y);
        return true;
        
        
    }
    
    public void remover(int x, int y){
        nodes.remove(x, y);
    }
    
    public void imprimir(){
        nodes.imprime();
    }
    
    public void imprimir(int count){
        System.out.print("\t".repeat(count));
        nodes.imprime();
    }
    
    
}
