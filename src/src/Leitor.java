package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class Leitor extends Thread {
	public void run() {
		
	}
	public ArrayList leia(File x) {
		FileReader c;
		ArrayList<String> lista = new ArrayList();
		try {
			c = new FileReader(x);
			BufferedReader leitor = new BufferedReader(c);
			String str;
			while((str = leitor.readLine()) != null){
		        lista.add(str);
		        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
