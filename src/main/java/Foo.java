public class Foo {
    private static int num = 1;

    // inner class
    private static class InnerFoo1 {
        public void print() {
            System.out.println(String.format("%s%d", "This is an inner class: ", num));
        }
    }
    // inner class
    private static class InnerFoo2 {
        public void print() {
            System.out.println(String.format("%s%d","This is an inner class: ", ++num));
        }
    }

    // Accessing the inner classes from the method within
    void displayInnerClasses() {
        InnerFoo1 innerFoo1 = new InnerFoo1();
        InnerFoo2 innerFoo2 = new InnerFoo2();
        innerFoo1.print();
        innerFoo2.print();
    }
}
