package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.lang.Math;

public class Controller {

    public Button btnRollDice;
    public TextField lblBetAmount;
    public Button btnLower;
    public Button btnHigher;
    public Label lblFinalScore;
    public Label lblRollNum;
    public Button btnEnd;
    public Button btnSame;
    public Label lblTotalPoints;
    public double totalPoints = 0;
    int lastRoll;


    public void rollDice(ActionEvent actionEvent) {
        int max = 1000;
        int min = 1;
        int range = max - min + 1;
        lastRoll = (int) (Math.random() * range) + min;
        lblRollNum.setText(Integer.toString(lastRoll));
        btnRollDice.setDisable(true);
        btnHigher.setDisable(false);
        btnSame.setDisable(false);
        btnLower.setDisable(false);
    }

    public void higher(ActionEvent actionEvent) {
        int max = 1000;
        int min = 1;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        lblRollNum.setText(Integer.toString(rand));

        if(rand>lastRoll){
            double num = Double.parseDouble(lblBetAmount.getText());
            totalPoints += num;
            lblTotalPoints.setText("Total Points: " + totalPoints);
        }
        else{
            double num = Double.parseDouble(lblBetAmount.getText());
            totalPoints -= num;
            lblTotalPoints.setText("Total Points: " + totalPoints);
        }
        btnRollDice.setDisable(false);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnSame.setDisable(true);
        lblBetAmount.clear();
    }

    public void lower(ActionEvent actionEvent) {
        int max = 1000;
        int min = 1;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        lblRollNum.setText(Integer.toString(rand));

        if(rand<lastRoll){
            double num = Double.parseDouble(lblBetAmount.getText());
            totalPoints += num;
            lblTotalPoints.setText("Total Points: " + totalPoints);
        }
        else{
            double num = Double.parseDouble(lblBetAmount.getText());
            totalPoints -= num;
            lblTotalPoints.setText("Total Points: " + totalPoints);
        }
        btnRollDice.setDisable(false);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnSame.setDisable(true);
        lblBetAmount.clear();
    }

    public void same(ActionEvent actionEvent) {
        int max = 1000;
        int min = 1;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        lblRollNum.setText(Integer.toString(rand));

        if(rand==lastRoll){
            double num = Double.parseDouble(lblBetAmount.getText());
            totalPoints += num;
            lblTotalPoints.setText("Total Points: " + totalPoints);
        }
        else{
            double num = Double.parseDouble(lblBetAmount.getText());
            totalPoints -= num;
            lblTotalPoints.setText("Total Points: " + totalPoints);
        }
        btnRollDice.setDisable(false);
        btnHigher.setDisable(true);
        btnLower.setDisable(true);
        btnSame.setDisable(true);
        lblBetAmount.clear();
    }

    public void endGame(ActionEvent actionEvent) {
        lblFinalScore.setText("Final Score: " + totalPoints);
        btnLower.setDisable(true);
        btnSame.setDisable(true);
        btnHigher.setDisable(true);
        btnRollDice.setDisable(true);
        btnEnd.setDisable(true);

    }
}