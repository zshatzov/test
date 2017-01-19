package org.zenovy.amex.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.zenovy.amex.service.AirportResource;

/**
 * 
 * @author zshatzov
 *
 */
@XmlRootElement(name="NewDataSet") 
@XmlAccessorType(XmlAccessType.FIELD)
public class AirportDataSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7155693213525667451L;
	 
	@XmlElement(name="Table")
	private List<AirportResource> dataSet =  new ArrayList<>();

	public AirportDataSet() {
		// TODO Auto-generated constructor stub
	}

	public List<AirportResource> getDataSet() {
		return dataSet;
	}

	public void setDataSet(List<AirportResource> dataSet) {
		this.dataSet = dataSet;
	}
}
