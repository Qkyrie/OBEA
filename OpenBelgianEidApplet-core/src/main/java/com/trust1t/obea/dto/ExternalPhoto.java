package com.trust1t.obea.dto;

public interface ExternalPhoto extends ExternalFailable{

	/**
	 * Gets the photo, encoded as bas64
	 * @return
	 */
	public String getBase64Photo(); 
}
