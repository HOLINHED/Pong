import javax.swing.*;
import java.awt.*;

class Pong extends JPanel {

    static final int WIDTH  = 858;
    static final int HEIGHT = 525;

    private User     user;
    private Computer cpu;
    private Ball     ball;

    Pong() {
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);

        user = new User(this);
        cpu  = new Computer();
        ball = new Ball(user,cpu);
        cpu.setBall(ball);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw background
        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        // game logic
        user.turn();
        cpu.turn();

        // handle collision
        user.collide(ball);
        cpu.collide(ball);

        // draw stuff
        ball.draw(g);
        user.draw(g);
        cpu.draw(g);
        g.setColor(Color.WHITE);

        g.setFont(new Font("CONSOLAS", Font.BOLD, 40));
        final String scores = user.getScore() + "          " + cpu.getScore();
        final int w = g.getFontMetrics().stringWidth(scores);
        g.drawString(scores, (WIDTH/2) - (w / 2), 40);
    }

}
