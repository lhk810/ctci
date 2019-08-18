package chapter7;

import java.util.ArrayList;
import java.util.Collections;

public class Question1 {

}

class Deck {
	ArrayList<Card> deck;
	public Deck() {
		this.deck = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (int i=1; i<14; i++) {
				deck.add(new Card(i,suit));
			}
		}
	}
	
	public Card getCard() {
		return deck.remove(deck.size());
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}

}

class Card {
	int value;
	Suit suit;
	boolean isInHand = false;
	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
		this.isInHand = true;
	}
	public void setAsUsed() {
		this.isInHand = false;
	}
}

enum Suit {
	Club, Diamond, Heart, Spade;
}
