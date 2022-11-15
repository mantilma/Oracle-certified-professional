package ocp.chapter8.io.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleSample {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a value :");
        BufferedReader br = new BufferedReader(
                new InputStreamReader( System.in ));
        String str = br.readLine();
        System.out.println(str); 
		InputStream in = System.in;

	}

}
