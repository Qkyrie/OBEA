/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.events;

import be.fedict.commons.eid.client.BeIDCard;

/**
 * The event thrown when a card was removed.
 * The event contains the correct card that was inserted, only if the card was a Belgian EID Card
 */
public class CardDetectedEvent implements ICardEvent{

	/** The beid card. */
	private BeIDCard beidCard;
	
	/* (non-Javadoc)
	 * @see be.qkyrie.ts.mqkapplet.events.ICardEvent#getIdentifier()
	 */
	public String getIdentifier() {
		return "_onCardDetected";
	}
	
	/**
	 * Instantiates a new card detected event.
	 *
	 * @param eidCard the eid card
	 */
	public CardDetectedEvent(BeIDCard eidCard){
		this.beidCard = eidCard;
	}

	/**
	 * Gets the beid card.
	 *
	 * @return the beid card
	 */
	public BeIDCard getBeidCard() {
		return beidCard;
	}
}
