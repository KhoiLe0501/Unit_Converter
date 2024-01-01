This Java program is a flexible unit conversion tool designed to convert various physical quantities, including length, mass, time, pressure, volume, force, energy, and power. The program is equipped to handle complex unit conversions, support arithmetic operations, and recognize metric prefixes. The README provides information on how to use the program, its file structure, and advanced features.

**Usage Instructions**

Compile and Run:

Compile the program using a Java compiler.
Run the compiled program.
Input Format:

Enter the amount and unit for conversion (e.g., "5 m").
Optionally, use the "to" keyword to specify the target unit (e.g., "5 m to cm").
Enter "xxx" in the 2nd or 3rd prompt to terminate the program.

Example Usage
plaintext
Please enter the amount and unit (in abbreviation) of your conversion (5 m) or (5 m to cm):
5 m to cm
There are [500.000 cm] in 5.0 m

**File Structure**

**Main.java:**

The main class containing the program logic.
Loads unit conversion factors from files.

**Unit.java:**

Represents a unit with a name, type, and conversion factor.

**Length_Units, Mass_Units, Time_Units, Pressure_Units, Volume_Units, Force_Units, Energy_Units, Power_Units:**

Files containing unit conversion factors for different quantities.

**Metric:**

File containing metric prefixes and their conversion factors.
Program Flow

**Load Files:**

Reads unit conversion factors from separate files for different quantities.

**User Interaction:**

Takes user input for the amount and units.
Parses input to identify the source and target units.

**Conversion:**

Utilizes conversion factors to perform unit conversion.

**Display Result:**

Displays the converted amount and unit.

**Advanced Features**

Supports basic arithmetic operations for complex unit conversions (e.g., cm^3 to m^2).
Recognizes metric prefixes for both source and target units.

**Note**

Explore different unit conversions and provide feedback for further improvements!
This program can be extended for additional unit types by creating new files with conversion factors.
Feel free to experiment with various conversions and enjoy the flexibility of this unit conversion tool!
