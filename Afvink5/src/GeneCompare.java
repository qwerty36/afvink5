
import java.util.*;

/**
 * Created by Stan on 11-12-2015.
 */
public class GeneCompare {

    public static void main(String[] args) {

        GUI gui = new GUI();

    }

    //Vult de hashsets op basis van de input gegeven in de 3 input velden.
    public static HashSet[] fillhash(GUI gui) {

        HashSet<String> hs1 = new HashSet<String>();
        HashSet<String> hs2 = new HashSet<String>();
        HashSet<String> hs3 = new HashSet<String>();

        for (String c : gui.txt1.getText().split("\n")) {
            hs1.add(c);
        }
        for (String c : gui.txt2.getText().split("\n")) {
            hs2.add(c);
        }
        for (String c : gui.txt3.getText().split("\n")) {
            hs3.add(c);
        }

        HashSet[] hsCollection = new HashSet[3];
        hsCollection[0] = hs1;
        hsCollection[1] = hs2;
        hsCollection[2] = hs3;
        return hsCollection;

    }

    //Vergelijkt de invoer van alle 3 de velden.
    public static HashSet compareAll(HashSet[] hsCollection) {
        HashSet<String> overeenkomst = new HashSet<String>();
        if (bepaalGrootste(hsCollection) == 1) {
            Iterator iterator = hsCollection[0].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[1].contains(iteratorItem) && hsCollection[2].contains(iteratorItem)) {
                    overeenkomst.add(iteratorItem);
                }
            }
        } else if (bepaalGrootste(hsCollection) == 2) {
            Iterator iterator = hsCollection[1].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[0].contains(iteratorItem) && hsCollection[2].contains(iteratorItem)) {
                    overeenkomst.add(iteratorItem);
                }
            }
        } else {
            Iterator iterator = hsCollection[2].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[0].contains(iteratorItem) && hsCollection[1].contains(iteratorItem)) {
                    overeenkomst.add(iteratorItem);
                }
            }
        }
        return overeenkomst;

    }

    //Vergelijkt de invoer van veld 1 met die van veld 2.
    public static HashSet compare1To2(HashSet[] hsCollection) {
        HashSet<String> results = new HashSet<String>();
        if (hsCollection[0].size() < hsCollection[1].size()) {
            Iterator iterator = hsCollection[0].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[1].contains(iteratorItem)) {
                    results.add(iteratorItem);
                }
            }
            return results;
        } else {
            Iterator iterator = hsCollection[1].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[0].contains(iteratorItem)) {
                    results.add(iteratorItem);
                }
            }
            return results;
        }
    }

    //Vergelijkt de invoer van veld 1 met die van veld 3.
    public static HashSet compare1To3(HashSet[] hsCollection) {
        HashSet<String> results = new HashSet<String>();
        if (hsCollection[0].size() < hsCollection[2].size()) {
            Iterator iterator = hsCollection[0].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[2].contains(iteratorItem)) {
                    results.add(iteratorItem);
                }
            }
            return results;
        } else {
            Iterator iterator = hsCollection[2].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[0].contains(iteratorItem)) {
                    results.add(iteratorItem);
                }
            }
            return results;
        }
    }

    //Vergelijkt de invoer van veld 2 met die van veld 3.
    public static HashSet compare2To3(HashSet[] hsCollection) {
        HashSet<String> results = new HashSet<String>();
        if (hsCollection[1].size() < hsCollection[2].size()) {
            Iterator iterator = hsCollection[1].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[2].contains(iteratorItem)) {
                    results.add(iteratorItem);
                }
            }

            return results;
        } else {
            Iterator iterator = hsCollection[2].iterator();
            while (iterator.hasNext()) {
                String iteratorItem = (String) iterator.next();
                if (hsCollection[1].contains(iteratorItem)) {
                    results.add(iteratorItem);
                }
            }

            return results;

        }
    }

    //Bepaalt de grootste HashSet.
    public static int bepaalGrootste(HashSet[] hsCollection) {
        if (hsCollection[0].size() >= hsCollection[1].size() && hsCollection[0].size() >= hsCollection[2].size()) {
            return 1;
        } else if (hsCollection[1].size() >= hsCollection[0].size() && hsCollection[1].size() >= hsCollection[2].size()) {
            return 2;
        } else {
            return 3;
        }
    }
}
