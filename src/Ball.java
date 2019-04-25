import java.awt.*;

class Ball {

    static final int    SPEED     = 10;
    static final double MAX_ANGLE = 5 * Math.PI / 12;
    static final int    SIZE      = 20;

    private double x;
    private double y;
    private double vx;
    private double vy;

    private Player left;
    private Player right;

    Ball(Player left, Player right) {
        reset();
        this.left  = left;
        this.right = right;
    }

    private void reset() {
        x = (double)((Pong.WIDTH / 2) + (SIZE / 2));
        y = (double)((Pong.HEIGHT / 2) + (SIZE / 2));

        // ball starts towards player
        vx = -SPEED;
    }

    void draw(Graphics g) {
        x += vx;
        y += vy;

        // bounce off screen
        if (x < 0)  {
            reset();
            right.goal();
        }
        if (x + SIZE > Pong.WIDTH) {
            reset();
            left.goal();
        }

        if (y < 0 || y + SIZE > Pong.HEIGHT) {
            vy *= -1;
        }

        g.setColor(Color.WHITE);
        g.fillOval((int)x,(int)y,SIZE,SIZE);
    }

    void setV(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    double getY()  { return y;  }
    double getX()  { return x;  }
    double getVx() { return vx; }
    double getVy() { return vy; }

}
