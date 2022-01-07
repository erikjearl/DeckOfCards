public class Card {
	private String suit;
	private int rank;

	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public String toString() {
		String convertedRank;
		switch (rank) { // change number cards to named values
		case 2:
			convertedRank = "TWO";
			break;
		case 3:
			convertedRank = "THREE";
			break;
		case 4:
			convertedRank = "FOUR";
			break;
		case 5:
			convertedRank = "FIVE";
			break;
		case 6:
			convertedRank = "SIX";
			break;
		case 7:
			convertedRank = "SEVEN";
			break;
		case 8:
			convertedRank = "EIGHT";
			break;
		case 9:
			convertedRank = "NINE";
			break;
		case 10:
			convertedRank = "TEN";
			break;
		case 11:
			convertedRank = "JACK";
			break;
		case 12:
			convertedRank = "QUEEN";
			break;
		case 13:
			convertedRank = "KING";
			break;
		case 14:
			convertedRank = "ACE";
			break;
		default:
			convertedRank = Integer.toString(rank);
		}
		return convertedRank + " of " + suit;
	}
}