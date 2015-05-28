package haw.pr2.OldStuff;


import jgame.JGColor;
import jgame.platform.JGEngine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abt434
 */
public class Window extends JGEngine{
    
    private Timer timer;
    
    
    private Window(int width, int height){
        initEngine(width, height);
        timer = Timer.valueOf();
    }
    
    public static Window valueOf(int width, int height){
        return new Window(width, height);
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
    }
    
    @Override
    public void doFrame(){
        //LOGIK
        
        // Update-Aufruf von Timer
        timer.update();
        
        // Step-Aufruf von Porsche
       // porsche.step(timeDiff, 1.0.....)
    }
    
    @Override
    public void paintFrame(){
        setColor(JGColor.red);
       // RENDERN
        drawString("Hallo, Jenny! ", viewWidth() / 2, viewHeight() / 2, 0); // letzter Parameter -> 0 = zentriet, -1 = linksbündig, 1 = rechtsbündig
    }
}
