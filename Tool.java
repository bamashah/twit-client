import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Tool {
    public static void main(String[] args)  {
        // read from the servers file
        FileReader fileReader = new FileReader();
        List<String> servers = fileReader.readFile();

        // loop through the server list and make http calls to each and get responses
        Client client = new Client();
        List<Response> responses = client.readFromServers(servers);

        // Grouping success rates by Application by Version
        Map<String, Map<String, Double>> successRateGroupedByApplicationAndVersion = responses.stream()
                .collect(groupingBy(Response::getApplication, groupingBy(Response::getVersion, averagingDouble(Response::getSuccessRate))));

        // write the output to stdout and output.txt file
        OutputWriter writer = new OutputWriter();
        writer.write(successRateGroupedByApplicationAndVersion);
    }

}

