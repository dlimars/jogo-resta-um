package restaum.views;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Pecas extends JButton {

	private Icon ico;
	
	Pecas( String type ) {
		super(type);
		this.setSize(60, 60);
		this.setBorderPainted(false);
		
		switch(type) {
		case "0":
		case "1":
			String icon = type == "0" ? "empty" : "button"; 
			this.setIcon( icon );		
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
		}
	}
	
	public void setIconDefault() {
		this.setIcon("button");
	}
	
	public void setIconSelected() {
		this.setIcon("selected");
	}
	
	public void setIconEmpty() {
		this.setIcon("empty");
	}
	
	private void setIcon( String icon ) {
		this.ico = new ImageIcon("src/"+ icon +".jpg");
		this.setIcon( this.ico );
	}
	
	
}
