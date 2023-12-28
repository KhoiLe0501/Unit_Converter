import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
	
	static List<Unit> unit_list = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		load_file(new File("Length_Units"), "length");
		load_file(new File("Mass_Units"), "mass");
		load_file(new File("Time_Units"), "time");
		// System.out.println(unit_list.toString());
		// convert(5, "km", "m");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Press xxx in 2nd or 3rd prompt to terminate\n");
		String input;
	    Double base = null;
		
	    do {
	        System.out.println("Please enter the amount and unit (in abbreviation) of your conversion (5 m) or (5 m to cm): ");
	        input = in.nextLine();

	        if (input.equals("xxx")) {
	            break;
	        }

	        int first_space = input.indexOf(' ');

	        base = Double.parseDouble(input.substring(0, first_space));
	        
	        String from = input.substring(first_space + 1).trim();
	        String to = null;

	        if (input.contains("to")) {
	            int to_index = input.indexOf("to");
	            from = input.substring(first_space + 1, to_index).trim();
	            to = input.substring(to_index + 3).trim();
	        } 
	        else {
	            System.out.println("Please enter the unit (in abbreviation) of your intended conversion");
	            to = in.nextLine().trim();
	        }
	        convert(base, from, to);
	    } while (!input.equals("xxx"));
	    
		in.close();
	}

	public static void load_file(File units, String type) throws FileNotFoundException {
		Scanner reader = new Scanner(units);
		List<String> name_list = new ArrayList<>();
		List<Double> factor_list = new ArrayList<>();
		
		while (true) {
			String line = reader.nextLine().trim();
			if (line.isEmpty()) line = reader.nextLine().trim();
			if (line.equals("End of File")) break;
			
			int bracket = line.indexOf('[');
			int bracket_end = line.indexOf(']');
			String name = line.substring(bracket+1, bracket_end);
			double factor = Double.parseDouble(line.substring(0, bracket-1));
			name_list.add(name);
			factor_list.add(factor);
		}
		
		for (int i=0; i < name_list.size(); i++) {
			unit_list.add(new Unit(name_list.get(i), type, factor_list.get(i)));
		}
		reader.close();
	}
	
	static DecimalFormat format = new DecimalFormat("0.000");
	
	public static void convert(double base, String from_name, String to_name) {
		Unit from = find_unit(from_name);
		Unit to = find_unit(to_name);
		double ori_base = base;
		
		if (!from.getType().equals(to.getType())) {
			System.out.println("Cannot convert as dimension of units are not consistent");
			System.out.println("From -> " + from.getType() + " [" + from.getName() + "]");
			System.out.println("To -> " + to.getType() + " [" + to.getName() + "]");
			return;
		}
		
		base = base / from.getFactor() * to.getFactor();
		String base_string = format.format(base);
		System.out.println("There are [" + base_string + " " + to.getName() + "] in " + ori_base + " " + from.getName());
	}
	
	public static Unit find_unit(String name) {
		for (Unit i: unit_list) {
			if (i.getName().equals(name))
				return i;
		}
		return null;
	}
}
