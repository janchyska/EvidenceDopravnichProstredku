package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author janch
 */
public class KontrolaVstupnichDat {

    public boolean paramCheckInt(TextField txtField) {
        if (txtField.getText().isEmpty()) {
            txtField.setText("");
            txtField.requestFocus();
            alertInt();
            return false;
        } else {
            try {
                int parse = Integer.parseInt(txtField.getText());
                return true;
            } catch (Exception e) {
                txtField.setText("");
                txtField.requestFocus();
                alertInt();
                return false;
            }
        }
    }

    public boolean paramCheckSpz(TextField txtField) {
        if (txtField.getText().isEmpty() || txtField.getText().length() != 8) {
            txtField.setText("");
            txtField.requestFocus();
            alertSPZ();
            return false;
        } else {
            try {
                String parse = txtField.getText().toUpperCase();
                return true;
            } catch (Exception e) {
                txtField.setText("");
                txtField.requestFocus();
                alertSPZ();
                return false;
            }
        }
    }

    public void alertSPZ() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Chybně zadané vstupní hodnoty");
        alert.setContentText("Pole je chybně vyplněné.\nDélka SPZ musí být 8 znaků v kombinaci písmen a číslic.");
        alert.showAndWait();
    }

    public void alertInt() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Chybně zadané vstupní hodnoty");
        alert.setContentText("Pole je chybně vyplněné.\nHodnoty musí být zapsány jako celá čísla.");
        alert.showAndWait();
    }
}
