/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.events;

import be.fedict.commons.eid.client.BeIDCard;

/**
 * Event thrown when a card is removed. The original BEIDCard is provided here for referencing
 */
public class CardRemovedEvent implements ICardEvent{

	/** The beid card. */
	private BeIDCard beidCard;
	
	/* (non-Javadoc)
	 * @see be.qkyrie.ts.mqkapplet.events.ICardEvent#getIdentifier()
	 */
	public String getIdentifier() {
		return "_onCardRemoved";
	}

	/**
	 * Instantiates a new card removed event.
	 *
	 * @param eidCard the eid card
	 */
	public CardRemovedEvent(BeIDCard eidCard){
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
