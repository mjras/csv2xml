import java.io.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;


public class cvs2xml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// schedule on the event dispatch thread
		
		String cvs_source = "AO-malaria-Kenya-v2.csv";
		//String cvs_source = "Options-Banjul.csv";
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(cvs_source));
			String line;
			line = input.readLine();		// first line empty
			
			
			while (line != null) {
											 
				//line = input.readLine();		// second line contains case id or location
			
				String location = line;
				line = input.readLine();		// third line contains elements
		    
				String [] elements = line.split(";");
				//String [] elements = line.split("\\//");
				int count_i = elements.length;
				for (int i=0;  i<count_i; i++) {
					System.out.println("token " + i + " is " + elements[i]);
				}
			
				String target = new String (location + ".xml");
				FileWriter fw = new FileWriter (target, true);
				fw.write("<" + location + ">"  + "\n");
			
				line = input.readLine();		// remaining lines contain options
			
				while ( line != null &&  line.trim().length()!=0)	{
					String [] values = line.split(";");
					
					//String [] values = line.split("\\//");
					// declare the option as an element
					fw.write("<adaptation_option>\n");
					
					for (int i=0; i<values.length; i++) {
						fw.write("<" + elements[i] + ">");
						System.out.println("reading element ..." + elements[i] + " value ..." + values[i]);
						fw.write(values[i]);
						fw.write("</" + elements[i] + ">" + "\n");
					
					}
					// close the element tag
					fw.write("</adaptation_option>\n");
					
					//if (line.trim().length()!=0) System.out.println("non-Empty line");
					System.out.println("exited while ...");
					line = input.readLine();		// read next line
				}
				//end of case
				System.out.println("reached end of case");
				fw.write("</" + location + ">"  + "\n");
				// flush
				fw.flush();
			}	
		
		
		} catch (Exception e) {
		System.out.println("Exception reading input file");
		System.out.println(e.getMessage());	
	}
		;
	
	}
	
	
	
}