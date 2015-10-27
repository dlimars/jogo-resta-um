package restaum.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;



public class Componentes {
	
	JButton logo;
	JPanel menu;
	JTextArea telaScoresText;
	
	Componentes(JButton logo, JPanel menu, JTextArea telaScoresText) {
		this.logo = logo;
		this.menu = menu;
		this.telaScoresText = telaScoresText;
	}

	public JPanel telaInicial() {
	
		JPanel panel = new JPanel();
		
		panel.setLayout( new BorderLayout() );
		
		JPanel header = new HeaderPanel();
		
		JPanel tronPanel = new JPanel();
	    tronPanel.setLayout( new GridLayout(1,0) );
	    tronPanel.setPreferredSize(new Dimension(500, 250));
	    tronPanel.add(new IconButton("tron.jpg"));
		
		JPanel content = new ContentPanel( tronPanel );
		
		panel.add( header, BorderLayout.NORTH );
		panel.add( content, BorderLayout.SOUTH );
		
		panel.setVisible(false);
		
		return panel;
		
	}
	
	public JPanel telaManual() {
		
		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );
		
		JPanel header = new HeaderPanel();
		
		JPanel inner = new JPanel();
	    inner.setBackground(Color.BLACK);
	    inner.setLayout( new BorderLayout() );
	    inner.setPreferredSize(new Dimension(500, 250));
	    JTextArea message = new JTextArea(
	        "SCORES\n" +
	        "[ 1 ] Selecione uma peça que pode pular sobre outra havendo um lugar\n" +
	          "vaga após a peça pulada. Só é permitido pular horizintalemente\n" +
	          "e verticalmente, não é permitido diagonalmente." +
	          "Ganha quando não puder mais pular peças, e quem deixar uma peça\n" +
	         "das");
	    
	    message.setWrapStyleWord(true);
	    message.setLineWrap(true);
	    message.setEditable(false);
	    message.setFocusable(false);
	    message.setForeground(Color.WHITE);
	    message.setBackground(Color.BLACK);
	       
	    JScrollPane scroll = new JScrollPane(message, 
	    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
	    scroll.setBackground(Color.BLACK);
	    inner.add( new GhostLabel(500,25), BorderLayout.NORTH );
	    inner.add( scroll, BorderLayout.CENTER );
	    inner.add( new GhostLabel(25,200), BorderLayout.EAST );
	    inner.add( new GhostLabel(25,200), BorderLayout.WEST );
	    inner.add( new GhostLabel(500,25), BorderLayout.SOUTH );
		
		JPanel content = new ContentPanel( inner );
		
		panel.add( header, BorderLayout.NORTH );
		panel.add( content, BorderLayout.SOUTH );
		
		return panel;
	
	}	
	
	public JPanel telaScores() {
		
		JPanel panel = new JPanel();
		panel.setLayout( new BorderLayout() );
		
		JPanel header = new HeaderPanel();
		
		JPanel inner = new JPanel();
		inner.setBackground(Color.BLACK);
		inner.setLayout( new BorderLayout() );
		inner.setPreferredSize(new Dimension(500, 250));

		this.telaScoresText.setText("SCORES\n");
		this.telaScoresText.setWrapStyleWord(true);
		this.telaScoresText.setLineWrap(true);
		this.telaScoresText.setEditable(false);
		this.telaScoresText.setFocusable(false);
		this.telaScoresText.setForeground(Color.WHITE);
		this.telaScoresText.setBackground(Color.BLACK);
		    
		JScrollPane scroll = new JScrollPane(this.telaScoresText, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		scroll.setBackground(Color.BLACK);
		inner.add( new GhostLabel(500,25), BorderLayout.NORTH );
		inner.add( scroll, BorderLayout.CENTER );
		inner.add( new GhostLabel(25,200), BorderLayout.EAST );
		inner.add( new GhostLabel(25,200), BorderLayout.WEST );
		inner.add( new GhostLabel(500,25), BorderLayout.SOUTH );

		JPanel content = new ContentPanel( inner );
		
		panel.add( header, BorderLayout.NORTH );
		panel.add( content, BorderLayout.SOUTH );
		
		return panel;
		
	}
	
	protected class HeaderPanel extends JPanel {
		
		HeaderPanel() {
			
			setBackground(Color.BLACK);
			setPreferredSize(new Dimension(500, 250));
			
			// top
			JPanel top = new JPanel();
			top.setBackground(Color.BLACK);
			top.setLayout( new BorderLayout() );
			top.setPreferredSize(new Dimension(500, 180));
			
		
			top.add(new GhostLabel(1,1),BorderLayout.WEST);
			top.add(Componentes.this.logo, BorderLayout.CENTER);
			top.add(new GhostLabel(1,1),BorderLayout.EAST);
				
			
			add(top, BorderLayout.NORTH);
			add(Componentes.this.menu, BorderLayout.SOUTH);
			
		}
	}
	
	protected class ContentPanel extends JPanel {
		ContentPanel( JPanel content ) {
			setBackground(Color.BLACK);
			setPreferredSize(new Dimension(500, 250));
			add(content);
		}
	}
	
	
	protected class GhostLabel extends JLabel {
		GhostLabel( int w, int h ) {
			this.setPreferredSize(new Dimension(w, h));
		}
	}
	

	protected class IconButton extends JButton {
		IconButton(String icon) {
			Icon ico = new ImageIcon("src/" + icon );
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setIcon(ico);
		}
	}

	
	
}
