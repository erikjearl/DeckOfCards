import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static List<Card> deck;

	public static void main(String[] args) {
		deck = new ArrayList<>();
		populateDeck(deck); // populate deck of cards
		System.out.println("Size of deck: " + deck.size() + "\n"); // print deck size
		Collections.shuffle(deck); // shuffle deck
		System.out.println("Shuffled Deck:");
		printDeck();
		sortRank(deck); // sort by rank
		System.out.println("Sorted by Rank:");
		printDeck();
		sortSuitRank(deck); // sort by suit and rank
		System.out.println("Sorted by Suit and Rank:");
		printDeck();
	}

	public static void populateDeck(List<Card> deck) {
		String[] suits = { "CLUBS", "DIAMONDS", "HEARTS", "SPADES" };
		for (int i = 0; i < suits.length; i++) { //iterate through suits
			for (int j = 2; j <= 14; j++) {  //iterate through ranks
				deck.add(new Card(suits[i], j));
			}
		}
	}

	public static void sortRank(List<Card> deck) { // insertion sort implementation of rank sorting
		int i, j;
		for (i = 1; i < deck.size(); i++) {
			Card toInsert = deck.get(i);
			for (j = i; j > 0 && toInsert.getRank() < deck.get(j - 1).getRank(); j--)
				deck.set(j, deck.get(j - 1));
			deck.set(j, toInsert);
		}
	}

	public static void sortSuitRank(List<Card> deck) { // sort by suit and rank
		List<Card> clubs = new ArrayList<>();
		List<Card> diamonds = new ArrayList<>();
		List<Card> hearts = new ArrayList<>();
		List<Card> spades = new ArrayList<>();
		
		for (int i = 0; i < deck.size(); i++) { //divide deck into suits
			switch (deck.get(i).getSuit()) {
			case "CLUBS":
				clubs.add(deck.get(i));
				break;
			case "DIAMONDS":
				diamonds.add(deck.get(i));
				break;
			case "HEARTS":
				hearts.add(deck.get(i));
				break;
			case "SPADES":
				spades.add(deck.get(i));
				break;
			}
		}
		
		//sort individual suits
		sortRank(clubs);
		sortRank(diamonds);
		sortRank(hearts);
		sortRank(spades);
		
		//combine suits into full deck
		deck.clear();
		deck.addAll(clubs);
		deck.addAll(diamonds);
		deck.addAll(hearts);
		deck.addAll(spades);
	}

	public static void printDeck() { // method to print deck to console
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i));
		}
		System.out.println();
	}

}
