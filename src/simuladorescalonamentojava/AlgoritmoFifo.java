package simuladorescalonamentojava;

import javax.swing.JOptionPane;

/**
 *
 * @author Roseane
 */
public class AlgoritmoFifo {
    
    int tamanho;
    int inicio;
    int fim;
    int processos = 0;
    int fifo[];

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getProcessos() {
        return processos;
    }

    public void setProcessos(int processos) {
        this.processos = processos;
    }

    public int[] getFifo() {
        return fifo;
    }

    public void setFifo(int[] fifo) {
        this.fifo = fifo;
    }
        
        
    public AlgoritmoFifo(){
        inicio = fim -1;
        tamanho = 50;
        fifo = new int[tamanho];
        processos = 0;
    }
        
    public boolean estaVazia(){
        if (processos == 0){
            return true;
        }
        return false;
    }
        
    public boolean estaCheia(){
        if(processos == tamanho - 1){
            return true;
        }
        return false;
    }
        
    public void adicionar(int ad){
        if(! estaCheia()){
            if(inicio == -1){
                inicio = 0;
            }
            fim++;
            fifo[fim] = ad;
            processos++;
        }
    }
    
    public void remover(){
        if(!estaVazia()){
            inicio++;
            processos--;
        }
    }
        
    public void mostrar(){
        String componentes = "";
        for(int i = inicio; i<=fim; i++){
            componentes += fifo[i]+" - ";
        }
        JOptionPane.showMessageDialog(null, componentes);
    }
    
    public static void main(String[] args) {
        AlgoritmoFifo f = new AlgoritmoFifo();
        f.adicionar(20);
        f.adicionar(10);
        f.adicionar(15);
        f.adicionar(5);
        f.adicionar(3);
        f.adicionar(2);
        f.mostrar();
        f.remover();
        f.mostrar();
        f.remover();
        f.mostrar();
        
    }

    
}
