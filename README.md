# JavaFX Calculator

A fully functional calculator application built with JavaFX, featuring basic and advanced mathematical operations, memory functions, theme switching, and calculation history tracking.

![Calculator Main Interface](screenshots/Screenshot%202026-05-01%20at%2022.25.01.png)

## 📋 Overview

This JavaFX Calculator is a comprehensive desktop application that provides users with a complete set of calculator functionalities. The application features an intuitive graphical user interface with a 7x4 button grid layout, real-time display of calculations, memory storage capabilities, and a history log of all performed operations.

## ✨ Features

### Basic Operations
- **Arithmetic Operations**: Addition (+), Subtraction (-), Multiplication (×), Division (÷)
- **Decimal Support**: Enter decimal numbers with automatic validation (prevents multiple decimal points)
- **Clear Functions**: 
  - **C (Clear)**: Resets all values and clears the display
  - **CE (Clear Entry)**: Clears only the current input
  - **← (Backspace)**: Removes the last entered digit

### Advanced Operations
- **Power (^)**: Raises a number to any power
- **Square Root (√)**: Calculates the square root of a number

### Memory Functions
- **M+ (Memory Add)**: Adds the current value to memory
- **M- (Memory Subtract)**: Subtracts the current value from memory
- **MR (Memory Recall)**: Recalls the stored memory value
- **MC (Memory Clear)**: Clears the memory

### User Interface Features
- **Theme Switching**: 
  - **Light Mode**: Default bright theme
  - **Dark Mode**: Dark background with white text
  - **Off Mode**: Simulates turning off the calculator
- **Calculation History**: Displays all completed operations in a scrollable text area
- **Memory Display**: Shows the current value stored in memory
- **Color-Coded Buttons**: 
  - Clear buttons (C, CE, ←) in peach color
  - Memory buttons (M+, M-, MR, MC) in blue
  - Theme buttons with custom colors

<div align="center">

### Calculator in Action

<table>
  <tr>
    <td align="center">
      <img src="screenshots/Screenshot%202026-05-01%20at%2022.25.07.png" alt="Basic Calculation" width="400"/>
      <br />
      <em>Basic arithmetic operations</em>
    </td>
    <td align="center">
      <img src="screenshots/Screenshot%202026-05-01%20at%2022.25.16.png" alt="Advanced Operations" width="400"/>
      <br />
      <em>Advanced operations with history</em>
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="screenshots/Screenshot%202026-05-01%20at%2022.25.27.png" alt="Memory Functions" width="400"/>
      <br />
      <em>Memory functions in use</em>
    </td>
    <td align="center">
      <img src="screenshots/Screenshot%202026-05-01%20at%2022.25.37.png" alt="Dark Theme" width="400"/>
      <br />
      <em>Dark theme mode</em>
    </td>
  </tr>
</table>

</div>

## 🎯 How It Works

1. **Number Input**: Click number buttons (0-9) to enter values
2. **Decimal Numbers**: Click the decimal point (.) button to enter decimal values
3. **Operations**: Click an operator button (+, -, ×, ÷, ^) after entering a number
4. **Calculate**: Press the equals (=) button to see the result
5. **Memory**: Use M+/M- to store values, MR to recall, and MC to clear memory
6. **History**: View all your calculations in the history panel at the bottom
7. **Themes**: Switch between Light, Dark, and Off modes using the theme buttons

## 🚀 New Concepts Used

- **JavaFX Application Framework**: Building GUI applications with JavaFX
- **Event Handling**: Using EventHandler and lambda expressions for button actions
- **Switch Statements**: Implementing multi-case logic for button handling and styling
- **BorderPane Layout**: Organizing UI components in top, center, and bottom zones
- **GridPane Layout**: Creating a responsive button grid with equal column widths
- **VBox Container**: Vertically stacking multiple UI components
- **TextField and TextArea Controls**: Displaying input/output and history
- **Text Control**: Showing memory status
- **CSS Styling in JavaFX**: Applying inline styles with `-fx-` properties
- **String Manipulation**: Using `substring()`, `contains()`, and `valueOf()` methods
- **Double Parsing**: Converting strings to doubles with `Double.parseDouble()`
- **Math Operations**: Using `Math.pow()` and `Math.sqrt()` for advanced calculations
- **Instance Variables**: Managing application state across methods
- **Method Overriding**: Overriding the `start()` method from Application class
- **Lambda Expressions**: Creating concise event handlers
- **Compound Operators**: Using `+=` and `-=` for memory operations
- **JavaDoc Documentation**: Writing professional code documentation
- **Conditional Logic**: Implementing validation (e.g., preventing multiple decimal points)

## 🛠️ Technical Details

### Technologies Used
- **Java**: Programming language
- **JavaFX**: GUI framework
- **Scene Builder Concepts**: Layout management and UI design

### Project Structure
```
CalcFX/
├── src/
│   └── JavaFXCalculator.java
├── screenshots/
│   ├── calculator-main.png
│   ├── calculator-dark.png
│   └── calculator-history.png
├── out/
├── .gitignore
└── README.md
```

### Key Classes and Components
- **JavaFXCalculator**: Main application class extending `Application`
- **EventHandler**: Handles all button click events
- **compute()**: Performs arithmetic calculations
- **start()**: Sets up the user interface

## 📦 Installation & Running

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- JavaFX SDK (if not included with your JDK)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd CalcFX
   ```

2. Compile the Java file:
   ```bash
   javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls src/JavaFXCalculator.java
   ```

3. Run the application:
   ```bash
   java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls -cp src JavaFXCalculator
   ```

   Or if using an IDE (IntelliJ IDEA, Eclipse, NetBeans):
   - Open the project
   - Configure JavaFX library
   - Run `JavaFXCalculator.java`

## 📸 Screenshots

### Main Calculator Interface
The calculator features a clean, intuitive interface with a 7x4 button grid layout, display field, memory indicator, and calculation history panel.

![Main Interface](screenshots/Screenshot%202026-05-01%20at%2022.25.01.png)

### Performing Calculations
The calculator handles basic arithmetic operations seamlessly with real-time display updates.

![Basic Operations](screenshots/Screenshot%202026-05-01%20at%2022.25.07.png)

### Advanced Operations & History
Advanced operations like power and square root are supported, with all calculations logged in the history panel.

![Advanced Operations](screenshots/Screenshot%202026-05-01%20at%2022.25.16.png)

### Memory Functions
Store and recall values using the memory buttons (M+, M-, MR, MC) displayed in blue.

![Memory Functions](screenshots/Screenshot%202026-05-01%20at%2022.25.27.png)

### Dark Theme Mode
Switch to dark mode for comfortable viewing in low-light environments.

![Dark Theme](screenshots/Screenshot%202026-05-01%20at%2022.25.37.png)

## 👨‍💻 Author

**[Your Name]**
- GitHub: [https://github.com/yourusername](https://github.com/yourusername)
- LinkedIn: [https://linkedin.com/in/yourprofile](https://linkedin.com/in/yourprofile)
- Email: your.email@example.com
- Portfolio: [https://yourportfolio.com](https://yourportfolio.com)

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- JavaFX documentation and community
- Course instructor and teaching assistants
- Stack Overflow community for troubleshooting support

## 📝 Version History

- **v2.0** (Current)
  - Added calculation history feature
  - Implemented memory functions (M+, M-, MR, MC)
  - Added theme switching (Light, Dark, Off)
  - Added advanced operations (power, square root)
  - Added input controls (backspace, clear entry)
  - Improved button styling with color coding
  
- **v1.0** (Initial Release)
  - Basic arithmetic operations
  - Simple calculator interface

---

*Built with ❤️ using JavaFX*
