package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import prostredky.*;

/**
 *
 * @author janch
 */
public class Filtr extends Dialog<DopravniProstredekKlic> {

    public final ComboBox<String> typ = new ComboBox<>();
    private final TextField txtFieldId = new TextField();
    private final TextField txtFieldSpz = new TextField();
    boolean kliknuto = false;

    public Filtr() {
        dialog();
    }

    private void dialog() {
        Dialog<String> dialog = new Dialog<>();
        DialogTools dialogToolsCW = new DialogTools(dialog, 400, 200);
        dialog.setTitle("Vyhledat dopravní prostředek");
        dialog.setHeaderText("Z nabídky vyberte dle jakého údaje chcete vyhledat dopravní prostředek.");
        dialog.setResizable(false);
        setComboBoxTyp();
        Button btnOK = new Button("Vybrat");
        btnOK.setOnAction((event) -> {
            Stage stageBtnOK = (Stage) btnOK.getScene().getWindow();
            stageBtnOK.close();
            kliknuto = true;
        }
        );
        Button btnCancel = new Button("Zrušit");
        btnCancel.setOnAction((event) -> {
            Stage stageBtnClose = (Stage) btnCancel.getScene().getWindow();
            stageBtnClose.close();
            kliknuto = false;
        });
        GridPane grid = new GridPane();
        grid.setVgap(7);
        grid.add(typ, 1, 1);
        HBox box = new HBox(160);
        box.getChildren().addAll(btnOK, btnCancel);
        box.setAlignment(Pos.BOTTOM_CENTER);
        btnOK.setPrefSize(120, 35);
        btnCancel.setPrefSize(120, 35);
        grid.add(box, 1, 4);
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
    }

    public DopravniProstredekKlic vstupnidataID() {
        Dialog<String> dialog = new Dialog<>();
        DialogTools dialogToolsCW = new DialogTools(dialog, 400, 200);
        dialog.setTitle("Vyhledat dopravní prostředek");
        dialog.setHeaderText("Zadejte ID prostředku, který chcete vyhledat.");
        dialog.setResizable(false);
        txtFieldId.setPromptText("ID");
        Button btnOK = new Button("Vybrat");
        btnOK.setOnAction((event) -> {
            Stage stageBtnOK = (Stage) btnOK.getScene().getWindow();
            stageBtnOK.close();
            kliknuto = true;
        }
        );
        Button btnCancel = new Button("Zrušit");
        btnCancel.setOnAction((event) -> {
            Stage stageBtnClose = (Stage) btnCancel.getScene().getWindow();
            stageBtnClose.close();
        });
        GridPane grid = new GridPane();
        grid.setVgap(7);
        grid.add(txtFieldId, 1, 1);
        HBox box = new HBox(160);
        box.getChildren().addAll(btnOK, btnCancel);
        box.setAlignment(Pos.BOTTOM_CENTER);
        btnOK.setPrefSize(120, 35);
        btnCancel.setPrefSize(120, 35);
        grid.add(box, 1, 3);
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
        int id = 0;
        if (txtFieldId.getText().isEmpty()) {
            txtFieldId.setText("");
            txtFieldId.requestFocus();
        } else {
            id = Integer.parseInt(txtFieldId.getText());
            return new DopravniProstredekKlic(id);
        }
        return null;
    }

    public DopravniProstredekKlic vstupnidataSPZ() {
        Dialog<String> dialog = new Dialog<>();
        DialogTools dialogToolsCW = new DialogTools(dialog, 400, 200);
        dialog.setTitle("Vyhledat dopravní prostředek");
        dialog.setHeaderText("Zadejte SPZ prostředku, který chcete vyhledat.");
        dialog.setResizable(false);
        txtFieldSpz.setPromptText("SPZ");
        Button btnOK = new Button("Vybrat");
        btnOK.setOnAction((event) -> {
            Stage stageBtnOK = (Stage) btnOK.getScene().getWindow();
            stageBtnOK.close();
            kliknuto = true;
        }
        );
        Button btnCancel = new Button("Zrušit");
        btnCancel.setOnAction((event) -> {
            Stage stageBtnClose = (Stage) btnCancel.getScene().getWindow();
            stageBtnClose.close();
        });
        GridPane grid = new GridPane();
        grid.setVgap(7);
        grid.add(txtFieldSpz, 1, 1);
        HBox box = new HBox(160);
        box.getChildren().addAll(btnOK, btnCancel);
        box.setAlignment(Pos.BOTTOM_CENTER);
        btnOK.setPrefSize(120, 35);
        btnCancel.setPrefSize(120, 35);
        grid.add(box, 1, 3);
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
        String spz = "";
        if (txtFieldSpz.getText().isEmpty()) {
            txtFieldSpz.setText("");
            txtFieldSpz.requestFocus();
        } else {
            spz = txtFieldSpz.getText().toUpperCase();
            return new DopravniProstredekKlic(txtFieldSpz.getText().toUpperCase());
        }
        return null;
    }

    private void setComboBoxTyp() {
        typ.getItems().add("ID");
        typ.getItems().add("SPZ");
        typ.getSelectionModel().selectFirst();
        typ.setPrefSize(400, 30);
    }
}
