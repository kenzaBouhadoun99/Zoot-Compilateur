package zoot.arbre.expressions;

import zoot.arbre.ArbreAbstrait;
/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public abstract class Expression extends ArbreAbstrait {
    /**
     * constructeur de la classe abstraite
     * @param n
     */

    protected Expression(int n) {
        super(n) ;
    }

    /**
     * getter de nom
     * @return
     */

    public abstract String getNom();
    /**
     * fonction qui verifie si la variable est constante
     * @return
     */

    public abstract boolean estConstante();
    /**
     *  fonction qui verifie si la variable est booleenne
     * @return
     */

    public abstract boolean estbooleen();
    /**
     *  fonction qui verifie si la variable est un identifiant
     * @return
     */

    public abstract boolean estidentifiant();
    /**
     * getter de type
     * @return
     */

    public abstract boolean estFonction();
    public abstract String getType();

}
