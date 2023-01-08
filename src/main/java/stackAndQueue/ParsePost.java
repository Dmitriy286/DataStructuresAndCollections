package stackAndQueue;

public class ParsePost {
    private IntStack stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
    }

    public int doParse() {
        stack = new IntStack(20);
        char ch;
        int i;
        int num1, num2, interAns;

        for (i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            stack.displayStack("" + ch + " ");
            if (ch >= '0' && ch <= '9') {
                stack.push((int)(ch - '0'));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                stack.push(interAns);
            }
        }
        interAns = stack.pop();
        return interAns;
    }
}
