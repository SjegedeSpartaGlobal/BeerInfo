package com.spartaglobal.beerInfo.view;

import com.spartaglobal.beerInfo.controller.BeerInfoServices;
import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import com.spartaglobal.beerInfo.model.BeerInfoServices.*;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class ConsoleInterface {

    private BeerInfoServices beerServices = new BeerInfoServices();

    public void run(){
        System.out.println("What would you like to search by: ");
        String input = getInput();
        search(input);
    }

    private void search(String searchTerm){
        searchTerm = toLowercase(searchTerm);
        if(searchTerm.equals("beer name")){
            searchByName();
        } else if(searchTerm.equals("food")){
            searchByFood();
        } else if(searchTerm.equals("high alcohol content")){
            searchByHighAlc();
        }else if(searchTerm.equals("low alcohol content")){
            searchByLowAlc();
        }else if(searchTerm.equals("high bitterness rating")){
            searchByHighBitterness();
        }else if(searchTerm.equals("low bitterness rating")){
            searchByLowBitterness();
        }
    }
    private String getInput(){
        String nextInput = "";
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextLine()) {
            nextInput = scanner.nextLine();
        }
        return nextInput;
    }

    private BeerInfoDTO getBeerDTO(String input, BeerInfoService bs){
        BeerInfoDTO beerDTO = null;
        input = toLowercase(input);
        if(input.equals("first")){
            beerDTO = bs.getFirstBeer();
        }else if(input.equals("random")){
            beerDTO = bs.selectRandomBeer();
        }
        return beerDTO;
    }

    private void displayResults(String[] beerNames, int amount, String query){
        BeerInfoDisplayer beerInfoDisplayer = new BeerInfoDisplayer(beerNames, amount, query);
        beerInfoDisplayer.displaySearchResults();
    }

    private void displayDTO(BeerInfoDTO beerInfoDTO){
        BeerInfoDTODisplayer beerInfoDTODisplayer = new BeerInfoDTODisplayer(beerInfoDTO);
        beerInfoDTODisplayer.displayBeerInfoDTO();
    }

    private boolean isExit(String input){
        input = toLowercase(input);
        if(input.equals("exit")){
            return true;
        }
        return false;
    }

    private String toLowercase(String str){
        String newStr = str.toLowerCase();
        return newStr;
    }

    private void searchHelper(BeerInfoService beerInfoService, String input){
        displayResults(beerInfoService.getBeerNames(), beerInfoService.getAmount(), input);
        System.out.println("Would you like to get the first beer or pick a random one? ");
        String input3 = getInput();
        input3 = toLowercase(input3);
        if(!isExit(input3)) {
            BeerInfoDTO beerDTO = getBeerDTO(input3, beerInfoService);
            displayDTO(beerDTO);
        } else{
            System.out.println("See you later!");
        }
    }

    private void searchByName(){
        String input2 = "";
        System.out.println("Enter Beer Name: ");
        input2 = getInput();
        input2 = toLowercase(input2);
        if(!isExit(input2)) {
            BeerSearcher bs = beerServices.searchBeers(input2);
            searchHelper(bs, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    private void searchByFood(){
        String input2 = "";
        System.out.println("Enter Food: ");
        input2 = getInput();
        input2 = toLowercase(input2);
        if(!isExit(input2)) {
            FoodToBeerFinder fb = beerServices.beersMatchingFood(input2);
            searchHelper(fb, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    private void searchByHighAlc(){
        String input2 = "";
        System.out.println("Enter Alcohol Content: ");
        input2 = getInput();
        input2 = toLowercase(input2);
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            GreaterAlchoholBeersRetreiver highAlc = beerServices.getHighAlcContent(intInput);
            searchHelper(highAlc, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    private void searchByLowAlc(){
        String input2 = "";
        System.out.println("Enter Alcohol Content: ");
        input2 = getInput();
        input2 = toLowercase(input2);
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            LowerAlchoholBeersRetriever lowAlc = beerServices.getLowAlcContent(intInput);
            searchHelper(lowAlc, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    private void searchByLowBitterness(){
        String input2 = "";
        System.out.println("Enter Bitterness Rating: ");
        input2 = getInput();
        input2 = toLowercase(input2);
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            LowerBitternessBeersRetriever lowBitterness = beerServices.getLowBittenessBeers(intInput);
            searchHelper(lowBitterness, input2);
        }else{
            System.out.println("See you later!");
        }
    }

    private void searchByHighBitterness(){
        String input2 = "";
        System.out.println("Enter Bitterness Rating: ");
        input2 = getInput();
        input2 = toLowercase(input2);
        if(!isExit(input2)) {
            int intInput = Integer.parseInt(input2);
            GreaterBitternessBeersRetriever highBitterness = beerServices.getHighBittenessBeers(intInput);
            searchHelper(highBitterness, input2);
        }else{
            System.out.println("See you later!");
        }
    }
}
