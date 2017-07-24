package simuladorescalonamentojava;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Roseane
 */

public class ROBIN implements Runnable {
    ArrayList<Processo> processos;
    ArrayList<Processo> processosFinal = new ArrayList<>();
    JLabel mostraLetra;
    JLabel mostraProcessos;
    JLabel mostraTempo;
    int quantum; 

    
    public ROBIN(ArrayList<Processo> processos, JLabel mostraLetra, JLabel mostraProcessos, JLabel mostraTempo, int quantum) {
        this.processos = processos;
        this.mostraLetra = mostraLetra;
        this.mostraProcessos = mostraProcessos;
        this.mostraTempo = mostraTempo;
        this.quantum = quantum;
    }

    @Override
    public void run() {
        executaEscalonador(processos, processosFinal, mostraLetra, mostraProcessos, mostraTempo, quantum);
      
    }
    
    public void executaEscalonador(ArrayList<Processo> processos, ArrayList<Processo> processosFinal, JLabel mostraLetra, JLabel mostraProcessos, JLabel mostraTempo, int quantum)
    {   
        int processoDaVez = 0;
        
        int tempoTotalTurnaround = 0;       
            while(!processos.isEmpty()){
                Processo processo2 = processos.get(processoDaVez);
                int tempoTotal = processo2.getTempoTotal(); 
                if(tempoTotal >= quantum)
                {
                    for(int x =0; x < quantum ;x++)
                    {
                        mostraLetra.setText(processo2.getNomeProcesso());
                        tempoTotalTurnaround++;
                        mostraTempo.setText(tempoTotalTurnaround+""); 
                        for(int j = 0; j < processos.size(); j++)
                        {
                            if(!processos.get(j).equals(processo2))processos.get(j).incrementaTempoEspera();
                        }    
                        
                        for(int j = 0; j < processos.size(); j++)
                        {
                            processos.get(j).incrementaTempoTurnround();
                        }
                       
                        processo2.decrementaTempoTotal();
                       
                        mostraProcessos.setText("<html>"+processos.toString()+"<html>");

                        try {                 
                            Thread.sleep(1000);                                              
                        } catch (InterruptedException ex) {
                        Logger.getLogger(FIFO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(processo2.getTempoTotal()==0)
                    {
                        processosFinal.add(processo2);
                        processos.remove(processo2);
                                            
                        if(processoDaVez > processos.size()-1 && !processos.isEmpty()) processoDaVez = 0;                         
                    }
                    
                    else if(processoDaVez+1 <= processos.size()-1) processoDaVez++;
                    
                    else processoDaVez = 0;                      
                    
                }
                else if(processo2.getTempoTotal() > 0)
                {
                    
                    for(int y =0; y< tempoTotal ;y++)
                    {
                        mostraLetra.setText(processo2.getNomeProcesso());
                        tempoTotalTurnaround++; 
                        mostraTempo.setText(tempoTotalTurnaround+""); 
                        
                        for(int j = 0; j < processos.size(); j++)
                        {
                            if(!processos.get(j).equals(processo2))processos.get(j).incrementaTempoEspera();
                        }    
                
                        for(int j = 0; j < processos.size(); j++)
                        {
                            processos.get(j).incrementaTempoTurnround();
                        }                        
                        processo2.decrementaTempoTotal();
                        
                        mostraProcessos.setText("<html>"+processos.toString()+"<html>");
      
                        try {                 
                            Thread.sleep(1000);                                              
                        } catch (InterruptedException ex) {
                        Logger.getLogger(FIFO.class.getName()).log(Level.SEVERE, null, ex);
                        }                                                
                    }                  
                    
                     if(processo2.getTempoTotal()==0)
                     {
                         processosFinal.add(processo2);
                         processos.remove(processo2);
                                            
                         if(processoDaVez > processos.size()-1 && !processos.isEmpty()) processoDaVez = 0;                         
                     }
                     
                     else if(processoDaVez+1 <= processos.size()-1) processoDaVez++;
                     else processoDaVez = 0;       
            }
            mostraProcessos.setText("<html>"+processosFinal.toString()+"<html>");
    }        
 }
}
