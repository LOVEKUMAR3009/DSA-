package array;

public class hello {
  public void m1(){
    System.out.println("h1");
  }
  public void m2(){
    System.out.println("h2");
    m1();
  }
}
class  test10 extends hello {
public void m1(){
  System.out.println("t1");
}
public static void main(String[] args) {
  test10 t = new test10();
  t.m2();
  hello h1  =new hello();
  h1.m2();
}
}
