package Implementations;
import java.util.ArrayList;

class StackArrayList{
    ArrayList<Integer> list=new ArrayList<>();
    public Boolean isEmpty(){
      return list.size()==0;
    }

    public void push(int data){
      list.add(data);
    }

    public  int pop(){
    if(isEmpty()) {
        System.out.println("No data Present in stack");
        return -1;
    }
    int top=list.get(list.size()-1);
    list.remove(list.size()-1);
    return top;
    }

   public int peek(){
    if(isEmpty()) {
        System.out.println("No data Present in stack");
        return -1;
    }
    return list.get(list.size()-1);
    }
   
}
public class StackImplementationUsingArrayList {
public static void main(String[] args) {
      StackArrayList obj=new StackArrayList();
      obj.push(22); 
      obj.push(23); 
      obj.push(24); 
      obj.push(25);
      System.out.println(obj.peek());
      System.out.println(obj.pop());
      System.out.println(obj.peek()); 
}    
}
