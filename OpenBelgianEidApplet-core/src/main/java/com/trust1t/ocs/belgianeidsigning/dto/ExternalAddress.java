/*
 * @author Quinten De Swaef
 */
package com.trust1t.ocs.belgianeidsigning.dto;

/**
 * The Interface ExternalAddress.
 */
public interface ExternalAddress {

	/**
	 * Gets the street and number.
	 *
	 * @return the street and number
	 */
	public abstract String getStreetAndNumber();

	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public abstract String getZip();

	/**
	 * Gets the municipality.
	 *
	 * @return the municipality
	 */
	public abstract String getMunicipality();

}