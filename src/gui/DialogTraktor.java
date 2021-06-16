package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import prostredky.DopravniProstredek;
import prostredky.DopravniProstredekTyp;
import prostredky.Traktor;
import prostredky.ZnackaTraktor;

/**
 *
 * @author janch
 */
public class DialogTraktor extends KontrolaVstupnichDat {

    private DopravniProstredek dopravniProstredek;
    private final ComboBox<ZnackaTraktor> comboBoxZnackaTraktoru = new ComboBox<>();
    private final TextField txtFieldSPZ = new TextField();
    private final TextField txtFieldVykon = new TextField();
    private final TextField txtFieldHmotnost = new TextField();
    private final TextField txtFieldTah = new TextField();
    private final Label labelSPZ = new Label();
    private final Label labelVykon = new Label();
    private final Label labelHmotnost = new Label();
    private final Label labelTypZnackaTraktoru = new Label("Značka");
    private final Label labelTah = new Label("Tah");
    private final String stringTFP = "Zadejte tah";
    private final Button btnVytvorit = new Button("Přidat");

    public DialogTraktor() {
        novyTraktor();
    }

    public DialogTraktor(DopravniProstredek dopravniProstredek) {
        novyTraktor(dopravniProstredek);
    }

    private DopravniProstredek novyTraktor() {
        Dialog<String> dialogTraktor = new Dialog<>();
        tools(dialogTraktor, "Nový traktor", "Vyplňte informace o novém traktoru");
        btnVytvorit.setOnAction((event) -> {
            if (paramCheckSpz(txtFieldSPZ) != true) {
                return;
            }
            String spz = txtFieldSPZ.getText().toUpperCase();
            if (paramCheckInt(txtFieldVykon) != true) {
                return;
            }
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            if (paramCheckInt(txtFieldHmotnost) != true) {
                return;
            }
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            ZnackaTraktor typZnackaTraktoru = comboBoxZnackaTraktoru.getValue();
            if (paramCheckInt(txtFieldTah) != true) {
                return;
            }
            int tah = Integer.parseInt(txtFieldTah.getText());
            dopravniProstredek = new Traktor(DopravniProstredekTyp.TRAKTOR, spz,
                    hmotnost, vykon, typZnackaTraktoru, tah);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogTraktor.showAndWait();
        return dopravniProstredek;
    }

    private DopravniProstredek novyTraktor(DopravniProstredek dopravniProstredek) {
        Traktor traktor = (Traktor) dopravniProstredek;
        Dialog<String> dialogTraktor = new Dialog<>();
        tools(dialogTraktor, "Úprava hodnot traktoru","Vyplňte informace o upravovaném traktoru");
        btnVytvorit.setOnAction((event) -> {
            if (paramCheckSpz(txtFieldSPZ) != true) {
                return;
            }
            String spz = txtFieldSPZ.getText().toUpperCase();
            traktor.setSpz(spz);
            if (paramCheckInt(txtFieldVykon) != true) {
                return;
            }
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            traktor.setVykon(vykon);
            if (paramCheckInt(txtFieldHmotnost) != true) {
                return;
            }
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            traktor.setHmotnost(hmotnost);
            ZnackaTraktor typZnackaTraktoru = comboBoxZnackaTraktoru.getValue();
            traktor.setZnackaTraktoru(typZnackaTraktoru);
            if (paramCheckInt(txtFieldVykon) != true) {
                return;
            }
            int tah = Integer.parseInt(txtFieldTah.getText());
            traktor.setTah(tah);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogTraktor.showAndWait();
        return traktor;
    }

    private void tools(Dialog<String> dialogTraktor, String msgTitle, String msgHeaderText) {
        dialogTraktor.setTitle(msgTitle);
        DialogTools dialogToolsCW = new DialogTools(dialogTraktor, 400, 400);
        DialogTools dialogToolsFont = new DialogTools(labelSPZ, labelVykon,
                labelHmotnost, labelTypZnackaTraktoru, labelTah);
        DialogTools dialogToolsTF = new DialogTools(txtFieldSPZ, txtFieldVykon,
                txtFieldHmotnost, txtFieldTah, stringTFP);
        setComboBoxZnackaTraktoru();
        VBox box = new VBox();
        VBox vboxThree = new VBox(20);
        VBox vboxOne = new VBox(24);
        VBox vboxTwo = new VBox(19);
        HBox hbox = new HBox(20);
        vboxOne.getChildren().addAll(labelSPZ, labelVykon, labelHmotnost,
                labelTypZnackaTraktoru, labelTah);
        vboxOne.setAlignment(Pos.TOP_LEFT);
        vboxTwo.getChildren().addAll(txtFieldSPZ, txtFieldVykon, txtFieldHmotnost,
                comboBoxZnackaTraktoru, txtFieldTah, btnVytvorit);
        vboxThree.getChildren().add(btnVytvorit);
        vboxThree.setAlignment(Pos.CENTER);
        vboxThree.setPadding(new Insets(40, 0, 0, 0));
        btnVytvorit.setPrefSize(100, 40);
        hbox.setPadding(new Insets(25, 0, 0, 20));
        hbox.getChildren().addAll(vboxOne, vboxTwo);
        box.getChildren().addAll(hbox, vboxThree);
        dialogTraktor.getDialogPane().setHeaderText(msgHeaderText);
        dialogTraktor.getDialogPane().setContent(box);
    }

    private void setComboBoxZnackaTraktoru() {
        comboBoxZnackaTraktoru.getItems().addAll(ZnackaTraktor.CLAAS,
                ZnackaTraktor.JOHN_DEER, ZnackaTraktor.NEW_HOLLAND,
                ZnackaTraktor.ZETOR, ZnackaTraktor.JINY);
        comboBoxZnackaTraktoru.getSelectionModel().selectLast();
        comboBoxZnackaTraktoru.setPrefWidth(200);
    }

    public DopravniProstredek getDopravniProstredek() {
        return dopravniProstredek;
    }

    public void setDopravniProstredek(DopravniProstredek dopravniProstredek) {
        this.dopravniProstredek = dopravniProstredek;
    }
}
