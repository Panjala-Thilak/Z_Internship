package java_coursera.JavaProgramming_SolvingProblemswithSoftware.Week4;

import edu.duke.FileResource;
import edu.duke.DirectoryResource;
import org.apache.commons.csv.CSVRecord;
import java.io.*;

public class Assignment {
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int boyTotalBirths = 0;
        int girlTotalBirths = 0;
        int boyCount = 0;
        int girlCount = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;

            if (record.get(1).equals("M")) {
                boyTotalBirths += numBorn;
                boyCount++;
            } else {
                girlTotalBirths += numBorn;
                girlCount++;
            }
        }

        System.out.println("Total data = " + (boyCount + girlCount));
        System.out.println("Total births = " + totalBirths);

        System.out.println("Total girls = " + girlCount);
        System.out.println("Total girls births = " + girlTotalBirths);

        System.out.println("Total boys = " + boyCount);
        System.out.println("Total boys births = " + boyTotalBirths);
    }

    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource("/home/thilp/java_coursera/java_coursera/Week4/us_babynames_by_year/yob" + year + ".csv" );
        int rank = 0;
        boolean recordFound = false;

        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentName = record.get(0);
            String currentGender = record.get(1);

            if (currentGender.equals(gender)) {
                rank++;

                if (currentName.equals(name)) {
                    recordFound = true;
                    break;
                }
            }
        }

        if (recordFound) {
            return rank;
        } else {
            return -1;
        }
    }

    public void testGetRank() {
        int year = 1960;
        String name = "Emily";
        String gender = "F";

        int rank = getRank(year, name, gender);
        System.out.println(name + " rank is " + rank);
    }

    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource("/home/thilp/java_coursera/java_coursera/Week4/us_babynames_by_year/yob" + year + ".csv" );
        String name = "NO NAME";
        int currentRank = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);

            if (currentGender.equals(gender)) {
                currentRank++;

                if (currentRank == rank) {
                    name = record.get(0);
                    break;
                }
            }
        }

        return name;
    }

    public void testGetName() {
        int year = 1980;
        int rank = 350;
        String gender = "F";

        String name = getName(year, rank, gender);
        System.out.println(year + " rank " + rank + " is " + name);
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int currentYearRank = getRank(year, name, gender);
        String newName = getName(newYear, currentYearRank, gender);

        System.out.println(name + " born in " + newYear + " would be " + newName + " if she was born in " + newYear);
    }

    public void testWhatIsNameInYear() {
        whatIsNameInYear("Owen", 1974, 2014, "M");
    }

    public int yearOfHighestRank(String name, String gender) {
        int year = Integer.MIN_VALUE;
        int rank = Integer.MAX_VALUE;
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(currentYear, name, gender);

            if (currentRank != -1 && currentRank < rank) {
                rank = currentRank;
                year = currentYear;
            }

        }

        if (year == Integer.MIN_VALUE) {
            return -1;
        } else {
            return year;
        }
    }

    public void testYearOfHighestRank() {
        String name = "Genevieve";
        String gender = "F";
        System.out.println(name + " most popular year is " + yearOfHighestRank(name, gender));
    }

    public double getAverageRank(String name, String gender) {
        double totalRank = 0;
        int recordCount = 0;
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(currentYear, name, gender);

            if (currentRank != -1) {
                totalRank += currentRank;
                recordCount++;
            }
        }

        if (recordCount == 0) {
            return -1.0;
        } else {
            return totalRank / recordCount;
        }
    }

    public void testGetAverageRank() {
        String name = "Susan";
        String gender = "F";
        System.out.println("Average rank for " + name + " is " + getAverageRank(name, gender));

        name = "Robert";
        gender = "M";
        System.out.println("Average rank for " + name + " is " + getAverageRank(name, gender));
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource("/home/thilp/java_coursera/java_coursera/Week4/us_babynames_by_year/yob" + year + ".csv" );
        int rank = getRank(year, name, gender);
        int totalBirths = 0;
        int currentRank = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);

            if (currentGender.equals(gender)) {
                currentRank++;

                if (currentRank < rank) {
                    int currentBirths = Integer.parseInt(record.get(2));
                    totalBirths += currentBirths;
                } else {
                    break;
                }
            }
        }

        return totalBirths;
    }

    public void testGetTotalBirthsRankedHigher() {
        int year = 1990;
        String name = "Emily";
        String gender = "F";
        System.out.println("Total births higher than " + name + " is " + getTotalBirthsRankedHigher(year, name, gender));

        year = 1990;
        name = "Drew";
        gender = "M";
        System.out.println("Total births higher than " + name + " is " + getTotalBirthsRankedHigher(year, name, gender));
    }

    public static void main(String[] args) {
        Assignment assignment=new Assignment();
        assignment.testTotalBirths();
        assignment.testGetName();
        assignment.testWhatIsNameInYear();
        assignment.testGetRank();
        assignment.testYearOfHighestRank();
        assignment.testGetTotalBirthsRankedHigher();
        assignment.testGetAverageRank();
    }






}