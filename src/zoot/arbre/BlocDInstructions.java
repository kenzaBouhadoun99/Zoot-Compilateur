package zoot.arbre;

import zoot.arbre.expressions.ListeErreursDetecter;
import zoot.arbre.tableDeSymboles.ListeFonctions;
import zoot.arbre.tableDeSymboles.TDS;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {

    protected ArrayList<ArbreAbstrait> prog ;

    public BlocDInstructions(int n) {
        super(n) ;
        prog = new ArrayList<>() ;
    }

    public void ajouter(ArbreAbstrait arbre) {
        prog.add(arbre) ;
    }

    @Override
    public void verifier() {
        for(ArbreAbstrait arbre :prog){
            arbre.verifier();
        }
    }

    /**
     * methode qui genere  le code mips de programme principale
     * @return
     */
    @Override
    public String toMIPS() {
        StringBuilder str = new StringBuilder();
        str.append("#Lahlou Ghalia  & Bouhadoun Kenza \n\n");

        str.append("   #   ********** Init data *********** \n");

        str.append(".data\n\n");
        str.append("vrai: .word 1\n");
        str.append("faux: .word 0\n");
        str.append("print_V: .asciiz \"vrai\"\n");
        str.append("print_F: .asciiz \"faux\"\n");
        str.append("erreur: .asciiz \"erreur\"\n");
        str.append("newligne: .asciiz \"\\n\"\n\n");
        str.append(".text\n\n");
        ListeFonctions listefonctions = ListeFonctions.getInstance();
        if(listefonctions.getCompteur() == 0){
           // listefonctions.getFonctions().get(0).toMIPS();
            listefonctions.setCompteur(listefonctions.getCompteur()+1);
        }
        str.append("main: \n");
        str.append("   #   ********** Init variables *********** \n");
        str.append("\tmove $s7, $sp\n");
        str.append("\taddi $sp, $sp, ").append(TDS.getInstance().getTailleZoneVariable()).append("\n\n");
        str.append("\tla $s1, faux\n\n");
        str.append("   # ***  Debut du programme ***\n\n");
        for (ArbreAbstrait a : prog) {
            if (ListeErreursDetecter.getInstance().getNbErreurs() != 0 && ListeErreursDetecter.getInstance().getErreur(0).getLigne() == a.getNoLigne()) {
                str.append("#Affichage de l'erreur\n");
                str.append("\tla $a0, erreur\n");
                str.append("\tli $v0, 4\n");
                str.append("\tsyscall\n");
                str.append("\tfin\n\n");
            }
            str.append(a.toMIPS());
        }
        str.append("   #  *** Fin du programme ***\n fin: \n\tli $v0, 10\n\tsyscall");
        return str.toString();
    }

    @Override
    public String toString() {
        return prog.toString() ;
    }

}
