import java.util.LinkedList;

public class LL_Collection_framework {
    public static void main(String[] args) {
        LinkedList<String> obj1=new LinkedList<String>();
        obj1.add("Azan");obj1.add("ali");
        obj1.add("umer");obj1.add("bilal");

        obj1.addFirst("Haider");
        obj1.addLast("Hina");

        obj1.add(1,"Azan");

       
        for(int i=0;i<obj1.size();i++){
            System.out.println(obj1.get(i));
        }
    }
}
