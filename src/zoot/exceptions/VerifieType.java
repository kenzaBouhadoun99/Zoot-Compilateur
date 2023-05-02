package zoot.exceptions;
/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public class VerifieType  extends AnalyseSemantiqueException{
    public VerifieType(String m) {
        super(" Type non compatible " +m);
    }
}
