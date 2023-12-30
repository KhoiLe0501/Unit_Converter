import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
	static List<Unit> unit_list = new ArrayList<>();
	static DecimalFormat format = new DecimalFormat("0.000");
	
	public static void main(String[] args) throws FileNotFoundException {
		load_file(new File("Length_Units"), "length");
		load_file(new File("Mass_Units"), "mass");
		load_file(new File("Time_Units"), "time");
		load_file(new File("Pressure_Units"), "pressure");
		load_file(new File("Volume_Units"), "volume");
		load_file(new File("Force_Units"), "force");
		load_file(new File("Energy_Units"), "energy");
		
		Scanner in = new Scanner(System.in);
		String input;
		
		System.out.println("Press xxx in 2nd or 3rd prompt to terminate\n");
		
	    do {
	        System.out.println("Please enter the amount and unit (in abbreviation) of your conversion (5 m) or (5 m to cm): ");
	        input = in.nextLine();

	        if (input.equals("xxx")) break;
	        
	        int first_space = input.indexOf(' ');
	        double base;
	        try {
	        	base = Double.parseDouble(input.substring(0, first_space));
	        } catch (NumberFormatException e) {
	        	System.out.println("ERROR! Input base is not a number.\n");
	        	continue;
	        }
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
	        
            Double converted = convert(base, from, to);
            
            if (converted != null) {
                String converted_string = format.format(converted);
            	System.out.println("There are [" + converted_string + " " + to + "] in " + base + " " + from + "\n");
            }
	    } while (!input.equals("xxx"));
	    
	    in.close();
	    
	}
	
	public static void load_file(File units, String type) throws FileNotFoundException {
		Scanner reader = new Scanner(units);
		
		while (true) {
			String line = reader.nextLine().trim();
			if (line.isEmpty()) 
				line = reader.nextLine().trim();
			if (line.equals("End of File")) 
				break;
			
			int bracket = line.indexOf('[');
			int bracket_end = line.indexOf(']');
			String name = line.substring(bracket+1, bracket_end);
			double factor = Double.parseDouble(line.substring(0, bracket-1));
			unit_list.add(new Unit(name, type, factor));
		}
		
		reader.close();
	}
		
	public static Double convert(double base, String from_name, String to_name) {
		Unit from = find_unit(from_name);
		Unit to = find_unit(to_name);
		
		if (from == null && to == null && from_name.contains("/") && to_name.contains("/")) {
			String[] arr = extract('/', from_name, to_name);
			Double upper_factor = convert(1, arr[0], arr[1]);
			Double lower_factor = convert(1, arr[2], arr[3]);
			
			if (upper_factor == null || lower_factor == null) 
				return null;
			return base * upper_factor / lower_factor;
		}
		
		if (from == null && to == null && from_name.contains("*") && to_name.contains("*")) {
			String[] arr = extract('*', from_name, to_name);
			Double upper_factor = convert(1, arr[0], arr[1]);
			Double lower_factor = convert(1, arr[2], arr[3]);
			
			if (upper_factor == null || lower_factor == null) 
				return null;
			return base * upper_factor * lower_factor;
		}
		
		if (from == null || to == null) {
			System.out.println("ERROR! Unknown unit in use");
			System.out.println("From -> " + from_name);
			System.out.println("To -> " + to_name + "\n");
			return null;
		}
		
		if (!from.getType().equals(to.getType())) {
			System.out.println("Cannot convert as dimension of units are not consistent.");
			System.out.println("From -> " + from.getType() + " [" + from.getName() + "]");
			System.out.println("To -> " + to.getType() + " [" + to.getName() + "]\n");
			return null;
		}
		
		return base / from.getFactor() * to.getFactor();
	}
	
	public static Unit find_unit(String name) {
		for (Unit i: unit_list) {
			if (i.getName().equals(name))
				return i;
		}
		return null;
	}
	
	public static String[] extract(char c, String from_name, String to_name) {
		int from_index = from_name.indexOf(c);
		int to_index = to_name.indexOf(c);
		String upper_from = from_name.substring(0, from_index);
		String upper_to = to_name.substring(0, to_index);
		String lower_from = from_name.substring(from_index + 1);
		String lower_to = to_name.substring(to_index + 1);
		return new String[] {upper_from, upper_to, lower_from, lower_to};
	}
	
}
