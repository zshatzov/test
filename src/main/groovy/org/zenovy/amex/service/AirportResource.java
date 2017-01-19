package org.zenovy.amex.service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author zshatzov
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class AirportResource implements Serializable{	
	/**
	 * 
	 */
	@XmlTransient
	private static final long serialVersionUID = 1384237388382044063L;
	
	private String airportCode;
	private String cityOrAirportName;
	private String country;
	private String countryAbbrviation;
	private String countryCode;
	
	@XmlElement(name="GMTOffset")
	private String GMTOffset;
	private String runwayLengthFeet;
	private String runwayElevationFeet;
    private String latitudeDegree;
    private String latitudeMinute;
    private String latitudeSecond;
    private String latitudeNpeerS;
    private String longitudeDegree;
    private String longitudeMinute;
    private String longitudeSeconds;
    private String longitudeEperW; 

	public AirportResource() {
		// TODO Auto-generated constructor stub
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCityOrAirportName() {
		return cityOrAirportName;
	}

	public void setCityOrAirportName(String cityOrAirportName) {
		this.cityOrAirportName = cityOrAirportName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	

	public String getCountryAbbrviation() {
		return countryAbbrviation;
	}

	public void setCountryAbbrviation(String countryAbbrviation) {
		this.countryAbbrviation = countryAbbrviation;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getGMTOffset() {
		return GMTOffset;
	}

	public void setGMTOffset(String gMTOffset) {
		GMTOffset = gMTOffset;
	}

	public String getRunwayLengthFeet() {
		return runwayLengthFeet;
	}

	public void setRunwayLengthFeet(String runwayLengthFeet) {
		this.runwayLengthFeet = runwayLengthFeet;
	}

	public String getRunwayElevationFeet() {
		return runwayElevationFeet;
	}

	public void setRunwayElevationFeet(String runwayElevationFeet) {
		this.runwayElevationFeet = runwayElevationFeet;
	}

	public String getLatitudeDegree() {
		return latitudeDegree;
	}

	public void setLatitudeDegree(String latitudeDegree) {
		this.latitudeDegree = latitudeDegree;
	}	

	public String getLatitudeMinute() {
		return latitudeMinute;
	}

	public void setLatitudeMinute(String latitudeMinute) {
		this.latitudeMinute = latitudeMinute;
	}

	public String getLatitudeSecond() {
		return latitudeSecond;
	}

	public void setLatitudeSecond(String latitudeSecond) {
		this.latitudeSecond = latitudeSecond;
	}

	public String getLatitudeNpeerS() {
		return latitudeNpeerS;
	}

	public void setLatitudeNpeerS(String latitudeNpeerS) {
		this.latitudeNpeerS = latitudeNpeerS;
	}

	public String getLongitudeDegree() {
		return longitudeDegree;
	}

	public void setLongitudeDegree(String longitudeDegree) {
		this.longitudeDegree = longitudeDegree;
	}

	public String getLongitudeMinute() {
		return longitudeMinute;
	}

	public void setLongitudeMinute(String longitudeMinute) {
		this.longitudeMinute = longitudeMinute;
	}

	public String getLongitudeSeconds() {
		return longitudeSeconds;
	}

	public void setLongitudeSeconds(String longitudeSeconds) {
		this.longitudeSeconds = longitudeSeconds;
	}

	public String getLongitudeEperW() {
		return longitudeEperW;
	}

	public void setLongitudeEperW(String longitudeEperW) {
		this.longitudeEperW = longitudeEperW;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirportResource [airportCode=");
		builder.append(airportCode);
		builder.append(", cityOrAirportName=");
		builder.append(cityOrAirportName);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}
}
