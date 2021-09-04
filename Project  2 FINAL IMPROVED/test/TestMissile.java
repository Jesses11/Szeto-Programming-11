import org.junit.Test;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.Game.objects.Missile;

import static org.junit.Assert.assertTrue;


public class TestMissile {

    //Requires: nothing
    //Modifies: this, reachedLeftEdge
    //Effects: tests if the missile created has reached and stops at the left side of the pane
    @Test
    public void testMissileReachesLeftOfScreen() {
        double speed = 10;
        long MIN_X = 10;
        AnchorPane pane = new AnchorPane();
        Missile missile = new Missile(pane, speed);
        ImageView missileImageView = (ImageView)pane.getChildren().get(0); // the ImageVew of the created missile.
        boolean reachedLeftEdge = false;
        while (!reachedLeftEdge) {
            reachedLeftEdge = missile.move();
            System.out.println("x=" + missileImageView.getX());
        }
        // Check that the while loop stops when the missile reaches the left edge of the pane.
        assertTrue(missileImageView.getX() <= MIN_X);
    }

}
