package sample.Game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.EndPage.EndPageController;
import sample.Game.objects.Missile;
import sample.Game.objects.Player;
import sample.EndPage.FinalScoreManager;

//controls the GamePage.fxml
public class GamePageController {
    public AnchorPane anchorPane;
    public Label displayPlayerName;
    private FinalScoreManager finalScoreManager;
    public Label score;

    private ArrayList<Missile> missiles;
    private double missileSpeed = 7;
    private double missileSpeedCounter = 0;
    private long timeOfNextMissileCreation = 0;
    private long missileDelay = 700000000;
    private int missileDelayCounter = 0;

    public ImageView playerImageView;
    private Player player;
    private AnimationTimer animationTimer;

    //Requires: KeyEvent keyEvent
    //Modifies: nothing
    //Effects: recognizes the up and down keys for the direction.
    //All other keys make the player motionless.
    public void handleKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP){
            player.setDirectionUp();
        } else if (keyEvent.getCode() == KeyCode.DOWN){
            player.setDirectionDown();
        } else {
            player.setDirectionMotionless();
        }
    }

    //Requires: KeyEvent keyEvent
    //Modifies: this, keyEvent
    //Effects: Make the player motionless when keys are released.
    public void handleKeyRelease(KeyEvent keyEvent) {
        player.setDirectionMotionless();
    }

    //Requires: Call this when the action view is displayed.
    //Modifies: the scene
    //Effects: Initializes the key handlers, the player and empty list of missiles,
    //and starts the animation timer.
    public void startPlay(){
        Scene scene = score.getScene();
        scene.setOnKeyPressed(this::handleKeyPress);
        scene.setOnKeyReleased(this::handleKeyRelease);

        finalScoreManager = new FinalScoreManager();

        player = new Player(playerImageView);
        missiles = new ArrayList<>();

        animationTimer = new AnimationTimer() {
            public void handle(long now){
                try {
                    animationTick(now);
                } catch(Exception x) {
                }
            }
        };
        animationTimer.start();
    }

    //Requires: long now - the time provided when the animation engine calls this
    //Modifies: the scene components being animated
    //Effects: moves the player if needed, moves/removes/creates missiles as needed,
    //and updates the screen score.
    private void animationTick(long now) throws IOException{
        player.move();
        ArrayList<Missile> remainingMissiles = new ArrayList<>();
        for(Missile missile : missiles){
            boolean isOffScreen = missile.move();
            if(isOffScreen){
                incrementScore();
            } else {
                if(player.isCollidingWithMissile(missile)){
                    endGame();
                    return;
                } else {
                    remainingMissiles.add(missile);
                }
            }
        }
        missiles = remainingMissiles;

        if (now < timeOfNextMissileCreation){
            return;
        }

        if (missileDelayCounter == 15){
            missileDelay -= 100050000;
            missileDelayCounter++;
        }
        long randomDelay = missileDelay;
        timeOfNextMissileCreation = now + randomDelay;

        if (missileSpeedCounter == 10){
            missileSpeedCounter = 0;
            missileSpeed += 2;
        }
        Missile missile = new Missile(anchorPane, missileSpeed);
        missileSpeedCounter++;
        missiles.add(missile);
    }

    //Requires: nothing
    //Modifies: this, numberMissilesDodged and score
    //Effects: adds 1 to the screen score
    private void incrementScore(){
        int numberMissilesDodged = Integer.parseInt(score.getText());
        numberMissilesDodged++;
        score.setText(Integer.toString(numberMissilesDodged));
    }

    //Requires: nothing
    //Modifies: this, animationTimer and finalScoreManager
    //Effects: stops the animation timer, records the final score, and calls changeSceneToGameOverView().
    private void endGame() throws IOException{
        animationTimer.stop();
        int numberMissilesDodged = Integer.parseInt(score.getText());
        finalScoreManager.addScore(numberMissilesDodged);
        changeToEndPage();
    }

    //Requires: nothing
    //Modifies: this, gameOverViewScene and window
    //Effects: Prepares the GameOverView and transfers the view to that scene.
    private void changeToEndPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/EndPage/EndPage.fxml"));
        Parent endPageParent = (Parent)loader.load();
        EndPageController controller = (EndPageController)loader.getController();
        controller.showPlayerName.setText(displayPlayerName.getText() + "!");
        Scene endPageScene = new Scene(endPageParent);
        Stage window = (Stage)score.getScene().getWindow();
        window.setScene(endPageScene);
        window.show();
    }
}
