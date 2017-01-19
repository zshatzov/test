package org.zenovy.amex.service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * A <em>POJO</em> that holds a currency information for a particular country.
 * </p>
 * 
 * 
 * @author zshatzov
 *
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4789153384918779990L;
	
	private String name;
	private String countryCode;
	private String currency;
	private String currencyCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CountryResource [name=");
		builder.append(name);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append("]");
		return builder.toString();
	}
}
