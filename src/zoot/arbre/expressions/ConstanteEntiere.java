package zoot.arbre.expressions;

public class ConstanteEntiere extends Constante {
    /**
     * constructeur
     * @param texte
     * @param n
     */

    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    /**
     * fonction qui genere le  code mips de la constante entiere
     * @return
     */

    @Override
    public String toMIPS() {
       // throw new UnsupportedOperationException("fonction toMips non définie ") ;
        return this.cste;
    }
    /**
     * fonction qui verifie si la variable est un booleen
     * @return
     */


    @Override
    public boolean estbooleen() {
        return false;
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
        return "entier";
    }
}
