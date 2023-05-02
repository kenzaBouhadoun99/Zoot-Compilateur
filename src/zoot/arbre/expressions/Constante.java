package zoot.arbre.expressions;


/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */
public abstract class Constante extends Expression {

    protected final String cste ;


    /**
     * constructeur de la classe constante
     * @param texte
     * @param n
     */

    protected Constante(String texte, int n) {
        super(n) ;
        cste = texte ;
    }


    /**
     * fonction qui verifie
     */
    @Override
    public void verifier() {
       // throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }


    /**
     * fonction qui retourne la constante
     * @return cste
     */
    @Override
    public String toString() {
        return cste ;
    }


    /**
     * getter de nom
     * @return String
     */
    public String getNom() {
        return
                 this.cste;
    }


    /**
     * fonction qui dis si la variable est constante
     * @return booleen
     */
    @Override
    public boolean estConstante (){
        return true;
    }

}
