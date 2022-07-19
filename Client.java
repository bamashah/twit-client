import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Objects;

public class Client {

    public List<Response> readFromServers(List<String> servers) {
        List<Response> responses;

        responses = servers.parallelStream()
                .map(server -> {
                    Gson gson = new Gson();
                    Scanner scanner = null;
                    Response response = null;
                    try {
                        URL serverURL = new URL(server);
                        scanner = new Scanner(serverURL.openStream());
                        String json = scanner.useDelimiter("\\Z").next();
                        //System.out.println(json);
                        response = gson.fromJson(json, Response.class);
                        response.calcSuccessRate();
                    } catch (IOException e) {
                        System.out.println("Unable to read from server: " + server);
                    } catch (Exception e) {
                        System.out.println("Response from " + server + " is maybe not in proper format.");
                    }

                    if (scanner != null)
                        scanner.close();

                    return response;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return responses;
    }

}
