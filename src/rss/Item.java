package rss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Item class object. Include elements from RSS item.
 * @author Pawin Suthipornopas 5510546123
 */

@XmlAccessorType(XmlAccessType.FIELD)

public class Item {
	
	private String title;
	private String description;
	private String guid;
	private String link;
	private String category;
	private String pubDate;
	private String enclosure;
	
	/**
	 * Constructor. Leave blank.
	 */
	public Item(){
		
	}

	/**
	 * Below are getter and setter for corresponding elements.
	 */
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}
}
