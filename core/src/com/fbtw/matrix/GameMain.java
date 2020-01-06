package com.fbtw.matrix;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fbtw.matrix.objects.MatrixColumn;


import java.util.Random;

public class GameMain extends ApplicationAdapter {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	SpriteBatch batch;
	BitmapFont  font;
	int columnCount = 80;
	int offset = 10;
	MatrixColumn [] column;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.GREEN);
		column = new MatrixColumn[columnCount];
		for(int i=0;i<columnCount;i++){
			column[i] = new MatrixColumn(font,generateVelocyty(),offset*i);
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		for(MatrixColumn c : column){
			c.render(batch);
		}
		batch.end();
	}


	private void update(){
		for(MatrixColumn c : column){
			c.updatePosition(Gdx.graphics.getDeltaTime());
		}
	}


	
	@Override
	public void dispose () {
		batch.dispose();

	}

	private int generateVelocyty(){
		Random random = new Random();

		return (1+ random.nextInt(4))*100;
	}
}
