package haw.pr2.jgame;



import java.awt.event.KeyEvent;

import jgame.JGColor;
import jgame.JGFont;
import jgame.platform.JGEngine;

public class Window extends JGEngine {
	
	private Timer timer;

	private Player player;
	private Switch eis;
	private Switch schnee;
	private Switch naesse;

	public static Window valueOf(int width, int height) {
		return new Window(width, height);
	}

	private Window(int width, int height) {
		timer = Timer.valueOf();

		initEngine(width, height);
		player = Player.valueOf(this, new Porsche911GT2RS(0.0,this.getWidth()/2,this.getHeight()/2,0.0,0.0, 0.0, true,true));
		player.getCar().setPlayer(player);
		
		eis = Switch.valueOf(this, KeyEvent.VK_1);
		schnee = Switch.valueOf(this, KeyEvent.VK_2);	
		naesse = Switch.valueOf(this, KeyEvent.VK_3);
		
	}

	@Override
	public void initCanvas() {
		setCanvasSettings(50, // Anzahl auf x.Achse
				37, // Anzahl auf y.Achse
				16, // Breite Tiles
				16, // Hoehe Tiles
				JGColor.yellow, // Vordergrund
				new JGColor(40, 90, 100, 0), // Hintergrundfarbe
				null); // Schriftart null = Standart
	}

	@Override
	public void initGame() {
		setFrameRate(60, 2);
		defineImage("Player", "p", 0, "pics/0.png", "-");
	}
	
	/**
	 * Update Frame
	 */
	@Override
	public void doFrame() {
		double elapsedTime = timer.update();
		player.getAbs().update();
		player.getAsr().update();
		player.move(elapsedTime);
	}
	
	/**
	 * Zeichne Zustand
	 */
	@Override
	public void paintFrame() {
            drawString("Abs: "+player.isAbsOn(), viewWidth() - 50, viewHeight() - 30, 0, new JGFont("Arial",1,11), new JGColor(20, 20, 20));
            drawString("Asr: "+player.isASROn(), viewWidth() - 50, viewHeight() - 50, 0);
            drawString("Speed: "+ (int)(player.getCar().getSpeed() * 3.6), viewWidth() - 50, viewHeight() - 70, 0);
            drawString("Traktion: " + player.getCar().getTraktion().toString(), viewWidth() - 50, viewHeight() - 100, 0);
          
            if(player.getCar().getState() == CarState.SLIDING){
            	defineImage("Player", "p", 0, "pics/Porsche_Sliding.png", "-");
            }else{
            	System.out.println("***********************Direction***********************: " + ((player.getCar().getCurrentDirection() / Math.PI)* 180) % 360);
            	defineImage("Player", "p", 0, "pics/0.png", "-");
//            	defineImage("Player", "p", 0, "pics/"+ (int)Math.abs(((player.getCar().getCurrentDirection() / Math.PI) * 180)  % 360) +".png", "-");
            }
	}
	
	public Switch getSwitchEis(){
		return eis;
	}
	
	public Switch getSwitchNaesse(){
		return naesse;
	}
	
	public Switch getSwitchSchnee(){
		return schnee;
	}
	
}
