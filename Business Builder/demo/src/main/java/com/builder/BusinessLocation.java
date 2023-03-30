package com.builder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import javax.management.openmbean.OpenDataException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BusinessLocation {
    InformationAPI key = new InformationAPI();

    public int LocateBusiness(String typeOfBusiness, String lat, String longi) {
        Gson gson = new Gson();
        Location location = new Location();
        Population population = new Population();
        String locationLat = lat;
        String locationLong = longi;
        Scanner input = new Scanner(System.in);
        String userInput;

        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://dev.virtualearth.net/REST/v1/LocalSearch/?query=" + typeOfBusiness
                            + "&userLocation=" + locationLat + "," + locationLong + "&maxResults=25&key="
                            + key.getBusinessLocationKey()))
                    .GET().build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            String data = getResponse.body();

            ObjectMapper om1 = new ObjectMapper();
            Root root = om1.readValue(data, Root.class);

            System.out.println("Would you also like to dislplay the json data with this? Input y or n");
            userInput = input.nextLine();
            input.close();

            if (userInput.charAt(0) == 'y' || userInput.charAt(0) == 'Y') {
                System.out.println("-------------------------");
                System.out.println(data);
                System.out.println("-------------------------");
            }

            input.close();
            return root.resourceSets.get(0).getResources().size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
