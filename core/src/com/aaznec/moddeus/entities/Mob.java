/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.entities;

import com.aaznec.moddeus.screens.GameScreen;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Aaznec
 */
public abstract class Mob extends DrawableEntity implements PhysEntity{
    
    public Mob(Vector2 pos, float width, float height, float dir, GameScreen gameState) {
        super(pos, width, height, dir, gameState);
    }
    
}
