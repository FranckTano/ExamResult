package com.example.consultationresultats;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private TextField inscriptionField;
    @FXML
    private Button consulterButton;

    private final Etudiant[] etudiants = {
            new Etudiant("BTS20240001", "Doe", "John", "2000-01-15", "CEFIAT", 12.5),
            new Etudiant("BTS20240002", "Tano", "Jane", "1999-07-23", "PIGIER CI", 9.0),
            new Etudiant("BTS20240003", "Doumbia", "Emily", "2001-11-05", "HEC", 14.0),
            new Etudiant("BTS20240004", "Kouame", "Michael", "2000-05-30", "UCAO", 8.5),
            new Etudiant("BTS20240005", "Yeo", "Sarah", "1999-12-12", "UIPA", 10.0)
    };

    @FXML
    protected void onConsulterButtonClick() {
        String matricule = inscriptionField.getText().trim();

        Etudiant etudiant = findEtudiantByMatricule(matricule);

        if (etudiant == null) {
            showError("Matricule non trouvé.");
        } else {
            showResultWindow(etudiant);
        }
    }

    private Etudiant findEtudiantByMatricule(String matricule) {
        for (Etudiant e : etudiants) {
            if (e.getMatricule().equals(matricule)) {
                return e;
            }
        }
        return null;
    }

    private void showResultWindow(Etudiant etudiant) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("result-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            stage.setScene(scene);
            stage.setTitle("Résultat");
            stage.show();

            ResultController resultController = fxmlLoader.getController();
            resultController.setEtudiant(etudiant);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showError(String message) {
        try {
            Stage stage = new Stage();
            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(20));

            Label errorLabel = new Label(message);
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");

            Button okButton = new Button("OK");
            okButton.setOnAction(event -> stage.close());

            vbox.getChildren().addAll(errorLabel, okButton);

            Scene scene = new Scene(vbox, 300, 150);
            stage.setScene(scene);
            stage.setTitle("Erreur");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
