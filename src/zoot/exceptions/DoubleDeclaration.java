package zoot.exceptions;
/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public class DoubleDeclaration extends AnalyseSemantiqueException{
    public DoubleDeclaration(String m , int nbligne) {
        super("ligne : "+nbligne+" double declaration des variables : " + m);
    }
}