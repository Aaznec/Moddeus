/*
 *  Aaznec 2016
 */
package com.aaznec.moddeus.entities;

import com.badlogic.gdx.physics.box2d.Body;

/**
 *
 * @author Aaznec
 */
public interface PhysEntity {
    
    void createBody();
    
    void onCollider(PhysEntity collider);
    
}
