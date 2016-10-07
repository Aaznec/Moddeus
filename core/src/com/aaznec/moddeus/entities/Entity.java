/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.entities;

import com.aaznec.moddeus.screens.GameScreen;

/**
 *
 * @author Aaznec
 */

public abstract class Entity {
    
    float stateTime;
    GameScreen gameState;
    
    public Entity(GameScreen gameState){
        this.gameState = gameState;
    }
    
    public void update(float delta){
        stateTime += delta;
    }
    
}
