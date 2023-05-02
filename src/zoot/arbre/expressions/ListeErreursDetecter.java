package zoot.arbre.expressions;

import java.util.ArrayList;

public class ListeErreursDetecter {
    private final ArrayList<DetectionErreur> erreurs;
    private static final ListeErreursDetecter INSTANCE = new ListeErreursDetecter();


    private ListeErreursDetecter() {
        this.erreurs = new ArrayList<>();
    }

    public static ListeErreursDetecter getInstance() {
        return INSTANCE;
    }

    public void ajouter(DetectionErreur e) {
        this.erreurs.add(e);
    }

    public int getNbErreurs() {
        return this.erreurs.size();
    }

    public DetectionErreur getErreur(int i) {
        return this.erreurs.get(i);
    }

    public ArrayList<DetectionErreur> getErreurs() {
        return erreurs;
    }
}
