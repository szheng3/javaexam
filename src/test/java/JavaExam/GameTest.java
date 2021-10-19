package JavaExam;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void placeChoice() {
        Game game = new Game();
        assertNull(game.placeChoice(1));
    }

    @Test
    public void placeChoice2() {
        Game game = new Game();
        game.placeChoice(1);
        game.placeChoice(2);
        game.placeChoice(4);
        game.placeChoice(5);
        Result result = game.placeChoice(7);
        assertEquals(result,Result.X);
    }
}