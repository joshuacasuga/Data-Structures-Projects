//
//  Name:       Casuga, Joshua
//  Project:    #4
//  Course:     cs-2400-01-f22
//
//  Description: The implementation for an expression tree. Includes
//  an expression tree constructor, postorder debug methods to confirm 
//  a correct postorder traversal of the expression tree, and other private
//  methods to assist the constructor and debug methods. Extends BinaryTree
//  and implements ExpressionTreeInterface
//
import java.util.Stack;

public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface {
    public ExpressionTree(String[] postfix) {
        Stack<BinaryTree<String>> et = new Stack<>();
        for (int i = 0; i < postfix.length; i++) {
            if (!isOperator(postfix[i])) {
                et.push(new BinaryTree<String>(postfix[i]));
            } else {
                BinaryTree<String> rhs = et.pop();
                BinaryTree<String> lhs = et.pop();
                et.push(new BinaryTree<String>(postfix[i], lhs, rhs));
            }
        }
        setRootNode(et.pop().getRootNode());
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(BinaryNode<String> node) {
        if (node != null) {
            postorder(node.getLeftChild());
            postorder(node.getRightChild());
            if (node.hasLeftChild() && node.hasRightChild()) {
                System.out.println(node.getLeftChild().getData() + " : "
                        + node.getData() + " : " + node.getRightChild().getData());
            } else {
                System.out.println(node.getData());
            }
        }
    }

    private static boolean isOperator(String str) {
        switch (str) {
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
            default:
                return false;
        }
    }

    public double evaluate() {
        return evaluate(getRootNode());
    }

    private double evaluate(BinaryNode<String> rootNode) {
        double result;
        if (rootNode == null)
            result = 0;
        else if (rootNode.isLeaf()) {
            String variable = rootNode.getData();
            result = getValueOf(variable);
        } else {
            double firstOperand = evaluate(rootNode.getLeftChild());
            double secondOperand = evaluate(rootNode.getRightChild());
            String operator = rootNode.getData();
            result = compute(operator, firstOperand, secondOperand);
        }
        return result;
    }

    private double getValueOf(String variable) {
        Double var = Double.valueOf(variable);
        return var;
    }

    private double compute(String operator, double firstOperand, double secondOperand) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
        }
        return result;
    }
}