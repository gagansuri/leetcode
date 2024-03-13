import java.util.ArrayDeque;
import java.util.Deque;

public class DequeImpl {
    public static void main(String[] args) {
       MyStack stack = new MyStack();
        System.out.println(stack.pop());
    }


    static class MyStack{
        private Deque<Character> deque;
        public MyStack(){
            deque = new ArrayDeque<>();
        }

        public Character pop() {
            return deque.getLast();
        }

        public void push(Character c) {
            deque.addFirst(c);
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

    }
}
