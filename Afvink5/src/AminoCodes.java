import java.util.*;

/**
 * Created by Stan on 13-12-2015.
 */
public class AminoCodes {

    private static HashMap<String, String> aminos = new HashMap<String, String>();
    private static String code;

    public static void main(String[] args) {

        vulHashMap();
        code = vraagAmino();
        geefComplement(code);

    }

    //Vult de HashMap met 3 lettercode : 1 lettercode.
    private static void vulHashMap() {

        aminos.put("ala", "a");
        aminos.put("arg", "r");
        aminos.put("asn", "n");
        aminos.put("asp", "d");
        aminos.put("cys", "c");
        aminos.put("gln", "q");
        aminos.put("glu", "e");
        aminos.put("gly", "g");
        aminos.put("his", "h");
        aminos.put("ile", "i");
        aminos.put("leu", "l");
        aminos.put("lys", "k");
        aminos.put("met", "m");
        aminos.put("phe", "f");
        aminos.put("pro", "p");
        aminos.put("ser", "s");
        aminos.put("thr", "t");
        aminos.put("trp", "w");
        aminos.put("tyr", "y");
        aminos.put("val", "v");

    }

    //Vraagt de gebruiker om invoer van een 1 of 3 letterige code.
    private static String vraagAmino() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer een 1- of 3 letterige code in");

        return scanner.next();

    }

    //Bepaald of de invoer een 1 of 3 lettercode is en roept op basis daarvan de juiste methode aan.
    private static void geefComplement(String code) {

        if (code.length() == 1) {

            zoek3LetterigeComplement(code);

        }

        else if (code.length() == 3) {

            zoek1LetterigeComplement(code);

        }

        else {

            System.out.println("No way José, wel een AA-sequentie invoeren!\n");
            String code2 = vraagAmino();
            geefComplement(code2);

        }
    }

    //Zoekt naar het 3 letterige complement van een 1 letterige code.
    private static void zoek3LetterigeComplement(String code) {

        Boolean flag = false;

        Set set = aminos.entrySet();

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {

            Map.Entry me = (Map.Entry) iterator.next();

            if (me.getValue().equals(code)) {

                System.out.println("3 Letterig complement: " + me.getKey());
                flag = true;

            }
        }

        if (flag == false) {

            System.out.println("Voer een geldige code in.\n");
            String code2 = vraagAmino();
            geefComplement(code2);

        }
    }

    //Zoekt naar het 1 letterige complement van een 3 letterige code.
    private static void zoek1LetterigeComplement(String code) {

        if (aminos.containsKey(code)) {

            System.out.println("1 Letterig complement: " + aminos.get(code));

        }

        else {

            System.out.println("Voer een geldige code in.\n");
            String code2 = vraagAmino();
            geefComplement(code2);

        }
    }
}
