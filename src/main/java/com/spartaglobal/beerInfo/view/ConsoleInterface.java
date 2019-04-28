package com.spartaglobal.beerInfo.view;

import com.spartaglobal.beerInfo.controller.BeerInfoServices;
import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import com.spartaglobal.beerInfo.model.BeerInfoServices.*;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class ConsoleInterface {


    private BeerInfoServices beerServices;

    public void run(){
        String input = getInput();
        search(input);
    }

    public void search(String searchTerm){
        if(searchTerm.equals("Search by Beer Name")){
            searchByName();
        }
        else if(searchTerm.equals("Search by Food")){
            searchByFood();
        }
        else if(searchTerm.equals("Search by High Alchohol Content")){
            searchByHighAlc();
        }else if(searchTerm.equals("Search by Low Alchohol Content")){
            searchByLowAlc();
        }else if(searchTerm.equals("Search by High Bitterness Rating")){
            searchByHighBitterness();
        }else if(searchTerm.equals("Search by Low Bitterness Rating")){
            searchByLowBitterness();
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

    public void searchHelper(BeerInfoService beerInfoService, String input){
        displayResults(beerInfoService.getBeerNames(), beerInfoService.getAmount(), input);
        System.out.println("Would you like to get the first beer or pick a random one? ");
        input = getInput();
        if(!isExit(input)) {
            JSONObject jsonObject = getJSONObject(input, beerInfoService);
            displayDTO(jsonObject);
        } else{
            System.out.println("See you later!");
        }
    }

    public void searchByName(){
        String input2 = "";
        System.out.println("Enter Beer Name: ");
        input2 = getInput();
        if(!isExit(input2)) {
            BeerSearcher bs = beerServices.searchBeers(input2);
            searchHelper(bs, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    public void searchByFood(){
        String input2 = "";
        System.out.println("Enter Beer Name: ");
        input2 = getInput();
        if(!isExit(input2)) {
            FoodToBeerFinder fb = beerServices.beersMatchingFood(input2);
            searchHelper(fb, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    public void searchByHighAlc(){
        String input2 = "";
        System.out.println("Enter Beer Name: ");
        input2 = getInput();
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            GreaterAlchoholBeersRetreiver highAlc = beerServices.getHighAlcContent(intInput);
            searchHelper(highAlc, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    public void searchByLowAlc(){
        String input2 = "";
        System.out.println("Enter Beer Name: ");
        input2 = getInput();
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            LowerAlchoholBeersRetriever lowAlc = beerServices.getLowAlcContent(intInput);
            searchHelper(lowAlc, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    public void searchByLowBitterness(){
        String input2 = "";
        System.out.println("Enter Beer Name: ");
        input2 = getInput();
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            LowerBitternessBeersRetriever lowBitterness = beerServices.getLowBittenessBeers(intInput);
            searchHelper(lowBitterness, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    public void searchByHighBitterness(){
        String input2 = "";
        System.out.println("Enter Beer Name: ");
        input2 = getInput();
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            GreaterBitternessBeersRetriever highBitterness = beerServices.getHighBittenessBeers(intInput);
            searchHelper(highBitterness, input2);
        }else{
            System.out.println("See you later!");
        }
    }
}
