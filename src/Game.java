import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Game game;
	
	public Ball ball;
	public Paddle paddle1;
	public Paddle paddle2;
	
	public Game(){
		ball = new Ball(this);
		paddle1 = new Paddle(this, 5 , 150);
		paddle2 = new Paddle(this, 268, 150);
		JFrame panel = new JFrame("PingPong");
		panel.add(this);
		panel.setSize(300, 300);
		panel.setVisible(true);
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputHandler ih = new InputHandler();
		panel.addKeyListener(ih);
	
	}
	private void detectCollisions(){
		
		if (ball.Intersect(paddle1)) {
			ball.vellX  = +1;
		}
		if (ball.Intersect(paddle2)) {
			ball.vellX  = -1;
		}
	}
	
	private void move(){
		ball.move();
		paddle1.move();
		paddle2.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		paddle1.paint(g2d);
		paddle2.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		game = new Game();
		
		
		while(true){
			
			game.move();
			game.repaint();
			Thread.sleep(5);
			game.detectCollisions();
		}
		
	}
		
	
}
