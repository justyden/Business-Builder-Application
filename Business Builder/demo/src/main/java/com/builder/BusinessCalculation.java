package com.builder;

public class BusinessCalculation {
    public void calculateBusiness(String typeOfBusiness, String city) {
        long populationCount;
        int businessAmount;

        Population population = new Population();

        String[] data = population.getPopulation(city.replace(' ', '_'));

        BusinessLocation location = new BusinessLocation();

        businessAmount = location.LocateBusiness(typeOfBusiness, data[1], data[2]);
        populationCount = Long.parseLong(data[0]);

        System.out.println("The amount of people living in " + city + " is " + data[0]);
        System.out.println("There were " + businessAmount + " places that had to with " + typeOfBusiness +
                " in the city");
        System.out.println("There are about " + (populationCount / businessAmount) + " for each business in the city");

    }
}
