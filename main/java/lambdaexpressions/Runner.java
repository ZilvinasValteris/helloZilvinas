package lambdaexpressions;

/**
 * Created by zilvinas on 06/11/15.
 */
public class Runner {

    public void run(Executable executable){
        System.out.println("\n=======================================");
        System.out.println("Execute some code...");
        int value = executable.execute(12, 13);
        System.out.println("Returned value: " + value);
    }

    public void run(StringExecutable executable){
        System.out.println("\n=======================================");
        int value = executable.execute("String Executable");
        System.out.println("Returned value: " + value);
    }
}
