package Program01;

public class City {
	// Fields to represent city information
		private String name;		// City name
	    private String county;		// County city is in
	    private String state;		// State city is in
	    private String stateAbbr;	// State abbreviation
	    private double latitude;	// Latitude of city
	    private double longitude;	// Longitude of city
	    private int population;		// Population of city
	    private double density;		// Population density of city
	    private String timezone;	// Timezone of city
	    private int id;				// ID of city

	    // Constructor to initialize city data from CSV string
	    public City(String data) {
	        String[] tokens = data.split(",");
	        name = tokens[0].trim();
	        stateAbbr = tokens[2].trim();
	        state = tokens[3].trim();
	        county = tokens[5].trim();
	        latitude = tokens[6].trim().length() > 0 ? Double.parseDouble(tokens[6].trim()) : 0.0;
	        longitude = tokens[7].trim().length() > 0 ? Double.parseDouble(tokens[7].trim()) : 0.0;
	        population = tokens[8].trim().length() > 0 ? Integer.parseInt(tokens[8].trim()) : 0;
	        density = tokens[9].trim().length() > 0 ? Double.parseDouble(tokens[9].trim()) : 0.0;
	        timezone = tokens[13].trim();
	        id = tokens[16].trim().length() > 0 ? Integer.parseInt(tokens[16].trim()) : 0;
	    }

	    // Getter methods to retrieve city information
	    public String getName() {
	        return name;
	    }

	    public String getCounty() {
	        return county;
	    }

	    public String getState() {
	        return state;
	    }

	    public String getStateAbbr() {
	        return stateAbbr;
	    }

	    public double getLatitude() {
	        return latitude;
	    }

	    public double getLongitude() {
	        return longitude;
	    }

	    public int getPopulation() {
	        return population;
	    }

	    public double getDensity() {
	        return density;
	    }

	    public String getTimezone() {
	        return timezone;
	    }

	    public int getId() {
	        return id;
	    }

	    // Override toString method to provide a formatted string representation
	    @Override
	    public String toString() {
	        StringBuilder result = new StringBuilder();
	        result.append("Name: ").append(name).append("\n");
	        result.append("County: ").append(county).append("\n");
	        result.append("State: ").append(state).append("\n");
	        result.append("Latitude: ").append(String.format("%.4f", latitude)).append("\n");
	        result.append("Longitude: ").append(String.format("%.4f", longitude)).append("\n");
	        result.append("Population: ").append(String.format("%,d", population)).append("\n");
	        result.append("Density: ").append(String.format("%,.2f", density)).append("\n");
	        result.append("Timezone: ").append(timezone).append("\n");
	        result.append("ID: ").append(id).append("\n");
	        return result.toString();
	    }
	}