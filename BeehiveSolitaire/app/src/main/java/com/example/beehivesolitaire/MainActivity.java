package com.example.beehivesolitaire;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Variables for determining deck size for easy future change
    int SetAmount = 13;
    int Colors = 4;
    int[] DeckArray;
    List Deck;
    List Beehive;
    List WorkingPile;

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

    public static List IntArrayToList(int[] Input){
        List Output = null;
        for( int Index = 0; Index < Input.length; Index++){
            Output.add(Input[Index]);
        }
        return Output;
    }


    public void setBoard(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DeckArray = setDeck(SetAmount, Colors);
        DeckArray = randomizeDeck(DeckArray);
        Deck = IntArrayToList(DeckArray);

    }


}
