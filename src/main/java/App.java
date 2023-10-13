import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    // Memoization storage for t(i) values
   // private static Map<Integer, Double> memoization = new HashMap<>();

    // Recursive method with memoization to calculate t(n)
//    public static Double calculateT(int n) {
//        // Base cases
//        if (n == 0 || n == 1) {
//            return 0.0;
//        }
//
//        // Check if t(n) is already computed and stored in the memoization map
//        if (memoization.containsKey(n)) {
//            return memoization.get(n);
//        }
//
//        // Calculate the sum using recursion
//        double sum = 0;
//        for (int i = 2; i < n; i++) {
//            sum += calculateT(i);
//        }
//
//        // Calculate t(n) using the equation
//        double result = n - 1 + (2.0/n) * sum;
//
//        // Store the computed result in the memoization map
//        memoization.put(n, result);
//
//        return result;
  //  }
    public static void main(String[] args) throws IOException {

        // Testing model.Foo
//        Foo foo = new Foo();
//        foo.displayInnerClasses();

        //display refactoring
        RefactorTest refactorTest = new RefactorTest();
        refactorTest.start();

        // Calculate and print t(n) for n = 0 to 10 as an example
//        int i = 120000;
//        for (int n = 110000; n <= 1000000; n++) {
//            double result = calculateT(n);
//            if(n == i){
//                System.out.println("t(" + n + ") = " + result);
//                i = i + 10000;
//            }
//
//        }
 }
}

