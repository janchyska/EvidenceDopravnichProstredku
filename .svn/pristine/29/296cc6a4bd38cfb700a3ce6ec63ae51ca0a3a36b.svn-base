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
import prostredky.Motocykl;
import prostredky.RidicskeOpravneni;
import prostredky.DopravniProstredek;
import prostredky.DopravniProstredekTyp;

/**
 *
 * @author janch
 */
public class DialogMotocykl extends KontrolaVstupnichDat{

    private DopravniProstredek dopravniProstredek;
    private final ComboBox<RidicskeOpravneni> comboBoxVolbaRidicskehoOpravneni = new ComboBox<>();
    private final TextField txtFieldSPZ = new TextField();
    private final TextField txtFieldVykon = new TextField();
    private final TextField txtFieldHmotnost = new TextField();
    private final TextField txtFieldObjemMotoru = new TextField();
    private final Label labelSPZ = new Label();
    private final Label labelVykon = new Label();
    private final Label labelHmotnost = new Label();
    private final Label labelRidicskeOpravneni = new Label("Řidičské oprávnění");
    private final Label labelObjemMotoru = new Label("Objem motoru");
    private final String stringTFP = "Zadejte objem motoru vozidla";
    private final Button btnVytvorit = new Button("Přidat");

    public DialogMotocykl() {
        novyMotocykl();
    }

    public DialogMotocykl(DopravniProstredek dopravniProstredek) {
        novyMotocykl(dopravniProstredek);
    }

    private DopravniProstredek novyMotocykl() {
        Dialog<String> dialogMotocykl = new Dialog<>();
        tools(dialogMotocykl, "Nový motocykl","Vyplňte informace o novém motocyklu");
        btnVytvorit.setOnAction((event) -> {
            if(paramCheckSpz(txtFieldSPZ)!=true)return;
            String spz = txtFieldSPZ.getText().toUpperCase();
            if(paramCheckInt(txtFieldVykon)!=true)return;
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            if(paramCheckInt(txtFieldHmotnost) != true)return;
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            RidicskeOpravneni typRidicskehoOpravneni = comboBoxVolbaRidicskehoOpravneni.getValue();
            if(paramCheckInt(txtFieldObjemMotoru)!=true)return;
            int objemMotoru = Integer.parseInt(txtFieldObjemMotoru.getText());
            dopravniProstredek = new Motocykl(DopravniProstredekTyp.MOTOCYKL,
                    spz, hmotnost, vykon, typRidicskehoOpravneni, objemMotoru);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogMotocykl.showAndWait();
        return dopravniProstredek;
    }

    private DopravniProstredek novyMotocykl(DopravniProstredek dopravniProstredek) {
        Motocykl motocykl = (Motocykl) dopravniProstredek;
        Dialog<String> dialogMotocykl = new Dialog<>();
        tools(dialogMotocykl, "Úprava hodnot motocyklu", "Vyplňte nové informace o upravovaném motocyklu");
        btnVytvorit.setOnAction((event) -> {
            if(paramCheckSpz(txtFieldSPZ)!=true)return;
            String spz = txtFieldSPZ.getText().toUpperCase();
            motocykl.setSpz(spz);
            if(paramCheckInt(txtFieldVykon)!=true)return;
            int vykon = Integer.parseInt(txtFieldVykon.getText());
            motocykl.setVykon(vykon);
            if(paramCheckInt(txtFieldHmotnost) != true)return;
            int hmotnost = Integer.parseInt(txtFieldHmotnost.getText());
            motocykl.setHmotnost(hmotnost);
            RidicskeOpravneni typRidicskehoOpravneni = comboBoxVolbaRidicskehoOpravneni.getValue();
            motocykl.setRidickeOpravneni(typRidicskehoOpravneni);
            if(paramCheckInt(txtFieldObjemMotoru)!=true)return;
            int objemMotoru = Integer.parseInt(txtFieldObjemMotoru.getText());
            motocykl.setObjemMotoru(objemMotoru);
            Stage stageBtnVytvorit = (Stage) btnVytvorit.getScene().getWindow();
            stageBtnVytvorit.close();
        });
        dialogMotocykl.showAndWait();
        return motocykl;
    }
   private void tools(Dialog<String> dialogMotocykl, String msgTitle, String msgHeaderText){
   dialogMotocykl.setTitle(msgTitle);
        DialogTools dialogToolsCW = new DialogTools(dialogMotocykl, 400, 400);
        DialogTools dialogToolsFont = new DialogTools(labelSPZ, labelVykon,
                labelHmotnost, labelRidicskeOpravneni, labelObjemMotoru);
        DialogTools dialogToolsTF = new DialogTools(txtFieldSPZ, txtFieldVykon,
                txtFieldHmotnost, txtFieldObjemMotoru, stringTFP);
        setComboBoxRidicskeOpravneni();
        VBox box = new VBox();
        VBox vboxThree = new VBox(20);
        VBox vboxOne = new VBox(24);
        VBox vboxTwo = new VBox(19);
        HBox hbox = new HBox(20);
        vboxOne.getChildren().addAll(labelSPZ, labelVykon, labelHmotnost,
                labelRidicskeOpravneni, labelObjemMotoru);
        vboxOne.setAlignment(Pos.TOP_LEFT);
        vboxTwo.getChildren().addAll(txtFieldSPZ, txtFieldVykon, txtFieldHmotnost,
                comboBoxVolbaRidicskehoOpravneni, txtFieldObjemMotoru, btnVytvorit);
        vboxThree.getChildren().add(btnVytvorit);
        vboxThree.setAlignment(Pos.CENTER);
        vboxThree.setPadding(new Insets(40, 0, 0, 0));
        btnVytvorit.setPrefSize(100, 40);
        hbox.setPadding(new Insets(25, 0, 0, 20));
        hbox.getChildren().addAll(vboxOne, vboxTwo);
        box.getChildren().addAll(hbox, vboxThree);
        dialogMotocykl.getDialogPane().setHeaderText(msgHeaderText);
        dialogMotocykl.getDialogPane().setContent(box);
   }
    private void setComboBoxRidicskeOpravneni() {
        comboBoxVolbaRidicskehoOpravneni.getItems().addAll(RidicskeOpravneni.A,
                RidicskeOpravneni.A1, RidicskeOpravneni.A2, RidicskeOpravneni.AM,
                RidicskeOpravneni.NEZNAME);
        comboBoxVolbaRidicskehoOpravneni.getSelectionModel().selectLast();
        comboBoxVolbaRidicskehoOpravneni.setPrefWidth(200);
    }

    public DopravniProstredek getDopravniProstredek() {
        return dopravniProstredek;
    }

    public void setDopravniProstredek(DopravniProstredek dopravniProstredek) {
        this.dopravniProstredek = dopravniProstredek;
    }
}
