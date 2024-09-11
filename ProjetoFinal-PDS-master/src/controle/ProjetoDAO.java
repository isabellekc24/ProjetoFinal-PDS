package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Projeto;

public class ProjetoDAO {
	
	
	public void escreverArquivo(ArrayList<Projeto> lista, String nomeArquivo) {
		try {
			File arq = new File(nomeArquivo);
			arq.delete();
			arq.createNewFile();

			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			objOutput.writeObject(lista);
			objOutput.close();

		} catch (IOException erro) {
			System.out.printf("Erro: %s", erro.getMessage());
		}
	}
	
	
	
	

	public ArrayList<Projeto> lerArquivo(String nomeArquivo) {
		ArrayList<Projeto> lista = new ArrayList<Projeto>();
		try {
			File arq = new File(nomeArquivo);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				lista = (ArrayList<Projeto>) objInput.readObject();
				objInput.close();
			}
		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}
		return lista;
	}
	
	
	
}
