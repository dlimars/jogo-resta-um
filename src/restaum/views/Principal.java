package restaum.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import restaum.core.Dados;
import restaum.core.Scores;


public class Principal extends JFrame implements ActionListener {
	
	JPanel container = new JPanel();
	
	JPanel telaInicialPanel = new JPanel();
	JPanel telaManualPanel = new JPanel();
	JPanel telaScoresPanel = new JPanel();
	JPanel telaStartPanel = new JPanel();
	JPanel telaGamePanel; 
	
	JTextArea telaScoresText = new JTextArea();
	Scores scores;
	Integer pontos = 0;
	
	Dados dados = new Dados();
	HashMap<String,JButton> hashButtons = new HashMap<String,JButton>();
	String selectedKey = null;
	
	
	
	public Principal() throws IOException {
		
		super("Resta Um");
		
		this.container.setLayout( new BorderLayout() );
		this.container.setBackground(Color.BLACK);
		this.container.setPreferredSize(new Dimension(500, 500));

		this.telaInicial();
		this.telaManual();	
		this.telaScores();	
		this.telaStart();
		this.telaGame();
		
		this.setPanel("init");
		
		this.add(this.container);
		
		 this.scores = new Scores();
			
	}
	
	public void gameOver() throws IOException {
		
		this.scores.addScore("Macachera", (this.pontos * 100) );
		this.setPanel("scores");
		System.out.println("batman");
		
		
	}
	
	public void setPanel( String panel ) {
		
		switch(panel) {
		case "start":
			
			this.telaGame();
			this.telaInicialPanel.setVisible(false);
			this.telaManualPanel.setVisible(false);
			this.telaScoresPanel.setVisible(false);
//			this.telaStartPanel.setVisible(false);
			this.telaGamePanel.setVisible(true);
			
			break;
//		case "game":
//			this.telaInicialPanel.setVisible(false);
//			this.telaManualPanel.setVisible(false);
//			this.telaScoresPanel.setVisible(false);
//			this.telaStartPanel.setVisible(true);
//			this.telaGamePanel.setVisible(false);
//			break;			
		case "manual": 
			this.telaInicialPanel.setVisible(false);
			this.telaManualPanel.setVisible(true);
			this.telaScoresPanel.setVisible(false);
//			this.telaStartPanel.setVisible(false);
			this.telaGamePanel.setVisible(false);
			break;
		case "scores": 
			
			ArrayList<String> scores = this.scores.getScores();
			String[] aux;
			String text = "";
			for( String s: scores ) {
				text += s + "\n";
			}
			this.telaScoresText.setText(text);
		
			this.telaInicialPanel.setVisible(false);
			this.telaManualPanel.setVisible(false);
			this.telaScoresPanel.setVisible(true);
//			this.telaStartPanel.setVisible(false);
			this.telaGamePanel.setVisible(false);
			break;	
		default:
			this.telaInicialPanel.setVisible(true);
			this.telaManualPanel.setVisible(false);
			this.telaScoresPanel.setVisible(false);
//			this.telaStartPanel.setVisible(false);
			this.telaGamePanel.setVisible(false);
		}
	}
	
	private void telaInicial() {
		
		this.telaInicialPanel.setLayout( new BorderLayout() );
		
		JPanel header = new HeaderPanel();
		
		JPanel tronPanel = new JPanel();
	    tronPanel.setLayout( new GridLayout(1,0) );
	    tronPanel.setPreferredSize(new Dimension(500, 250));
	    tronPanel.add(new IconButton("tron.jpg"));
		
		JPanel content = new ContentPanel( tronPanel );
		
		this.telaInicialPanel.add( header, BorderLayout.NORTH );
		this.telaInicialPanel.add( content, BorderLayout.SOUTH );
		
		this.telaInicialPanel.setVisible(false);
		
		this.container.add(this.telaInicialPanel, BorderLayout.NORTH);
		
	}
	
	private void telaManual() {
		
		this.telaManualPanel.setLayout( new BorderLayout() );
		
		JPanel header = new HeaderPanel();
		
		JPanel panel = new JPanel();
	    panel.setBackground(Color.BLACK);
	    panel.setLayout( new BorderLayout() );
	    panel.setPreferredSize(new Dimension(500, 250));
	    JTextArea message = new JTextArea(
	        "SCORES\n" +
	        "[ 1 ] Selecione uma peça que pode pular sobre outra havendo um lugar\n" +
	          "vaga após a peça pulada. Só é permitido pular horizintalemente\n" +
	          "e verticalmente, não é permitido diagonalmente." +
	          "Ganha quando não puder mais pular peças, e quem deixar uma peça\n" +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
	          "no meio do tabuleiro é o mais ralado." +
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
	    panel.add( new GhostLabel(500,25), BorderLayout.NORTH );
	    panel.add( scroll, BorderLayout.CENTER );
	    panel.add( new GhostLabel(25,200), BorderLayout.EAST );
	    panel.add( new GhostLabel(25,200), BorderLayout.WEST );
	    panel.add( new GhostLabel(500,25), BorderLayout.SOUTH );
		
		JPanel content = new ContentPanel( panel );
		
		this.telaManualPanel.add( header, BorderLayout.NORTH );
		this.telaManualPanel.add( content, BorderLayout.SOUTH );
		
		this.container.add(this.telaManualPanel, BorderLayout.EAST);
		
	}
	
	private void telaScores() {
		
		this.telaScoresPanel.setLayout( new BorderLayout() );
		
		JPanel header = new HeaderPanel();
		
		JPanel panel = new JPanel();
	    panel.setBackground(Color.BLACK);
	    panel.setLayout( new BorderLayout() );
	    panel.setPreferredSize(new Dimension(500, 250));
	    
	    
	    this.telaScoresText.setText("SCORES\n");
	    this.telaScoresText.setWrapStyleWord(true);
	    this.telaScoresText.setLineWrap(true);
	    this.telaScoresText.setEditable(false);
	    this.telaScoresText.setFocusable(false);
	    this.telaScoresText.setForeground(Color.WHITE);
	    this.telaScoresText.setBackground(Color.BLACK);
	        
        JScrollPane scroll = new JScrollPane(this.telaScoresText, 
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setBackground(Color.BLACK);
	    panel.add( new GhostLabel(500,25), BorderLayout.NORTH );
	    panel.add( scroll, BorderLayout.CENTER );
	    panel.add( new GhostLabel(25,200), BorderLayout.EAST );
	    panel.add( new GhostLabel(25,200), BorderLayout.WEST );
	    panel.add( new GhostLabel(500,25), BorderLayout.SOUTH );
		
		JPanel content = new ContentPanel( panel );
		
		this.telaScoresPanel.add( header, BorderLayout.NORTH );
		this.telaScoresPanel.add( content, BorderLayout.SOUTH );
		
		this.container.add(this.telaScoresPanel, BorderLayout.WEST);
		
	}
	
	private void telaStart() {
		
		
		
	}
	
	
	private void telaGame() {
		
		this.telaGamePanel = new JPanel();
		this.telaGamePanel.setLayout( new GridLayout(7,7) );
		this.telaGamePanel.setBackground(Color.BLACK);
	
		// Criando os Botoes
		int total = 7;
		int xIndex = -1;
		int yIndex;
		 
		String key;
		String val;
		while( ++xIndex < total ) {
			yIndex = -1;
			while( ++yIndex < total ) {
				key = Dados.encodeKey( xIndex , yIndex );
				val = Principal.getInitialValue(key);
				
				Pecas peca = new Pecas(val);
				peca.setActionCommand(key);
				peca.addActionListener(this); //event listener
				this.telaGamePanel.add(peca); // add painel
				this.hashButtons.put(key, peca );
				
				// Preenche o vetor 
				this.dados.vetor[xIndex][yIndex] = val;
			}
		}
		
		// Verifica as Posicoes Validas
		this.dados.gerarPosicoesValidas();
		
		
		this.container.add(this.telaGamePanel, BorderLayout.CENTER);
	}	
	
	private static String getInitialValue( String key ) {
		if ( "|0,0|0,1|0,5|0,6|1,0|1,1|1,5|1,6|5,0|5,1|5,5|5,6|6,0|6,1|6,5|6,6".indexOf(key) != -1 ) {
			return "-1";
		}
		if ( key.equals("3,3") ) {
			return "0";
		}
		return "1";		
	}
	
	private void trocarPecas( String key, Pecas button ) {
		
		if( this.selectedKey != null) {
    		
    		String entreKey = this.dados.getPosicaoEntre(selectedKey,key);
    		Pecas selected = (Pecas)this.hashButtons.get(this.selectedKey);
    		Pecas entre = (Pecas)this.hashButtons.get(entreKey);
    		
    		button.setIconDefault();
    		selected.setIconEmpty();
    		entre.setIconEmpty();
    		
    		this.dados.changeVetor(this.selectedKey, key, entreKey);
    		
    		this.selectedKey = null;
    	}
	}
	
	private void selecionarUmaPeca(  String key, Pecas button ) {
		if ( this.dados.posicoesValidas.containsKey(key) ) {
        	if( this.selectedKey != null) {
        		Pecas selected = (Pecas)this.hashButtons.get(this.selectedKey);
        		selected.setIconDefault();
        	}
    		this.selectedKey = key;
    		button.setIconSelected();
    	}
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
			
			JButton logo = new IconButton("logo.jpg");
			
			top.add(new GhostLabel(1,1),BorderLayout.WEST);
			top.add(logo, BorderLayout.CENTER);
			top.add(new GhostLabel(1,1),BorderLayout.EAST);
			
			// menu
			JPanel menu = new JPanel();
			menu.setBackground(Color.BLACK);
			menu.setLayout( new BorderLayout() );
			menu.setPreferredSize(new Dimension(500, 70));
			
			JButton start  = new IconButton("start.jpg");
			JButton manual = new IconButton("manual.jpg");
			JButton scores = new IconButton("scores.jpg");
			
			logo.setActionCommand("init");
		    logo.addActionListener(Principal.this);
			
			start.setActionCommand("start");
		    start.addActionListener(Principal.this);
		      
		    manual.setActionCommand("manual");
		    manual.addActionListener(Principal.this);
		      
		    scores.setActionCommand("scores");
		    scores.addActionListener(Principal.this);
			
			menu.add(manual, BorderLayout.WEST);
			menu.add(start, BorderLayout.CENTER);
			menu.add(scores, BorderLayout.EAST);
			
			add(top, BorderLayout.NORTH);
			add(menu, BorderLayout.SOUTH);
			
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
	
	
	private class IconButton extends JButton {
		IconButton(String icon) {
			Icon ico = new ImageIcon("src/" + icon );
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setIcon(ico);
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		String command = "";
		command = ((JButton) e.getSource()).getActionCommand();
		
		System.out.println(command);
		
		switch(command) {
			case "init":
			case "start":
			case "manual":
			case "scores":
				this.setPanel(command);
				break;
			default:
			try {
				this.turnGame(command);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void turnGame( String key ) throws IOException {
	    Pecas button = (Pecas)this.hashButtons.get(key);
	    if (null != button) {
	    	
	    	int keys[] = Dados.decodeKey(key);
	        String value = this.dados.getValorDaPosicao(keys[0], keys[1]);
	        // Seleciona a Origem
	    	if( value == "0" ) {
	    		this.pontos++;
	    		this.trocarPecas(key, button);
	    	} else {
	    		this.selecionarUmaPeca(key, button);
	    		
	    	}
		    // VERIFICA SE TEM POSICOES VALIDAS
		    if ( false == this.dados.possuiPosicoesValidas() ) {
		    	System.out.println("GAME OVER");
		    	this.gameOver();
		    }
	    }	
	}
	
	
 
	
}
