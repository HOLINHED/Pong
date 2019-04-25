import javax.swing.*;

class User extends Player {

    private JPanel window;

    User(JPanel window) {
        super(20);
        this.window = window;
    }

    @Override
    void turn() {
        try {
            int newPos = window.getMousePosition().y - Player.HEIGHT / 2;
            if (newPos + Player.HEIGHT > Pong.HEIGHT) {
                newPos = Pong.HEIGHT - Player.HEIGHT;
            }
            if (newPos < 0) {
                newPos = 0;
            }
            setPos(newPos);
        } catch (NullPointerException ignored) { }
    }

}
