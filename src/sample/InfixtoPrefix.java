package sample;

import java.util.Stack;

@SuppressWarnings("Duplicates")

class InfixtoPrefix {

// odwracanie

    public static String odwroc(String inp) {
        String input = inp;
        String odwroconyNawiasy = "";
        char arr[];

        // getBytes() metoda konwersji ciągu
        // into bytes[].
        byte[] strAsByteArray = input.getBytes();

        byte[] result =
                new byte[strAsByteArray.length];

        //  Zapisz wynik w odwrotnej kolejności do wyniku byte []

        for (int i = 0; i < strAsByteArray.length; i++) {
            result[i] =
                    strAsByteArray[strAsByteArray.length - i - 1];
        }
        String odwrocony = new String(result);

        // odwróć nawiasy

        for (int i = 0; i < odwrocony.length(); i++) {
            char c = odwrocony.charAt(i);
            if (odwrocony.charAt(i) == '(')
                c = ')';
            if (odwrocony.charAt(i) == ')')
                c = '(';

            odwroconyNawiasy = odwroconyNawiasy + Character.toString(c);
        }

        return odwroconyNawiasy;
    }

// odwracanie

    // Funkcja  zwracająca pierwszeństwo danego operatora
    // Wyższa zwrócona wartość oznacza wyższy priorytet

    static int Priorytet(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
            case '&': //pierwiastek
                return 3;

            case '@': //sin
            case '#': //cos
            case '$': //tg
            case '%': //ctg
            case '!':
                return 4;

        }
        return -1;
    }

    //Główna metoda konwertująca wyrażenie infix

    static String infixToPrefix(String exp) {

        //inicjowanie pustego ciągu dla wyniku

        String wynik = new String("");

        // odwroc ciąg infix

        // inicjowanie pustego stosu
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);


            // Jeśli zeskanowany znak jest operandem, dodaj go do wyjścia.

            if (Character.isLetterOrDigit(c))
                wynik += c;

                // Jeśli zeskanowana postać to '(', połóż ją na stos.

            else if (c == '(')
                stack.push(c);

                // Jeśli zeskanowany znak to ')', wyrzuć ze stosu na wyjście
                // aż do napotkania '('.

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    wynik += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Nieprawidłowe wyrażenie"; // Nieprawidłowe wyrażenie
                else
                    stack.pop();
            } else // napotkany operator
            {
                while (!stack.isEmpty() && Priorytet(c) <= Priorytet(stack.peek()))
                    wynik += stack.pop();
                stack.push(c);
            }

        }

        //
        //wyrzuć wszystko ze stosu

        while (!stack.isEmpty())
            wynik += stack.pop();

        return wynik;

        //odwroc wynik
    }
}
