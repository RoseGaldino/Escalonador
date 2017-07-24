package simuladorescalonamentojava;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Roseane
 */
public class FIFO {
    
    private char[] alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private List<Processo> processos;
    private int processoAtual;
    
    public FIFO() {
        processos = new ArrayList();
    }

    public FIFO(ArrayList<Processo> proc, JLabel Label_mostrarLetra, JLabel Label_mostrarProcessos, JLabel Label_mostrarTempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void adicionar(Processo processo) {
        this.processos.add(processo);
    }
    
    private boolean remover() {
        
        if (!estaVazio()) {
            this.processos.remove(0);
            return true;
        } else {
            return false;
        }
        
    }
    
    private boolean estaVazio() {
        return processos.isEmpty();
    }
    
    private String listar() {
        StringBuilder builder = new StringBuilder();
        
        for (Processo processo : processos) {
            builder.append(processo.getId()).append(" - ");
        }
        
        return builder.toString();
    }
    
    private int lerEntradaQuantidade(){
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de processos: "));
        
        return quantidade;
    }
    
    private void lerEntradaProcesso(){
        int tempo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tempo de execução: "));
        
        processos.add(new Processo(String.valueOf(alfabeto[processoAtual++]), tempo));
    }
    
    public void executar(){
        
        int quantidade = lerEntradaQuantidade();
        
        for(int i = 0; i < quantidade; i++){
            lerEntradaProcesso();
        }
        
        executarLogica();
        
    }
    
    private void mostrar(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void executarLogica(){
        
        while (true) {
            String listagem = listar();
            
            int resposta = JOptionPane.showConfirmDialog(null, listagem);
            
            if (resposta == JOptionPane.OK_OPTION) {
                boolean removeu = remover();
                
                if (!removeu) {
                    break;
                }
            } else {
                continue;
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Algoritmo finalizado.");
        
    }
    
}
