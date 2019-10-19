package com.example.beehivesolitaire;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Variables for determining deck size for easy future change
    int SetAmount = 13;
    int Colors = 4;
    int[] DeckArray;
    ArrayList<Integer> Deck = new ArrayList<>();
    ArrayList<Integer> Beehive = new ArrayList<>();
    ArrayList<Integer> WorkingPile = new ArrayList<>();
    ArrayList<Integer> FlowerGarden1 = new ArrayList<>();
    ArrayList<Integer> FlowerGarden2 = new ArrayList<>();
    ArrayList<Integer> FlowerGarden3 = new ArrayList<>();
    ArrayList<Integer> FlowerGarden4 = new ArrayList<>();
    ArrayList<Integer> FlowerGarden5 = new ArrayList<>();
    ArrayList<Integer> FlowerGarden6 = new ArrayList<>();

    // Fills the deck and then randomizes the deck
    public static int[] setDeck(int SetAmount, int Colors){
        // Needed variables for this code
        int[] Deck = new int[SetAmount*Colors];
        int index = 0;

        // Fills the deck in with color and what card it is
        for( int CardColor = 1; CardColor <= Colors; CardColor++ ){
            for ( int CardNumber = 1; CardNumber <= SetAmount; CardNumber ++){
                Deck[index] = (CardColor*100) + CardNumber;
                index++;
            }
        }
        return Deck;
    }
    public static int[] randomizeDeck(int[] Deck){
        // Needed variables for this code
        Random rng = new Random();

        // Randomizes the deck
        for( int DeckPlace = 0; DeckPlace < Deck.length; DeckPlace++ ){
            int NewDeckPlace = rng.nextInt(Deck.length);
            int temp = Deck[NewDeckPlace];
            Deck[NewDeckPlace] = Deck[DeckPlace];
            Deck[DeckPlace] = temp;
        }

        return Deck;
    }

    // Changes the array to a list
    public static ArrayList<Integer> IntArrayToList(int[] Input){
        ArrayList<Integer> Output = new ArrayList<>();
        for( int Index = 0; Index < Input.length; Index++){
            Output.add(Input[Index]);
        }
        return Output;
    }


    public void setBoard(){

        // Fills in the beehive
        for(int index = 0; index < 10; index++ ){
            Beehive.add(Deck.get(0));
            Deck.remove(0);
        }

        // Fills in the Flower Garden sections of the board
        FlowerGarden1.add(Deck.get(0));
        Deck.remove(0);
        FlowerGarden2.add(Deck.get(0));
        Deck.remove(0);
        FlowerGarden3.add(Deck.get(0));
        Deck.remove(0);
        FlowerGarden4.add(Deck.get(0));
        Deck.remove(0);
        FlowerGarden5.add(Deck.get(0));
        Deck.remove(0);
        FlowerGarden6.add(Deck.get(0));
        Deck.remove(0);
        setCard("Beehive");
        setCard("WorkingPile");
        setCard("Garden1");
        setCard("Garden2");
        setCard("Garden3");
        setCard("Garden4");
        setCard("Garden5");
        setCard("Garden6");
    }

    // Gets the card information set and then finds
    public void setCard(String ButtonName){

        // Initializes Variables
        int ButtonID = R.id.Garden1;
        int Image = R.drawable.c101_background;

        // Walks through each button name to see if it is a valid name passed in
        if(ButtonName == "Garden1"){
            ButtonID = R.id.Garden1;
            Image = getImageID(ButtonName);
        } else if ( ButtonName == "Garden2"){
            ButtonID = R.id.Garden2;
            Image = getImageID(ButtonName);
        } else if ( ButtonName == "Garden3"){
            ButtonID = R.id.Garden3;
            Image = getImageID(ButtonName);
        } else if ( ButtonName == "Garden4"){
            ButtonID = R.id.Garden4;
            Image = getImageID(ButtonName);
        } else if ( ButtonName == "Garden5"){
            ButtonID = R.id.Garden5;
            Image = getImageID(ButtonName);
        } else if ( ButtonName == "Garden6"){
            ButtonID = R.id.Garden6;
            Image = getImageID(ButtonName);
        } else if ( ButtonName == "WorkingPile"){
            ButtonID = R.id.WorkingPileButton;
            Image = getImageID(ButtonName);
        } else if ( ButtonName == "Beehive"){
            ButtonID = R.id.BeehiveButton;
            Image = getImageID(ButtonName);
        }

        // Sets the image of the button to the new image
        ImageButton TempButton = findViewById(ButtonID);
        TempButton.setBackgroundResource(Image);
    }

    // Gets the image needed in that slot
    public int getImageID(String ButtonName){

        // Initializes Variables
        int ImageNeeded = 101;

        if(ButtonName == "Garden1"){
            ImageNeeded = FlowerGarden1.get(FlowerGarden1.toArray().length-1);
        } else if ( ButtonName == "Garden2"){
            ImageNeeded = FlowerGarden2.get(FlowerGarden2.toArray().length-1);
        } else if ( ButtonName == "Garden3"){
            ImageNeeded = FlowerGarden3.get(FlowerGarden3.toArray().length-1);
        } else if ( ButtonName == "Garden4"){
            ImageNeeded = FlowerGarden4.get(FlowerGarden4.toArray().length-1);
        } else if ( ButtonName == "Garden5"){
            ImageNeeded = FlowerGarden5.get(FlowerGarden5.toArray().length-1);
        } else if ( ButtonName == "Garden6"){
            ImageNeeded = FlowerGarden6.get(FlowerGarden6.toArray().length-1);
        } else if ( ButtonName == "WorkingPile" && WorkingPile.toArray().length > 0){
            ImageNeeded = WorkingPile.get(WorkingPile.toArray().length-1);
        } else if ( ButtonName == "Beehive"){
            ImageNeeded = Beehive.get(Beehive.toArray().length-1);
        }

        // Returns the image value for card needed
        switch (ImageNeeded){

            // Handles the clubs suit of cards
            case 101:
                return R.mipmap.c101_foreground;
            case 102:
                return R.mipmap.c102_foreground;
            case 103:
                return R.mipmap.c103_foreground;
            case 104:
                return R.mipmap.c104_foreground;
            case 105:
                return R.mipmap.c105_foreground;
            case 106:
                return R.mipmap.c106_foreground;
            case 107:
                return R.mipmap.c107_foreground;
            case 108:
                return R.mipmap.c108_foreground;
            case 109:
                return R.mipmap.c109_foreground;
            case 110:
                return R.mipmap.c110_foreground;
            case 111:
                return R.mipmap.c111_foreground;
            case 112:
                return R.mipmap.c112_foreground;
            case 113:
                return R.mipmap.c113_foreground;

            // Handles the diamonds suit of cards
            case 201:
                return R.mipmap.c201_foreground;
            case 202:
                return R.mipmap.c202_foreground;
            case 203:
                return R.mipmap.c203_foreground;
            case 204:
                return R.mipmap.c204_foreground;
            case 205:
                return R.mipmap.c205_foreground;
            case 206:
                return R.mipmap.c206_foreground;
            case 207:
                return R.mipmap.c207_foreground;
            case 208:
                return R.mipmap.c208_foreground;
            case 209:
                return R.mipmap.c209_foreground;
            case 210:
                return R.mipmap.c210_foreground;
            case 211:
                return R.mipmap.c211_foreground;
            case 212:
                return R.mipmap.c212_foreground;
            case 213:
                return R.mipmap.c213_foreground;

            // Handles the hearts suit of cards
            case 301:
                return R.mipmap.c301_foreground;
            case 302:
                return R.mipmap.c302_foreground;
            case 303:
                return R.mipmap.c303_foreground;
            case 304:
                return R.mipmap.c304_foreground;
            case 305:
                return R.mipmap.c305_foreground;
            case 306:
                return R.mipmap.c306_foreground;
            case 307:
                return R.mipmap.c307_foreground;
            case 308:
                return R.mipmap.c308_foreground;
            case 309:
                return R.mipmap.c309_foreground;
            case 310:
                return R.mipmap.c310_foreground;
            case 311:
                return R.mipmap.c311_foreground;
            case 312:
                return R.mipmap.c312_foreground;
            case 313:
                return R.mipmap.c313_foreground;

            // Handles the clubs suit of cards
            case 401:
                return R.mipmap.c401_foreground;
            case 402:
                return R.mipmap.c402_foreground;
            case 403:
                return R.mipmap.c403_foreground;
            case 404:
                return R.mipmap.c404_foreground;
            case 405:
                return R.mipmap.c405_foreground;
            case 406:
                return R.mipmap.c406_foreground;
            case 407:
                return R.mipmap.c407_foreground;
            case 408:
                return R.mipmap.c408_foreground;
            case 409:
                return R.mipmap.c409_foreground;
            case 410:
                return R.mipmap.c410_foreground;
            case 411:
                return R.mipmap.c411_foreground;
            case 412:
                return R.mipmap.c412_foreground;
            case 413:
                return R.mipmap.c413_foreground;
            default:
                return R.mipmap.c101_foreground;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets up the basics for the game
        setContentView(R.layout.activity_main);
        DeckArray = setDeck(SetAmount, Colors);
        DeckArray = randomizeDeck(DeckArray);
        Deck = IntArrayToList(DeckArray);
        setBoard();
    }

}
