package com.spartaglobal.beerInfo.view;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import com.spartaglobal.beerInfo.model.BeerInfoDTO.IBUException;

public class BeerInfoDTODisplayer {
    private BeerInfoDTO beerInfoDTO;
    private String name;
    private double alcContent;
    private long bitternessRating;
    private String[] foodPairings;
    private String description;
    private boolean unknownBitterness;

    public BeerInfoDTODisplayer(BeerInfoDTO beerInfoDTO) {
        this.beerInfoDTO = beerInfoDTO;
        name = this.beerInfoDTO.getName();
        alcContent = this.beerInfoDTO.getAlcContent();
        foodPairings = new String[]{"hello"};
        foodPairings = this.beerInfoDTO.getFoodPairings();
        description = this.beerInfoDTO.getDescription();
        try {
            bitternessRating = this.beerInfoDTO.getBitternessRating();
        } catch (IBUException e) {
            bitternessRating = 0;
            unknownBitterness = true;
        }
    }

    public void displayBeerInfoDTO(){
        System.out.println("Name: "+name);
        System.out.println("Alchohol Content: "+alcContent);
        if(!unknownBitterness) {
            System.out.println("Bitterness Rating: " + bitternessRating);
        }else{
            System.out.println("Bitterness Rating: Unknown");
        }
        System.out.println("Food Pairings: ");
        for(int i=0; i<foodPairings.length; i++){
            System.out.println(foodPairings[i]);
        }
        System.out.println("Description: "+description);
    }
}
