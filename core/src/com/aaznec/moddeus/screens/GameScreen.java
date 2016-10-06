/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.screens;

import com.aaznec.moddeus.Moddeus;
import com.aaznec.moddeus.entities.DrawableEntity;
import com.aaznec.moddeus.entities.Entity;
import com.aaznec.moddeus.entities.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
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
    
    //Entities cannot be removed mid-frame, so pre and dead lists are needed
    public ArrayList<Entity> preEntList; //Entities to be added to entList
    public ArrayList<Entity> entList; //List containing all current entities in the game
    public ArrayList<Entity> deadEntList; //Entities to be removed from entList
    public ArrayList<DrawableEntity> drawList;
    
    String levelname; //Level to be loaded
    TiledMap map; //Stores the loaded level
    TiledMapTileLayer background, ground, foreground, spawns; //Seperate layers
    OrthogonalTiledMapRenderer renderer; //Renderer for tile map and entities
    
    public World world; //Physics context
    float worldTime;    //Accumulator for how many physics steps are due
    final float worldStep; //Fixed time step for physics
    
    float timeScale; //To slow down time
    
    Batch batch; //Render batch
    
    OrthographicCamera cam;
    
    public GameScreen(Moddeus game, String levelname) {
        super(game);
        this.levelname = levelname;
        
        preEntList = new ArrayList<Entity>(); //Init ent lists
        entList = new ArrayList<Entity>();
        deadEntList = new ArrayList<Entity>();
        drawList = new ArrayList<DrawableEntity>();
        
        map = new TmxMapLoader().load(levelname + ".tmx"); //Load in map
        
        background = (TiledMapTileLayer) map.getLayers().get("background"); //Render before anything else
        ground = (TiledMapTileLayer) map.getLayers().get("ground"); //Physical (with box2d bodies) layer rendered before entities
        foreground = (TiledMapTileLayer) map.getLayers().get("foreground"); //Rendered on top of entities
        spawns = (TiledMapTileLayer) map.getLayers().get("spawns"); //The spawn locations for any entities on the map
        
        for(int x = 0; x <= ground.getWidth(); x++){            //Create a tile entity for each cell of the ground layer
            for(int y = 0; y <= ground.getHeight(); y++){       
                Cell cell = ground.getCell(x, y);
                if(cell != null){
                    preEntList.add(new Tile(x, y, cell));       //Tiles will be added to entList in the next frame
                }
            }
        }
        
        renderer = new OrthogonalTiledMapRenderer(map, 1/16f); //Set to render map and set units to 1 unit = 16px
        
        world = new World(new Vector2(0, -10), true); //Init physics with gravity of 10N down
        worldTime = 0;
        worldStep = 1/300f; //Step forward physics sim at increments of 1/300 of a second
        
        timeScale = 1; //We just want normal time to start.
        
        batch = renderer.getBatch(); //Init drawing batch
        
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 16, 9);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        
        delta *= timeScale; //Scale time (if we want slow motion or to pause)
        
        Gdx.gl.glClearColor(0.8f, 0.8f, 1f, 1); //Clear the screen to a light blue
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // ^
        
        batch.begin();
        
        renderer.renderTileLayer(background);
        renderer.renderTileLayer(ground);
        
        for(DrawableEntity e : drawList){
            batch.draw(e.getFrame(), e.x, e.pos, 0, 0, e.width, e.height, 1, 1, e.rot);
        }
        
        batch.end();
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
