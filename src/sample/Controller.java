package sample;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class Controller {

    //Input/Output
    @FXML
    private TextField TextFieldInputInfix1;

    @FXML
    private TextField TextFieldInputPrefix2;

    @FXML
    private TextField TextFieldInputPostfix3;

    @FXML
    private TextField TextFieldOutput1;

    @FXML
    private TextField TextFieldOutput2;

    @FXML
    private TextField TextFieldOutput3;

    @FXML
    private RadioButton PrefixInput1;

    @FXML
    private RadioButton PostfixInput1;

    @FXML
    private RadioButton InfixInput2;

    @FXML
    private RadioButton PostfixInput2;

    @FXML
    private RadioButton InfixInput3;

    @FXML
    private RadioButton PrefixInput3;


        // Pierwszy wiersz Input Infix

        @FXML
        public void onActionInfixInput1_1 () {

        //zmienna pobierana

        String exp1 = TextFieldInputInfix1.getText();

            // Infix Prefix 1

            // CO ROBIMY:

            // exp1 = InfixtoPrefix.odwroc(exp1) -> odwrocone wyrazenie
            // InfixtoPostfix.infixToPostfix(exp1)   -> liczymy postfix
            // InfixtoPrefix.odwroc(to co policzylismy wyżej) -> ponownie odwracamy

            if (PrefixInput1.isSelected() == true)

           {

            try{

                TextFieldOutput1.setText(InfixtoPrefix.odwroc(
                    InfixtoPostfix.infixToPostfix(InfixtoPrefix.odwroc(exp1))));

                          } catch (RuntimeException ex) {
             TextFieldOutput1.setText("niepoprawne wyrazenie w Input Infix");
                    }

        }
                // Infix Postfix

                else if (PostfixInput1.isSelected() == true)
            {

            try{
                TextFieldOutput1.setText(InfixtoPostfix.infixToPostfix(exp1));

                System.out.println("");
                System.out.println("Algorytm krok po kroku: ");
                System.out.println("");
                InfixToPostfixAlgorytm algorytm = new InfixToPostfixAlgorytm();
                String wypisz_algorytm =algorytm.infixToPostfixZamiana(exp1);
                System.out.println("");
                System.out.println("Wynik:                                 " +wypisz_algorytm);



            } catch (RuntimeException ex) {
                TextFieldOutput1.setText("niepoprawne wyrazenie w Input Infix");
            }

        }

    }

        // Pierwszy wiersz end


        // Drugi wiersz Input Prefix

        @FXML
        public void onActionPrefixInput2_1 () {

        //zmienna pobierana

        String exp2 = TextFieldInputPrefix2.getText();

        // prefix infix 2

            if (InfixInput2.isSelected() == true)

            {
                PreInf prei0 = new PreInf();

                try {

                    String ll = prei0.prefixinfix(exp2);

                    if (ll == "niepoprawne wyrazenie w->Input Prefix")

                        TextFieldOutput2.setText("niepoprawne wyrazenie w->Input Prefix");
                    else
                        ll = ll.replace(" ", "");
                    TextFieldOutput2.setText(ll);

                } catch (RuntimeException ex) {
                    TextFieldOutput2.setText("niepoprawne wyrazenie w Input Prefix");

                }

            }

        // prefix (infix - infix) postfix 2

        else if (PostfixInput2.isSelected() == true)

        {

            try{

            PreInf prei1 = new PreInf();

            if (prei1.prefixinfix(exp2)=="niepoprawne wyrazenie w->Input Prefix")

                TextFieldOutput2.setText("niepoprawne wyrazenie w Input Prefix");

            else



            TextFieldOutput2.setText(InfixtoPostfix.infixToPostfix(prei1.prefixinfix(exp2)));

        } catch (RuntimeException ex) {
                TextFieldOutput2.setText("niepoprawne wyrazenie w Input Prefix");

            }

        }

    }

        // Drugi wiersz end


        // Trzeci wiersz Input Postfix

        @FXML
        public void onActionPostfixInput3_1 () {

        //zmienna pobierana

        String exp3 = TextFieldInputPostfix3.getText();


        // Postfix Infix 3

            if (InfixInput3.isSelected() == true)

            {

                PostInf posi0 = new PostInf();

                try{

                    String ss = posi0.postfixinfix(exp3);

                    if (ss == "niepoprawne wyrazenie w->Input Postfix")

                        TextFieldOutput3.setText(ss);

                    else

                        ss = ss.replace(" ", "");

                    TextFieldOutput3.setText(ss);

                } catch (NullPointerException ex) {
                    TextFieldOutput3.setText("niepoprawne wyrazenie w Input Postfix");

                } catch (RuntimeException ex) {
                    TextFieldOutput3.setText("niepoprawne wyrazenie w Input Postfix");

                }

            }

        // Postfix (infix - infix) Prefix 3

        else if (PrefixInput3.isSelected() == true)

        {

            PostInf posi1 = new PostInf();

            try {

                String ii = posi1.postfixinfix(exp3);

                if (ii == "niepoprawne wyrazenie w->Input Postfix") {
                    TextFieldOutput3.setText("niepoprawne wyrazenie w->Input Postfix");

                } else

                TextFieldOutput3.setText(InfixtoPrefix.odwroc(
                        InfixtoPostfix.infixToPostfix(InfixtoPrefix.odwroc(ii))));

            } catch (NullPointerException ex) {
                TextFieldOutput3.setText("niepoprawne wyrazenie w Input Postfix");

            } catch (RuntimeException ex) {
                TextFieldOutput3.setText("niepoprawne wyrazenie w Input Postfix");

            }

        }


    }

        // Trzeci wiersz end

}