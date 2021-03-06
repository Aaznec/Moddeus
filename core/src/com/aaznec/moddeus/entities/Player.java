/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.entities;

import com.aaznec.moddeus.screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Aaznec
 */
public class Player extends Mob{
    
    final float PLAYERWIDTH = 1;
    final float PLAYERHEIGHT = 2;
    
    enum State{
        standing, walking, jumping, attacking
    }
    State state;
    
    enum AttackState{
        laserbolt //more to be added
    }
    
    Animation stand;
    Animation walk;
    
    Texture texture;
    TextureRegion[][] frameSet;
    
    public Player(Vector2 pos, GameScreen gameState) {
        super(pos, 1, 2, 1, gameState);
        
        texture = new Texture("img/player-set.png");
        frameSet = TextureRegion.split(texture, 16, 32);
        
        state = state.standing;
        
        stand = new Animation(0.4f, frameSet[0][0], frameSet[0][0], frameSet[0][0], frameSet[0][0], frameSet[0][0], frameSet[0][0], frameSet[0][4]);
        walk = new Animation(0.15f, frameSet[0][0], frameSet[0][1] ,frameSet[0][2]);
        stand.setPlayMode(Animation.PlayMode.LOOP);
        walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        acc = 5;
        maxSpeed = 5;
    }

    @Override
    public TextureRegion getFrame() {
        switch(state){
            case standing:
                return stand.getKeyFrame(stateTime);
            case walking:
                return walk.getKeyFrame(stateTime);
            //case attacking
            default:
                return frameSet[0][0];
        }
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        
        Vector2 vel = body.getLinearVelocity();
        
        if(Gdx.input.isKeyPressed(Keys.D)){
            vel.x = 5;
        }
        
        body.setLinearVelocity(vel);
        
        clampVel();
    }

    @Override
    public void createBody() {
        super.createBody();
    }

    @Override
    public void onCollider(PhysEntity collider) {
    }
    
}
