import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readFile() {
        List<String> servers = new ArrayList<>();
        String csvFile = "servers.txt";
        String line = "";

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                servers.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return servers;
    }
}
