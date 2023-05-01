package assignment2;

public class ActionQueue extends MyQueue<Direction> {
    MyStack<String> stack;
    public ActionQueue() {
        super();
        stack = new MyStack<String>();
    }

    public void clear() {
        super.clear();
    }

    private String decodedString(String message) {
        String num = "";
        String directions = "";
        String inBracket = "";
        int b;
        int i = 0;
        while (i<message.length()) {
            char c = message.charAt(i);
            if (c=='N' || c=='E' || c=='S' || c=='W') {
                directions += c;
            } else if (c=='[') {
                try {
                    int x = Integer.parseInt("" + message.charAt(i-1));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("The Directions inputted was not in proper format.");
                }
                b = 1;
                for (int j=i+1; j<message.length(); j++) {
                    if (message.charAt(j)=='[') {
                        b++;
                    } else if (message.charAt(j)==']') {
                        b--;
                    }
                    if (b==0) {
                        i++;
                        break;
                    }
                    inBracket += message.charAt(j);
                    i++;
                    if (j==message.length()-1 && b!=0) {
                        throw new IllegalArgumentException("The Directions inputted was not in proper format.");
                    }
                }
                String x = decodedString(inBracket);
                for (int k=0; k<Integer.parseInt(num); k++) {
                    directions+=x;
                }
                inBracket = "";
                num = "";
            } else {
                try {
                    int x = Integer.parseInt("" + c);
                    num += x;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("The Directions inputted is not proper.");
                }
            }

            i++;
        }
        return directions;
    }

    public void loadFromEncodedString(String message) {
        if (!(message instanceof String)) {
            throw new IllegalArgumentException("You must add a target of type String.");
        }
        String msg = decodedString(message);
        for (int m=0; m<msg.length(); m++) {
            char newC = msg.charAt(m);
            if (newC=='N') {
                this.enqueue(Direction.NORTH);
            } else if (newC=='S') {
                this.enqueue(Direction.SOUTH);
            } else if (newC=='E') {
                this.enqueue(Direction.EAST);
            } else if (newC=='W') {
                this.enqueue(Direction.WEST);
            }
        }
    }
}
