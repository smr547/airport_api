package au.com.southsky.airports;

public class Airport {

    String airport_code;
    String altalternate_ident;
    String code_icao;
    String code_iata; // eg SFO,
    String code_lid; // eg SFO
    String name; //eg "San Francisco Int'l"
    String type; // eg "Airport" +
    int elevation; // in meters
    String city; // San Francisco
    String state; // "CA"
    float longitude; //-122.3754167
    float latitude; //:37.6188056
    String timezone; // "America/Los_Angeles
    String  country_code; // US
    String  wiki_url; // http://en.wikipedia.org/wiki/San_Francisco_International_Airport
    String airport_flights_url; // /airports/KSFO/flights"
    String [] alternatives;
}
