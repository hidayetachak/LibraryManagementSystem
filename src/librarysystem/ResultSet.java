/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystem;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Hidayet
 */
public class ResultSet {
    private List<Map<String, Object>> rows; // Holds the rows of the result set
    private int currentRow; // Tracks the current row position

    public ResultSet(List<Map<String, Object>> rows) {
        this.rows = rows;
        this.currentRow = -1; // Set the initial position to before the first row
    }

    public boolean next() {
        if (currentRow < rows.size() - 1) {
            currentRow++;
            return true;
        } else {
            return false;
        }
    }

    public String getString(String columnName) {
        Map<String, Object> row = rows.get(currentRow);
        Object value = row.get(columnName);
        if (value != null) {
            return value.toString();
        } else {
            return null;
        }
    }

    public int getInt(String columnName) {
        String value = getString(columnName);
        if (value != null) {
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }

    // Add more methods for retrieving other data types (e.g., getDouble, getDate, etc.)

    public void close() {
        // Optionally close any resources used by the result set
    }

    boolean getBoolean(String admin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

