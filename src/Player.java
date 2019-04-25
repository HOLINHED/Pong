import java.awt.*;

abstract class Player {

    static final int HEIGHT = 150;
    static final int WIDTH  = 10;

    private int x;
    private int y;
    private int score;

    Player(int x) {
        this.x = x;
        this.y = (Pong.HEIGHT / 2) - (HEIGHT / 2);
    }

    abstract void turn();

    void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x,y,WIDTH,HEIGHT);
    }

    void setPos(int y) {
        this.y = y;
    }

    void collide(Ball ball) {
        if (x < ball.getX() + Ball.SIZE &&
                x + WIDTH > ball.getX() &&
                y < ball.getY() + Ball.SIZE &&
                y + HEIGHT > ball.getY()) {

            double intersect = (y + (HEIGHT / 2.0)) - ball.getY();
                   intersect /= HEIGHT/2.0; // normalized
            double angle = intersect * Ball.MAX_ANGLE;

            double newVx = Ball.SPEED * Math.cos(angle);
            double newVy = Ball.SPEED * Math.sin(angle);

            if (x > Pong.WIDTH / 2) newVx *= -1;

            ball.setV(newVx,newVy);
        }
    }

    int getScore() { return score; }
    int getY()     { return y;     }

    void goal() { score += 1; }

}
