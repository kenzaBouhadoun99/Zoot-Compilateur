package zoot.arbre.instructions;
import zoot.arbre.expressions.Expression;

public class Retourne extends Instruction{

    private Expression exp;

    public Retourne(int i, Expression exp) {
        super(i);
        this.exp = exp;
    }

    @Override
    public void verifier() {
    }

    @Override
    public String toMIPS() {
        StringBuilder strb = new StringBuilder();
        strb.append("\tli, $v0, " + exp.toMIPS() + "\n");
        strb.append("\tjr $ra\n");
        return strb.toString();
    }
}