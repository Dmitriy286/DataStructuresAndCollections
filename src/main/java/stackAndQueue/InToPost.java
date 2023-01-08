package stackAndQueue;

public class InToPost {
    private CharStack stack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        this.input = in;
        int stackSize = input.length();
        this.stack = new CharStack(stackSize);
    }

    //преобразование в постфиксную форму
    public String doTransformation() {
        for (int i = 0; i < this.input.length(); i++) {
            char ch = input.charAt(i);
            stack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    getOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    getOperator(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    getParenthesis(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }

        while (!stack.isEmpty()) {
            stack.displayStack("While ");
            output = output + stack.pop();
        }
        stack.displayStack("End ");
        return output;
    }

    public void getOperator(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }
        }
        stack.push(opThis);
    }

    public void getParenthesis(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }
    }
}
