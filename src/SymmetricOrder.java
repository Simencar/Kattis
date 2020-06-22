import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricOrder {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        boolean queueNow = true;
        int n;
        int setCount = 1;

        while ((n = io.getInt()) != 0) {
            for (int i = 0; i < n; i++) {
                if (queueNow) {
                    queue.add(io.getWord());
                    queueNow = false;
                }
                else {
                    stack.push(io.getWord());
                    queueNow = true;
                }
            }
            io.println("SET " +setCount);
            while (!queue.isEmpty()) {
                io.println(queue.poll());
            }
            while (!stack.isEmpty()) {
                io.println(stack.pop());
            }
            setCount++;
            queueNow = true;
        }
        io.close();
    }

}
