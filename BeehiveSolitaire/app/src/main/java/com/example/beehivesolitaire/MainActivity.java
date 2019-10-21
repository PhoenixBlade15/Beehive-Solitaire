package com.example.beehivesolitaire;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Variables for determining deck size for easy future change
    // ButtonOnePress: 0 == None, 1 == Beehive, 2 == Working Pile
    int ButtonOnePress = 0;
    // ButtonTwoPress: 0 == None, 1 == Garden1, 2 == Garden2, etc...
    int ButtonTwoPress = 0;
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
    boolean GameLose = true;
    boolean GameWin = false;
    int CompletedSets = 0;

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

    // Sets the beehive, pile counts, and garden
    public void setBoard(){

        // Fills in the beehive
        for(int index = 0; index < 10; index++ ){
            Beehive.add(Deck.get(0));
            Deck.remove(0);
        }

        // Fills in the Flower Garden sections of the board
        setGarden("Garden1");
        setGarden("Garden2");
        setGarden("Garden3");
        setGarden("Garden4");
        setGarden("Garden5");
        setGarden("Garden6");

        // Checks to make sure no sets in gardens
        checkGarden();

        // Sets the card display on all sections
        setCard("Beehive");
        setCard("WorkingPile");
        setCard("Garden1");
        setCard("Garden2");
        setCard("Garden3");
        setCard("Garden4");
        setCard("Garden5");
        setCard("Garden6");

        // Sets text telling how many cards in each pile
        setText("Beehive");
        setText("WorkingPile");
        setText("Garden1");
        setText("Garden2");
        setText("Garden3");
        setText("Garden4");
        setText("Garden5");
        setText("Garden6");
        setText("Deck");
    }

    // Checks each garden to get rid of sets
    public void checkGarden(){
        // If any sets are in the flower garden get rid of them.
        while( FlowerGarden1.get(0) %100 == FlowerGarden2.get(0) %100 || FlowerGarden1.get(0) %100 == FlowerGarden3.get(0) %100 || FlowerGarden1.get(0) %100 == FlowerGarden4.get(0) %100 || FlowerGarden1.get(0) %100 == FlowerGarden5.get(0) %100 || FlowerGarden1.get(0) %100 == FlowerGarden6.get(0) %100) {
            if(FlowerGarden1.get(0) %100 == FlowerGarden2.get(0) %100 ){
                FlowerGarden1.add(FlowerGarden2.get(0));
                FlowerGarden2.remove(0);
                setGarden("Garden2");
            } else if(FlowerGarden1.get(0) %100 == FlowerGarden3.get(0) %100 ){
                FlowerGarden1.add(FlowerGarden3.get(0));
                FlowerGarden3.remove(0);
                setGarden("Garden3");
            } else if(FlowerGarden1.get(0) %100 == FlowerGarden4.get(0) %100 ){
                FlowerGarden1.add(FlowerGarden4.get(0));
                FlowerGarden4.remove(0);
                setGarden("Garden4");
            } else if(FlowerGarden1.get(0) %100 == FlowerGarden5.get(0) %100 ){
                FlowerGarden1.add(FlowerGarden5.get(0));
                FlowerGarden5.remove(0);
                setGarden("Garden5");
            } else if(FlowerGarden1.get(0) %100 == FlowerGarden6.get(0) %100 ){
                FlowerGarden1.add(FlowerGarden6.get(0));
                FlowerGarden6.remove(0);
                setGarden("Garden6");
            }
        }

        // If any sets are in the flower garden get rid of them.
        while( FlowerGarden2.get(0) %100 == FlowerGarden3.get(0) %100 || FlowerGarden2.get(0) %100 == FlowerGarden4.get(0) %100 || FlowerGarden2.get(0) %100 == FlowerGarden5.get(0) %100 || FlowerGarden2.get(0) %100 == FlowerGarden6.get(0) %100){
            if(FlowerGarden2.get(0) %100 == FlowerGarden3.get(0) %100 ){
                FlowerGarden2.add(FlowerGarden3.get(0));
                FlowerGarden3.remove(0);
                setGarden("Garden3");
            } else if(FlowerGarden2.get(0) %100 == FlowerGarden4.get(0) %100 ){
                FlowerGarden2.add(FlowerGarden4.get(0));
                FlowerGarden4.remove(0);
                setGarden("Garden4");
            } else if(FlowerGarden2.get(0) %100 == FlowerGarden5.get(0) %100 ){
                FlowerGarden2.add(FlowerGarden5.get(0));
                FlowerGarden5.remove(0);
                setGarden("Garden5");
            } else if(FlowerGarden2.get(0) %100 == FlowerGarden6.get(0) %100 ){
                FlowerGarden2.add(FlowerGarden6.get(0));
                FlowerGarden6.remove(0);
                setGarden("Garden6");
            }
        }

        // If any sets are in the flower garden get rid of them.
        while( FlowerGarden3.get(0) %100 == FlowerGarden4.get(0) %100 || FlowerGarden3.get(0) %100 == FlowerGarden5.get(0) %100 || FlowerGarden3.get(0) %100 == FlowerGarden6.get(0) %100) {
            if(FlowerGarden3.get(0) %100 == FlowerGarden4.get(0) %100 ){
                FlowerGarden3.add(FlowerGarden4.get(0));
                FlowerGarden4.remove(0);
                setGarden("Garden4");
            } else if(FlowerGarden3.get(0) %100 == FlowerGarden5.get(0) %100 ){
                FlowerGarden3.add(FlowerGarden5.get(0));
                FlowerGarden5.remove(0);
                setGarden("Garden5");
            } else if(FlowerGarden3.get(0) %100 == FlowerGarden6.get(0) %100 ){
                FlowerGarden3.add(FlowerGarden6.get(0));
                FlowerGarden6.remove(0);
                setGarden("Garden6");
            }
        }

        // If any sets are in the flower garden get rid of them.
        while( FlowerGarden4.get(0) %100 == FlowerGarden5.get(0) %100 || FlowerGarden4.get(0) %100 == FlowerGarden6.get(0) %100) {
            if(FlowerGarden4.get(0) %100 == FlowerGarden5.get(0)) {
                FlowerGarden4.add(FlowerGarden5.get(0) %100);
                FlowerGarden5.remove(0);
                setGarden("Garden5");
            } else if (FlowerGarden4.get(0) %100 == FlowerGarden6.get(0) %100) {
                FlowerGarden4.add(FlowerGarden6.get(0));
                FlowerGarden6.remove(0);
                setGarden("Garden6");
            }
        }

        // If any sets are in the flower garden get rid of them.
        while( FlowerGarden5.get(0) %100 == FlowerGarden6.get(0) %100) {
            if(FlowerGarden5.get(0) %100 == FlowerGarden6.get(0) %100) {
                FlowerGarden5.add(FlowerGarden6.get(0));
                FlowerGarden6.remove(0);
                setGarden("Garden6");
            }
        }

        // If garden 1 is a set of 4
        if ( FlowerGarden1.toArray().length == 4 ){
            CompletedSets++;
            TextView CompletedSets = findViewById(R.id.CompletedSets);
            CompletedSets.setText("Completed Sets: " + CompletedSets);
            FlowerGarden1.clear();
            setGarden("Garden1");
            checkGarden();
        }

        // If garden 2 is a set of 4
        if ( FlowerGarden2.toArray().length == 4 ){
            CompletedSets++;
            TextView CompletedSets = findViewById(R.id.CompletedSets);
            CompletedSets.setText("Completed Sets: " + CompletedSets);
            FlowerGarden2.clear();
            setGarden("Garden2");
            checkGarden();
        }

        // If garden 3 is a set of 4
        if ( FlowerGarden3.toArray().length == 4 ){
            CompletedSets++;
            TextView CompletedSets = findViewById(R.id.CompletedSets);
            CompletedSets.setText("Completed Sets: " + CompletedSets);
            FlowerGarden3.clear();
            setGarden("Garden3");
            checkGarden();
        }

        // If garden 1 is a set of 4
        if ( FlowerGarden4.toArray().length == 4 ){
            CompletedSets++;
            TextView CompletedSets = findViewById(R.id.CompletedSets);
            CompletedSets.setText("Completed Sets: " + CompletedSets);
            FlowerGarden4.clear();
            setGarden("Garden4");
            checkGarden();
        }

        // If garden 5 is a set of 4
        if ( FlowerGarden5.toArray().length == 4 ){
            CompletedSets++;
            TextView CompletedSets = findViewById(R.id.CompletedSets);
            CompletedSets.setText("Completed Sets: " + CompletedSets);
            FlowerGarden5.clear();
            setGarden("Garden5");
            checkGarden();
        }

        // If garden 6 is a set of 4
        if ( FlowerGarden6.toArray().length == 4 ){
            CompletedSets++;
            TextView CompletedSets = findViewById(R.id.CompletedSets);
            CompletedSets.setText("Completed Sets: " + CompletedSets);
            FlowerGarden6.clear();
            setGarden("Garden6");
            checkGarden();
        }



    }

    // Sets the flower gardens
    public void setGarden(String GardenName){

        // Checks which garden is being set
        if ( Deck.toArray().length > 0 ){
            if (GardenName == "Garden1" ){
                FlowerGarden1.add(Deck.get(0));
                Deck.remove(0);
                setText("Garden1");
                setCard("Garden1");
            } else if ( GardenName == "Garden2" ){
                FlowerGarden2.add(Deck.get(0));
                Deck.remove(0);
                setText("Garden2");
                setCard("Garden2");
            } else if ( GardenName == "Garden3" ){
                FlowerGarden3.add(Deck.get(0));
                Deck.remove(0);
                setText("Garden3");
                setCard("Garden3");
            } else if ( GardenName == "Garden4" ){
                FlowerGarden4.add(Deck.get(0));
                Deck.remove(0);
                setText("Garden4");
                setCard("Garden4");
            } else if ( GardenName == "Garden5" ){
                FlowerGarden5.add(Deck.get(0));
                Deck.remove(0);
                setText("Garden5");
                setCard("Garden5");
            } else if ( GardenName == "Garden6" ){
                FlowerGarden6.add(Deck.get(0));
                Deck.remove(0);
                setText("Garden6");
                setCard("Garden6");
            }

            setText("Deck");
            setCard("Deck");
        } else if ( WorkingPile.toArray().length > 0 ){
            if (GardenName == "Garden1" ){
                FlowerGarden1.add(WorkingPile.get(0));
                WorkingPile.remove(0);
                setText("Garden1");
                setCard("Garden1");
            } else if ( GardenName == "Garden2" ){
                FlowerGarden2.add(WorkingPile.get(0));
                WorkingPile.remove(0);
                setText("Garden2");
                setCard("Garden2");
            } else if ( GardenName == "Garden3" ){
                FlowerGarden3.add(WorkingPile.get(0));
                WorkingPile.remove(0);
                setText("Garden3");
                setCard("Garden3");
            } else if ( GardenName == "Garden4" ){
                FlowerGarden4.add(WorkingPile.get(0));
                WorkingPile.remove(0);
                setText("Garden4");
                setCard("Garden4");
            } else if ( GardenName == "Garden5" ){
                FlowerGarden5.add(WorkingPile.get(0));
                WorkingPile.remove(0);
                setText("Garden5");
                setCard("Garden5");
            } else if ( GardenName == "Garden6" ){
                FlowerGarden6.add(WorkingPile.get(0));
                WorkingPile.remove(0);
                setText("Garden6");
                setCard("Garden6");
            }

            setText("WorkingPile");
            setCard("WorkingPile");
        }
    }

    // Set the text of the incoming pile
    public void setText(String ButtonName){

        // Initializes Variables
        int TextID = R.id.Garden1Text;
        String Text = "Cards in Stack: ";

        // Walks through each button name to see if it is a valid name passed in
        if(ButtonName == "Garden1"){
            TextID = R.id.Garden1Text;
            Text = "Cards in Stack: " + FlowerGarden1.toArray().length;
        } else if ( ButtonName == "Garden2"){
            TextID = R.id.Garden2Text;
            Text = "Cards in Stack: " + FlowerGarden2.toArray().length;
        } else if ( ButtonName == "Garden3"){
            TextID = R.id.Garden3Text;
            Text = "Cards in Stack: " + FlowerGarden3.toArray().length;
        } else if ( ButtonName == "Garden4"){
            TextID = R.id.Garden4Text;
            Text = "Cards in Stack: " + FlowerGarden4.toArray().length;
        } else if ( ButtonName == "Garden5"){
            TextID = R.id.Garden5Text;
            Text = "Cards in Stack: " + FlowerGarden5.toArray().length;
        } else if ( ButtonName == "Garden6"){
            TextID = R.id.Garden6Text;
            Text = "Cards in Stack: " + FlowerGarden6.toArray().length;
        } else if ( ButtonName == "WorkingPile"){
            TextID = R.id.WorkingPileText;
            Text = "Cards in Stack: " + WorkingPile.toArray().length;
        } else if ( ButtonName == "Beehive"){
            TextID = R.id.BeehiveText;
            Text = "Cards in Stack: " + Beehive.toArray().length;
        } else if ( ButtonName == "Deck"){
            TextID = R.id.DeckText;
            Text = "Cards in Stack: " + Deck.toArray().length;
        }

        // Sets the text to the correct amount of cards in the stack
        TextView TempText = findViewById(TextID);
        TempText.setText(Text);
    }

    // Gets the card information set and then finds
    public void setCard(String ButtonName){

        // Initializes Variables
        int ButtonID = R.id.Garden1;
        int Image = R.mipmap.cback_foreground;

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
        int ImageNeeded = 1;

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
        } else if ( ButtonName == "Beehive" && Beehive.toArray().length > 0){
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
            case 1:
                return R.mipmap.cback_foreground;
            default:
                return R.mipmap.cback_foreground;
        }
    }

    // When Player taps the deck
    public void pullDeck(){

        // If the pile is not empty draw
        if(Deck.toArray().length != 0 ){
            // Checks if deck has 3 cards to draw to working pile if not draws remaining
            int StoppingPoint = Math.min(3, Deck.toArray().length);
            for(int index = 0; index < StoppingPoint; index++ ){
                WorkingPile.add(Deck.get(0));
                Deck.remove(0);
            }
        } else {

            // If the player has not been able to use any card from the deck
            if ( GameLose == true ){
                GameOver();
            }

            // If the deck is empty put the working pile back into the deck
            Deck.addAll(WorkingPile);
            WorkingPile.clear();
            GameLose = true;
        }
        setCard("WorkingPile");
        setText("Deck");
        setText("WorkingPile");
    }

    // If they lose the game
    public void GameOver(){
        TextView FlowerGarden = findViewById(R.id.FG_Text);
        FlowerGarden.setText("You Lose!");
    }

    // If they win the game
    public void GameWin(){
        TextView FlowerGarden = findViewById(R.id.FG_Text);
        FlowerGarden.setText("You Win!");
    }

    // Check if Game is won
    public void isWin(){
        if ( CompletedSets >= SetAmount ){
            GameWin();
        }
    }

    // Sets the selected identifier
    public void setSelected(String ButtonPressed){

        // If beehive was tapped
        if ( ButtonPressed == "Beehive" ){
            TextView BeehiveSelected = findViewById(R.id.BeehiveSelected);

            // If no piles were selected
            if ( ButtonOnePress == 0 ){
                ButtonOnePress = 1;
                BeehiveSelected.setText("Selected");

                // If unselecting beehive
            } else if ( ButtonOnePress == 1 ){
                ButtonOnePress = 0;
                BeehiveSelected.setText("");

                // If working pile was already selected
            } else if ( ButtonOnePress == 2){
                ButtonOnePress = 1;
                BeehiveSelected.setText("Selected");
                TextView WorkingPileSelected = findViewById(R.id.WorkingPileSelected);
                WorkingPileSelected.setText("");
            }
            // If the working pile was tapped
        } else if ( ButtonPressed == "WorkingPile" ){

            // Makes sure there are cards in the working pile to be selected
            if ( WorkingPile.toArray().length > 0 ){
                TextView WorkingPileSelected = findViewById(R.id.WorkingPileSelected);

                // If no piles were selected
                if ( ButtonOnePress == 0 ){
                    ButtonOnePress = 2;
                    WorkingPileSelected.setText("Selected");

                    // If beehive was already selected
                } else if ( ButtonOnePress == 1 ){
                    ButtonOnePress = 2;
                    WorkingPileSelected.setText("Selected");
                    TextView BeehiveSelected = findViewById(R.id.BeehiveSelected);
                    BeehiveSelected.setText("");

                    // If unselecting working pile
                } else if ( ButtonOnePress == 2){
                    ButtonOnePress = 0;
                    WorkingPileSelected.setText("");
                }
            }
        } else if ( ButtonPressed == "Garden1"){
            ButtonTwoPress = 1;
        } else if ( ButtonPressed == "Garden2"){
            ButtonTwoPress = 2;
        } else if ( ButtonPressed == "Garden3"){
            ButtonTwoPress = 3;
        } else if ( ButtonPressed == "Garden4"){
            ButtonTwoPress = 4;
        } else if ( ButtonPressed == "Garden5"){
            ButtonTwoPress = 5;
        } else if ( ButtonPressed == "Garden6"){
            ButtonTwoPress = 6;
        }
    }

    // Handles the logic that the flower garden slots take
    public void GardenLogic(){

        // If or beehive has been selected be able to do this logic
        if ( ButtonOnePress == 1 ){

            // If garden 1 was selected
            if ( ButtonTwoPress == 1 ){
                // If the two cards are sets
                if ( Beehive.get(Beehive.toArray().length-1) %100 == FlowerGarden1.get(0) %100  ){
                    FlowerGarden1.add(Beehive.get(Beehive.toArray().length-1));
                    Beehive.remove(Beehive.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 1 is a set of 4
                    if ( FlowerGarden1.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden1.clear();
                        setGarden("Garden1");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden1");
                    setText("Garden1");
                    GameLose = false;
                }

                // If Garden 2 was selected
            } else if ( ButtonTwoPress == 2 ){
                // If the two cards are sets
                if ( Beehive.get(Beehive.toArray().length-1) %100 == FlowerGarden2.get(0) %100  ){
                    FlowerGarden2.add(Beehive.get(Beehive.toArray().length-1));
                    Beehive.remove(Beehive.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 2 is a set of 4
                    if ( FlowerGarden2.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden2.clear();
                        setGarden("Garden2");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden2");
                    setText("Garden2");
                    GameLose = false;
                }

                // If Garden 3 was selected
            } else if ( ButtonTwoPress == 3 ){
                // If the two cards are sets
                if ( Beehive.get(Beehive.toArray().length-1) %100 == FlowerGarden3.get(0) %100  ){
                    FlowerGarden3.add(Beehive.get(Beehive.toArray().length-1));
                    Beehive.remove(Beehive.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 3 is a set of 4
                    if ( FlowerGarden3.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden3.clear();
                        setGarden("Garden3");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden3");
                    setText("Garden3");
                    GameLose = false;
                }

                // If Garden 4 was selected
            } else if ( ButtonTwoPress == 4 ){
                // If the two cards are sets
                if ( Beehive.get(Beehive.toArray().length-1) %100 == FlowerGarden4.get(0) %100  ){
                    FlowerGarden4.add(Beehive.get(Beehive.toArray().length-1));
                    Beehive.remove(Beehive.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 4 is a set of 4
                    if ( FlowerGarden4.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden4.clear();
                        setGarden("Garden4");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden4");
                    setText("Garden4");
                    GameLose = false;
                }

                // If Garden 5 was selected
            } else if ( ButtonTwoPress == 5 ){
                // If the two cards are sets
                if ( Beehive.get(Beehive.toArray().length-1) %100 == FlowerGarden5.get(0) %100  ){
                    FlowerGarden5.add(Beehive.get(Beehive.toArray().length-1));
                    Beehive.remove(Beehive.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 5 is a set of 4
                    if ( FlowerGarden5.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden5.clear();
                        setGarden("Garden5");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden5");
                    setText("Garden5");
                    GameLose = false;
                }

                // If Garden 6 was selected
            } else if ( ButtonTwoPress == 6 ){
                // If the two cards are sets
                if ( Beehive.get(Beehive.toArray().length-1) %100 == FlowerGarden6.get(0) %100  ){
                    FlowerGarden6.add(Beehive.get(Beehive.toArray().length-1));
                    Beehive.remove(Beehive.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 6 is a set of 4
                    if ( FlowerGarden6.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden6.clear();
                        setGarden("Garden6");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden6");
                    setText("Garden6");
                    GameLose = false;
                }
            }
            // If the working pile was selected
        } else if ( ButtonOnePress == 2 ){

            // If garden 1 was selected
            if ( ButtonTwoPress == 1 ){
                // If the two cards are sets
                if ( WorkingPile.get(WorkingPile.toArray().length-1) %100 == FlowerGarden1.get(0) %100  ){
                    FlowerGarden1.add(WorkingPile.get(WorkingPile.toArray().length-1));
                    WorkingPile.remove(WorkingPile.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 1 is a set of 4
                    if ( FlowerGarden1.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden1.clear();
                        setGarden("Garden1");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden1");
                    setText("Garden1");
                    GameLose = false;
                }

                // If Garden 2 was selected
            } else if ( ButtonTwoPress == 2 ){
                // If the two cards are sets
                if ( WorkingPile.get(WorkingPile.toArray().length-1) %100 == FlowerGarden2.get(0) %100  ){
                    FlowerGarden2.add(WorkingPile.get(WorkingPile.toArray().length-1));
                    WorkingPile.remove(WorkingPile.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 2 is a set of 4
                    if ( FlowerGarden2.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden2.clear();
                        setGarden("Garden2");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden2");
                    setText("Garden2");
                    GameLose = false;
                }

                // If Garden 3 was selected
            } else if ( ButtonTwoPress == 3 ){
                // If the two cards are sets
                if ( WorkingPile.get(WorkingPile.toArray().length-1) %100 == FlowerGarden3.get(0) %100  ){
                    FlowerGarden3.add(WorkingPile.get(WorkingPile.toArray().length-1));
                    WorkingPile.remove(WorkingPile.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 3 is a set of 4
                    if ( FlowerGarden3.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden3.clear();
                        setGarden("Garden3");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden3");
                    setText("Garden3");
                    GameLose = false;
                }

                // If Garden 4 was selected
            } else if ( ButtonTwoPress == 4 ){
                // If the two cards are sets
                if ( WorkingPile.get(WorkingPile.toArray().length-1) %100 == FlowerGarden4.get(0) %100  ){
                    FlowerGarden4.add(WorkingPile.get(WorkingPile.toArray().length-1));
                    WorkingPile.remove(WorkingPile.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 4 is a set of 4
                    if ( FlowerGarden4.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden4.clear();
                        setGarden("Garden4");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden4");
                    setText("Garden4");
                    GameLose = false;
                }

                // If Garden 5 was selected
            } else if ( ButtonTwoPress == 5 ){
                // If the two cards are sets
                if ( WorkingPile.get(WorkingPile.toArray().length-1) %100 == FlowerGarden5.get(0) %100  ){
                    FlowerGarden5.add(WorkingPile.get(WorkingPile.toArray().length-1));
                    WorkingPile.remove(WorkingPile.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 5 is a set of 4
                    if ( FlowerGarden5.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden5.clear();
                        setGarden("Garden5");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden5");
                    setText("Garden5");
                    GameLose = false;
                }

                // If Garden 6 was selected
            } else if ( ButtonTwoPress == 6 ){
                // If the two cards are sets
                if ( WorkingPile.get(WorkingPile.toArray().length-1) %100 == FlowerGarden6.get(0) %100  ){
                    FlowerGarden6.add(WorkingPile.get(WorkingPile.toArray().length-1));
                    WorkingPile.remove(WorkingPile.toArray().length-1);
                    setCard("Beehive");
                    setText("Beehive");

                    // If garden 6 is a set of 4
                    if ( FlowerGarden6.toArray().length == 4 ){
                        CompletedSets++;
                        TextView CompletedSetsText = findViewById(R.id.CompletedSets);
                        CompletedSetsText.setText("Completed Sets: " + CompletedSets);
                        FlowerGarden6.clear();
                        setGarden("Garden6");
                        checkGarden();
                        isWin();
                    }
                    setCard("Garden6");
                    setText("Garden6");
                    GameLose = false;
                }
            }
        }

        WorkingPile.trimToSize();
        Beehive.trimToSize();
        ButtonTwoPress = 0;
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

        // When the player wants to draw more for working pile
        ImageButton DeckButton = findViewById(R.id.DeckButton);
        DeckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pullDeck();
            }
        });

        // When the player decides to select the beehive
        ImageButton BeehiveButton = findViewById(R.id.BeehiveButton);
        BeehiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected("Beehive");
            }
        });

        // When the player decides to select the working pile
        ImageButton WorkingPileButton = findViewById(R.id.WorkingPileButton);
        WorkingPileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected("WorkingPile");
            }
        });

        // When the player decides to select the garden 1
        ImageButton Garden1 = findViewById(R.id.Garden1);
        Garden1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonTwoPress = 1;
                setSelected("Garden1");
                GardenLogic();
            }
        });

        // When the player decides to select the garden 2
        ImageButton Garden2 = findViewById(R.id.Garden2);
        Garden2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonTwoPress = 2;
                setSelected("Garden2");
                GardenLogic();
            }
        });

        // When the player decides to select the garden 3
        ImageButton Garden3 = findViewById(R.id.Garden3);
        Garden3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonTwoPress = 3;
                setSelected("Garden3");
                GardenLogic();
            }
        });

        // When the player decides to select the garden 4
        ImageButton Garden4 = findViewById(R.id.Garden4);
        Garden4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonTwoPress = 4;
                setSelected("Garden4");
                GardenLogic();
            }
        });

        // When the player decides to select the garden 5
        ImageButton Garden5 = findViewById(R.id.Garden5);
        Garden5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonTwoPress = 5;
                setSelected("Garden5");
                GardenLogic();
            }
        });

        // When the player decides to select the garden 6
        ImageButton Garden6 = findViewById(R.id.Garden6);
        Garden6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonTwoPress = 6;
                setSelected("Garden6");
                GardenLogic();
            }
        });



    }
}
