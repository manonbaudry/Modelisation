/**
 * 
 */
package PolygonFileVerif;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Groupe O3
 *
 */
public class PolygonParser {
	private Result result;
	private int nbVertex;
	private int nbFaces;
	private int nbProperty;
	private int headerLength;

	public PolygonParser() {
		this.result = new Result();
		this.nbFaces = 0;
		this.nbVertex = 0;
		this.nbProperty = 0;
		this.headerLength = 0;
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Result parse(File f){
		int idx = 1;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			line = br.readLine();
			if (!line.equals("ply")) {
				result.setValue(false);
				result.addErrors("Erreur sur la première ligne");
			}
			line = br.readLine();
			
			//Parcours du header
			while (!line.equals("end_header")) {
				idx++;
				if (startWith(line, "format")) {
					result.setValue(result.isValue() && validateFormat(line, idx));
				} else if (startWith(line, "property")) {
					result.setValue(result.isValue() && validateProperty(line, idx));
				} else if (startWith(line, "element")) {
					result.setValue(result.isValue() && validateElement(line, idx));
				}
				line = br.readLine();
			}
			
			line = br.readLine();
			idx++;
			headerLength = idx;
			idx = 0;
			
			//parcours body
			while (idx< (nbVertex+nbFaces)) {
				if (idx <= nbVertex) {
					if(idx!=nbVertex) 
					result.setValue(result.isValue() && validateVertex(line, idx));
					
				} else if (idx < (nbVertex+nbFaces)) {
					result.setValue(result.isValue() && validateFace(line, idx));
				}
				line = br.readLine();
				idx++;
			}	
			
			br.close();
			
		} catch (IOException ioe) {
			result.addErrors(ioe.toString());
		}catch(IndexOutOfBoundsException e) {
			result.addErrors(e.toString());
		}catch(NullPointerException npe) {
			result.addErrors("end-header not found");
		}
		System.out.println(nbProperty+"");
		return result;
	}

	/**
	 * 
	 * @param line
	 * @param s
	 * @return
	 */
	private boolean startWith(String line, String s) {
		try {
			String[] split = line.split(" ");
			return split[0].equals(s);	
		}catch (IndexOutOfBoundsException e) {
			result.addErrors("The line doesn't exist");
			return false;
		}
	}
	/**
	 * 
	 * @param line
	 * @param idx
	 * @return
	 */
	private boolean validateFormat(String line, int idx) {
		if (idx != 2) {
			result.addErrors("Format header is not at the correct position");
			return false;
		} else if (!line.equals("format ascii 1.0")) {
			result.addErrors("Format header is wrong");
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @param line
	 * @param idx
	 * @return
	 */
	private boolean validateProperty(String line, int idx) {
		String[] split = line.split(" ");
		if (line.equals("property list uint8 int32 vertex_indices")) {
			return true;
		}
		if ((split[1].equals("float32") || split[1].equals("float")) && split[2].matches("[x-z]*")) {
			nbProperty++;
			return true;
		}
		result.addErrors("property header is wrong");
		return false;
	}
	
	/**
	 * 
	 * @param line
	 * @param idx
	 * @return
	 */
	private boolean validateElement(String line, int idx) {
		if (idx != 3 && idx != 7) {
			result.addErrors("Element header is not at the correct position");
			return false;
		}
		String[] split = line.split(" ");
		if (split[1].equals("vertex") && split[2].matches("[0-9]*")) {
			this.nbVertex = Integer.parseInt(split[2]);
			return true;
		} else if (split[1].equals("face") && split[2].matches("[0-9]*")) {
			this.nbFaces = Integer.parseInt(split[2]);
			return true;
		}
		result.addErrors("element header is wrong");
		return false;
	}
	
	
	public Result parseBody(File f) {
		int idx = 1;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = "";
			line = br.readLine();

			br.close();
			
		} catch (IOException ioe) {
			result.addErrors(ioe.toString());
		}catch(IndexOutOfBoundsException e) {
			result.addErrors(e.toString());
		}catch(NullPointerException npe) {
			result.addErrors("end-header not found");
		}
		return result;
		
	}

	private boolean validateFace(String line, int idx) {
		line += " ";
		if(line.matches("^([0-9]*\\ )*")) {
				return true;
		}
		result.addErrors("La face à la ligne " + (idx+headerLength) + " est incorrecte");
		return false;
	}
	
	private boolean validateVertex(String line, int idx) {
		if(line.matches("^(-?[0-9]+\\.?[0-9]*\\ ){3}$")) {
				return true;
		}
		result.addErrors("Le point à la ligne " + (idx+headerLength) + " est incorrect");
		return false;
	}
	
	public static void main(String[] args) {
		PolygonParser p = new PolygonParser();
		Result r = p.parse(new File("ressources/cube.ply"));
		System.out.println(r.isValue());
		System.out.println(r.getErrors().toString());
		 
	}
}
