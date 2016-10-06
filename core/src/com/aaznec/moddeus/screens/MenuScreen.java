/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.screens;

import com.aaznec.moddeus.Moddeus;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Aaznec
 */
public class MenuScreen extends AbstractScreen{
    
    Texture buttonImg;
    Texture titleImg;
    
    float tWidth;
    float tHeight;
    float tX;
    float tY;
    
    float pWidth;
    float pHeight;
    float pX;
    float pY;
    
    
    public MenuScreen(Moddeus game) {
        super(game);
        titleImg = new Texture("img/title.png");
        buttonImg = new Texture("img/button.png");
    }

    @Override
    public void show() {
        float width = Gdx.graphics.getWidth(), height = Gdx.graphics.getHeight();
        
        //Title image vars
        tWidth = width * 0.75f;
        tHeight = tWidth/titleImg.getWidth() * titleImg.getHeight();
        tX = width/2 - tWidth/2;
        tY = height/2 - tHeight/2 + 0.25f * height;
        
        //Play button image vars
        pWidth = width/6;
        pHeight = height/12;
        pX = width/2 - pWidth/2;
        pY = tY - pHeight - width/20;
        //Settings button image vars
        
        //Exit button image vars
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.27f, 0, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        
        game.batch.draw(titleImg, tX, tY, tWidth, tHeight); //Position the title so its centered X and 30% up from centre on Y
        game.batch.draw(buttonImg, pX, pY, pWidth, pHeight);
        game.batch.end();
        
    }

    @Override
    public void resize(int width, int height) {
        show();
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
