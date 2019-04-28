package com.spartaglobal.beerInfo.view;

import com.spartaglobal.beerInfo.controller.BeerInfoServices;
import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerInfoService;
import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class ConsoleInterface {


    private BeerInfoServices beerServices;

    public void search(String searchTerm){

        String input2 = "";
        String input3 = "";

        if(searchTerm.equals("Search by Beer Name")){
            System.out.println("Enter Beer Name: ");
            input2 = getInput();
            if(!isExit(input2)) {
                BeerSearcher bs = beerServices.searchBeers(input2);
                displayResults(bs.getBeerNames(), bs.getAmount(), input2);
                System.out.println("Would you like to get the first beer or pick a random one? ");
                input3 = getInput();
                if(!isExit(input3)) {
                    JSONObject jsonObject = getJSONObject(input3, bs);
                    displayDTO(jsonObject);
                } else{
                    System.out.println("See you later!");
                }
            }else{
                System.out.println("See you later!");
            }
        }
        else if(searchTerm.equals("Search by Food")){

        }
        else if(searchTerm.equals("Search by High Alchohol Content")){

        }else if(searchTerm.equals("Search by Low Alchohol Content")){

        }else if(searchTerm.equals("Search by High Bitterness Rating")){

        }else if(searchTerm.equals("Search by Low Bitterness Rating")){

        }
    }
    public String getInput(){
        String nextInput = "";
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextLine()) {
            nextInput = scanner.nextLine();
        }
        return nextInput;
    }

    public JSONObject getJSONObject(String input, BeerInfoService bs){
        JSONObject json = null;
        if(input.equals("first")){
            json = bs.getFirstBeer();
        }else if(input.equals("random")){
            json = bs.selectRandomBeer();
        }
        return json;
    }

    public void displayResults(String[] beerNames, int amount, String query){
        BeerInfoDisplayer beerInfoDisplayer = new BeerInfoDisplayer(beerNames, amount, query);
        beerInfoDisplayer.displaySearchResults();
    }

    public void displayDTO(JSONObject jsonObject){
        BeerInfoDTO beerInfoDTO = new BeerInfoDTO(jsonObject);
        BeerInfoDTODisplayer beerInfoDTODisplayer = new BeerInfoDTODisplayer(beerInfoDTO);
        beerInfoDTODisplayer.displayBeerInfoDTO();
    }

    public boolean isExit(String input){
        if(input.equals("Exit")){
            return true;
        }
        return false;
    }
}
