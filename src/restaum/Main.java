package restaum;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;

import restaum.views.Principal;

public class Main {

	public static void main(String[] args) throws IOException {

		Principal p = new Principal();
		
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setPreferredSize(new Dimension(500, 500));
		p.setResizable(false);
		p.pack();
		p.setVisible(true);
	

	}
}
