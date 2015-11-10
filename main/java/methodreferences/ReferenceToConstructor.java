//package methodreferences;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ReferenceToConstructor {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        List numbers = Arrays.asList(4, 9, 16, 25, 36);
//        List squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers,Double::new);
//        System.out.println("Square root of numbers = "+squaredNumbers);
//    }
//
//    private static List findSquareRoot(List list, Function<double,double> f){
//        List result = new ArrayList();
//        list.forEach(x -> result.add(f.apply(Math.sqrt(x))));
//        return result;
//    }
//}
