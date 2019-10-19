package com.example.beehivesolitaire;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Variables for determining deck size for easy future change
    int SetAmount = 13;
    int Colors = 4;
    int[] Deck;

    // Fills the deck and then randomizes the deck
    public static int[] setDeck(int SetAmount, int Colors){
        // Needed variables for this code
        Random rng = new Random();
        int[] Deck = new int[SetAmount*Colors];
        int index = 0;

        // Fills the deck in with color and what card it is
        for( int CardColor = 1; CardColor <= Colors; CardColor++ ){
            for ( int CardNumber = 1; CardNumber <= SetAmount; CardNumber ++){
                Deck[index] = (CardColor*100) + CardNumber;
                index++;
            }
        }

        // Rnadomizes the deck
        for( int DeckPlace = 0; DeckPlace < Deck.length; DeckPlace++ ){
            int NewDeckPlace = rng.nextInt(Deck.length);
            int temp = Deck[NewDeckPlace];
            Deck[NewDeckPlace] = Deck[DeckPlace];
            Deck[DeckPlace] = temp;
        }

        return Deck;
    }

    public void setBoard(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Deck = setDeck(SetAmount, Colors);


    }


}
