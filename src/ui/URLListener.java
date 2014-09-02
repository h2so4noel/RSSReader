package ui;

import java.awt.Desktop;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * URL Listener for user interface to open the default browser.
 * @author Pawin Suthipornopas 5510546123
 */

public class URLListener implements HyperlinkListener {

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
        	if(Desktop.isDesktopSupported()) {
        	    try {
					Desktop.getDesktop().browse(e.getURL().toURI());
				} catch (Exception e1){
					System.out.println("Link Error");
				}
        	}
        }
	}

}
