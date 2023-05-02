package zoot.arbre.expressions;

public class Booleen extends Constante{


    /**
     * Lahlou Ghalia & Bouhadoun Kenza
     */
    public Booleen(String texte, int n) {
        super(texte, n);
    }


    /**
     * fonction qui retourn 1 si vrai 0 sinon
     * @return 1 ou 0
     */
    @Override
    public String toMIPS() {
        return cste.equals("vrai") ? "1" : "0";
    }


    /**
     * fonction qui verifie si la variables est booleenne
     * @return booleen
     */
    @Override
    public boolean estbooleen() {
        return false;
    }


    /**
     * fonction qui verifie si la variables est un identifiant
     * @return booleen
     */
    @Override
    public boolean estidentifiant() {
        return false;
    }

    @Override
    public boolean estFonction() {
        return false;
    }


    /**
     * fonction qui retourne le type de variable
     * @return string
     */
    @Override
    public String getType() {
        return null;
    }
}