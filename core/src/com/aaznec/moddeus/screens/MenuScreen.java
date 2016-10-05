/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.screens;

import com.aaznec.moddeus.Moddeus;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 *
 * @author Aaznec
 */
public class MenuScreen extends AbstractScreen{

    public MenuScreen(Moddeus game) {
        super(game);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.27f, 0, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
