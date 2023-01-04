package stackAndQueue;

public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        CharStack stack = new CharStack(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chInStack = stack.pop();
                        if ((ch == '}' && chInStack != '{') ||
                        (ch == ']' && chInStack != '[') ||
                        (ch == ')' && chInStack != '(')) {
                            System.out.println("First Error: " + ch + " at " + i);
                        }
                    }
                    else {
                        System.out.println("Second Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Third Error: missing right delimiter");
        }
    }
}
