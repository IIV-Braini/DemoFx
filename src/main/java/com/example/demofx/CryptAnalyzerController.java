package com.example.demofx;

import com.example.demofx.service.Alphabet;
import com.example.demofx.service.File;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CryptAnalyzerController {
    @FXML
    private Label welcomeTextEncode;
    @FXML
    private Label welcomeTextDecode;
    @FXML
    private Label welcomeTextBruteForce;
    @FXML
    public TextField filePathEncode;
    @FXML
    public TextField filePathDecode;
    @FXML
    public TextField filePathBruteForce;
    @FXML
    public TextField keyEncode;
    @FXML
    public TextField keyDecode;
    @FXML
    public TextField filePathAnalyzed;

    @FXML
    protected void onEncodeButtonClickRun() {
        try {
            File fileIn = new File(filePathEncode.getText());
            int key = Integer.parseInt(keyEncode.getText()) % Alphabet.listSymbols.size();
            fileIn.encoding(key);
            welcomeTextEncode.setText("Encode Done!");
        } catch (RuntimeException e) {
            welcomeTextEncode.setText("Ошибка программы!");
        }

    }

    @FXML
    protected void onDecodeButtonClickRun() {
        try {
            File fileIn = new File(filePathDecode.getText());
            int key = Integer.parseInt(keyDecode.getText()) % Alphabet.listSymbols.size();
            fileIn.decoding(key);
            welcomeTextDecode.setText("Decode Done!");
        } catch (RuntimeException e) {
            welcomeTextDecode.setText("Ошибка программы!");
        }

    }

    @FXML
    protected void onBruteForceButtonClickRun() {
        try {
            File fileIn = new File(filePathBruteForce.getText());
            File fileAnalyzer = new File(filePathAnalyzed.getText());            // Создаем файл для анализа
            fileIn.bruteForce(fileAnalyzer);
                welcomeTextBruteForce.setText("BruteForce Done!");
            } catch (RuntimeException e) {
                welcomeTextBruteForce.setText("Ошибка программы!");
            }
    }
}