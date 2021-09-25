package java_coursera.perimeter_project;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape shape) {
        double totalPerimeter = 0.0;
        Point previousPoint = shape.getLastPoint();
        for (Point currentPoint : shape.getPoints()) {
            double currentDistance = previousPoint.distance(currentPoint);
            totalPerimeter = totalPerimeter + currentDistance;
            previousPoint = currentPoint;
        }
        return totalPerimeter;
    }

    public int getNumPoints (Shape shape) {
        // Put code here
        int count=0;
        for(edu.duke.Point point:shape.getPoints())
        {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape shape) {
        // Put code here
        double perimeter=getPerimeter(shape);
        int numberOfPoints=getNumPoints(shape);
        double averageLength=perimeter/numberOfPoints;
        return averageLength;
    }

    public double getLargestSide(Shape shape) {
        double largestSideLength=0;
        Point previousPoint = shape.getLastPoint();
        for (Point currentPoint : shape.getPoints()) {
            double currentDistance = previousPoint.distance(currentPoint);
            if(largestSideLength<currentDistance)
                largestSideLength=currentDistance;
            previousPoint=currentPoint;
        }
        return largestSideLength;
    }

    public double getLargestX(Shape shape) {
        Point lastPoint = shape.getLastPoint();
        int lastPointX = lastPoint.getX();
        double largestX = (double) lastPointX;

        for(Point point : shape.getPoints()){
            int newX = point.getX();
            if(newX > largestX) {
                largestX = (double) newX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource directoryResource = new DirectoryResource();
        double largestPerimeter = 0.0;

        for(File file : directoryResource.selectedFiles()){
            FileResource fileResource = new FileResource(file);
            Shape shape = new Shape(fileResource);
            double perimeter = getPerimeter(shape);
            if(perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {

        DirectoryResource directoryResource = new DirectoryResource();
        double largestPerimeter = 0.0;
        File largestFile=null;
        for(File file : directoryResource.selectedFiles()){
            FileResource fileResource = new FileResource(file);
            Shape shape = new Shape(fileResource);
            double perimeter = getPerimeter(shape);
            if(perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
                largestFile=file;
            }
        }
        return largestFile.getName();
    }


    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest Perimeter is "+getLargestPerimeterMultipleFiles());

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("The File with largest Perimeter is "+getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    public void testPerimeter () {
        FileResource fileResource = new FileResource();
        Shape shape = new Shape(fileResource);
        double length = getPerimeter(shape);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points="+getNumPoints(shape));
        System.out.println("Average Length ="+getAverageLength(shape));
        System.out.println("The largest side of the shape is "+getLargestSide(shape));
        System.out.println("The largest x value is "+getLargestX(shape));
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();

    }
    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            System.out.println(file);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner perimeterAssignmentRunner = new PerimeterAssignmentRunner();
        perimeterAssignmentRunner.testPerimeter();
    }
}
