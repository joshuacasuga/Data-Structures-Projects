import java.util.Arrays;

//
//  Name:       Casuga, Joshua
//  Project:    #3
//  Due:        10/21/2022
//  Course:     cs-2400-01-f22
//
//  Description:
//              The main application that prints out the answer to any given infix expression.
//
public class ExpressionTest {

    public static void main(String[] args)
    {
        for(int i=0; i<args.length; i++)
        {
            if(args[i].equals("x"))
            {
                args[i] = "*";
            }
        }

        String[] postfixExpression = Expression.convertToPostfix(args[0].split(" "));
        System.out.println(Expression.evaluatePostfix(postfixExpression));
    }
}
