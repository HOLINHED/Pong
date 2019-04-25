class Computer extends Player {

    private static final int SPEED = 5;

    private Ball ball;

    Computer() {
        super(Pong.WIDTH - (20 + Player.WIDTH));
    }

    void setBall(Ball ball) {
        this.ball = ball;
    }

    @Override
    void turn() {
        // tracks y position of ball
        int currPos = getY() + Player.HEIGHT / 2;
        int newPos  = getY();

        if (ball.getVx() > 0) {

            if (!(ball.getY() > getY() && ball.getY() < getY() + Player.HEIGHT)) {

                if (ball.getY() > currPos) {
                    newPos += SPEED;
                }
                if (ball.getY() < currPos) {
                    newPos -= SPEED;
                }

            }
        }

        if (newPos + Player.HEIGHT > Pong.HEIGHT) {
            newPos = Pong.HEIGHT - Player.HEIGHT;
        }
        if (newPos < 0) {
            newPos = 0;
        }
        setPos(newPos);
    }
}
