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
        if (cheia()){
            System.out.println("Lista cheia");
            return;
        }
        
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
        
        // to ignorando valores negativos por enquanto meu canvas vai de 0,0 a inf,inf
        
        // explicacao antiga com apenas um int
        //[1,3,4,5,6,10]
        //2
        //[1,2,3,4,5,6,10]
        //40
        //[1,2,3,4,5,6,10,40]
        //9
        //[1,2,3,4,5,6,9,10,40]
        //0
        //[0,1,2,3,4,5,6,9,10,40]
        
        if(vazia()){
            inserePrimeiro(x,y);
            return;
        }
        
        Node no = new Node();
        no.setX(null);
        no.setY(null);
        
        Node atual = Lista;
        Node maior = no;
        
        while (atual.getProximo() != null) {
            
            if(atual.getX()<x){
                maior = atual;
            }else if(atual.getY()<y){
                maior = atual;
            }
            
            
            atual = atual.getProximo();
        }
        
        if(atual.getX()<x){
            maior = atual;
        }else if(atual.getY()<y){
            maior = atual;
        }
        
        if(maior.getX()==null && maior.getY()==null ){
            inserePrimeiro(x,y);
        }else{
            insereDepois(maior, x,y);
        }
        
    }
    
    //Removendo elementos
//    public Integer remove(int indice){
//        if(vazia()){
//            return null;
//        }
//        if(indice==0){
//            return removePrimeiro();
//        }
//        
//        Node atual = Lista;
//        Node atualProximo = atual.getProximo();
//        Node node_removido;
//        
//        if(atualProximo == null){
//            node_removido = atual);
//            Lista = null;
//            return info;
//        }
//        
//        while (atualProximo!=null && atualProximo.getProximo() != null) {
//            atual = atual.getProximo();
//            atualProximo = atual.getProximo();
//        }
//        
//        info = atualProximo.getInformacao();
//        atual.setProximo(null);
//        return info;
//    }
//    
//    public Integer remove(Node node){
//        if(vazia()){
//            return null;
//        }
//        if(node==Lista){
//            return removePrimeiro();
//        }
//        
//        Node atual = Lista;
//        Node atualProximo = atual.getProximo();
//        
//        Integer info = null;
//        
//        while (atual.getProximo() != null && atual!=node) {
//            atual = atual.getProximo();
//        }
//        
//        info = atual.getInformacao();
//        atual.setProximo(null);
//        
//        return info;
//    }
//    
//    Integer removePrimeiro(){
//        if(vazia()){
//            return null;
//        }
//        Integer info = Lista.getInformacao();
//        Node proximo = Lista.getProximo();
//        
//        
//        Lista = proximo;
//        return info;
//        
//    }
//    
//    Integer removeUltimo(){
//        if(vazia()){
//            return null;
//        }
//        
//        Node atual = Lista;
//        Node atualProximo = atual.getProximo();
//        Integer info;
//        
//        if(atualProximo == null){
//            info = atual.getInformacao();
//            Lista = null;
//            return info;
//        }
//        
//        while (atualProximo!=null && atualProximo.getProximo() != null) {
//            atual = atual.getProximo();
//            atualProximo = atual.getProximo();
//        }
//        
//        info = atualProximo.getInformacao();
//        atual.setProximo(null);
//        return info;
//    }
    
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