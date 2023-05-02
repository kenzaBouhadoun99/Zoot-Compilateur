package zoot.arbre.tableDeSymboles;

import zoot.exceptions.DoubleDeclaration;
import zoot.exceptions.VariablenonDecalrees;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public class TDS {

    private static final TDS INSTANCE = new TDS();
    private final HashMap<String, Symbole> var;

    /**
     * constructeur
     */
    private TDS() {
        this.var =  new HashMap<>();
    }

    /**
     * getter de l'instance
     * @return
     */
    public static TDS getInstance(){
        return INSTANCE;
    }

    /**
     * fonction qui ajout un symbole
     * @param entree
     * @param s
     * @throws DoubleDeclaration
     */
    public void ajouter(Entree entree, Symbole s ) throws DoubleDeclaration {
        if(this.var.containsKey(entree.getNom())){
            throw new DoubleDeclaration("le symbole " + entree.getNom() + " est déclaré 2 fois",s.noligne());
        }
        s.setDeplacement(this.getTailleZoneVariable());
        this.var.put(String.valueOf(entree.getNom()), s);
    }
    /**
     *
     * @param entree
     * @return
     * @throws VariablenonDecalrees
     */

    public Symbole identifier(Entree entree) throws VariablenonDecalrees {
        Symbole symbole = new Symbole(0, "");
        for (Map.Entry<String, Symbole> m : this.var.entrySet()){
            if(m.getKey().equals(entree.getNom())) {
                symbole.setDeplacement(m.getValue().getDeplacement());
                symbole.setType(m.getValue().getType());
            }

        }
        if(!symbole.getType().equals("entier") && !symbole.getType().equals("booleen")){
            throw new VariablenonDecalrees("Attention erreur dans la table de symbole");
        }
        return symbole;
    }
    /**
     * getter de taille de zone de variable
     * @return
     */

    public int getTailleZoneVariable(){
        return this.var.size() * (-4);
    }

}
