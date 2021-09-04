package sample.Game.objects;

import javafx.scene.image.ImageView;

//manages the movement as well as the interactions of the object player
public class Player {
    private ImageView playerImageView;
    private double increment = 0;

    private static final double MIN_Y = -140;
    private static final double MAX_Y = 150;
    private static final double INCREMENT_Y = 7;

    //Requires: ImageView playerImageView
    //Modifies: this, playerImageView
    //Effects: saves the received playerImageView
    public Player(ImageView playerImageView) {
        this.playerImageView = playerImageView;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: makes the increment negative so the direction is going up
    public void setDirectionUp() {
        increment = -INCREMENT_Y;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: makes the increment positive so the direction is going down
    public void setDirectionDown() {increment = INCREMENT_Y;}

    //Requires: nothing
    //Modifies: this, increment
    //Effects: removes increment so the player is stationary
    public void setDirectionMotionless() {
        increment = 0;
    }

    //Requires: nothing
    //Modifies: this, playerYPosition and PlayerImageView
    //Effects: moves the player in the direction of the increment (if there is one).  Ensures that the
    //player images stays within the screen.
    public void move(){
        if (increment == 0){
            return;
        }
        double playerYPosition = playerImageView.getY();
        playerYPosition += increment;
        if (playerYPosition < MIN_Y) {
            playerYPosition = MIN_Y;
        } else if (playerYPosition > MAX_Y){
            playerYPosition = MAX_Y;
        }
        playerImageView.setY(playerYPosition);
    }

    //Requires: Missile missile
    //Modifies: nothing
    //Effects: if playerImageView's boundaries intersect with missile's boundaries, than returns true, else returns false
    public boolean isCollidingWithMissile(Missile missile) {
        return playerImageView.getBoundsInParent().intersects(missile.getBoundsInParent());
    }
}
