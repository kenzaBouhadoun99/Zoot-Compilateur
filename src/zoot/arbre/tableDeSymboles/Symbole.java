package zoot.arbre.tableDeSymboles;
/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public class Symbole {

    protected int deplacement;
    protected String type;
    protected int numligne;

    /**
     * constructeur de symbole avec le deplacement
     * @param dep
     * @param t
     */
    public Symbole(int dep, String t) {
        this.deplacement = dep;
        this.type = t;
    }

    public Symbole(String t , int numligne){
        this.type = t;
        this.numligne = numligne;
    }
    /**
     * constructeur de symbole
     * @param type
     */

    public Symbole(String type) {
        this.type = type;
    }

    /**
     * getter de deplacement
     * @return
     */
    public int getDeplacement() {
        return deplacement;
    }

    /**
     * setter de deplacement
     * @return
     */
    public void setDeplacement(int dep) {
        this.deplacement = dep;
    }

    /**
     * getter de type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * setter de type
     * @param t
     */
    public void setType(String t) {
        this.type = t;
    }

    public int noligne(){
        return numligne;
    }
}