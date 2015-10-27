package restaum.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import restaum.core.Dados;

public class Tabuleiro extends JPanel implements ActionListener {
	
	static final int TOTAL = 7;

	HashMap<String,JButton> hashButtons = new HashMap<String,JButton>();
	
	Dados dados = new Dados();
	
	String selectedKey = null;
	  
	public Tabuleiro() {
		
		this.setLayout( new GridLayout(7,7) );
		this.setBackground(Color.BLACK);
		
		this.createButtons();
	
	}
	
	private void createButtons() {
		
		int total = TOTAL;
		int xIndex = -1;
		int yIndex;
		 
		String key;
		String val;
		while( ++xIndex < total ) {
			yIndex = -1;
			while( ++yIndex < total ) {
				key = Dados.encodeKey( xIndex , yIndex );
				val = this.getInitialValue(key);
				
				Pecas peca = new Pecas(val);
				peca.setActionCommand(key);
				peca.addActionListener(this); //event listener
				this.add(peca); // add painel
				this.hashButtons.put(key, peca );
				
				// Preenche o vetor 
				this.dados.vetor[xIndex][yIndex] = val;
			}
		}
		
		// Verifica as Posicoes Validas
		this.dados.gerarPosicoesValidas();
	}
	
	
	private String getInitialValue( String key ) {
		if ( "|0,0|0,1|0,5|0,6|1,0|1,1|1,5|1,6|5,0|5,1|5,5|5,6|6,0|6,1|6,5|6,6".indexOf(key) != -1 ) {
			return "-1";
		}
		if ( key.equals("3,3") ) {
			return "0";
		}
		return "1";		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String key = ((JButton) e.getSource()).getActionCommand();
	    Pecas button = (Pecas)this.hashButtons.get(key);
	    if (null != button) {
	    	
	    	int keys[] = Dados.decodeKey(key);
	        String value = this.dados.getValorDaPosicao(keys[0], keys[1]);
	        // Seleciona a Origem
	    	if( value == "0" ) {
	    		this.trocarPecas(key, button);
	    	} else {
	    		this.selecionarUmaPeca(key, button);
	    		
	    	}
	    	
		    // VERIFICA SE TEM POSICOES VALIDAS
		    if ( false == this.dados.possuiPosicoesValidas() ) {
		    	System.out.println("GAME OVER");
		    }
	    }	
	    
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
}

	


