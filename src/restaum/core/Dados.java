package restaum.core;

import java.util.HashMap;

public class Dados {

	public String[][] vetor = new String[7][7];
	
	public HashMap<String,int[]> posicoesValidas = new HashMap<String,int[]>();
	
	public void gerarPosicoesValidas() {
		
		this.posicoesValidas = new HashMap<String,int[]>(); // sempre inicia um novo
		
		int total = 7;
		int xIndex = -1;
		int yIndex;
		while( ++xIndex < total ) {
			yIndex = -1;
			while( ++yIndex < total ) {
				this.putPosicoesValidasInHash( xIndex, yIndex );		
			}
		}
	}
	
	
	public String getValorDaPosicao( int x, int y) {
		if ( this.vetor[x][y] == null ) {
			return "";
		}
		return this.vetor[x][y];
	}
	
	public String getPosicaoEntre( String origem, String destino ) {
		
		int[] a = Dados.decodeKey(origem);
		int[] b = Dados.decodeKey(destino);

		int x = a[0] > b[0] ? a[0] - 1 : ( a[0] < b[0] ? a[0] + 1: a[0] );
		int y = a[1] > b[1] ? a[1] - 1 : ( a[1] < b[1] ? a[1] + 1: a[1] );
		
		String r = Dados.encodeKey(x, y);
		
		return r;
	}
	
	private void putPosicoesValidasInHash( int x, int y) {
		
		// coloca no hash(posicoesValidas) todas as posicoes que podem ser jogadas e seus alvos.

		int[][][] pos = {
				{ { x -1, y },  { x - 2, y } }, // top
				{ { x + 1, y }, { x + 2, y } }, // bottom
			    { { x, y - 1 }, { x, y - 2 } }, // left
			    { { x, y + 1 }, { x, y + 2 } }  // right
		};
		
		int len = pos.length;
		int a[];
		int b[];
		String key; // x + "_" + y
		String posXY;
		String posA;
		String posB;
		
		while( len-- > 0 ) {
			a = pos[len][0];
			b = pos[len][1];
			if ( false == this.isInvalidIndex(a, b ) ) {
				posXY = this.getValorDaPosicao(x, y);
				posA  = this.getValorDaPosicao(a[0], a[1]);
				posB  = this.getValorDaPosicao(b[0], b[1]);
				if( posXY == "1" &&  posA == "1" &&  posB == "0" ) {
					key = Dados.encodeKey( x , y );
					this.posicoesValidas.put(key,b);
				}
			}
		}		
	}
	
	private boolean isInvalidIndex( int[] a, int[] b) {
		int len = 7;
		return (a[0] >= len || a[0] < 0 ) || (a[1] >= len || a[1] < 0 ) ||
			   (b[0] >= len || b[0] < 0 ) || (b[1] >= len || b[1] < 0 );
	}
	
	// CHANGE
	public void changeVetor( String origem, String destino, String entre ) {
		int[] ori = Dados.decodeKey(origem);
		int[] des = Dados.decodeKey(destino);
		int[] ent = Dados.decodeKey(entre);
		
		this.vetor[ ori[0] ][ ori[1] ] = "0";
		this.vetor[ des[0] ][ des[1] ] = "1";
		this.vetor[ ent[0] ][ ent[1] ] = "0";
		
		this.gerarPosicoesValidas();
		
	}
	
	public boolean possuiPosicoesValidas() {
		return this.posicoesValidas.size() > 0;
	}
	
	//	STATIC
	public static String encodeKey( int x, int y ) {
		return x + "," + y;
	}
	
	public static int[] decodeKey( String k ) {
		String a[] = k.split(",");
		int[] xy = { Integer.parseInt(a[0]), Integer.parseInt(a[1]) };
		return xy;
	}
}	