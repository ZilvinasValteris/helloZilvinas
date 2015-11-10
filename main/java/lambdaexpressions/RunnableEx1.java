package lambdaexpressions;

/**
 * Created by zilvinas on 10/11/15.
 */
public class RunnableEx1 {

    static void show(){
        System.out.println("show defined in separate method");
    }

    public static void main(String[] args) {
        Runnable r1 = () -> show(); //System.out.println("show defined in lambda body");
        r1.run();

        Runnable r2 = RunnableEx1::show;
        r2.run();
    }
}
