/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.limadeveloper.listaencadeada;

/**
 *
 * @author Lima
 */
public class ListaEncadeada {
    private Node Lista;
    private int num_nodes;
    private Integer capacidade;

    public ListaEncadeada() {
        this.Lista = null;
        this.num_nodes = 0;
        this.capacidade = null;
    }
    
    public ListaEncadeada(int capacidade) {
        this.Lista = null;
        this.num_nodes = 0;
        this.capacidade = capacidade;
    }
    
    
    public boolean vazia(){
        return Lista==null; 
    }
    
    public boolean cheia(){
        if(capacidade!=null){
            return num_nodes >= capacidade;
        }else{
            return false;
        }
    }

    //Inserindo elementos
    public void insereUltimo(int x, int y) {
        if (cheia()){
            System.out.println("Lista cheia");
            return;
        }
        
        //Declarando nosso novo nó
        Node no = new Node();
        no.setX(x);
        no.setY(y);
        if (vazia()) {
            Lista = no;
            num_nodes++;
        } else {
            //Aqui se cria um apontador para a lista.
            Node atual = Lista;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(no);
            num_nodes++;
            System.out.println("Nó atual no endereço" + atual);
        }
    }
    
    public void inserePrimeiro(int x, int y){
        if (cheia()){
            System.out.println("Lista cheia");
            return;
        }
        Node no = new Node();
        no.setX(x);
        no.setY(y);
        if (vazia()) {
            Lista = no;
            num_nodes++;
        } else {
            Node atual = Lista;
            no.setProximo(atual);
            Lista = no;
            num_nodes++;
        }
    }
    
    public void insereDepois(int indice, int x, int y){
        if (cheia()){
            System.out.println("Lista cheia");
            return;
        }
        Node no = new Node();
        no.setX(x);
        no.setY(y);
        if (vazia()) {
            Lista = no;
            num_nodes++;
        }else if(indice==0){
            inserePrimeiro(x,y);
        }else {
            Node atual = Lista;
            Node atualProximo = atual.getProximo();
            int contador = 1;
            while (atualProximo != null && contador!=indice) {
                atual = atual.getProximo();
                atualProximo = atual.getProximo();
                contador++;
            }
            if(contador!=indice){
                System.out.println("Indice não encontrado");
            }else{
                no.setProximo(atualProximo);
                atual.setProximo(no);
                num_nodes++;
                System.out.println("Nó atual no endereço" + atual);
            }
        }
        
    }
    
    public void insereDepois(Node node, int x, int y){
        if (cheia()){
            System.out.println("Lista cheia");
            return;
        }
        Node no = new Node();
        no.setX(x);
        no.setY(y);
        if (vazia()) {
            Lista = no;
            num_nodes++;
        }else{
            Node atual = Lista;
            Node atualProximo = atual.getProximo();
            while (atualProximo != null && node!=atual) {
                atual = atual.getProximo();
                atualProximo = atual.getProximo();
            }
            if(node!=atual){
                System.out.println("Indice não encontrado");
            }else{
                no.setProximo(atualProximo);
                atual.setProximo(no);
                num_nodes++;
                System.out.println("Nó atual no endereço" + atual);
            }
        }
    }
    
    public void insereOrdenado(int x, int y){
        // [(1,3),(1,5),(2,2),(3,1)]
        // (1,4)
        // [(1,3),(1,4),(1,5),(2,2),(3,1)]
        // (0,9)
        // [(0,9),(1,3),(1,4),(1,5),(2,2),(3,1)]
        // (10,10)
        // [(0,9),(1,3),(1,4),(1,5),(2,2),(3,1),(10,10)]
        // (2,4)
        // [(0,9),(1,3),(1,4),(1,5),(2,2),(2,4),(3,1),(10,10)]
        // (2,4)
        // [(0,9),(1,3),(1,4),(1,5),(2,2),(2,4),(2,4),(3,1),(10,10)]
        
        
        if (cheia()){
            System.out.println("Lista cheia");
            return;
        }else if (vazia()){
            inserePrimeiro(x,y);
            return;
        }
        
        Node no = new Node();
        no.setX(-1);
        no.setY(-1);

        Node atual = Lista;
        Node maior = no;
        
        
        while (atual.getProximo() != null) {
            
            if((atual.getX()<x || (atual.getX()<=x && atual.getY()<y))
                    && 
               (x>maior.getX() || (x>=maior.getX() && y>maior.getY()))){
                maior = atual;
            }
            
            atual = atual.getProximo();
        }
         
        if((atual.getX()<x || (atual.getX()<=x && atual.getY()<y))
                && 
           (x>maior.getX() || (x>=maior.getX() && y>maior.getY()))){
            maior = atual;
        }
        
        if(maior.getX()==-1 && maior.getY()==-1){
            inserePrimeiro(x, y);
        }else{
            insereDepois(maior, x, y);
        }
        
    }
    
    //Removendo elementos
    public Node remove(int indice){
        if(vazia()){
            return null;
        }
        if(indice==0){
            return removePrimeiro();
        }
        
        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        Node node_removido;
        
        if(atualProximo == null){
            node_removido = atual;
            Lista = null;
            return node_removido;
        }
        
        while (atualProximo!=null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }
        
        atual.setProximo(null);
        return atualProximo;
    }
    
    public Node remove(Integer x, Integer y){
        if(vazia()){
            return null;
        }
        
        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        Node node_removido;
        
        if(atualProximo == null){
            node_removido = atual;
            Lista = null;
            return node_removido;
        }
        
        
        while ((atualProximo!=null && atualProximo.getProximo() != null) 
               || (atualProximo.getX()==x && atualProximo.getY()==y)) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }
        
        atual.setProximo(atualProximo.getProximo());
        return atualProximo;
    }
    
    public Node remove(Node node){
        if(vazia()){
            return null;
        }
        if(node==Lista){
            return removePrimeiro();
        }
        
        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        
        while (atual.getProximo() != null && atual!=node) {
            atual = atual.getProximo();
        }
        
        atual.setProximo(null);
        
        return atual;
    }
    
    public Node removePrimeiro(){
        if(vazia()){
            return null;
        }
        Node node_removido = Lista;
        Node proximo = Lista.getProximo();
        
        
        Lista = proximo;
        return node_removido;
        
    }
    
    public Node removeUltimo(){
        if(vazia()){
            return null;
        }
        
        Node atual = Lista;
        Node atualProximo = atual.getProximo();
        Integer info;
        
        if(atualProximo == null){
            Lista = null;
            return atual;
        }
        
        while (atualProximo!=null && atualProximo.getProximo() != null) {
            atual = atual.getProximo();
            atualProximo = atual.getProximo();
        }
        
        atual.setProximo(null);
        return atualProximo;
    }
    
    //Imprimindo elementos
    public void imprime() {
        Node atual = Lista;
        while (atual != null) {
            atual.imprime();
            System.out.print(" -> ");
            atual = atual.getProximo();
        }
        System.out.println("Null");
    }
    
}