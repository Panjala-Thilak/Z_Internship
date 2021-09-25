package java_coursera;
import edu.duke.Point;
import edu.duke.Shape;
import edu.duke.FileResource;
public class PerimeterRunner {
    public double getPerimeter(Shape shape)
    {
     double totalPerimeter=0;
      Point previousPoint=shape.getLastPoint();
      for (Point currentPoint: shape.getPoints())
      {
          double currentDistance=previousPoint.distance(currentPoint);
          totalPerimeter=totalPerimeter+currentDistance;
          previousPoint=currentPoint;
      }
    return totalPerimeter;
    }
    public void testPerimeter()
    {
        FileResource  fileResource=new FileResource();
        Shape shape=new Shape(fileResource);
        double length=getPerimeter(shape);
        System.out.println("Perimeter ="+length);
    }

    public static void main(String[] args) {
        PerimeterRunner perimeterRunner=new PerimeterRunner();
        perimeterRunner.testPerimeter();
    }
}
