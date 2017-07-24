package simuladorescalonamentojava;

/**
 *
 * @author Roseane
 */
public class Processo {
    
    private int tempoExecucao;
    private String id;
    private int tempoTurnround = 0; //Acrescentei
    private int tempoEspera=0;//Acrescentei
    private int tempoTotal = 0; //Acrescentei
    
    public Processo() {
        
    }
    
    public Processo(String id, int tempoExecucao) {
        this.id = id;
        this.tempoExecucao = tempoExecucao;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + this.id;
    }

    int getTempoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getNomeProcesso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void incrementaTempoEspera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void incrementaTempoTurnround() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void decrementaTempoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
