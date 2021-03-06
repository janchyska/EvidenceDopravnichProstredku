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
import prostredky.NakladniAutomobil;
import prostredky.NakladniAutomobilTyp;

/**
 *
 * @author janch
 */
public class DialogNakladniAutomobil extends KontrolaVstupnichDat{

    private DopravniProstredek dopravniProstredek;
    private final ComboBox<NakladniAutomobilTyp> comboBoxVolbaTypuNakladnihoAutomobilu = new ComboBox<>();
    private final TextField txtFieldSPZ = new TextField();
    private final TextField txtFieldVykon = new TextField();
    private final TextField txtFieldHmotnost = new TextField();
    private final TextField txtFieldMaxNosnost = new TextField();
    private final Label labelSPZ = new Label();
    private final Label labelVykon = new Label();
    private final Label labelHmotnost = new Label();
    private final Label labelTypNakladnihoAutomobilu = new Label("Typ");
    private final Label labelMaximalniNosnost = new Label("Maximální nosnost");
    private final String stringTFP = "Zadejte maximální nosnost vozidla";
    private final Button btnVytvorit = new Button("Přidat");

    public DialogNakladniAutomobil() {
        novyNakladniAutomobil();
    }

    public DialogNakladniAutomobil(DopravniProstredek dopravniProstredek) {
        novyNakladniAutomobil(dopravniProstredek);
    }

    private DopravniProstredek novyNakladniAutomobil() {
        Dialog<String> dialogNakladniAutomobil = new Dialog<>();
        tools(dialogNakladniAutomobil, "Nový nákladní automobil","Vyplňte informace o novém nákladním automobilu" );
        btnVytvorit.setOnAction((event) -> {
            if(paramCheckSpz(txtFieldSPZ)!=true)return;
            String spz = txtFieldSPZ.getText().toUpperCase();
            if(paramCheckInt(txtFieldVykon)!= true)return;
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            if(paramCheckInt(txtFieldHmotnost) != true)return;
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            NakladniAutomobilTyp typRidicskehoOpravneni = comboBoxVolbaTypuNakladnihoAutomobilu.getValue();
            if(paramCheckInt(txtFieldMaxNosnost) != true)return;
            int maxNosnost = Integer.parseInt(txtFieldMaxNosnost.getText());
            dopravniProstredek = new NakladniAutomobil(DopravniProstredekTyp.NAKLADNI_AUTOMOBIL,
                    spz, hmotnost, vykon, typRidicskehoOpravneni, maxNosnost);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogNakladniAutomobil.showAndWait();
        return dopravniProstredek;
    }

    private DopravniProstredek novyNakladniAutomobil(DopravniProstredek dopravniProstredek) {
        NakladniAutomobil nakladniAutomobil = (NakladniAutomobil) dopravniProstredek;
        Dialog<String> dialogNakladniAutomobil = new Dialog<>();
        tools(dialogNakladniAutomobil, "Úprava hodnot nákladního automobilu", "Vyplňte nové informace o upravovaném nákladním automobilu");
        btnVytvorit.setOnAction((event) -> {
            if(paramCheckSpz(txtFieldSPZ)!=true)return;
            String spz = txtFieldSPZ.getText().toUpperCase();
            nakladniAutomobil.setSpz(spz);
            if(paramCheckInt(txtFieldVykon)!= true)return;
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            nakladniAutomobil.setVykon(vykon);
            if(paramCheckInt(txtFieldHmotnost) != true)return;
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            nakladniAutomobil.setHmotnost(hmotnost);
            NakladniAutomobilTyp typNakladnihoAutomobilu = comboBoxVolbaTypuNakladnihoAutomobilu.getValue();
            nakladniAutomobil.setNaTyp(typNakladnihoAutomobilu);
            if(paramCheckInt(txtFieldMaxNosnost) != true)return;
            int maxNosnost = Integer.parseInt(txtFieldMaxNosnost.getText());
            nakladniAutomobil.setMaxNosnost(maxNosnost);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogNakladniAutomobil.showAndWait();
        return nakladniAutomobil;
    }
     private void tools(Dialog<String> dialogNakladniAutomobil, String msgTitle, String msgHeaderText){
        dialogNakladniAutomobil.setTitle(msgTitle);
        DialogTools dialogToolsCW = new DialogTools(dialogNakladniAutomobil, 400, 400);
        DialogTools dialogToolsFont = new DialogTools(labelSPZ, labelVykon,
                labelHmotnost, labelTypNakladnihoAutomobilu, labelMaximalniNosnost);
        DialogTools dialogToolsTF = new DialogTools(txtFieldSPZ, txtFieldVykon,
                txtFieldHmotnost, txtFieldMaxNosnost, stringTFP);
        setComboBoxRidicskeOpravneni();
        VBox box = new VBox();
        VBox vboxThree = new VBox(20);
        VBox vboxOne = new VBox(24);
        VBox vboxTwo = new VBox(19);
        HBox hbox = new HBox(20);
        vboxOne.getChildren().addAll(labelSPZ, labelVykon, labelHmotnost,
                labelTypNakladnihoAutomobilu, labelMaximalniNosnost);
        vboxOne.setAlignment(Pos.TOP_LEFT);
        vboxTwo.getChildren().addAll(txtFieldSPZ, txtFieldVykon, txtFieldHmotnost,
                comboBoxVolbaTypuNakladnihoAutomobilu, txtFieldMaxNosnost, btnVytvorit);
        vboxThree.getChildren().add(btnVytvorit);
        vboxThree.setAlignment(Pos.CENTER);
        vboxThree.setPadding(new Insets(40, 0, 0, 0));
        btnVytvorit.setPrefSize(100, 40);
        hbox.setPadding(new Insets(25, 0, 0, 20));
        hbox.getChildren().addAll(vboxOne, vboxTwo);
        box.getChildren().addAll(hbox, vboxThree);
        dialogNakladniAutomobil.getDialogPane().setHeaderText(msgHeaderText);
        dialogNakladniAutomobil.getDialogPane().setContent(box);
     }
    private void setComboBoxRidicskeOpravneni() {
        comboBoxVolbaTypuNakladnihoAutomobilu.getItems().addAll(NakladniAutomobilTyp.CISTERNA,
                NakladniAutomobilTyp.PLACHTA, NakladniAutomobilTyp.SKLAPEC, NakladniAutomobilTyp.SKRIN,
                NakladniAutomobilTyp.VALNIK);
        comboBoxVolbaTypuNakladnihoAutomobilu.getSelectionModel().selectFirst();
        comboBoxVolbaTypuNakladnihoAutomobilu.setPrefWidth(200);
    }

    public DopravniProstredek getDopravniProstredek() {
        return dopravniProstredek;
    }

    public void setDopravniProstredek(DopravniProstredek dopravniProstredek) {
        this.dopravniProstredek = dopravniProstredek;
    }
}
