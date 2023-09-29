package model;

public class Lot {
    private static int num = 1;

    // inner class
    private static class LotInner {
        public void print() {
            System.out.println(String.format("%s%d", "This is an inner class: ", num));
        }
    }

    // Accessing the inner classes from the method within
    public void displayInnerClasses() {
        LotInner lotInner = new LotInner();
        lotInner.print();
    }
}
