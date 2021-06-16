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
import prostredky.Dodavka;
import prostredky.DodavkaTyp;
import prostredky.DopravniProstredek;
import prostredky.DopravniProstredekTyp;

/**
 *
 * @author janch
 */
public class DialogDodavka extends KontrolaVstupnichDat{

    private DopravniProstredek dopravniProstredek;
    private final ComboBox<DodavkaTyp> comboBoxVolbaTypuDodavky = new ComboBox<>();
    private final TextField txtFieldSPZ = new TextField();
    private final TextField txtFieldVykon = new TextField();
    private final TextField txtFieldHmotnost = new TextField();
    private final TextField txtFieldKapacita = new TextField();
    private final Label labelSPZ = new Label();
    private final Label labelVykon = new Label();
    private final Label labelHmotnost = new Label();
    private final Label labelTypDodavky = new Label("Typ");
    private final Label labelKapacita = new Label("Kapacita");
    private final String stringTFP = "Zadejte kapacitu vozidla";
    private final Button btnVytvorit = new Button("Přidat");

    public DialogDodavka() {
        novaDodavka();
    }

    public DialogDodavka(DopravniProstredek dopravniProstredek) {
        editDodavka(dopravniProstredek);
    }

    private DopravniProstredek novaDodavka() {
        Dialog<String> dialogDodavka = new Dialog<>();
        tools(dialogDodavka, "Nová dodávka", "Vyplňte informace o nové dodávce");
        btnVytvorit.setOnAction((event) -> {
            if (paramCheckSpz(txtFieldSPZ) != true) return;
            String spz = txtFieldSPZ.getText().toUpperCase();
            if (paramCheckInt(txtFieldVykon) != true) return;
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            if (paramCheckInt(txtFieldHmotnost) != true) return;
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            DodavkaTyp typDodavky = comboBoxVolbaTypuDodavky.getValue();
            if (paramCheckInt(txtFieldKapacita) != true) return;
            int kapacita = Integer.parseInt(txtFieldKapacita.getText());
            dopravniProstredek = new Dodavka(DopravniProstredekTyp.DODAVKA, spz,
                    hmotnost, vykon, typDodavky, kapacita);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogDodavka.showAndWait();
        return dopravniProstredek;
    }

    private DopravniProstredek editDodavka(DopravniProstredek dopravniProstredek) {
         Dodavka dodavka = (Dodavka) dopravniProstredek;
        Dialog<String> dialogDodavka = new Dialog<>();
        tools(dialogDodavka, "Úprava hodnot dodávky", "Vyplňte nové informace o upravované dodávce");
        btnVytvorit.setOnAction((event) -> {
            if(paramCheckSpz(txtFieldSPZ) != true)return;
            String spz = txtFieldSPZ.getText().toUpperCase();
            dodavka.setSpz(spz);
            if(paramCheckInt(txtFieldVykon)!=true)return;
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            dodavka.setVykon(vykon);
            if(paramCheckInt(txtFieldHmotnost)!=true)return;
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            dodavka.setHmotnost(hmotnost);
            DodavkaTyp typDodavky = comboBoxVolbaTypuDodavky.getValue();
            dodavka.setTypDodavky(typDodavky);
            if(paramCheckInt(txtFieldKapacita)!=true)return;
            int kapacita = Integer.parseInt(txtFieldKapacita.getText());
            dodavka.setKapacita(kapacita);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogDodavka.showAndWait();
        return dodavka;
    }
    private void tools(Dialog<String> dialogDodavka, String msgTitle, String msgHeaderText){
        dialogDodavka.setTitle(msgTitle);
        DialogTools dialogToolsCW = new DialogTools(dialogDodavka, 400, 400);
        DialogTools dialogToolsFont = new DialogTools(labelSPZ, labelVykon,
                labelHmotnost, labelTypDodavky, labelKapacita);
        DialogTools dialogToolsTF = new DialogTools(txtFieldSPZ, txtFieldVykon,
                txtFieldHmotnost, txtFieldKapacita, stringTFP);
        setComboBoxDodavkaTyp();
        VBox box = new VBox();
        VBox vboxThree = new VBox(20);
        VBox vboxOne = new VBox(24);
        VBox vboxTwo = new VBox(19);
        HBox hbox = new HBox(20);
        vboxOne.getChildren().addAll(labelSPZ, labelVykon, labelHmotnost,
                labelTypDodavky, labelKapacita);
        vboxOne.setAlignment(Pos.TOP_LEFT);
        vboxTwo.getChildren().addAll(txtFieldSPZ, txtFieldVykon, txtFieldHmotnost,
                comboBoxVolbaTypuDodavky, txtFieldKapacita, btnVytvorit);
        vboxThree.getChildren().add(btnVytvorit);
        vboxThree.setAlignment(Pos.CENTER);
        vboxThree.setPadding(new Insets(40, 0, 0, 0));
        btnVytvorit.setPrefSize(100, 40);
        hbox.setPadding(new Insets(25, 0, 0, 20));
        hbox.getChildren().addAll(vboxOne, vboxTwo);
        box.getChildren().addAll(hbox, vboxThree);
        dialogDodavka.getDialogPane().setHeaderText(msgHeaderText);
        dialogDodavka.getDialogPane().setContent(box);
    }
    private void setComboBoxDodavkaTyp() {
        comboBoxVolbaTypuDodavky.getItems().addAll(DodavkaTyp.DVOJKABINA,
                DodavkaTyp.MINIBUS, DodavkaTyp.PICKUP, DodavkaTyp.SKLAPEC,
                DodavkaTyp.VALNIK, DodavkaTyp.NEZNAMY);
        comboBoxVolbaTypuDodavky.getSelectionModel().selectLast();
        comboBoxVolbaTypuDodavky.setPrefWidth(200);
    }

    public DopravniProstredek getDopravniProstredek() {
        return dopravniProstredek;
    }

    public void setDopravniProstredek(DopravniProstredek dopravniProstredek) {
        this.dopravniProstredek = dopravniProstredek;
    }


}
