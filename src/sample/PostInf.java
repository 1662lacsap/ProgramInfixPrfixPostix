package sample;

import java.util.Stack;
import java.util.*;

@SuppressWarnings("Duplicates")


public class PostInf {


    String wypisz3 = null;

    String postfixinfix(String exp3) {

        exp3 = exp3.replace(" ", "");
        exp3 = exp3.replace("(", "");
        exp3 = exp3.replace(")", "");
        int x = exp3.length();

    Stack<String> values = new Stack<String>();

    char[] expArr = exp3.toCharArray();

    for(int i = 0; i<expArr.length;i++)

    {

        if (expArr[i] == ' ') {
            continue;
        } else if (expArr[i] == '+' || expArr[i] == '-' || expArr[i] == '/'
                || expArr[i] == '*' || expArr[i] == '^') {
            StringBuffer buf = new StringBuffer("");
            String b = values.pop(), a = values.pop();
            buf.append("(" + a + expArr[i] + b + ")");
            values.push(buf.toString());
        } else {
            values.push(String.valueOf(expArr[i]));
        }
    }

        String k = values.pop();
        String k3=k.replace("(","");
        k3=k3.replace(")","");

        if (k3.length() == x)
            wypisz3 = k;
        else
            wypisz3 = "niepoprawne wyrazenie w->Input Postfix";

        return wypisz3;

}


}
