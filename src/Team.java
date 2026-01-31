public class Team {
    private String nome;
    private String[] giocatori; // 5 giocatori
    private int punteggioClassifica;
    private String strategia;

    public Team(String nome, String[] giocatori) {
        this.nome = nome;
        this.giocatori = giocatori;
        this.punteggioClassifica = 0;
        this.strategia = "";
    }

    // getter e setter
    public String getNome() { 
        return nome; 
    }

    public int getPunteggioClassifica() { 
        return punteggioClassifica; 
    }

    public void aggiungiPunti(int punti) { 
        punteggioClassifica += punti; 
    }

    public String[] getGiocatori() { 
        return giocatori; 
    }
    
    public void setStrategia(String strategia) { 
        this.strategia = strategia; 
    }

    public String getStrategia() { 
        return strategia; 
    }
}

