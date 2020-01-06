package com.fbtw.matrix.objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fbtw.matrix.GameMain;

import java.util.Random;

public class MatrixColumn {
    private int bufferLength = 33;
    private BitmapFont font;
    private int initVelosity;
    private int lenth = GameMain.WINDOW_HEIGHT;
    private int x;
    private int y1;
    private int y2;

    private String s1;
    private String s2;

    private int chengeTime;
    private int loopTime=10;

    public MatrixColumn(BitmapFont font, int initVelosity, int x) {
        this.font = font;
        this.initVelosity = initVelosity;
        this.x = x;
        y1=lenth;
        y2=lenth*2;
        updateText();
        chengeTime =0;
    }

    public void updatePosition(float dt){
        chengeTime+=1;
        y1-=initVelosity*dt;
        y1 = replaceColumn(y1);
        y2-=initVelosity*dt;
        y2 = replaceColumn(y2);

        if(chengeTime>loopTime){
            updateText();
            chengeTime=0;
        }

    }


    public void render(SpriteBatch sb){
       // font.draw(sb,y1+" "+y2,0,lenth);
        font.draw(sb,s1,x,y1);
        font.draw(sb,s2,x,y2);
    }

    private int replaceColumn( int curY){
        if(curY<=0){
            curY+=lenth*2;
        }
        return curY;
    }

    private void updateText(){
        s1 = buildColumn(bufferLength);
        s2 = buildColumn(bufferLength);
    }

    private String buildColumn(int count){
        Random random  = new Random();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<count;i++){
            builder.append(random.nextInt(10)+"\n");
        }
        return builder.toString();
    }
}
