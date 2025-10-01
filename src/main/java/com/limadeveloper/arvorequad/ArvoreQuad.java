/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.limadeveloper.arvorequad;

import com.limadeveloper.listaencadeada.Node;

/**
 *
 * @author Lima
 */
public class ArvoreQuad {
    // Cada ArvoreQuad representa uma região do espaço (um quadrante)
    private Quadrante quadrante;
    private boolean dividido;
    
    // Se foi dividido, usa as 4 subdivisões
    private ArvoreQuad esquerda_cima;
    private ArvoreQuad direita_cima;
    private ArvoreQuad esquerda_baixo;
    private ArvoreQuad direita_baixo;
    
    // Construtor inicializa o quadrante raiz
    ArvoreQuad(int num_max_nodes, int x0, int y0, int largura, int altura){
        this.quadrante = new Quadrante(num_max_nodes, x0, y0, largura, altura);
    }
    
    // Verifica se o ponto (x,y) pertence a este quadrante ou subquadrantes
    public boolean taNoQuadrante(int x, int y){
        if(dividido){
            if (esquerda_cima.taNoQuadrante(x,y)){
                return esquerda_cima.taNoQuadrante(x,y);
            }else if (direita_cima.taNoQuadrante(x,y)){
                return direita_cima.taNoQuadrante(x,y);
            }else if (esquerda_baixo.taNoQuadrante(x,y)){
                return esquerda_baixo.taNoQuadrante(x,y);
            }else if (direita_baixo.taNoQuadrante(x,y)){
                return direita_baixo.taNoQuadrante(x,y);
            }else{
                System.out.println("O ponto ("+x+","+y+") não pertence a este quadrante.");
                return false;
            }
        }else{
            return quadrante.taNoQuadrante(x,y);
        }
    }
    
    
    // Insere um ponto (x,y) neste quadrante ou no subquadrante
    public boolean inserir(int x, int y){
        boolean retorno = false;
        if(dividido){
            if (esquerda_cima.taNoQuadrante(x,y)){
                retorno = esquerda_cima.inserir(x, y);
            }else if (direita_cima.taNoQuadrante(x,y)){
                retorno = direita_cima.inserir(x, y);
            }else if (esquerda_baixo.taNoQuadrante(x,y)){
                retorno = esquerda_baixo.inserir(x, y);
            }else if (direita_baixo.taNoQuadrante(x,y)){
                retorno = direita_baixo.inserir(x, y);
            }else{
                System.out.println("O ponto ("+x+","+y+") não pertence a este quadrante.");
            }
        }else{
            // Tenta inserir no quadrante
            retorno = quadrante.inserir(x,y);
            if (!retorno){ // Caso falhe
                if (quadrante.cheia()){ // Verifica se esta cheia
                    System.out.println("Dividir"); // Caso cheia, divide em quadrantes
                    dividir();
                    retorno = inserir(x,y); // insere o ponto que a pessoa queria inserir
                    quadrante = null;
                }
            }
        }
        return retorno;
    }
    
    public boolean is_vazia(){
        if (dividido){
            return (esquerda_cima.is_vazia() 
                    && direita_cima.is_vazia() 
                    && esquerda_baixo.is_vazia()
                    && direita_baixo.is_vazia());
        }else{
            return quadrante.vazia();
        }
    }
    
    // Dividir o quadrante em 4 subquadrantes
    public void dividir(){
        if(dividido){
            System.out.println("Esse quadrante ja foi dividido.");
            return; 
        }
        
        // Informacoes do quadrante atual
        int num_max_nodes = quadrante.getNumMaxNodes();
        int x0 = quadrante.getX0();
        int y0 = quadrante.getY0();
        int largura = quadrante.getLargura();
        int altura = quadrante.getAltura();
        
        // Divide largura e altura pela metade
        int metade_x = (int) largura/2;
        int metade_y = (int) altura/2;
        
        // esquerda_cima
        int esquerda_cima_x0 = x0;
        int esquerda_cima_y0 = y0;
        int esquerda_cima_largura = metade_x;
        int esquerda_cima_altura = metade_y;
        
        // direita_cima
        int direita_cima_x0 = x0+metade_x;
        int direita_cima_y0 = y0;
        int direita_cima_largura = metade_x;
        int direita_cima_altura = metade_y;

        
        // esquerda_baixo
        int esquerda_baixo_x0 = x0;
        int esquerda_baixo_y0 = y0+metade_y;
        int esquerda_baixo_largura = metade_x;
        int esquerda_baixo_altura = metade_y;
        
        
        // direita_baixo
        int direita_baixo_x0 = x0+metade_x;
        int direita_baixo_y0 = y0+metade_y;
        int direita_baixo_largura = metade_x;
        int direita_baixo_altura = metade_y;
        
        // Criacao de subquadrantes
        esquerda_cima = new ArvoreQuad(num_max_nodes,esquerda_cima_x0,esquerda_cima_y0,esquerda_cima_largura, esquerda_cima_altura);
        direita_cima = new ArvoreQuad(num_max_nodes,direita_cima_x0,direita_cima_y0,direita_cima_largura,direita_cima_altura);
        esquerda_baixo = new ArvoreQuad(num_max_nodes,esquerda_baixo_x0,esquerda_baixo_y0,esquerda_baixo_largura,esquerda_baixo_altura);
        direita_baixo = new ArvoreQuad(num_max_nodes,direita_baixo_x0,direita_baixo_y0,direita_baixo_largura,direita_baixo_altura);
        
        dividido = true;
        
        // Reinsere os pontos nos seus respectivos quadrantes.
        Node no = quadrante.removerPrimeiro();
        while(no!=null){
            inserir(no.getX(), no.getY());
            no = quadrante.removerPrimeiro();
        }
        
        
    }
    
    public int getX0(){
        if(dividido){
            return esquerda_cima.getX0();
        } else{
            return quadrante.getX0();
        }
    }
    
    public int getY0(){
        if(dividido){
            return esquerda_cima.getY0();
        } else{
            return quadrante.getY0();
        }
    }
    
    public int getLargura(){
        if(dividido){
            return esquerda_cima.getLargura()+direita_cima.getLargura();
        } else{
            return quadrante.getLargura();
        }
    }
    
    public int getAltura(){
        if(dividido){
            return esquerda_cima.getAltura()+esquerda_baixo.getAltura();
        } else{
            return quadrante.getAltura();
        }
    }
    
    public int getNumMaxNodes(){
        if(dividido){
            return esquerda_cima.getNumMaxNodes();
        } else{
            return quadrante.getNumMaxNodes();
        }
    }
    
    // Junta os subquadrantes em um quadrante
    public void unir(){
        if(dividido){
            if (is_vazia()){
                int x0 = getX0();
                int y0 = getY0();
                
                int largura = getLargura();
                int altura = getAltura();
                
                int num_max_nodes = getNumMaxNodes();
                
                quadrante = new Quadrante(num_max_nodes, x0, y0, largura, altura);
                
                esquerda_cima = null;
                direita_cima = null;
                esquerda_baixo = null;
                direita_baixo = null;
                
                dividido = false;
                
            }else{
                System.out.println("Não é possivel unir, pois existem pontos a dentro dos subquadrantes.");
            }
        }else{
            System.out.println("jJa está unido em um quadrante.");
        }
    }
    
    public Node buscarNode(int x, int y){
        Node retorno = null;
        if(dividido){
            if (esquerda_cima.taNoQuadrante(x,y)){
                retorno = esquerda_cima.buscarNode(x, y);
            }else if (direita_cima.taNoQuadrante(x,y)){
                retorno = direita_cima.buscarNode(x, y);
            }else if (esquerda_baixo.taNoQuadrante(x,y)){
                retorno = esquerda_baixo.buscarNode(x, y);
            }else if (direita_baixo.taNoQuadrante(x,y)){
                retorno = direita_baixo.buscarNode(x, y);
            }else{
                System.out.println("O ponto ("+x+","+y+") não pertence a este quadrante.");
            }
        }else{
            retorno = quadrante.buscarNode(x,y);
            if (retorno == null){
                System.out.println("O ponto ("+x+","+y+") não pertence a este quadrante.");
            }
        }
        return retorno;
    }
    
    public Node remover(int x, int y){
        Node retorno = null;
        if(dividido){
            if (esquerda_cima.taNoQuadrante(x,y)){
                retorno = esquerda_cima.remover(x, y);
            }else if (direita_cima.taNoQuadrante(x,y)){
                retorno = direita_cima.remover(x, y);
            }else if (esquerda_baixo.taNoQuadrante(x,y)){
                retorno = esquerda_baixo.remover(x, y);
            }else if (direita_baixo.taNoQuadrante(x,y)){
                retorno = direita_baixo.remover(x, y);
            }else{
                System.out.println("O ponto ("+x+","+y+") não pertence a este quadrante.");
            }
            
            if(is_vazia()){
                unir();
            }
            
        }else{
            retorno = quadrante.remover(x,y);
            if (retorno == null){
                System.out.println("O ponto ("+x+","+y+") não pertence a este quadrante.");
            }
        }
        return retorno;
    }
    
    public void imprimir(){
        int count = 0;
        imprimir(count);
    }
    
    public void imprimir(int count){
        System.out.print("\t".repeat(count));
        System.out.println("Quadrante");
        if(dividido){
            esquerda_cima.imprimir(count+1);
            direita_cima.imprimir(count+1);
            esquerda_baixo.imprimir(count+1);
            direita_baixo.imprimir(count+1);
        }else{
            quadrante.imprimir(count+1);
        }
    }
}
