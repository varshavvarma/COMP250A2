package assignment2;

public class TargetQueue extends MyQueue<Position>{
    private MyStack<String> stack;
    public TargetQueue() {
        super();
        stack = new MyStack<>();
    }

    public void clear() {
        super.clear();
    }

    public void addTargets(String s) {
        String num = "";
        MyStack<String> check = new MyStack<String>();
        int bracket = 0;
        if (!(s instanceof String)) {
            throw new IllegalArgumentException("You must add a target of type String.");
        }
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==',') {
                try {
                    stack.push(num);
                } catch (IllegalAccessError e) {
                    throw new IllegalArgumentException("The input string has an error.");
                }
                stack.push(",");
                num = "";
            } else if (s.charAt(i)==')') {
                if (num == "") {
                    throw new IllegalArgumentException("The input string has an error.");
                }
                if (stack.pop() == ",") {
                    try {
                        int x = Integer.parseInt(stack.pop());
                        if (stack.pop()=="(") {
                            int y = Integer.parseInt(num);
                            Position p = new Position(x,y);
                            this.enqueue(p);
                        }
                    } catch (IllegalAccessError e) {
                        throw new IllegalArgumentException("The input string has an error.");
                    }
                }

                num = "";
                stack.clear();
                check.clear();
                bracket--;
                if (i != s.length()-1) {
                    if (s.charAt(i+1) != '.') {
                        throw new IllegalArgumentException("The input string has an error.");
                    }
                }
            } else if (s.charAt(i) == '(') {
                stack.push("(");
                bracket++;
            } else if (s.charAt(i) == '.') {
                if (!stack.isEmpty() || num != "") {
                    throw new IllegalArgumentException("There is an error.");
                }
            } else {
                try {
                    int x = Integer.parseInt("" + s.charAt(i));
                    num += s.charAt(i);
                } catch (IllegalArgumentException e) {}
            }
        }
    }
}

