package sample;


public class InfixToPostfixAlgorytm {


    public String infixToPostfixZamiana(String exp)

    {
        int i;

        char temp;

        String output="";

        for(i=0; i<exp.length();i++)
        {

            temp=exp.charAt(i);

            if (Character.isLetterOrDigit(temp))

            {
                output += temp;

                System.out.println("Stała lub zmienna na wyjście:             " +output);


            }
            else if (temp == '(')

                push(temp);

            else if (temp ==')')

            {

                // dopóki stos nie jest pusty i szczyt stosu jest rózny od '('
                while(!isEmpty()&& stackTop()!='(')

                {

                    output+=pop();

                }

                if(isEmpty())
                    return "niepoprawne wyrażenie";
                else
                    pop();
            }
            else{ //gdy napotkano operator
                while(!isEmpty()&&(pierszenstwo(temp)<= pierszenstwo(stackTop())))

                {
                    output+=pop();

                }
                push(temp);
            }
        }
        while (!isEmpty())

            output +=pop();

        return output;

    }



    //pierszenstwo
    public int pierszenstwo (char c)
    {

        switch (c) {

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;

    }


    int top=-1;

    static final int MAX=1000;
    char[] stack=new char[MAX];


    // push połóż na stos

    public void push(char element) {
        if (top > MAX)
            System.out.println("Stos jest pełny");

        else

            stack[++top] = element;

        System.out.println("połóż na stos:                         " + element);
    }


    // pop zdejmij ze stosu

    public char pop() {

        if (!isEmpty()) {


            if (stack[top] == '(')

            { System.out.println("Zdejmij ze stosu nie dawaj na wyjście: " + stack[top]);
                return stack[top--];}

                else

            {System.out.println("Zdejmij ze stosu na wyjście:           " + stack[top]);
            return stack[top--];}
        }
        else {

            System.out.println("Stos jest pusty:");
            return 0;

        }
    }


    // czy stos jest pusty
    public boolean isEmpty() {

        if (top < 0) {

            System.out.println("Stos jest pusty");

            return true;
        } else
            return false;
    }


      // zwroc wierzcholek stosu

    public char stackTop() {

        return stack[top];

    }


}
