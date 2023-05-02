package zoot.exceptions;

/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public class AnalyseSemantiqueException extends AnalyseException{

    protected AnalyseSemantiqueException(String m) {
        super("Erreur de semantique :\n\t" + m);
    }
}