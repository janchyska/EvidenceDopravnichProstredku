package gui;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import prostredky.*;
import gui.*;

/**
 *
 * @author janch
 */
public class DialogDopravniProstredek extends Stage {

    private DopravniProstredek dopravniProstredek;
    public final ComboBox<String> typ = new ComboBox<>();
    Button btnOK = new Button("Potvrdit");
    MainFX graphicuserInterface = new MainFX();
    String vysledek;
    boolean kliknuto = false;

    public DialogDopravniProstredek() {
        novyDopravniProstredek();
    }

    public String novyDopravniProstredek() {
        Dialog<String> dialog = new Dialog<>();
        DialogTools dialogToolsCW = new DialogTools(dialog, 400, 200);
        dialog.setTitle("Nový dopravní prostředek");
        dialog.setHeaderText("Z nabídky vyberte dopravní prostředek, který chcete vytvořit.");
        dialog.setResizable(false);
        setComboBoxTyp();
        Button btnOK = new Button("Potvrdit");
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
        grid.add(typ, 1, 1);
        HBox box = new HBox(160);
        box.getChildren().addAll(btnOK, btnCancel);
        box.setAlignment(Pos.BOTTOM_CENTER);
        btnOK.setPrefSize(120, 35);
        btnCancel.setPrefSize(120, 35);
        grid.add(box, 1, 4);
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
        return typ.getValue();
    }

    private void setComboBoxTyp() {
        typ.getItems().add("Dodávka");
        typ.getItems().add("Motocykl");
        typ.getItems().add("Nákladní automobil");
        typ.getItems().add("Osobní automobil");
        typ.getItems().add("Traktor");
        typ.getSelectionModel().selectFirst();
        typ.setPrefSize(400, 30);
    }

    public boolean isKliknuto() {
        return kliknuto;
    }

    public void setKliknuto(boolean kliknuto) {
        this.kliknuto = kliknuto;
    }

}
