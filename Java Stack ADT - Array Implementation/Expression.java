//
//  Name:       Casuga, Joshua
//  Project:    #3
//  Due:        10/21/2022
//  Course:     cs-2400-01-f22
//
//  Description:
//              Implements the convertToPostfix and evaluatePostfix methods using a method-defined precedence
//              for operators and a method definition for numeric characters in an array of strings.
//
import java.util.*;

public class Expression
{
    /**
     *  Returns the precedence for different operators. Operators with higher precedence return higher values.
     * @param c A string of an operator in the infix expression array
     * @return Return a value based on the precedence of the operator
     */
    private static int precedence(String c)
    {
        switch(c){
            case"+":
            case"-":
                return 1;
            case"*":
            case"/":
                return 2;
            case"^":
                return 3;
        }
        return -1;
    }

    /**
     * Checks if a character in the infix expression array is numeric.
     * @param str is a character in the infix expression array
     * @return Returns true if the character in the infix expression array is numeric, false if not
     */
    public static boolean isNumeric(String str)
    {
        try{
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Converts an infix expression to a postfix expression
     * @param infixExpression An array of strings containing the infix expression
     * @return Returns a postfix expression if successful, returns a RuntimeException if unsuccessful
     */
    public static String[] convertToPostfix(String[] infixExpression)
    {
        try
        {
            StackInterface<String> operatorStack = new ArrayStack<>();
            ArrayList<String> result = new ArrayList<>();
            String topOperator;
            for(int i=0; i<infixExpression.length; i++)
            {
                String nextCharacter = infixExpression[i];
                switch(nextCharacter)
                {
                    case "^":
                        operatorStack.push(nextCharacter);
                        break;
                    case"+": case"-": case"*": case"x": case"/":
                    while(!operatorStack.isEmpty() && precedence(nextCharacter) <= precedence(operatorStack.peek()))
                    {
                        result.add(operatorStack.peek());
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    operatorStack.pop();
                    case "(":
                        operatorStack.push(nextCharacter);
                        break;
                    case ")":
                        topOperator = operatorStack.pop();
                        while(!topOperator.equals("("))
                        {
                            result.add(topOperator);
                            topOperator = operatorStack.pop();
                        }
                        break;
                    default:
                        if(isNumeric(nextCharacter))
                        {
                            result.add(nextCharacter);
                        }
                        break;
                }
            }
            while (!operatorStack.isEmpty())
            {
                topOperator = operatorStack.pop();
                if(topOperator.equals("("))
                {
                    throw new RuntimeException("Infix expression is not well-formed or not a number literal.");
                }
                else
                {
                    result.add(topOperator);
                }
            }

            /** Prints out postfix expression
             *
            for(int i = 0; i<result.size();i++)
            {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            */

            String[] postfix = result.toArray(new String[result.size()]);
            return postfix;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Infix expression is not well-formed or not a number literal.");
        }

    }

    /**
     * Evaluates a postfix expression
     * @param postfixExpression An array of strings containing the postfix expression
     * @return Returns the result of the expression
     */
    public static double evaluatePostfix(String[] postfixExpression)
    {
        StackInterface<Double> valueStack = new ArrayStack<>();
        double operandTwo, operandOne;
        double result;
        for(int i=0; i<postfixExpression.length; i++)
        {
            String nextCharacter = postfixExpression[i];
            switch(nextCharacter)
            {
                case "+":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne + operandTwo;
                    valueStack.push(result);
                    break;
                case "-":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne - operandTwo;
                    valueStack.push(result);
                    break;
                case "x":
                case "*":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne * operandTwo;
                    valueStack.push(result);
                    break;
                case "/":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne/operandTwo;
                    valueStack.push(result);
                    break;
                case "^":
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = Math.pow(operandOne, operandTwo);
                    valueStack.push(result);
                    break;
                default: if(isNumeric(nextCharacter))
                {
                    valueStack.push(Double.parseDouble(nextCharacter));
                    break;
                }
            }
        }
        return valueStack.peek();
    }
}
