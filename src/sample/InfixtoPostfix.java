package sample;

import java.util.Stack;

@SuppressWarnings("Duplicates")

class InfixtoPostfix {

    // Funkcja zwracająca pierwszeństwo danego operatora
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

    //Główna metoda konwertująca dane wyrażenie infix

    //push - umieszcza element na stosie
    //pop - zdejmuje element ze szczytu stosu

    static String infixToPostfix(String exp) {

      //inicjowanie pustego ciągu dla wyniku

        String wynik = new String("");

        // inicjowanie pustego stosu
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // Jeśli zeskanowany znak jest operandem, dodaj go do wyjścia.

            if (Character.isLetterOrDigit(c))
                wynik += c;

            // Jeśli zeskanowana postać to '(', połóż na stos.
            else if (c == '(')
                stack.push(c);

            // Jeśli zeskanowany znak to ')', usuń ze stosu aż do napotkania '('.

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

        //wyrzuć wszystkie operatory ze stosu
        while (!stack.isEmpty())
            wynik += stack.pop();

        return wynik;
    }
}


/*

Klasa Stack to podklasa klasy Vector, która implementuje tradycyjny stos, czyli
strukture typu LIFO (ostatni wszedł pierwszy wychodzi). Klasa definiuje jedynie domyślny
konstruktor tworzący pusty stos.

Deklaracja: Stack <E> - E określa typ obektów przechowywanych na stosie.

boolean empty () - zwraca true, jeśli stos jest pusty, lub false jeśli stos zawiera elementy
E peek () - zwraca element ze szczytu stosu, ale go nie usuwa
E pop() - Zwraca i jednoczesnie usuwa element ze szczytu stosu
E push ( E element) - umieszcza element na szczycie stosu. Dodatkowo zwraca element.
int search (Object element) - poszukuje element na stosie. Jesli zostanie znaleziony, zwraca jego
przesunięcie względem szczytu stosu. Liczbe operacji pop() które trzeba wykonać, by umieścić ten element na stosie.
W przeciwnym wypadku zwraca -1.


Wyjątek EmptyStackException - przy próbie pobrania obiektu z pustego stosu.




 */