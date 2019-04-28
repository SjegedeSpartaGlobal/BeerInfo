package com.spartaglobal.beerInfo.controller;

import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;

import java.util.Scanner;

public class Starter {
//    private static int length;

    public static void main(String[] param){
        BeerInfoServices beerInfo = new BeerInfoServices();
//        Scanner scanner = new Scanner(System.in);
//        if(scanner.hasNextLine()) {
//            System.out.println(scanner.nextLine());
//        }
        BeerSearcher bs = beerInfo.searchBeers("Berliner Weisse");
        String[] beerArray = (String[]) bs.getBeerNames();
        int length = beerArray.length;
//        System.out.println(beerArray.length);
        for(int i=0; i<length; i++ ){
            System.out.println(beerArray[i]);
        }
    }

}
