package zoot.arbre.expressions;
/**
 *@author Lahlou Ghalia & Bouhadoun Kenza
 */

public class ConstanteBooleene extends Constante {
    /**
     * constructeur
     * @param texte
     * @param n
     */

    public ConstanteBooleene(String texte, int n) {
        super(texte, n);
    }

    /**
     * fonction qui genere le code mips la constante booleenne
     * @return
     */

    //faire un teste ici si c vrai alors il affiche 1 si c est faut il affiche 0
    @Override
    public String toMIPS() {
        if(cste.equals("vrai")){
            return "1";
        }else
        return "0";
    }
    /**
     * fonction qui verifie si la variable est booleen
     * @return
     */

    @Override
    public boolean estbooleen() {
        return true;
    }
    /**
     * fonction qui verifie si la variable est un identifiant
     * @return
     */

    @Override
    public boolean estidentifiant() {
        return false;
    }
    /**
     * getter de type
     * @return
     */

    @Override
    public boolean estFonction(){
        return false;
    }
    @Override
    public String getType() {
        return "booleen";
    }

}