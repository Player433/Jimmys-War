package com.war;
	import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

	public class War {

		private LinkedList<Deck> userCards = new LinkedList<Deck>();
		private LinkedList<Deck> dealerCards = new LinkedList<Deck>();
		private ArrayList<Deck> lastUserHand = new ArrayList<Deck>();
		private ArrayList<Deck> lastDealerHand = new ArrayList<Deck>();
		private Boolean playerWonHand;
		private Boolean playerWonGame;
		
		public War(){
			gameSetup();
		}

		public void playHand(){
			lastUserHand.clear();
			lastDealerHand.clear();
			
			Deck playerCard = userCards.pollFirst();
			Deck dealerCard = dealerCards.pollFirst();
			lastUserHand.add(playerCard);
			lastDealerHand.add(dealerCard);
			
			// Compare hands
			if(playerCard.getValue() == dealerCard.getValue()){
				playerWonHand = playWar();
			}
			else {
				playerWonHand = (playerCard.getValue() > dealerCard.getValue());
			}
			
			// Pass on winnings
			if(playerWonHand){
				userCards.addAll(lastUserHand);
				userCards.addAll(lastDealerHand);				
			}			
			else{
				dealerCards.addAll(lastUserHand);
				dealerCards.addAll(lastDealerHand);	
			}
			
			// Determine if game has been won
			if(userCards.isEmpty() || dealerCards.isEmpty()){
				playerWonGame = (userCards.size() > dealerCards.size());
			}
		}
		
		private boolean playWar(){
			for ( int i = 0; i < 2; i++ ){
				if ( userCards.peekFirst() != null ){
					lastUserHand.add(userCards.pollFirst());
				}
				if ( dealerCards.peekFirst() != null ){
					lastDealerHand.add(dealerCards.pollFirst());
				}
			}
			
			Deck playerCard = lastUserHand.get(lastUserHand.size() - 1);
			Deck dealerCard = dealerCards.get(lastUserHand.size() - 1);
			
			// Double War
			if(playerCard.getValue() == dealerCard.getValue()){
				playWar();
			}
			
			return (playerCard.getValue() > dealerCard.getValue());
		}
		
		private void gameSetup(){
			ArrayList<Deck> sortedDeck = new ArrayList<Deck>();
			Collections.copy(sortedDeck, Deck.getAllCards());
			Collections.shuffle(sortedDeck);
			for( int i = 0; i < 52; i += 2 ){
				userCards.add(sortedDeck.get(i));				
				dealerCards.add(sortedDeck.get(i+1));				
			}			
			System.out.println();
		}

		public Boolean getPlayerWonHand() {
			return playerWonHand;
		}

		public ArrayList<Deck> getLastUserHand() {
			return lastUserHand;
		}

		public ArrayList<Deck> getLastDealerHand() {
			return lastDealerHand;
		}

		public Boolean getPlayerWonGame() {
			return playerWonGame;
		}

	}
