package entity;

import main.*;
import entity.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public Player (GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update ( ){

        if (keyH.upPressed == true){
            direction = "up";
            position = 1;
            y -= speed;
        }
        else if (keyH.downPressed == true) {
            direction = "down";
            position = 2;
            y +=speed;
        }
        else if (keyH.leftPressed == true) {
            direction = "left";
            position = 3;
            x-=speed;
        }
        else if (keyH.rightPressed == true) {
            direction = "right";
            position = 4;
            x += speed;
        } else {
            direction = "idle";
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }

    }
    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
            case "idle":
                if(position == 1){
                    image = up1;
                }
                else if(position == 2){
                    image = down1;
                }
                else if (position == 3){
                    image = left1;
                }
                else if (position == 4) {
                    image = right1;
                }

        }
        g2.drawImage(image , x ,y ,gp.tileSize,gp.tileSize,null );
    }
}
