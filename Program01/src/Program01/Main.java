/**
 * Anthony Letizia
 * CPS 142 - Spring 2024
 * 29 January 2024
 * Instructor: Adam Divelbiss
 * Assignment: Program01
 * Purpose: Take input of a US state from a user and display details 
 * about both the most populous and most dense cities in that state.
 */
package Program01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the City Database Program!");

        Scanner scanner = new Scanner(System.in);

        do {
        	//Step 1: Prompt user for input
            System.out.print("Enter a US State: ");
            String stateInput = scanner.nextLine();

            try {
            	// Step 2: Load city data
                ArrayList<City> cities = loadData();
                boolean found = false;

                City mostPopulousCity = null;
                City densestCity = null;
                
                int totalCityRecords = 0; //Initialize total city records count

                //Step 3: Search for cities in the state the user input
                for (City city : cities) {
                    if (city.getStateAbbr().equalsIgnoreCase(stateInput) || city.getState().equalsIgnoreCase(stateInput)) {
                        found = true;
                        
                        // Increment total city records count
                        totalCityRecords++;

                        // Step 4: Identify most populous and most dense cities
                        if (mostPopulousCity == null || city.getPopulation() > mostPopulousCity.getPopulation()) {
                            mostPopulousCity = city;
                        }

                        if (densestCity == null || city.getDensity() > densestCity.getDensity()) {
                            densestCity = city;
                        }
                    }
                }

                // Step 5: Display results
                if (found) {
                	System.out.println("You searched cities in: " + stateInput);
                	System.out.println("Total City Records for " + stateInput + ": " + totalCityRecords);
                    System.out.println("Most Populous City in " + stateInput + ":");
                    displayReport(mostPopulousCity);

                    System.out.println("\nDensest City in " + stateInput + ":");
                    displayReport(densestCity);
                } else {
                    System.out.println("No data found for the state: " + stateInput);
                }

            } catch (FileNotFoundException e) {
            	// File not found exception
                System.out.println("Error: File not found.");
            }

            // Step 6: Prompt user for another search
            System.out.print("Do you want to generate another search report? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));

        System.out.println("Thank you for using the City Database Program!");
        scanner.close();
    }

	// Step 7: Load city data from database file
    public static ArrayList<City> loadData() throws FileNotFoundException {
        ArrayList<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(new File("uscities.csv"));

        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Skip header row
        }

        while (scanner.hasNextLine()) {
            cities.add(new City(scanner.nextLine()));
        }

        scanner.close();
        return cities;
    }

    // Step 8: Display city report
    public static void displayReport(City city) {
        System.out.println(city);
    }
}