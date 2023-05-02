package zoot.arbre.tableDeSymboles;

import zoot.arbre.ArbreAbstrait;

public class Fonction {
    private ArbreAbstrait arbreAbstrait;
    private int noLigne;
    private String idf;

    public Fonction(ArbreAbstrait arbreAbstrait, int noLigne, String identifiant) {
        this.arbreAbstrait = arbreAbstrait;
        this.noLigne = noLigne;
        this.idf = identifiant;
    }


    public String toMIPS(){
        return "\t" + idf + ":\n" +arbreAbstrait.toMIPS() + "\n";
    }

    public void verifier(){

    }
}
