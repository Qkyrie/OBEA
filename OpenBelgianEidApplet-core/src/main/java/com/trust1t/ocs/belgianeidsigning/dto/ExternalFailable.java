/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.dto;

/**
 * Interface that is necessary because it is possible that something goes wrong and the returnobject
 * couldn't be created. When this is the case, we use getErrorCode() here to display what went wrong.
 * 
 * Errorcodes should be defined in the public API
 */
public interface ExternalFailable {
	String getErrorCode();
}
