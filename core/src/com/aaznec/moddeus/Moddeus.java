package com.aaznec.moddeus;

import com.aaznec.moddeus.screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Moddeus extends Game {
    
    public SpriteBatch batch;
    public BitmapFont font;
    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        setScreen(new MenuScreen(this)); //Initialise the game to the menuscreen and pass a ref to itself.
    }
	
}
