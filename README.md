**Unit Conversion Program Readme**
**Overview**
This Java program is a unit conversion tool that allows users to convert values between different units of measurement. The program supports various unit types, including length, mass, time, pressure, volume, force, and energy. Users can enter conversion requests in the format "amount unit1 to unit2" or simply "amount unit1" for unit conversion without specifying the target unit.

**Features**
Unit Definitions:
The program reads unit definitions from external files for different unit types. These files, such as "Length_Units," "Mass_Units," etc., contain information about unit names, types, and conversion factors.

Conversion Logic:
The conversion logic handles different scenarios, including basic unit conversions, area and volume calculations, and compound conversions involving multiplication and division of units.

Input and Termination:
Users can interactively enter conversion requests in the console. The program continues to prompt the user until the input "xxx" is provided, at which point the program terminates.

**Usage**
Input Format:

To convert between units: Enter the amount, source unit, and target unit in the format "amount unit1 to unit2" (e.g., "5 m to cm").
For basic unit conversion: Enter the amount and source unit without specifying the target unit (e.g., "5 m").
Termination:

To terminate the program, enter "xxx" during the input prompts.

**Files**
The program consists of the following files:

Main.java:

Contains the main program logic.
Handles user input, unit conversion, and file loading.
Unit.java:

Defines the Unit class, representing a unit with a name, type, and conversion factor.
**External Files**
The program loads unit definitions from external files (e.g., "Length_Units," "Mass_Units," etc.). Each file follows a specific format, providing information about different units.

**Error Handling**
The program handles errors gracefully, such as invalid numeric input and unknown units.
Future Improvements
The program can be extended to support additional unit types and conversions.
Improved error messages and user prompts can enhance the user experience.
**Contributors**
[Your Name]
Version History
v1.0: Initial release
**License**
This program is released under the MIT License. Feel free to modify and distribute it as needed.

**Acknowledgments**
Special thanks to contributors and resources that inspired or supported the development of this unit conversion program.
