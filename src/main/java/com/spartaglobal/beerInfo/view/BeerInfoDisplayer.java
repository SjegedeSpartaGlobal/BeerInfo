package com.spartaglobal.beerInfo.view;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;

public class BeerInfoDisplayer {
    private String[] beerNames;
    private int amount;
    private String query;

    public BeerInfoDisplayer(String[] beerNames, int amount, String query) {
        this.beerNames = beerNames;
        this.amount = amount;
        this.query = query;
    }

    public void displaySearchResults(){
        System.out.println("There are "+amount+" results for "+query);
        System.out.println(" ");
        System.out.println("Here they are: ");
        for(int i=0; i<beerNames.length; i++){
            System.out.println((i+1)+" "+beerNames[i]);
        }
    }
}
