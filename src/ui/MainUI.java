package ui;
/**
 * Main fram UI for RSSReader windows app.
 * @author Pawin Suthipornopas 5510546123
 */

import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.*;

import reader.Reader;
import rss.RSS;

public class MainUI extends JFrame implements Runnable {
	
	JPanel urlPanel = new JPanel();
	JPanel linkPanel = new JPanel();
	JPanel channelPanel = new JPanel();
	JPanel itemPanel = new JPanel();
	
	JLabel urlLabel = new JLabel("URL:");
	JTextField urlField = new JTextField(30);
	JButton urlButton = new JButton("Fetch");
	
	JEditorPane channelLink = new JEditorPane();
	JTextArea channelArea = new JTextArea(10,10);
	JScrollPane scrollPane = new JScrollPane(channelArea);
	
	JScrollPane itemScrollPane = new JScrollPane(itemPanel);
	
	URLListener listener = new URLListener();
	
	Reader reader = new Reader();
	RSS rss;
	
	/**
	 * Main method. Just set close operation. Doing nothing else.
	 */
	public MainUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		initComponents();
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Initiate all required components.
	 */
	private void initComponents(){
		this.setTitle("RSSReader Alpha");
		final Container container = this.getContentPane(); 
		container.setLayout( new BoxLayout(container, BoxLayout.PAGE_AXIS) );
		
		urlButton.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				try {
					URL url = new URL(urlField.getText());
					rss = reader.getRSS(url);
					setChannelArea();
					setItemArea();
				} catch (Exception e1) {
					System.out.println("URL Error");
				}
			}
		});
		
		itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.PAGE_AXIS));
		channelPanel.setLayout(new FlowLayout());
		
		urlPanel.add(urlLabel);
		urlPanel.add(urlField);
		urlPanel.add(urlButton);
		
		channelLink.setEditable(false);
		channelLink.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
		channelLink.setText("<Channel Title>");
		channelLink.setPreferredSize(new Dimension(200, 30));
		linkPanel.setPreferredSize(new Dimension(200, 30));
		linkPanel.add(channelLink);
		
		channelArea.setEditable(false);
		channelArea.setWrapStyleWord(true);
		channelArea.setLineWrap(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(400, 150));
		channelPanel.add(scrollPane);
		
		itemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		itemScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		itemScrollPane.setPreferredSize(new Dimension(300, 500));
		itemScrollPane.setAutoscrolls(false);
		
		container.add(urlPanel);
		container.add(new JLabel("Channel Info"));
		container.add(linkPanel);
		container.add(channelPanel);
		container.add(new JLabel("Item List"));
		container.add(itemScrollPane);
	}
	
	/**
	 * Initialize the Channel Information.
	 */
	private void setChannelArea(){
		channelLink.setText("<a href=\"" + rss.getChannel().getLink() + "\">" + rss.getChannel().getTitle() + "</a>");
		channelLink.addHyperlinkListener(listener);
		channelArea.setText(rss.getChannel().getTitle() + "\n" +
							rss.getChannel().getLink() + "\n" +
							rss.getChannel().getDescription() + "\n" +
							rss.getChannel().getPubDate() + "\n" +
							rss.getChannel().getTtl() + "\n" +
							rss.getChannel().getImage());
	}
	
	/**
	 * Initialize the Item Area list information.
	 */
	private void setItemArea(){
		itemPanel.removeAll();
		for(int i = 0; i < rss.getChannel().getItems().size(); i++){
			JEditorPane itemPane = new JEditorPane();
			itemPane.setEditable(false);
			itemPane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
			itemPane.setText("<a href=\"" + rss.getChannel().getItems().get(i).getLink() + "\">" + rss.getChannel().getItems().get(i).getTitle() + "</a>");
			itemPane.addHyperlinkListener(listener);
			itemPanel.add(itemPane);
			JTextArea itemArea = new JTextArea(rss.getChannel().getItems().get(i).getDescription());
			itemArea.setWrapStyleWord(true);
			itemArea.setLineWrap(true);
			itemPanel.add(itemArea);
		}
	}
}
