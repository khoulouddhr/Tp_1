package pres;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args){
        /*
        injection des dependances par instanciation =>new
         */
        DaoImpl2 dao=new DaoImpl2();/* Couplage fort*/
        MetierImpl metier=new MetierImpl();
        metier.setDao(dao);
        System.out.println("Résultat="+metier.calcul() );


    }
}
