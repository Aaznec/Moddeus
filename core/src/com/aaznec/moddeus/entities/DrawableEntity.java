/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Aaznec
 */
public abstract class DrawableEntity extends Entity{
    
    public Vector2 pos;
    public float width;
    public float height;
    float dir;
    
    public DrawableEntity() {
        
    }
    
    public abstract TextureRegion getFrame();
}
