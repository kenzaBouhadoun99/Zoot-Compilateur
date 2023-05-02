package zoot.arbre.tableDeSymboles;

import java.util.ArrayList;

public class ListeFonctions {

    private final ArrayList<Fonction> listefonctions;
    private int compteur;
    private static final ListeFonctions INSTANCE = new ListeFonctions();

    public ListeFonctions(){
        this.listefonctions = new ArrayList<>();
        this.compteur = 0;
    }


    public static ListeFonctions getInstance(){
        return INSTANCE;
    }

    public void ajouter(Fonction fonc){
        this.listefonctions.add(fonc);
    }

    public ArrayList<Fonction> getFonctions() {
        return listefonctions;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int cpt) {
        this.compteur = cpt;
    }
}
