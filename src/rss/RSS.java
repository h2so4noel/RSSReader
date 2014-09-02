package rss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class that handles RSS object. Includes Channel element.
 * @author Pawin Suthipornopas 5510546123
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class RSS {
	
	@XmlElement(name = "channel")
	private Channel channel;
	
	/**
	 * Constructor. Leave blank.
	 */
	public RSS(){
		
	}
	
	/**
	 * Get method for Channel element from this Rss object.
	 * @return this object's channel.
	 */
	public Channel getChannel(){
		return this.channel;
	}
	
	/**
	 * Set method of this object's Channel element.
	 * @param channel
	 */
	public void setChannel(Channel channel){
		this.channel = channel;
	}
}
