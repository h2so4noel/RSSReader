package rss;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Class that handles Channel object. 
 * Contains components of Channel in RSS and items as a list.
 * @author Pawin Suthipornopas 5510546123
 */

@XmlAccessorType(XmlAccessType.FIELD)

public class Channel {
	
	private String title;
	private String link;
	private String description;
	private String copyright;
	private String pubDate;
	private String ttl;
	private String image;
	
	@XmlElement(name = "item")
	private List<Item> items;
	
	/**
	 * Constructor. Leave blank.
	 */
	public Channel(){
		
	}
	
	/**
	 * Below are basic getter and setter for each elements in this channel object.
	 */

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
