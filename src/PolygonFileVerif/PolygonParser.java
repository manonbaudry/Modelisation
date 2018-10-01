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

import javax.swing.JOptionPane;

/**
 * @author Manon
 *
 */
public class PolygonParser {
	private Result result;
	private int nbVertex;
	private int nbFaces;
	private int nbProperty;

	public PolygonParser() {
		this.result = new Result();
		this.nbFaces = 0;
		this.nbVertex = 0;
		this.nbProperty = 0;
	}

	public Result Parse(File f){
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
			br.close();
		} catch (IOException ioe) {
			result.addErrors(ioe.toString());
		}catch(LineNotFoundException e) {
			result.addErrors(e.toString());
		}
		return result;
	}

	private boolean startWith(String line, String s) throws LineNotFoundException {
		String[] split = line.split(" ");
		return split[0].equals(s);
	}

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

	public static void main(String[] args) {
		PolygonParser p = new PolygonParser();
		Result r = p.Parse(new File("ressources/dolphin.ply"));
		System.out.println(r.isValue());
		System.out.println(r.getErrors().toString());
	}
}
