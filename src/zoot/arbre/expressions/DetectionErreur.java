package zoot.arbre.expressions;

public class DetectionErreur {

    private final String message;
    private final int ligne;

    public DetectionErreur(String msg, int ligne) {
        this.message = msg;
        this.ligne = ligne;
    }

    public String getMessage() {
        return message;
    }

    public int getLigne() {
        return ligne;
    }
}
