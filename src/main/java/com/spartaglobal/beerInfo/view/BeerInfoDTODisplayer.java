package com.spartaglobal.beerInfo.view;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;

public class BeerInfoDTODisplayer {
    private BeerInfoDTO beerInfoDTO;
    private String name;
    private double alcContent;
    private long bitternessRating;
    private String[] foodPairings;
    private String description;

    public BeerInfoDTODisplayer(BeerInfoDTO beerInfoDTO) {
        this.beerInfoDTO = beerInfoDTO;
        name = this.beerInfoDTO.getName();
        alcContent = this.beerInfoDTO.getAlcContent();
        bitternessRating = this.beerInfoDTO.getBitternessRating();
        foodPairings = this.beerInfoDTO.getFoodPairings();
        description = this.beerInfoDTO.getDescription();
    }

    public void displayBeerInfoDTO(){
        System.out.println("Name: "+name);
        System.out.println("Alchohol Content: "+alcContent);
        System.out.println("Bitterness Rating: "+bitternessRating);
        System.out.println("Food Pairings: -");
        for(int i=0; i<foodPairings.length; i++){
            System.out.println(foodPairings[i]);
        }
        System.out.println("Description: "+description);
    }
}
