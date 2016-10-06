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
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

/**
 *
 * @author Aaznec
 */
public class GameScreen extends AbstractScreen{
    
    String levelname; //Level to be loaded
    TiledMap map; //Stores the loaded level
    TiledMapTileLayer background, ground, foreground, spawns; //Seperate layers
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
        
        map = new TmxMapLoader().load(levelname + ".tmx"); //Load in map
        
        background = (TiledMapTileLayer) map.getLayers().get("background");
        ground = (TiledMapTileLayer) map.getLayers().get("ground");
        foreground = (TiledMapTileLayer) map.getLayers().get("foreground");
        spawns = (TiledMapTileLayer) map.getLayers().get("spawns");
        
        int mapWidth = ground.getWidth();
        int mapHeight = ground.getHeight();
        
        
        renderer = new OrthogonalTiledMapRenderer(map, 1/16f); //Set to render map and set units to 1 unit = 16px
        
        preEntList = new ArrayList<Entity>(); //Init ent lists
        entList = new ArrayList<Entity>();
        deadEntList = new ArrayList<Entity>();
        
        world = new World(new Vector2(0, -10), true); //Init physics with gravity of 10N down
        worldTime = 0;
        worldStep = 1/300f; //Step forward physics sim at increments of 1/300 of a second
        
        timeScale = 1; //We just want normal time to start.
        
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 16, 9);
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
