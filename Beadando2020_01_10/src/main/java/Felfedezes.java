//@author Vicu
public class Felfedezes {
    private int ev_Int;
    private String ev_String;
    private String nev;
    private String vegyjel;
    private int rendszam;
    private String felfedezo;
    
    private boolean tryParseInt(String value) {  
     try {  
         Integer.parseInt(value);  
         return true;  
      } catch (NumberFormatException e) {  
         return false;  
      }  
}

    public Felfedezes(String sor) 
    {
        String[] tmp = sor.split(";");
        
        
        if (tryParseInt(tmp[0]))
        {
            this.ev_Int = Integer.parseInt(tmp[0]);
            this.ev_String = null;
        }
        else
        {
            this.ev_Int = 0;
            this.ev_String = tmp[0];
        }
        this.nev = tmp[1];
        this.vegyjel = tmp[2];
        this.rendszam = Integer.parseInt(tmp[3]);
        this.felfedezo = tmp[4];  
    }
    

    public int Ev_Int() {
        return ev_Int;
    }

    public String Ev_String() {
        return ev_String;
    }

    public String Nev() {
        return nev;
    }

    public String Vegyjel() {
        return vegyjel;
    }

    public int Rendszam() {
        return rendszam;
    }

    public String Felfedezo() {
        return felfedezo;
    }
}
