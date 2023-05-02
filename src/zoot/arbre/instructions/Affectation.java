package zoot.arbre.instructions;

import zoot.arbre.expressions.DetectionErreur;
import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Identifiant;
import zoot.arbre.expressions.ListeErreursDetecter;
import zoot.exceptions.VariablenonDecalrees;
import zoot.exceptions.VerifieType;

public class Affectation extends Instruction {

    /**
     * Lahlou Ghalia & Bouhadoun Kenza
     */

    protected final Expression expression ;
    protected final Identifiant identifiant;

    /**
     * constructeur de la classe
     * @param ident
     * @param exp
     * @param i
     */
    public Affectation(Identifiant ident, Expression exp, int i) {
        super(i) ;
        this.expression = exp;
        this.identifiant = ident;
    }


    /**
     * fonction qui verifie l'expression et l'identifiant
     * @throws VariablenonDecalrees
     */

    @Override
    public void verifier(){
        this.expression.verifier();
        this.identifiant.verifier();
        try {
            if (!this.identifiant.getType().equals(this.expression.getType())) {
                ListeErreursDetecter.getInstance().ajouter(new DetectionErreur((this.identifiant.getNom() + " = " + this.expression.getNom() + "   Attention! les variables n'ont pas le meme type , cette opération n'est pas valables! \n"), this.noLigne));
            }
        } catch (VariablenonDecalrees e) {

        }
    }

    /**
     * fonction qui genere le code mips de l'affectation
     * @return
     */
    @Override
    public String toMIPS() {
        StringBuilder str = new StringBuilder();
        if (expression.estFonction()) {
            str.append("   #").append(identifiant.getNom()).append(" = ").append(expression.getNom()).append("\n");
            str.append(expression.toMIPS());
            str.append("\tsw $v0, ").append(identifiant.toMIPS()).append("\n");
        } else {
            if (!expression.estidentifiant()) {
                str.append("   #").append(identifiant.getNom()).append(" = ").append(expression).append("\n");
                if (expression.estbooleen()) {
                    str.append("\tla $v0, ").append(expression.toMIPS()).append("\n")
                            .append("\tsw $v0, ").append(identifiant.toMIPS()).append("\n");
                } else {
                    str.append("\tli $v0, ").append(expression.toMIPS()).append("\n")
                            .append("\tsw $v0, ").append(identifiant.toMIPS()).append("\n");
                }
            } else {
                str.append("   #").append(identifiant.getNom()).append(" = ").append(expression.getNom()).append("\n");
                str.append("\tlw $v0, ").append(expression.toMIPS()).append("\n").append("\tsw $v0, ").append(identifiant.toMIPS()).append("\n");
            }
        }
        return str.toString();
    }
}
