import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

public class GUI extends JFrame implements ActionListener {

    public static HashSet[] hsCollection;

    public JPanel panel1;
    public JButton btnCompare;
    public JComboBox cmbKeuze;
    public JTextArea txt1;
    public JTextArea txt2;
    public JTextArea txt3;
    public JTextArea txtOutput;
    public JScrollPane pane1;
    public JScrollPane pane2;
    public JScrollPane pane3;
    public JScrollPane paneOutput;


    public GUI() {

        add(panel1);

        btnCompare.addActionListener(this);
        vulComboBox();

        setVisible(true);
        pack();

    }

    private void vulComboBox() {

        cmbKeuze.addItem("Overeenkomst 1 & 2 & 3");
        cmbKeuze.addItem("Overeenkomst 1 & 2");
        cmbKeuze.addItem("Overeenkomst 1 & 3");
        cmbKeuze.addItem("Overeenkomst 2 & 3");

    }

    //Bepaalt op basis van de geselecteerde waarde van de combobox welke vergelijking uitgevoerd moet worden.
    private void bepaalMethode() {

        HashSet<String> results;

        if (cmbKeuze.getSelectedItem().equals("Overeenkomst 1 & 2 & 3")) {

            results = GeneCompare.compareAll(hsCollection);
            showResultsAll(results);

        }

        else if (cmbKeuze.getSelectedItem().equals("Overeenkomst 1 & 2")) {

            results = GeneCompare.compare1To2(hsCollection);
            showResults1To2(results);

        }

        else if (cmbKeuze.getSelectedItem().equals("Overeenkomst 1 & 3")) {

            results = GeneCompare.compare1To3(hsCollection);
            showResults1To3(results);

        }

        else if (cmbKeuze.getSelectedItem().equals("Overeenkomst 2 & 3")) {

            results = GeneCompare.compare2To3(hsCollection);
            showResults2To3(results);

        }
    }

    //Schrijft de resultaten van de vergelijking van alle velden naar het output veld.
    private void showResultsAll(HashSet<String> results) {

        txtOutput.setText("Overeenkomst tussen alle velden:\n");

        Iterator iterator = results.iterator();

        while (iterator.hasNext()) {

            txtOutput.append(iterator.next() + "\n");

        }
    }

    //Schrijft de resultaten van de vergelijking van veld 1 met veld 2 naar het output veld.
    private void showResults1To2(HashSet<String> results) {

        txtOutput.setText("Overeenkomst tussen 1 & 2:\n");

        Iterator iterator = results.iterator();

        while (iterator.hasNext()) {

            txtOutput.append(iterator.next() + "\n");

        }
    }

    //Schrijft de resultaten van de vergelijking van veld 1 met veld 3 naar het output veld.
    private void showResults1To3(HashSet<String> results) {

        txtOutput.setText("Overeenkomst tussen 1 & 3:\n");

        Iterator iterator = results.iterator();

        while (iterator.hasNext()) {

            txtOutput.append(iterator.next() + "\n");

        }
    }

    //Schrijft de resultaten van de vergelijking van veld 2 met veld 3 naar het output veld.
    private void showResults2To3(HashSet<String> results) {

        txtOutput.setText("Overeenkomst tussen 2 & 3:\n");

        Iterator iterator = results.iterator();

        while (iterator.hasNext()) {

            txtOutput.append(iterator.next() + "\n");

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        hsCollection = GeneCompare.fillhash(this);
        bepaalMethode();

    }
}
