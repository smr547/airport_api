package au.com.southsky.airports;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        AirportCache cache = new AirportCache("airport_cache");
        Airport airport = cache.get("SYD");
        System.out.println(airport.timezone);

    }
}
