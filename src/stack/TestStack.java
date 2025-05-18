package stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);
        System.out.println(test.size());
        test.display();
    }
    
}
