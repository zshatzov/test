package org.zenovy.amex.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.zenovy.amex.service.CountryResource;

/**
 * 
 * @author zshatzov
 *
 */
@XmlRootElement(name="NewDataSet") 
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryDataSet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -660122716285514710L;
	
	@XmlElement(name="Table")
	private List<CountryResource> dataSet = new ArrayList<>();

	public List<CountryResource> getDataSet() {
		return dataSet;
	}

	public void setDataSet(List<CountryResource> dataSet) {
		this.dataSet = dataSet;
	}
}
