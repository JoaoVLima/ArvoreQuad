/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limadeveloper.listaencadeada;

public class Node {
    // ArvoreQuad com apenas (x,y) sendo guardado no Node,
    // essa informação depende da aplicação que vc for utilizar.
    private Integer x;
    private Integer y;
    private Node proximo;

    public Node() {
        this.x = null;
        this.y = null;
        this.proximo = null;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
    
    public void imprime() {
        System.out.print("("+x+","+y+")");
    }
    
    public void imprimeln() {
        System.out.println("("+x+","+y+")");
    }
}
