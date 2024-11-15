package au.com.southsky.airports;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;


public class AirportCache {

    private String cachePath; // path to directory containing airport JSON files

    public AirportCache(String cachePath) {
        this.cachePath = cachePath;
    }

    public Airport get(String code) throws IOException, InterruptedException {
        // check the cache
        Path cachePath = FileSystems.getDefault().getPath(this.cachePath, code);
        if (! cachePath.toFile().exists()) {

            // read the airport detail from AeroAPI

            String YOUR_API_KEY = System.getenv("AEROAPI_KEY");
            String apiUrl = "https://aeroapi.flightaware.com/aeroapi/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl + "airports/" + code))
                    .headers("x-apikey", YOUR_API_KEY)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // save response in cache

            Files.writeString(cachePath, response.body(), StandardCharsets.UTF_8);
        }
        String json =  Files.readString(cachePath);
        Gson gson = new Gson();
        Airport airport =  gson.fromJson(json, Airport.class);
        return airport;
    }
}
