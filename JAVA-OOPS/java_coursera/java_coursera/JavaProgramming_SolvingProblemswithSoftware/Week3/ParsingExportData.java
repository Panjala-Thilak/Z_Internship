package java_coursera.JavaProgramming_SolvingProblemswithSoftware.Week3;

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParsingExportData {

    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String currentCountry = record.get("Country");

            if (currentCountry.equalsIgnoreCase(country)) {
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");

                String result = currentCountry + ": " + exports + ": " + value;
                return result;
            }
        }

        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        System.out.println("Two Products");
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");

            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int totalCountry = 0;

        for (CSVRecord record : parser) {
            String exports = record.get("Exports");

            if (exports.contains(exportItem)) {
                totalCountry++;
            }
        }

        return totalCountry;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String currentAmount = record.get("Value (dollars)");

            if (currentAmount.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + currentAmount);
            }
        }
    }

    public void tester() {
        FileResource fr = new FileResource();

        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "fish", "nuts");

        parser = fr.getCSVParser();
        System.out.println("Sugar "+numberOfExporters(parser, "sugar"));

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }

    public static void main(String[] args) {
        ParsingExportData parsingExportData=new ParsingExportData();
        parsingExportData.tester();
    }
}