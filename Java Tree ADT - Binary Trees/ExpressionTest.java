//
//  Name:       Casuga, Joshua
//  Project:    #4
//  Course:     cs-2400-01-f22
//
//  Description: The main method; creates a new expression tree, 
//  prints out the input postfix expression, the evaluation of that
//  postfix expression, and the postorder traversal
//
public class ExpressionTest {
    public static void main(String[] args) {
        System.out.println("Expression Tree by J. Casuga" + "\n");
        String[] postfix = args[0].split(" ");
        ExpressionTree expressionTree = new ExpressionTree(postfix);

        String str = "";
        for (int i = 0; i < args.length; i++) {
            str = str + args[i] + " ";
        }
        System.out.println("Input: " + str);

        System.out.println("Value: " + expressionTree.evaluate() + "\n");
        System.out.println("Postorder Traversal:");
        expressionTree.postorder();
    }
}