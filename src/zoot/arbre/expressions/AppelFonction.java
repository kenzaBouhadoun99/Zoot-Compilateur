package zoot.arbre.expressions;

import zoot.arbre.tableDeSymboles.Entree;
import zoot.arbre.tableDeSymboles.TDS;

public class AppelFonction extends Expression{

        private final Identifiant identifiant;

        public AppelFonction(Identifiant identifiant, int i) {
            super(i);
            this.identifiant = identifiant;
        }

        @Override
        public void verifier() {
        }

        @Override
        public String toMIPS() {
            return "\tsw $v0, ($sp)\n" +
                    "\tadd $sp, $sp, -4\n" +
                    "\tjal " + identifiant.getNom() + "\n\n";
        }

        @Override
        public boolean estidentifiant() {
            return false;
        }

        @Override
        public boolean estbooleen() {
            return false;
        }

        @Override
        public boolean estFonction() {
            return true;
        }

        @Override
        public String getType() {
            return TDS.getInstance().identifier(new Entree(identifiant.getNom())).getType();
        }

        @Override
        public String getNom() {
            return this.identifiant.getNom();
        }

    @Override
    public boolean estConstante() {
        return false;
    }
}

