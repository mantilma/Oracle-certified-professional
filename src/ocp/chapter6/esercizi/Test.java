package ocp.chapter6.esercizi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// ESERCIZIO 3
		try {
			throw new FileNotFoundException();
		}
		catch (FileNotFoundException | RuntimeException e) {
			
		}

	}

}
