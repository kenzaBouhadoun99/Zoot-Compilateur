package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;
/**
 * Lahlou Ghalia & Bouhadoun Kenza
 */

public class Ecrire extends Instruction {

    protected Expression expression ;

    /**
     * Constructeur
     * @param e
     * @param n
     */
    public Ecrire (Expression e, int n) {
        super(n) ;
        expression = e ;
    }
    /**
     * fonction qui verifie l'expression
     */

    @Override
    public void verifier() {
       this.expression.verifier();
    }

    /**
     * fonction qui genere le code mips d'ecriture
     * @return
     */

    @Override
    public String toMIPS() {
      /* StringBuilder strb =new StringBuilder("");
        if(expression.estConstante()){
            strb.append("\tli $a0, ").append(expression.toMIPS());
            strb.append("\n");
            strb.append("\tli $v0, 1\n\tsyscall\n\n");
        }else{
            strb.append("\tlw $v0, ")
                    .append(expression.toMIPS())
                    .append("\tmove $a0, $v0\n")
                    .append("\tli $v0, 1\n")
                    .append("\tsyscall\n\n");
        }
        strb.append("\tla $a0, newligne\n\tli $v0, 4\n\tsyscall\n\n");
        return strb.toString();*/
        StringBuilder strb = new StringBuilder();
        strb.append("  #ecrire ").append(expression.getNom()).append("\n");
        if (expression.estbooleen()) {
            if (expression.estidentifiant()) {
                strb.append("\tlw $t0, ").append(expression.toMIPS()).append("\n");
                strb.append("\tbeq $s1, $t0, Sinon").append(expression.getNoLigne()).append("\n");
                strb.append("\tla $a0, print_V\n");
                strb.append("\tli $v0, 4\n\tsyscall" + "\n");
                strb.append("\tb FinSi").append(expression.getNoLigne()).append("\n");
                strb.append("\tSinon").append(expression.getNoLigne()).append(":").append("\n");
                strb.append("\tla $a0, print_F\n");
                strb.append("\tli $v0, 4\n\tsyscall" + "\n");
                strb.append("\tFinSi").append(expression.getNoLigne()).append(":").append("\n");
            } else {
                strb.append("\tla $a0,");
                if (expression.getNom().equals("vrai")) {
                    strb.append(" print_V\n");
                } else {
                    strb.append(" print_F\n");
                }
                strb.append("\tli $v0, 4\n\tsyscall" + "\n");
            }
        } else if (!expression.estidentifiant()) {
            strb.append("\tli $a0, ").append(expression.toMIPS()).append("\n");
            strb.append("\tli $v0, 1\n\tsyscall\n");
        } else {
            strb.append("\tlw $v0, ")
                    .append(expression.toMIPS())
                    .append("\tmove $a0, $v0\n")
                    .append("\tli $v0, 1\n")
                    .append("\tsyscall\n");
        }
        strb.append("\tla $a0, newligne\n\tli $v0, 4\n\tsyscall\n\n");
        return strb.toString();
    }
    }
