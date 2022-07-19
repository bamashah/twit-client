import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputWriter {

    public void write (Map<String, Map<String, Double>> successRateByApplicationAndVersion) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("output.txt"));

            List<String> applications = successRateByApplicationAndVersion.keySet().stream().sorted().collect(Collectors.toList());

            for (String application : applications) {
                System.out.println ("Application: " + application);
                Map<String, Double> ratePerVersion = successRateByApplicationAndVersion.get(application);

                List<String> versions = ratePerVersion.keySet().stream().sorted().collect(Collectors.toList());
                for (String version : versions) {
                    double rate = ratePerVersion.get(version);
                    System.out.println ("   Ver " + version + " - " + rate + " %");
                    writer.println(application + ", " + version + ", " + rate);
                }
                System.out.println ();
            }
        } catch (IOException e) {
            System.out.println("Unable to open an output file to write to.");
        } finally {
            if (writer != null)
                writer.close();
        }

    }


}
