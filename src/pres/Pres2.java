package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(new File("config.txt"));

        /* Instanciation dynamique parcequ'on ne connait pas la classe qui va etre instanciée */
        String doaClassName=scanner.nextLine();
        Class cDAO=Class.forName(doaClassName); /*forname cherche si une classe donné en parametre existe */
        IDao dao=(IDao) cDAO.newInstance();/* fait appel au constructeur sans parametres*/

        String metierClassName= scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) /* un cast */ cMetier.newInstance();

        /* get et set ne sont pas des methodes fonctionnelles*/
        /* On cree des interfaces seulement au classes avec des methodes foncttionnelles (traitement)*/


        /* creer un objet dynamique pour appeler la methode set */
        Method method=cMetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao); //appel de la methode set dynamique;

        System.out.println("Résultat=>" +metier.calcul());



    }
}
