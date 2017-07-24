package simuladorescalonamentojava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author Roseane
 */
public class SJF implements Runnable {

    ArrayList<Processo> processos;    
    ArrayList<Integer> processosOrdenadosInt = new ArrayList<>();
    ArrayList<Processo> processosOrdenados =  new ArrayList<>();
    ArrayList<Processo> processosFinal = new ArrayList<>();
    JLabel mostraLetra;
    JLabel mostraProcessos;
    JLabel mostraTempo;
    

    public SJF(ArrayList<Processo> processos, JLabel mostraLetra, JLabel mostraProcessos, JLabel mostraTempo) {
        this.processos = processos;
        this.mostraLetra = mostraLetra;
        this.mostraProcessos = mostraProcessos;
        this.mostraTempo = mostraTempo;
    }

    public SJF() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        executaEscalonador(processosOrdenados, processosOrdenadosInt, processos, mostraLetra, mostraProcessos, mostraTempo, processosFinal);
      
    }
    
    public void executaEscalonador(ArrayList<Processo> processosOrdenados, ArrayList<Integer> processosOrdenadosInt, ArrayList<Processo> processos, JLabel mostraLetra, JLabel mostraProcessos, JLabel mostraTempo,ArrayList<Processo> processosFinalizados){
 
        for(Processo processox : processos)
        {
            processosOrdenadosInt.add(processox.getTempoTotal());
        }
        Collections.sort(processosOrdenadosInt);
        
        while(!processos.isEmpty())
        {
            for(int processoInt : processosOrdenadosInt)
            {
                for(Processo processoy : processos)
                {
                    if(processoInt == processoy.getTempoTotal()) 
                    {
                        processosOrdenados.add(processoy);
                        processos.remove(processoy);                        
                        break;
                    }
                }
            }
        }
        mostraProcessos.setText(processosOrdenados.toString());
               
        int tempoTotalTurnaround = 0;       
            while(!processosOrdenados.isEmpty()){
                Processo processo2 = processosOrdenados.get(0);
                int tempoTotal = processo2.getTempoTotal(); 
                for(int x =0; x< tempoTotal ;x++)
                {
                    mostraLetra.setText(processo2.getNomeProcesso());
                    tempoTotalTurnaround++; 
                    mostraTempo.setText(tempoTotalTurnaround+""); 
                    for(int j = processosOrdenados.indexOf(processo2)+1; j < processosOrdenados.size(); j++)
                    {
                        processosOrdenados.get(j).incrementaTempoEspera();
                    }    
                    for(int j = processosOrdenados.indexOf(processo2); j < processosOrdenados.size(); j++)
                    {
                        processosOrdenados.get(j).incrementaTempoTurnround();
                    }
                    processo2.decrementaTempoTotal(); 
                    mostraProcessos.setText("<html>"+processosOrdenados.toString()+"<html>");
                    
                    try {                 
                        Thread.sleep(1000);                                              
                    } catch (InterruptedException ex) {
                    Logger.getLogger(FIFO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                processosFinal.add(processo2);
                processosOrdenados.remove(processo2);                
            }
            mostraProcessos.setText("<html>"+processosFinal.toString()+"<html>");       
        
    }
    

}
