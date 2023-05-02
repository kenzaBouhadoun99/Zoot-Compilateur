package zoot.exceptions;
/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public class AnalyseSyntaxiqueException extends AnalyseException {
 
    public AnalyseSyntaxiqueException(String m) {
        super("ERREUR SYNTAXIQUE :\n\t" + m) ;
    }

}
