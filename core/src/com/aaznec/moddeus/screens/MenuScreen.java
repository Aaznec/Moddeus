/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.screens;

import com.aaznec.moddeus.Moddeus;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

/**
 *
 * @author Aaznec
 */
public class MenuScreen extends AbstractScreen{
      
    Texture buttonImg;
    Texture titleImg;
    
    float width;
    float height;
    
    float tWidth;
    float tHeight;
    float tX;
    float tY;
    
    float pWidth;
    float pHeight;
    float pX;
    float pY;
    
    float sY;
    
    float eY;
    
    GlyphLayout layout;
    
    public MenuScreen(Moddeus game) {
        super(game);
        titleImg = new Texture("img/title.png");
        buttonImg = new Texture("img/button.png");
    }

    @Override
    public void show() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        
        //Title image vars
        tWidth = width * 0.75f;
        tHeight = tWidth/titleImg.getWidth() * titleImg.getHeight();
        tX = width/2 - tWidth/2;
        tY = height/2 - tHeight/2 + 0.25f * height;
        
        //Play button image vars
        pWidth = width/6;
        pHeight = height/12;
        pX = width/2 - pWidth/2;
        pY = tY - pHeight - height/30;
        //Settings button image vars
        sY = pY - pHeight - height/30;
        //Exit button image vars
        eY = sY - pHeight - height/30;
    }

    @Override
    public void render(float delta) {
        //CLEAR SCREEN
        Gdx.gl.glClearColor(0.27f, 0, 0.3f, 1); 
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //BEGIN DRAWING
        game.batch.begin();
        
        //DRAW TITLE AND BUTTONS
        game.batch.draw(titleImg, tX, tY, tWidth, tHeight); //Position the title so its centered X and 30% up from centre on Y
        game.batch.draw(buttonImg, pX, pY, pWidth, pHeight); //Draw the buttons a small distance below the previous element
        game.batch.draw(buttonImg, pX, sY, pWidth, pHeight);
        game.batch.draw(buttonImg, pX, eY, pWidth, pHeight);
        //DRAW TEXT
        layout = new GlyphLayout(game.font, "Play");
        game.font.draw(game.batch, "Play", pX + pWidth/2 - layout.width/2, pY + pHeight/2 + layout.height/2); //Center the text on the buttons
        layout.setText(game.font, "Settings");
        game.font.draw(game.batch, "Settings", pX + pWidth/2 - layout.width/2, sY + pHeight/2 + layout.height/2);
        layout.setText(game.font, "Exit");
        game.font.draw(game.batch, "Exit", pX + pWidth/2 - layout.width/2, eY + pHeight/2 + layout.height/2);
        game.batch.end();
        
        //CHECK BUTTONS
        if(Gdx.input.isTouched()){
            float x = Gdx.input.getX();
            float y = height - Gdx.input.getY();
            System.out.println(x + "," + y);
            if( x > pX && x < pX + pWidth){
                if(y > pY && y < pY + pHeight){
                    game.setScreen(new LevelScreen(game));
                }
                if(y > sY && y < sY + pHeight){
                    game.setScreen(new SettingsScreen(game));
                }
                if(y > eY && y < eY + pHeight){
                    Gdx.app.exit();
                }
            }
        }
        
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
