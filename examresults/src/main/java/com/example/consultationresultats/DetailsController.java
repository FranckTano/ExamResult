package com.example.consultationresultats;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailsController {
    @FXML
    private Label matriculeLabel;
    @FXML
    private Label nomPrenomLabel;
    @FXML
    private Label dateNaissanceLabel;
    @FXML
    private Label ecoleLabel;
    @FXML
    private Label moyenneLabel;

    private Etudiant etudiant;

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        updateLabels();
    }

    private void updateLabels() {
        if (etudiant != null) {
            matriculeLabel.setText("Matricule: " + etudiant.getMatricule());
            nomPrenomLabel.setText("Nom Prénom: " + etudiant.getNom() + " " + etudiant.getPrenom());
            dateNaissanceLabel.setText("Date de naissance: " + etudiant.getDateNaissance());
            ecoleLabel.setText("École: " + etudiant.getEcole());
            moyenneLabel.setText("Moyenne: " + etudiant.getMoyenne());
        }
    }
}
