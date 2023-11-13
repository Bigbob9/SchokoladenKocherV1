package org.example;

public class SchokoladenKocher {
    private volatile static SchokoladenKocher einzigartigeInstanz;
    private boolean leer;
    private boolean gekocht;

    private SchokoladenKocher(){
        leer = true;
        gekocht = false;
    }

    // Singelton mit doppelter Sperrung
    public static SchokoladenKocher getInstance(){
        if( einzigartigeInstanz == null){
            synchronized (SchokoladenKocher.class) {
                if (einzigartigeInstanz == null) {
                    einzigartigeInstanz = new SchokoladenKocher();
                }
            }
        }
        return einzigartigeInstanz;
    }

    public void fuellen(){
         if (isLeer()){
             leer = false;
             gekocht = false;
             // den Kocher mit der Milch-Schokolade_mischung füllen
         }
    }

    public void leeren(){
        if (!isLeer() && isGekocht()){
            //gekochte Milch-Schokolade_Mischung ausleeren
            leer = true;
        }
    }

    public void kochen(){

        if(!isLeer() && !isGekocht()){
            // den Inhalt zum Kochen bringen
            gekocht = true;
        }
    }

    public boolean isLeer(){
        return leer;
    }

    public boolean isGekocht(){
        return gekocht;
    }





}