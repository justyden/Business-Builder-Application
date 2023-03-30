package com.builder;

import java.util.Scanner;

import com.google.gson.Gson;

public final class App {
    public static void main(String[] args) {
        String city;
        String businessType;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the business calculator. Please input \n" +
                "a keyword associated with a business");
        businessType = input.nextLine();

        System.out.println("Now please input a city");
        city = input.nextLine();

        BusinessCalculation calculate = new BusinessCalculation();
        calculate.calculateBusiness(businessType, city);
        input.close();
    }
}
