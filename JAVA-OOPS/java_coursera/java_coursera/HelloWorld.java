package java_coursera;
import edu.duke.FileResource;

public class HelloWorld {
    public void runHello() {
        FileResource fileResource;
        fileResource = new FileResource("/home/thilp/java_coursera/java_coursera/file");
        for (String line : fileResource.lines())
            System.out.println(line);
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.runHello();
    }
}
