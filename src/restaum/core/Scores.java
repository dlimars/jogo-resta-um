package restaum.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Scores {

	HashMap<String,Integer> datas = new HashMap<String,Integer>();
	
	public Scores() throws IOException {
		this.loadDatas();
	}
	
	public void addScore( String name, int score ) throws IOException {
		this.datas.put(name, score);
		this.saveDatas();
		this.loadDatas();
	}
	
	public ArrayList<String> getScores() {
		
		HashMap<String,Integer> hash = this.datas;
		ArrayList<String> rankToPrint = new ArrayList<String>();
		String[] rank = new String[3];
		int i = -1;
		int t = 3;
		String name = "";
		int gt = 0;
		while( ++i < t ) {
			name = "";
			gt = 0;
			for (String key : hash.keySet()) {
				if( false == Arrays.asList(rank).contains(key) ) {
					if ( hash.get(key) > gt ) {
						gt = hash.get(key);
						name = key;
					}
				}
			}
			rank[i] = name;
			rankToPrint.add( (i+1) + " " + name + " = " + gt );
		}
		
		return rankToPrint; 
	}
	

	private void loadDatas() throws IOException {
		InputStream in = new FileInputStream("src/restaum/storage/scores.txt");
		Reader r       = new InputStreamReader(in);
		int i;
		String c = "";
		while ((i = r.read()) != -1) {
			c += (char)i;
		}
		String[] lines = c.split("\n");
		for( String s: lines) {
			String[] val = s.split("[(|)*]");
			this.datas.put(val[0], Integer.parseInt(val[1]));
		}
	}
	
	private void saveDatas() throws IOException {
		OutputStream out = new FileOutputStream("src/scores.txt");
		Writer w         = new OutputStreamWriter(out);
		String s;
		for( String key: this.datas.keySet() ) {
			s = key + "|" + this.datas.get(key);
			w.write( s + "\n");
		}
		w.close();
	}
	
}
