package Implementations;
import java.util.Stack;

public class Stack_Collection_framwork {
    
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(22);
        s.push(29);
        s.push(39);
        s.push(49);

        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());    
        System.out.println(s.pop());
        System.out.println(s.isEmpty());    
    }
}
