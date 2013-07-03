/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.external;

import com.trust1t.ocs.belgianeidsigning.events.IAppletEvent;
import com.trust1t.ocs.belgianeidsigning.events.ICardEvent;

public interface ExternalOutputManager {

	/**
	 * This method is delegated to the External Connection method to call a card event.
	 *
	 * @param cardEvent the card event
	 */
	void onCardEvent(ICardEvent cardEvent);
	
	/**
	 * This method is delegated to the External Connection method to call a card event.
	 *
	 * @param cardEvent the card event
	 */
	void onAppletEvent(IAppletEvent appletEvent);
}
