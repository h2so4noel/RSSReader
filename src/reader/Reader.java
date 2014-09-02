package reader;

import java.net.URL;
import javax.xml.bind.*;

import rss.RSS;

/**
 * RSS Reader class. Read in RSS Url and unmarshalling into objects.
 * @author Pawin Suthipornopas 5510546123
 */

public class Reader {
	
	/**
	 * Constructor. Simply create the reader and leave blank.
	 */
	public Reader(){

	}
	
	/**
	 * Fetch in the URL and unmarshall and return as RSS object.
	 * @param url designated the rss feed file
	 * @return rss object from the input url
	 * @throws JAXBException
	 */
	public RSS getRSS(URL url) throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance(RSS.class);
		Unmarshaller um = ctx.createUnmarshaller();
		RSS rss = (RSS) um.unmarshal(url);
		return rss;
	}
}
