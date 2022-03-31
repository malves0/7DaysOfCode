
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + dotenv.get("API_KEY")))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}