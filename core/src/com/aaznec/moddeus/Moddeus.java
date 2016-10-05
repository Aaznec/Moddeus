package com.aaznec.moddeus;

import com.aaznec.moddeus.screens.MenuScreen;
import com.badlogic.gdx.Game;

public class Moddeus extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this)); //Initialise the game to the menuscreen and pass a ref to itself.
    }
	
}
