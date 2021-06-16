package gui;

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import prostredky.*;
import sprava.*;
import kolekce.*;

/**
 *
 * @author janch
 */
public class MainFX extends Application {

    private final Ovladani spravce = new SpravaProstredku();
    private final BorderPane root = new BorderPane();
    private final HBox hbox = new HBox();
    private final VBox vbox = new VBox();
    private ListView<Object> list = new ListView<>();
    private static String BIN_SOUBOR = "zaloha.bin";
    private static String BIN_SOUBOR_BUG = "bug.bin";
    private static String TEXT_SOUBOR = "prostredky.csv";
    private ComboBox novy;
    private DopravniProstredek dopravniProstredek = null;
    private boolean clicked = false;
    private boolean kliknutoOK = false;
    private ComboBox<DopravniProstredekTyp> comboBoxFiltr = newComboBox("Filtr", DopravniProstredekTyp.getProstredkyFilter());

    @Override
    public void init() throws Exception {
        super.init();
        spravce.vytvorSeznam(LinSeznam::new);
        root.setPrefWidth(850);
        root.setPrefHeight(600);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setPadding(new Insets(10));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        vytvorScenu();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Správa dopravních prostředků");
        primaryStage.show();
    }

    private void vytvorScenu() {
        hbox.getChildren().addAll(
                newButton("Generuj", generujData()), newButton("Ulož", uloz()),
                newButton("Načti", nactiText()), newLabel("Nový: ", TextAlignment.LEFT),
                newButton("Nový", zadejNovyDopravniProstredek()),
                newLabel("Filtr: ", TextAlignment.LEFT), comboBoxFiltr,
                newButton("Najdi", najdi()), newButton("Zálohuj", zalohuj()),
                newButton("Obnov", obnov()), newButton("Zruš", zrus()),
                newButton("Ukončit", ukoncitProgram()));
        vbox.getChildren().addAll(
                newLabel("Procházení", TextAlignment.JUSTIFY),
                newButtonV("první", prvni()), newButtonV("předchozí", predchozi()),
                newButtonV("další", dalsi()), newButtonV("poslední", posledni()),
                newLabel("Příkazy", TextAlignment.LEFT),
                newButtonV("Edituj", edituj()), newButtonV("Vyjmi", vyjmi()),
                newButtonV("Zobraz", zobraz()));
        root.setBottom(hbox);
        root.setRight(vbox);
        root.setCenter(list);
        comboBoxFiltrListener();
    }

    private void comboBoxFiltrListener() {
        comboBoxFiltr.valueProperty().addListener((changed, oldVal, newVal) -> {
            list.getItems().clear();
            DopravniProstredek dp = null;
            if (spravce.dejKopiiAktualniPolozky() != null) {
                dp = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
            }
            spravce.prejdiNaPrvniPolozku();
            for (int i = 0; i < spravce.dejAktualniPocetPolozek(); i++) {
                DopravniProstredek polozka = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
                if (comboBoxFiltr.getValue() == polozka.getTypNazev()) {
                    list.getItems().add(polozka);
                }
                spravce.prejdiNaDalsiPolozku();
                polozka = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
            }
            if (comboBoxFiltr.getValue() == DopravniProstredekTyp.NON_FILTER) {
                spravce.stream().forEach(t -> list.getItems().add(t));
            }
            if (dp != null) {
                spravce.nastavAktualniPolozku(new DopravniProstredekKlic(dp.getSpz()));
            }
            dp = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
            System.out.println("Vyfiltrováno");
        });
    }

    private static Button newButton(
            String text, EventHandler<ActionEvent> handler) {
        Button button = new Button(text);
        button.setOnAction(handler);
        return button;
    }

    private static Button newButtonV(
            String text, EventHandler<ActionEvent> handler) {
        Button button = new Button(text);
        button.setOnAction(handler);
        button.setPrefWidth(70);
        return button;
    }

    private static Label newLabel(String text, TextAlignment ta) {
        Label lbl = new Label(text);
        lbl.setTextAlignment(ta);
        return lbl;
    }

    private static ComboBox<DopravniProstredekTyp> newComboBox(String text, Enum[] vycet) {
        ComboBox comboBox = new ComboBox<>(FXCollections.observableList(Arrays.asList(vycet)));
        comboBox.setPromptText(text);
        return comboBox;
    }

    private static ComboBox comboBoxNovy(String text, Enum[] vycet) {
        ComboBox comboBox = new ComboBox(FXCollections.observableList(Arrays.asList(vycet)));
        comboBox.setPromptText(text);
        return comboBox;
    }

    private void alert(String nazev, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(nazev);
        alert.setContentText(text);
        alert.showAndWait();
    }

    private void obnovZobrazeniSeznamu() {
        list.getItems().clear();
        spravce.stream().forEach(t -> list.getItems().add(t));
    }

    private EventHandler<ActionEvent> ukoncitProgram() {
        return event -> {
            System.exit(0);
        };
    }

    private EventHandler<ActionEvent> generujData() {
        return event -> {
            int pocet = pocetProstredkuKVygenerovani();
            spravce.generujData(pocet);
            list.getItems().clear();
            obnovZobrazeniSeznamu();
            if (pocet != 0) {
                System.out.println("Data úspěšně vygenerována.");
            }

        };
    }

    private EventHandler<ActionEvent> zrus() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Nelze zrušit seznam, jelikož je prázdný.");
            } else {
                spravce.zrus();
                list.getItems().clear();
            }
        };
    }

    private EventHandler<ActionEvent> prvni() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Nelze nastavit první dopravní prostředek, jelikož seznam je prázdný.");
            } else {
                spravce.prejdiNaPrvniPolozku();
                list.getSelectionModel().selectFirst();
            }
        };
    }

    private EventHandler<ActionEvent> dalsi() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Nelze nastavit další dopravní prostředek jako aktuální, jelikož seznam je prázdný.");
            } else if (spravce.dejKopiiAktualniPolozky() == null) {
                spravce.prejdiNaPrvniPolozku();
                list.getSelectionModel().selectFirst();
            } else {
                spravce.prejdiNaDalsiPolozku();
                list.getSelectionModel().selectNext();
            }
        };
    }

    private EventHandler<ActionEvent> predchozi() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Nelze nastavit předchozí dopravní prostředek jako aktuální, jelikož seznam je prázdný.");
            } else if (spravce.dejKopiiAktualniPolozky() == null) {
                alert("Chyba!", "Nelze nastavit předchozí dopravní prostředek jako aktuální, jelikož není nastaven aktuální prostředek.");
            } else if (list.getSelectionModel().getSelectedIndex() == 0) {
                alert("Chyba!", "Nelze nastavit předchozí dopravní prostředek jako aktuální, jelikož aktuální prostředek je první v seznamu.");
            } else {
                spravce.prejdiNaPredchoziPolozku();
                list.getSelectionModel().selectPrevious();
            }
        };
    }

    private EventHandler<ActionEvent> posledni() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Nelze nastavit poslední dopravní prostředek jako aktuální, jelikož seznam je prázdný.");
            } else {
                spravce.prejdiNaPosledniPolozku();
                list.getSelectionModel().selectLast();
            }
        };
    }

    private EventHandler<ActionEvent> vyjmi() {
        return event -> {
            spravce.vyjmiAktualniPolozku();
            bugIsFixedByThisMethod();
        };
    }

    private EventHandler<ActionEvent> zobraz() {
        return event -> {
            if (spravce.dejKopiiAktualniPolozky() == null) {
                alert("Chyba!", "Nelze zobrazit aktuální dopravní prostředek, jelikož žádný není nastaven.");
            } else {
                DopravniProstredek puvAktualni = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
                spravce.prejdiNaPrvniPolozku();
                DopravniProstredek aktualni = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
                int pozice = 0;
                while (aktualni.getSpz() != puvAktualni.getSpz()) {
                    spravce.prejdiNaDalsiPolozku();
                    aktualni = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
                    pozice++;
                }
                list.getSelectionModel().select(pozice);
            }
        };
    }

    private EventHandler<ActionEvent> zalohuj() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Nelze zálohovat seznam dopravních prostředků, jelikož seznam je prázdný.");
            } else {
                spravce.ulozDoSouboru(BIN_SOUBOR);
            }
        };
    }

    private EventHandler<ActionEvent> obnov() {
        return event -> {
            try {
                spravce.nactiZeSouboru(BIN_SOUBOR);
                list.getItems().clear();
                spravce.stream().forEach(t -> list.getItems().add(t));
            } catch (Exception e) {
                alert("Chyba!", "Nepodařilo se seznam obnovit.");
            }
        };
    }

    private EventHandler<ActionEvent> uloz() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Nelze uložit seznam dopravních prostředků do textového souboru, jelikož seznam je prázdný.");
            } else {
                spravce.ulozTextSoubor(TEXT_SOUBOR, perzistence.Mappers.mapperOutput);
            }
        };
    }

    private EventHandler<ActionEvent> nactiText() {
        return event -> {
            try {
                spravce.nactiTextSoubor(TEXT_SOUBOR, perzistence.Mappers.mapperInput);
                spravce.stream().forEach(t -> list.getItems().add(t));
            } catch (Exception e) {
                alert("Chyba!", "Nepodařilo se načíst seznam.");
            }
        };
    }

    private EventHandler<ActionEvent> zadejNovyDopravniProstredek() {
        return event -> {
            novy = comboBoxNovy("Možnosti", DopravniProstredekTyp.getProstredky());
            DialogDopravniProstredek dialog = new DialogDopravniProstredek();
            if (dialog.isKliknuto() == true) {
                String value = dialog.typ.getValue();
                switch (value) {
                    case "Dodávka":
                        DialogDodavka dialogD = new DialogDodavka();
                        DopravniProstredek dodavka = dialogD.getDopravniProstredek();
                        try {
                            spravce.vlozPolozku(dodavka);
                        } catch (Exception e) {}
                        break;
                    case "Motocykl":
                        DialogMotocykl dialogM = new DialogMotocykl();
                        DopravniProstredek motocykl = dialogM.getDopravniProstredek();
                        try {
                            spravce.vlozPolozku(motocykl);
                        } catch (Exception e) {}
                        break;
                    case "Nákladní automobil":
                        DialogNakladniAutomobil dialogNA = new DialogNakladniAutomobil();
                        DopravniProstredek nakladniAutomobil = dialogNA.getDopravniProstredek();
                        try {
                            spravce.vlozPolozku(nakladniAutomobil);
                        } catch (Exception e) {}
                        break;
                    case "Osobní automobil":
                        DialogOsobniAutomobil dialogOA = new DialogOsobniAutomobil();
                        DopravniProstredek osobniAutomobil = dialogOA.getDopravniProstredek();
                        try {
                            spravce.vlozPolozku(osobniAutomobil);
                        } catch (Exception e) {}
                        break;
                    case "Traktor":
                        DialogTraktor dialogT = new DialogTraktor();
                        DopravniProstredek traktor = dialogT.getDopravniProstredek();
                        try {
                            spravce.vlozPolozku(traktor);
                        } catch (Exception e) {
                        }
                        break;}}
            obnovZobrazeniSeznamu();};}

    private EventHandler<ActionEvent> edituj() {
        return event -> {
            if (spravce.dejAktualniPocetPolozek() == 0) {
                alert("Chyba!", "Seznam je prázdný.");
            } else if (list.getSelectionModel().getSelectedItem() == null) {
                alert("Chyba!", "Není vybrán prvek k úpravě.");
            } else {
                dopravniProstredek = (DopravniProstredek) list.getSelectionModel().getSelectedItem();
                Editor edit = new Editor(dopravniProstredek);
                obnovZobrazeniSeznamu();
            }
        };
    }
    
    private EventHandler<ActionEvent> najdi() {
        return event -> {
            DopravniProstredekKlic klic = null;
            Filtr filtr = new Filtr();
            if (filtr.kliknuto == true) {
                if (filtr.typ.getValue() == "ID") {
                    klic = filtr.vstupnidataID();
                } else if (filtr.typ.getValue() == "SPZ") {
                    klic = filtr.vstupnidataSPZ();
                }
                Object NullPointerException = null;
                if (klic == null) {
                } else if (spravce.nastavAktualniPolozku(klic) == NullPointerException) {
                    alert("Chyba!", "Dopravní prostředek s touto hodnotou nenalezen!");
                } else {
                    spravce.nastavAktualniPolozku(klic);
                    System.out.println(spravce.dejKopiiAktualniPolozky());
                    DopravniProstredek puvAkt = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
                    spravce.prejdiNaPrvniPolozku();
                    DopravniProstredek aktualni = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
                    int pozice = 0;
                    while (aktualni.getSpz() != puvAkt.getSpz()) {
                        spravce.prejdiNaDalsiPolozku();
                        aktualni = (DopravniProstredek) spravce.dejKopiiAktualniPolozky();
                        pozice++;
                    }
                    list.getSelectionModel().select(pozice);
                }
            }
        };
    }

    private int pocetProstredkuKVygenerovani() {
        Dialog<String> dialog = new Dialog<>();
        DialogTools dialogToolsCW = new DialogTools(dialog, 400, 200);
        TextField txtFieldPocet = new TextField();
        dialog.setTitle("Počet dopravních prostředků k vygenerování");
        dialog.setHeaderText("Do textového pole napište, kolik prostředků si přejete vygenerovat.");
        Button btnOK = new Button("Potvrdit");
        btnOK.setOnAction((event) -> {
            kliknutoOK = false;
            if (paramCheckInt(txtFieldPocet) != true)return;
            Stage stageBtnOK = (Stage) btnOK.getScene().getWindow();
            stageBtnOK.close();
            kliknutoOK = true;});
        Button btnCancel = new Button("Zrušit");
        btnCancel.setOnAction((event) -> {
            Stage stageBtnClose = (Stage) btnCancel.getScene().getWindow();
            stageBtnClose.close();
        });
        GridPane grid = new GridPane();
        grid.setVgap(7);
        grid.add(txtFieldPocet, 1, 1);
        HBox box = new HBox(160);
        box.getChildren().addAll(btnOK, btnCancel);
        box.setAlignment(Pos.BOTTOM_CENTER);
        btnOK.setPrefSize(120, 35);
        btnCancel.setPrefSize(120, 35);
        grid.add(box, 1, 4);
        dialog.getDialogPane().setContent(grid);
        dialog.showAndWait();
        int pocet = 0;
        if (kliknutoOK == true) {
            pocet = Integer.parseInt(txtFieldPocet.getText());}
        return pocet;
    }

    private boolean paramCheckInt(TextField txtField) {
        if (txtField.getText().isEmpty()) {
            txtField.setText("");
            txtField.requestFocus();
            alert("Chybně zadaná hodnota!", "Zadaná hodnota musí být celé číslo.");
            return false;
        } else {
            try {
                int parse = Integer.parseInt(txtField.getText());
                if (parse > 0 && parse < 25) {
                    return true;
                } else {
                    txtField.setText("");
                    txtField.requestFocus();
                    alert("Chybně zadaná hodnota!", "Zadaná hodnota musí být celé číslo větší než 0 a menší než 25.");
                    return false;
                }
            } catch (Exception e) {
                txtField.setText("");
                txtField.requestFocus();
                alert("Chybně zadaná hodnota!", "Zadaná hodnota musí být celé číslo.");
                return false;
            }
        }
    }

    private void bugIsFixedByThisMethod() {
        spravce.ulozDoSouboru(BIN_SOUBOR_BUG);
        spravce.nactiZeSouboru(BIN_SOUBOR_BUG);
        list.getItems().clear();
        spravce.stream().forEach(t -> list.getItems().add(t));
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
