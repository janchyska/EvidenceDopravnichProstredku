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
import prostredky.OsobniAutomobil;
import prostredky.Barva;

/**
 *
 * @author janch
 */
public class DialogOsobniAutomobil extends KontrolaVstupnichDat {

    private DopravniProstredek dopravniProstredek;
    private final ComboBox<Barva> comboBoxBarva = new ComboBox<>();
    private final TextField txtFieldSPZ = new TextField();
    private final TextField txtFieldVykon = new TextField();
    private final TextField txtFieldHmotnost = new TextField();
    private final TextField txtFieldPocetMist = new TextField();
    private final Label labelSPZ = new Label();
    private final Label labelVykon = new Label();
    private final Label labelHmotnost = new Label();
    private final Label labelTypBarva = new Label("Barva");
    private final Label labelPocetMist = new Label("Počet míst");
    private final String stringTFP = "Zadejte počet míst vozidla";
    private final Button btnVytvorit = new Button("Přidat");

    public DialogOsobniAutomobil() {
        novyOsobniAutomobil();
    }

    public DialogOsobniAutomobil(DopravniProstredek dopravniProstredek) {
        novyOsobniAutomobil(dopravniProstredek);
    }

    private DopravniProstredek novyOsobniAutomobil() {
        Dialog<String> dialogOsobniAutomobil = new Dialog<>();
        tools(dialogOsobniAutomobil, "Nový osobní automobil", "Vyplňte informace o novém osobním automobilu");
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
            Barva typBarva = comboBoxBarva.getValue();
            if (paramCheckInt(txtFieldPocetMist) != true) {
                return;
            }
            int pocetMist = Integer.parseInt(txtFieldPocetMist.getText());
            dopravniProstredek = new OsobniAutomobil(DopravniProstredekTyp.OSOBNI_AUTOMOBIL,
                    spz, hmotnost, vykon, typBarva, pocetMist);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogOsobniAutomobil.showAndWait();
        return dopravniProstredek;
    }

    private DopravniProstredek novyOsobniAutomobil(DopravniProstredek dopravniProstredek) {
        OsobniAutomobil osobniAutomobil = (OsobniAutomobil) dopravniProstredek;
        Dialog<String> dialogOsobniAutomobil = new Dialog<>();
        tools(dialogOsobniAutomobil,"Úprava hodnot osobního automobilu" ,"Vyplňte nové informace o upravovaném osobním automobilu" );
        btnVytvorit.setOnAction((event) -> {
            if (paramCheckSpz(txtFieldSPZ) != true) {
                return;
            }
            String spz = txtFieldSPZ.getText().toUpperCase();
            osobniAutomobil.setSpz(spz);
            if (paramCheckInt(txtFieldVykon) != true) {
                return;
            }
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            osobniAutomobil.setVykon(vykon);
            if (paramCheckInt(txtFieldHmotnost) != true) {
                return;
            }
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            osobniAutomobil.setHmotnost(hmotnost);
            Barva typBarva = comboBoxBarva.getValue();
            osobniAutomobil.setBarva(typBarva);
            if (paramCheckInt(txtFieldPocetMist) != true) {
                return;
            }
            int pocetMist = Integer.parseInt(txtFieldPocetMist.getText());
            osobniAutomobil.setPocetMist(pocetMist);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogOsobniAutomobil.showAndWait();
        return osobniAutomobil;
    }

    private void tools(Dialog<String> dialogOsobniAutomobil, String msgTitle, String msgHeaderText) {
           dialogOsobniAutomobil.setTitle(msgTitle);
        DialogTools dialogToolsCW = new DialogTools(dialogOsobniAutomobil, 400, 400);
        DialogTools dialogToolsFont = new DialogTools(labelSPZ, labelVykon,
                labelHmotnost, labelTypBarva, labelPocetMist);
        DialogTools dialogToolsTF = new DialogTools(txtFieldSPZ, txtFieldVykon,
                txtFieldHmotnost, txtFieldPocetMist, stringTFP);
        setComboBoxBarva();
        VBox box = new VBox();
        VBox vboxThree = new VBox(20);
        VBox vboxOne = new VBox(24);
        VBox vboxTwo = new VBox(19);
        HBox hbox = new HBox(20);
        vboxOne.getChildren().addAll(labelSPZ, labelVykon, labelHmotnost,
                labelTypBarva, labelPocetMist);
        vboxOne.setAlignment(Pos.TOP_LEFT);
        vboxTwo.getChildren().addAll(txtFieldSPZ, txtFieldVykon, txtFieldHmotnost,
                comboBoxBarva, txtFieldPocetMist, btnVytvorit);
        vboxThree.getChildren().add(btnVytvorit);
        vboxThree.setAlignment(Pos.CENTER);
        vboxThree.setPadding(new Insets(40, 0, 0, 0));
        btnVytvorit.setPrefSize(100, 40);
        hbox.setPadding(new Insets(25, 0, 0, 20));
        hbox.getChildren().addAll(vboxOne, vboxTwo);
        box.getChildren().addAll(hbox, vboxThree);
        dialogOsobniAutomobil.getDialogPane().setHeaderText(msgHeaderText);
        dialogOsobniAutomobil.getDialogPane().setContent(box);
    }

    private void setComboBoxBarva() {
        comboBoxBarva.getItems().addAll(Barva.BILA, Barva.CERNA, Barva.CERVENA,
                Barva.MODRA, Barva.SEDA, Barva.JINA);
        comboBoxBarva.getSelectionModel().selectLast();
        comboBoxBarva.setPrefWidth(200);
    }

    public DopravniProstredek getDopravniProstredek() {
        return dopravniProstredek;
    }

    public void setDopravniProstredek(DopravniProstredek dopravniProstredek) {
        this.dopravniProstredek = dopravniProstredek;
    }
}
