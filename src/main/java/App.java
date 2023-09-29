import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        // Testing blackbox.model.Foo
//        Foo foo = new Foo();
//        foo.displayInnerClasses();

        //display refactoring
        RefactorTest refactorTest = new RefactorTest();
        refactorTest.start();
    }
}
