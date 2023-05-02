package zoot.arbre.expressions;

import zoot.arbre.tableDeSymboles.*;
import zoot.exceptions.VariablenonDecalrees;

/**
 *@author Lahlou Ghalia & Bouhadoun Kenza
 */

    public class Identifiant extends Expression {
        private final Entree entree;
        private Symbole s;
    /**
     * constructeur
     * @param str
     * @param n
     */

        public Identifiant(String str, int n) {
            super(n) ;
            this.entree= new Entree(str);
            this.noLigne = n;
        }
    /**
     * fonction de verification
     * @throws VariablenonDecalrees
     */

        @Override
        public void verifier() throws VariablenonDecalrees {
            try {
                this.s = TDS.getInstance().identifier(this.entree);
            } catch (VariablenonDecalrees m) {
                ListeErreursDetecter.getInstance().ajouter(new DetectionErreur("Attention! le symbole  : " + entree.getNom() + "  n'a pas été déclaré", this.noLigne));
            }
        }
    /**
     * getter de nom
     * @return
     */

        public String getNom() {
            return this.entree.getNom();
        }

    /**
     * getter de type
     * @return
     */
    public String getType() throws VariablenonDecalrees{
            return TDS.getInstance().identifier(this.entree).getType();
        }

    /**
     * fonction qui genere le code mips de l'identifiant
     * @return
     */
        @Override
        public String toMIPS() {
            try {
                return (TDS.getInstance().identifier(this.entree).getDeplacement() + ("($s7)\n"));
            } catch (VariablenonDecalrees msg) {
                ListeErreursDetecter.getInstance().ajouter(new DetectionErreur(msg.getMessage(), this.noLigne));
            }
            return ("0($s7)\n");
        }


    /**
     *  fonction qui verifie si la variable est constante
     * @return
     */

        @Override
        public boolean estConstante() {
            return false;
        }

    /**
     *  fonction qui verifie si la variable est booleen
     * @return
     */
    @Override
    public boolean estbooleen() {
        try {
            return (s.getType().equals("booleen"));
        } catch (NullPointerException e) {
            return false;
        }
    }

        @Override
    public boolean estFonction(){
        return false;
    }

    /**
     *  fonction qui verifie si la variable est un identifiant
     * @return
     */
        @Override
        public boolean estidentifiant() {
            return true;
        }
    }
