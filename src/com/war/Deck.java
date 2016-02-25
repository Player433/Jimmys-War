package com.war;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public enum Deck {

	twoOfH(2, "two of Hearts"), threeOfH(3, "three of Hearts"), fourOfH(4,
			"four of Hearts"), fiveOfH(5, "five of Hearts"), sixOfH(6,
			"six of Hearts"), sevenOfH(7, "seven of Hearts"), eightOfH(8,
			"eight of Hearts"), nineOfH(9, "nine of Hearts"),tenofH(10, "ten of Hearts"), jackOfH(10,
			"jack of Hearts"), queenOfH(10, "queen of Hearts"), kingOfH(10,
			"king of Hearts"), aceOfH(11, "ace of Hearts"), twoOfD(2,
			"two of Diamonds"), threeOfD(3, "three of Diamonds"), fourOfD(4,
			"four of Diamonds"), fiveOfD(5, "five of Diamonds"), sixOfD(6,
			"six of Diamonds"), sevenOfD(7, "seven of Diamonds"), eightOfD(8,
			"eight of Diamonds"), nineOfD(9, "nine of Diamonds"),tenofD(10, "ten of Diamonds"), jackOfD(10,
			"jack of Diamonds"), queenOfD(10, "queen of Diamonds"), kingOfD(10,
			"king of Diamonds"), aceOfD(11, "ace of Diamonds"), twoOfC(2,
			"two of Clubs"), threeOfC(3, "three of Clubs"), fourOfC(4,
			"four of Clubs"), fiveOfC(5, "five of Clubs"), sixOfC(6,
			"six of Clubs"), sevenOfC(7, "seven of Clubs"), eightOfC(8,
			"eight of Clubs"), nineOfC(9, "nine of Clubs"),tenofC(10, "ten of Clubs"), jackOfC(10,
			"jack of Clubs"), queenOfC(10, "queen of Clubs"), kingOfC(10,
			"king of Clubs"), aceOfC(11, "ace of Clubs"), twoOfS(2,
			"two of Spades"), threeOfS(3, "three of Spades"), fourOfS(4,
			"four of Spades"), fiveOfS(5, "five of Spades"), sixOfS(6,
			"six of Spades"), sevenOfS(7, "seven of Spades"), eightOfS(8,
			"eight of Spades"), nineOfS(9, "nine of Spades"),tenofS(10, "ten of Spades"), jackOfS(10,
			"jack of Spades"), queenOfS(10, "queen of Spades"), kingOfS(10,
			"king of Spades"), aceOfS(11, "ace of Spades");

	private int value;
	private String cardName;
	private static final List<Deck> allCards = new ArrayList<Deck>(EnumSet.allOf(Deck.class));

	private Deck(int value, String cardName) {
		this.value = value;
		this.cardName = cardName;
	}

	public static List<Deck> getAllCards() {
		return allCards;
	}

	public static Deck getRandomCard() {
		int randomNum = Math.abs(new Random().nextInt()) % 52;
		return allCards.get(randomNum);
	}

	public int getValue() {
		return value;
	}

	public String getCardName() {
		return cardName;
	}
	
	@Override public String toString(){
		return this.cardName;
	}
	
}