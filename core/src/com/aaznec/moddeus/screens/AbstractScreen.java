/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.screens;

import com.aaznec.moddeus.Moddeus;
import com.badlogic.gdx.Screen;

/**
 *
 * @author Aaznec
 */
public abstract class AbstractScreen implements Screen{
    
    Moddeus game;   //Whatever screen I am in, I need a reference to the game object.
    public AbstractScreen(Moddeus game){ 
        this.game = game;
    }
    
    @Override
    public void dispose(){
        game.assets.clear();
    }
}
