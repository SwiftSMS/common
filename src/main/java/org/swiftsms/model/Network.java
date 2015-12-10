package org.swiftsms.model;


/**
 * Simple enum to hold the current Network operators ICC will support.
 * 
 * @author Rob Powell
 * @version 1.1
 */
public enum Network {

	EMOBILE("eMobile", "/operator_logo_emobile"),
	METEOR("Meteor", "/operator_logo_meteor"),
	O2("O2 on Three", "/operator_logo_o3"),
	TESCO("Tesco", "/operator_logo_tesco"),
	THREE("Three", "/operator_logo_three");
//	VODAFONE("Vodafone", "/operator_logo_vodafone");

	private final String network;
	private String logoLocation;

	private Network(final String network, final String logoLocation) {
		this.network = network;
		this.logoLocation = logoLocation;
	}

	/**
	 * This method returns the default logo for the network Operator.
	 * 
	 * @return The location of the Operators logo.
	 */
	public String getLogo() {
		return this.logoLocation;
	}

	@Override
	public String toString() {
		return this.network;
	}
}
