package zoot.exceptions;
/**
 * @author Lahlou Ghalia & Bouhadoun Kenza
 */

public class VariablenonDecalrees extends AnalyseSemantiqueException{

    public VariablenonDecalrees(String str) {
        super("Variable non declaree : " + str);
    }}
