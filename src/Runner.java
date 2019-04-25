import javax.swing.*;

class Runner extends JFrame {

    private Runner(JPanel game) {
        super("Pong");

        add(game);
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void start() throws InterruptedException {

        while (true) {
            // 20 frames per second
            Thread.sleep(1000 / 20);
            getComponent(0).repaint();
        }
    }

    public static void main(String... args) throws InterruptedException {
        Runner game = new Runner(new Pong());
        game.start();
    }
}
