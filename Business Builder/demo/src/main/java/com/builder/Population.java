package com.builder;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

//Population API key 61df26cc692fa4ee3007794fa4ca596f57a48ab3
public class Population {
    private String host = "";
    private InformationAPI key = new InformationAPI();

    public String[] getPopulation(String city) {
        PopulationJSON population;
        Gson gson = new Gson();
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(
                            "https://api.api-ninjas.com/v1/city?name=" + city))
                    .header("X-Api-Key", key.getPopulationAPIKey())
                    .GET().build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            String data = getResponse.body();
            data = data.replace("[", "");
            data = data.replace("]", "");

            population = gson.fromJson(data, PopulationJSON.class);
            String[] dataSet = { population.getPopulation(), population.getLatitude(), population.getLongitude() };
            return dataSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
