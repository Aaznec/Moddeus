/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.screens;

import com.aaznec.moddeus.Moddeus;
import com.aaznec.moddeus.entities.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

/**
 *
 * @author Aaznec
 */
public class GameScreen extends AbstractScreen{
    
    String levelname; //Level to be loaded
    TiledMap map; //Stores the loaded level
    TiledMapTileLayer background, ground, foreground, spawn; //Seperate layers
    TiledMapRenderer renderer; //Renderer for tile map and entities
    
    //Entities cannot be removed mid-frame, so pre and dead lists are needed
    public ArrayList<Entity> preEntList; //Entities to be added to entList
    public ArrayList<Entity> entList; //List containing all current entities in the game
    public ArrayList<Entity> deadEntList; //Entities to be removed from entList
    
    public World world; //Physics context
    float worldTime;    //Accumulator for how many physics steps are due
    final float worldStep; //Fixed time step for physics
    
    float timeScale; //To slow down time
    
    OrthographicCamera cam;
    
    public GameScreen(Moddeus game, String levelname) {
        super(game);
        this.levelname = levelname;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
    
}
