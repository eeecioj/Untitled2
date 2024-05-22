import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readCSV {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String line = "";
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read header if needed
            // String headerLine = br.readLine();
            // Process headerLine if needed

            // Read data lines
            while ((line = br.readLine()) != null) {
                // Split the line by the CSV separator
                String[] data = line.split(csvSeparator);

                // Process each field in the data array
                for (String field : data) {
                    System.out.print(field + "\t"); // Or process the field as needed
                }
                System.out.println(); // Move to the next line for the next record
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
