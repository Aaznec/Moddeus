/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Aaznec
 */

//I realise that implementing Tile as an entity is kinda hacky and that I'm adding
public class Tile extends Entity implements PhysEntity{
    
    public Tile(float x, float y, Cell cell){
        //to be created, just made this so I didn't get errors while writing GameScreen
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void createBody() {
    }

    @Override
    public void onCollider(PhysEntity collider) {
    }
}
