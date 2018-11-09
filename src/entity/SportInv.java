//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.09 at 11:09:14 AM EET 
//

package entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SportInv complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SportInv">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/first}Entity">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.example.org/first}description"/>
 *         &lt;element name="price" type="{http://www.example.org/first}Price"/>
 *         &lt;element name="category" type="{http://www.example.org/first}Category"/>
 *         &lt;element name="CodeTovars" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9][0-9][0-9][0-9][0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SportInv", propOrder = { "name", "company", "description", "price", "category", "codeTovars" })
public class SportInv extends Entity {

	@XmlElement(required = true)
	protected String name;
	@XmlElement(required = true)
	protected String company;
	@XmlElement(required = true)
	protected String description;
	@XmlElement(required = true)
	protected double price;
	@XmlElement(required = true)
	@XmlSchemaType(name = "string")
	protected Category category;
	@XmlElement(name = "CodeTovars", defaultValue = "000000")
	protected String codeTovars;

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the company property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Sets the value of the company property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCompany(String value) {
		this.company = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the price property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the value of the price property.
	 * 
	 * @param d
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPrice(double d) {
		this.price = d;
	}

	/**
	 * Gets the value of the category property.
	 * 
	 * @return possible object is {@link Category }
	 * 
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets the value of the category property.
	 * 
	 * @param value
	 *            allowed object is {@link Category }
	 * 
	 */
	public void setCategory(Category value) {
		this.category = value;
	}

	/**
	 * Gets the value of the codeTovars property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodeTovars() {
		return codeTovars;
	}

	/**
	 * Sets the value of the codeTovars property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodeTovars(String value) {
		this.codeTovars = value;
	}

	@Override
	public String toString() {
		return "SportInv [name=" + name + ", company=" + company + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", codeTovars=" + codeTovars + "]";
	}

	
}
