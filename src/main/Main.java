package main;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import reader.Reader;
import rss.RSS;
import ui.MainUI;
/**
 * Main class for RSSReader.
 * @author Pawin Suthipornopas 5510546123
 */
public class Main {
	/**
	 * Main class. Initiate and run stuff.
	 * @param args is not used.
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		MainUI ui = new MainUI();
		ui.run();
	}
}
