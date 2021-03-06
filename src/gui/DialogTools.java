package gui;

import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author janch
 */
public class DialogTools {

    public DialogTools(Dialog dialogN, int w, int h) {
        closebleOkno(dialogN, w, h);
    }

    public DialogTools(Label labelSPZ, Label labelVykon, Label labelHmotnost, Label labelCB, Label labelP) {
        setLabelFontSize(labelSPZ, labelVykon, labelHmotnost, labelCB, labelP);
    }

    public DialogTools(TextField txtFieldSPZ, TextField txtFieldVykon, TextField txtFieldHmotnost, TextField txtFieldP, String stringTFP) {
        setTextFieldPromptText(txtFieldSPZ, txtFieldVykon, txtFieldHmotnost, txtFieldP, stringTFP);
    }
    public void novyDialog(){
    
    }
    private void setLabelFontSize(Label labelSPZ, Label labelVykon, Label labelHmotnost, Label labelCB, Label labelP) {
        labelSPZ.setText("SPZ (8 znaků)");
        labelVykon.setText("Výkon");
        labelHmotnost.setText("Hmotnost");
        labelSPZ.setFont(new Font(15));
        labelVykon.setFont(new Font(15));
        labelHmotnost.setFont(new Font(15));
        labelCB.setFont(new Font(15));
        labelP.setFont(new Font(15));
    }

    private void setTextFieldPromptText(TextField txtFieldSPZ, TextField txtFieldVykon, TextField txtFieldHmotnost, TextField txtFieldP, String stringTFP) {
        txtFieldSPZ.setPromptText("Zadejte 8 místnou SPZ");
        txtFieldVykon.setPromptText("Zadejte výkon vozidla");
        txtFieldHmotnost.setPromptText("Zadejte hmotnost vozidla");
        txtFieldP.setPromptText(stringTFP);
    }

    private void closebleOkno(Dialog dialogN, int w, int h) {
        dialogN.getDialogPane().setPrefSize(w, h);
        dialogN.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        Node closeButtonD = dialogN.getDialogPane().lookupButton(ButtonType.CLOSE);
        closeButtonD.managedProperty().bind(closeButtonD.visibleProperty());
        closeButtonD.setVisible(false);
    }
    
}
