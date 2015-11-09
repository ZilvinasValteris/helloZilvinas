package lambdaexpressions;

/**
 * Created by zilvinas on 06/11/15.
 */
public class App {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run(new Executable(){
            public int execute(int a, int b){
                System.out.println("Executed function of an anonymous class.");
                return 7 + a + b;
            }
        });

        System.out.println("\nLambda expression used:\n");

        runner.run((int a, int b) -> {
            System.out.println("Executed function of an anonymous class.");
            System.out.println("Second line of the function...");
            return 9 + a + b;
        });

        runner.run((int a, int b) -> {
            return 8 + a + b;
        });

        // Exactly equivalent to the above
        // You don't need squiggly brackets or "return" for a one line expression
        runner.run((a, b) -> 7 + a + b);

        // Normally you can miss out the type of the param since int's known/inferred from the interface
        // However, Java will get confused if you have two interfaces that have a method of the same name
        // implemented in one class by methods of same names (polymorphism), like run(Executable e) and run(StringExecutable e)
        // One interface has a method that accepts a string and the other interface has a method accepting an int
        // but Java won't know which one you mean if you don't specify the type in lambda expression.

        // runner.run((a) -> 12 + a);

        // Could even do this when you don't need to specify the type:
        // runner.run(a -> 12 + a);

    }
}
