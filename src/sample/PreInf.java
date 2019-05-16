package sample;

import java.util.Stack;

@SuppressWarnings("Duplicates")

public class PreInf {

    String wypisz2 = null;

    String prefixinfix(String exp2) {

        exp2 = exp2.replace(" ", "");
        exp2 = exp2.replace("(", "");
        exp2 = exp2.replace(")", "");
        int x = exp2.length();

        Stack<String> values = new Stack<String>();
        char[] expArr = exp2.toCharArray();

        for (int i = exp2.length() - 1; i >= 0; i--) {
            if (expArr[i] == ' ') {
                continue;
            } else if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/'
                    || expArr[i] == '*' || expArr[i] == '^') {
                StringBuffer buf = new StringBuffer("");
                String a = values.pop(), b = values.pop();
                buf.append("(" + a + expArr[i] + b + ")");
                values.push(buf.toString());
            } else {
                values.push(String.valueOf(expArr[i]));
            }
        }

        String k = values.pop();
        String k2=k.replace("(","");
        k2=k2.replace(")","");

        if (k2.length() == x)
            wypisz2 = k;
        else
            wypisz2 = "niepoprawne wyrazenie w->Input Prefix";

        return wypisz2;


    }

}
