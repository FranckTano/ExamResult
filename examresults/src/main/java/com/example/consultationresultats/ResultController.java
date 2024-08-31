package com.example.consultationresultats;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResultController {
    @FXML
    private Label messageLabel;
    @FXML
    private Button detailsButton;
    @FXML
    private VBox resultBox; // Référence à la boîte principale pour changer les couleurs

    private Etudiant etudiant;

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        boolean isSuccess = etudiant.getMoyenne() >= 10;
        messageLabel.setText(isSuccess ? "Félicitations, vous avez réussi!" : "Désolé, vous avez échoué.");

        // Changement des couleurs en fonction du succès ou de l'échec
        if (isSuccess) {
            resultBox.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Vert pour succès
            detailsButton.setStyle("-fx-background-color: #388E3C; -fx-text-fill: white;");
        } else {
            resultBox.setStyle("-fx-background-color: #F44336; -fx-text-fill: white;"); // Rouge pour échec
            detailsButton.setStyle("-fx-background-color: #D32F2F; -fx-text-fill: white;");
        }
    }

    @FXML
    protected void onDetailsButtonClick() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("details-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            stage.setScene(scene);
            stage.setTitle("Détails de l'étudiant");
            stage.show();

            DetailsController detailsController = fxmlLoader.getController();
            detailsController.setEtudiant(etudiant);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
