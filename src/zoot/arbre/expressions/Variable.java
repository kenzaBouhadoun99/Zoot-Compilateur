package zoot.arbre.expressions;
/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public abstract class Variable extends Expression {

    protected String texte ;
    /**
     * constructeur de la classe
     * @param texte
     * @param n
     */

    protected Variable (String texte, int n) {
        super(n) ;
        this.texte = texte ;
    }

    /**
     * fonction verifie pas encore definie
     */

    @Override
    public void verifier() {
        throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

}