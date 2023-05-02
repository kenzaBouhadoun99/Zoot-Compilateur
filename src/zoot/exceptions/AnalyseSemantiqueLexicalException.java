package zoot.exceptions;

public class AnalyseSemantiqueLexicalException extends AnalyseException {

    public AnalyseSemantiqueLexicalException(String m) {
        super("ERREUR SEMANTIQUE LEXICALE : " + m);
    }

}
