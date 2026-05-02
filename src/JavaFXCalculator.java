import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import static java.lang.Math.pow;

/**
 * JavaFXCalculator - A fully functional calculator application built with JavaFX.
 * 
 * Features:
 * - Basic arithmetic operations: addition, subtraction, multiplication, division
 * - Advanced operations: power (^) and square root (√)
 * - Memory functions: M+ (add to memory), M- (subtract from memory), MR (recall memory), MC (clear memory)
 * - Input controls: decimal point support, backspace (←), clear entry (CE), clear all (C)
 * - Theme switching: Off, Dark, and Light modes
 * - Calculation history: displays all completed operations in a TextArea
 * - Memory display: shows current memory value
 * 
 * @author [Your Name]
 * @version 2.0
 */
public class JavaFXCalculator extends Application {
    private TextField tfDisplay;    // display textfield
    private BorderPane root;        // root pane for theme switching
    private javafx.scene.text.Text memoryText; // GUI control storing the memory value as a string
    private double memory = 0;      // field storing the memory value as a double
    private javafx.scene.control.TextArea calcHistory; // TextArea to display calculation history

    // For computation
    private double result = 0;      // Result of computation
    private String inStr = "0";  // Input number as String
    // Previous operator: ' '(nothing), '+', '-', '*', '/', '='
    private char lastOperator = ' ';

    /**
     * Event handler for all calculator buttons.
     * Handles number input, operators, memory operations, and special functions.
     * Converts the current input string to a double at the start for use in various operations.
     */
    // Event handler for all the 16 Buttons
    EventHandler handler = evt -> {
        // Convert current input string to double since multiple case blocks will need this
        double inNum = Double.parseDouble(inStr);
        
        String currentBtnLabel = ((Button)evt.getSource()).getText();
        switch (currentBtnLabel) {
            // Number buttons
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                if (inStr.equals("0")) {
                    inStr = currentBtnLabel;  // no leading zero
                } else {
                    inStr += currentBtnLabel; // append input digit
                }
                tfDisplay.setText(inStr);
                // Clear buffer if last operator is '='
                if (lastOperator == '=') {
                    result = 0;
                    lastOperator = ' ';
                }
                break;
            
            case ".":
                // Only add the period if the current input doesn't already contain a period
                if (!inStr.contains(".")) {
                    inStr += "."; // add the period to the end of the current input string
                    tfDisplay.setText(inStr); // update the GUI control
                }
                break;

            // Operator buttons: '+', '-', 'x', '/' and '='
            case "+":
                compute();
                lastOperator = '+';
                break;
            case "-":
                compute();
                lastOperator = '-';
                break;
            case "x":
                compute();
                lastOperator = '*';
                break;
            case "/":
                compute();
                lastOperator = '/';
                break;

            case "^":
                compute();
                lastOperator = '^';
                break;

            case "=":
                compute();
                lastOperator = '=';
                break;

            // Clear button
            case "C":
                result = 0;
                inStr = "0";
                lastOperator = ' ';
                tfDisplay.setText("0");
                break;
            
            // Memory operations
            case "M+":
                // If lastOperator isn't equal '=' then increase memory field by the value of current value (inNum)
                if (lastOperator != '=') {
                    memory += inNum; // increase memory field by the value of current value using a compounded operator
                } else {
                    memory += result; // increase memory field by the value of result using a compounded operator
                }
                memoryText.setText("Memory = " + memory); // update the GUI control
                break;
            
            case "M-":
                // If lastOperator isn't equal '=' then decrease memory field by the value of current value (inNum)
                if (lastOperator != '=') {
                    memory -= inNum; // decrease memory field by the value of current value using a compounded operator
                } else {
                    memory -= result; // decrease memory field by the value of result using a compounded operator
                }
                memoryText.setText("Memory = " + memory); // update the GUI control
                break;
            
            case "MR":
                // Set the inStr field to the String value of memory using String.valueOf
                inStr = String.valueOf(memory);
                tfDisplay.setText(inStr); // update the GUI control
                // NOTE: adding a String to a double implicitly converts it to a String
                // this is the lazy way of converting a number to a string by adding empty string
                break;
            
            case "MC":
                memory = 0.0; // set the numeric memory value to 0.0
                memoryText.setText("Memory = " + memory); // update the GUI control
                break;
            
            case "CE":
                inStr = "0"; // set inStr to "0"
                tfDisplay.setText("0"); // update the GUI control
                break;
            
            case "←":
                // If inStr.length() equals 1 - if there is only one digit currently displayed
                if (inStr.length() == 1) {
                    inStr = "0"; // set inStr to "0"
                } else {
                    inStr = inStr.substring(0, inStr.length() - 1); // inStr to one less character using substring method
                }
                tfDisplay.setText(inStr); // update the GUI Control
                break;
            
            case "√":
                // Since square root doesn't need another number we don't call the compute method
                if (lastOperator != '=') {
                    result = inNum; // set result to the current value inNum
                    // NOTE: inNum needs to be defined above the switch as double inNum = Double.parseDouble(inStr))
                }
                double originalValue = result; // store original value before calculation
                result = Math.sqrt(result); // set result to the square root value of result using Math.sqrt
                calcHistory.appendText("√" + originalValue + " = " + result + "\n"); // update calcHistory
                inStr = result + ""; // again this is the lazy way of converting a numeric value to string
                tfDisplay.setText(inStr); // update the GUI control
                lastOperator = '='; // set the lastOperator to '=' since we just computed a new value
                inStr = "0"; // set inStr to 0 to prepare for the next numeric input
                break;
        }
    };

    /**
     * Performs computation on the previous result and the current input number,
     * based on the previous operator (+, -, *, /, ^).
     * Updates the calculation history with each operation.
     * Displays the result in the text field.
     */
    // User pushes '+', '-', '*', '/' or '=' button.
    // Perform computation on the previous result and the current input number,
    // based on the previous operator.
    private void compute() {
        double inNum = Double.parseDouble(inStr);
        inStr = "0";
        double previousResult = result; // store previous result for history
        if (lastOperator == ' ') {
            result = inNum;
        } else if (lastOperator == '+') {
            result += inNum;
            calcHistory.appendText(previousResult + " + " + inNum + " = " + result + "\n"); // update calcHistory
        } else if (lastOperator == '-') {
            result -= inNum;
            calcHistory.appendText(previousResult + " - " + inNum + " = " + result + "\n"); // update calcHistory
        } else if (lastOperator == '*') {
            result *= inNum;
            calcHistory.appendText(previousResult + " * " + inNum + " = " + result + "\n"); // update calcHistory
        } else if (lastOperator == '/') {
            result /= inNum;
            calcHistory.appendText(previousResult + " / " + inNum + " = " + result + "\n"); // update calcHistory
        } else if (lastOperator == '^') {
            result = Math.pow(result, inNum); // calculate result raised to the power of inNum
            calcHistory.appendText(previousResult + " ^ " + inNum + " = " + result + "\n"); // update calcHistory
        } else if (lastOperator == '=') {
            // Keep the result for the next operation
        }
        tfDisplay.setText(result + "");
    }

    /**
     * Sets up the user interface for the calculator.
     * Creates and configures:
     * - Display text field for showing input and results
     * - 28 buttons in a 7x4 grid layout
     * - Memory display text
     * - Calculation history text area
     * - Theme switching buttons with custom colors
     * - VBox container for bottom zone elements
     * 
     * @param primaryStage the primary stage for this application
     */
    // Setup the UI
    @Override
    public void start(Stage primaryStage) {
        // Convert btnLabels from a field to a local variable
        String[] btnLabels = {   // Labels of 28 buttons - add all of the new button labels to the btnLabels array list
                "Off", "Dark", "Light", "+",
                "7", "8", "9", "-",
                "4", "5", "6", "x",
                "1", "2", "3", "\u00F7",
                ".", "0", "=", "\u2190",
                "C", "CE", "\u221A", "^",
                "M+", "M-", "MR", "MC"
        };
        
        Button[] btns;          // 28 buttons
        // Setup the Display TextField
        tfDisplay = new TextField("0");
        tfDisplay.setEditable(false);
        tfDisplay.setAlignment(Pos.CENTER_RIGHT);

        // Setup a GridPane for 7x4 Buttons
        int numCols = 4;
        GridPane paneButton = new GridPane();
        paneButton.setPadding(new Insets(15, 0, 15, 0));  // top, right, bottom, left
        paneButton.setVgap(5);  // Vertical gap between nodes
        paneButton.setHgap(5);  // Horizontal gap between nodes
        // Setup 4 columns of equal width, fill parent
        ColumnConstraints[] columns = new ColumnConstraints[numCols];
        for (int i = 0; i < numCols; ++i) {
            columns[i] = new ColumnConstraints();
            columns[i].setHgrow(Priority.ALWAYS) ;  // Allow column to grow
            columns[i].setFillWidth(true);  // Ask nodes to fill space for column
            paneButton.getColumnConstraints().add(columns[i]);
        }

        // Setup 28 Buttons and add to GridPane; and event handler
        btns = new Button[28];
        for (int i = 0; i < btns.length; ++i) {
            btns[i] = new Button(btnLabels[i]); // instantiate the new button
            btns[i].setOnAction(handler); // set all buttons use the handler BUT the switch overrides this for some
            btns[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // full-width

            switch(btnLabels[i]) {
                case "C": case "CE": case "←": // set the color for more than one button at the same time
                    btns[i].setStyle("-fx-color: #FbeDad");
                    break;
                
                case "M+": case "M-": case "MR": case "MC":
                    btns[i].setStyle("-fx-color: blue"); // set the color for memory buttons
                    break;

                case "Off":
                    btns[i].setStyle("-fx-color: #8a2b2b");
                    btns[i].setOnAction(ActionEvent -> { // special logic - override using the handler for this button
                        root.setStyle("-fx-text-fill: white; -fx-background-color: black;");
                        memoryText.setStyle("-fx-fill: white;");
                    });
                    break;

                case "Dark":
                    btns[i].setStyle("-fx-text-fill: white; -fx-background-color: black;");
                    btns[i].setOnAction(ActionEvent -> { // special logic - override using the handler for this button
                        root.setStyle("-fx-text-fill: white; -fx-background-color: black;");
                        memoryText.setStyle("-fx-fill: white;");
                    });
                    break;

                case "Light":
                    btns[i].setStyle("-fx-text-fill: white; -fx-background-color: lightgray;");
                    btns[i].setOnAction(ActionEvent -> { // special logic - override using the handler for this button
                        root.setStyle("-fx-text-fill: black; -fx-background-color: white;");
                        memoryText.setStyle("-fx-fill: black;");
                    });
                    break;
            }

            paneButton.add(btns[i], i % numCols, i / numCols); // control, col, row
        }

        // Setup up the scene graph rooted at a BorderPane (of 5 zones)
        root = new BorderPane();
        root.setPadding(new Insets(15, 15, 15, 15));  // top, right, bottom, left

        // Instantiate a new memoryText control setting it's initial value to "Memory = 0.0"
        memoryText = new javafx.scene.text.Text("Memory = 0.0");
        
        // Create a TextArea for calculation history
        calcHistory = new TextArea("No History");
        calcHistory.setEditable(false); // make it read-only
        calcHistory.setPrefRowCount(3); // set preferred number of rows
        
        // Create a VBox that will contain both memoryText and calcHistory
        VBox bottomBox = new VBox();
        bottomBox.getChildren().addAll(memoryText, calcHistory); // using vbox.getChildren().addAll method to add both controls

        root.setTop(tfDisplay);     // Top zone contains the TextField
        root.setCenter(paneButton); // Center zone contains the GridPane of Buttons
        root.setBottom(bottomBox);  // Bottom zone contains the VBox with memoryText and calcHistory

        // Set up scene and stage
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.setTitle("JavaFX Calculator");
        primaryStage.show();
    }

    /**
     * Main entry point for the JavaFX application.
     * Launches the calculator application.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }
}