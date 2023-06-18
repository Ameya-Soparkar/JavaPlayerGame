package entity;

import main.GamePanel;
import main.keyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Player extends Entity {
    GamePanel gp;
    keyHandler keyH;

    public Player(GamePanel gp, keyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            InputStream isup1 = getClass().getClassLoader().getResourceAsStream("player/boy_up_1.png");
            up1 = ImageIO.read(isup1);

            InputStream isup2 = getClass().getClassLoader().getResourceAsStream("player/boy_up_2.png");
            up2 = ImageIO.read(isup2);

            InputStream isdown1 = getClass().getClassLoader().getResourceAsStream("player/boy_down_1.png");
            down1 = ImageIO.read(isdown1);

            InputStream isdown2 = getClass().getClassLoader().getResourceAsStream("player/boy_down_2.png");
            down2 = ImageIO.read(isdown2);

            InputStream isleft1 = getClass().getClassLoader().getResourceAsStream("player/boy_left_1.png");
            left1 = ImageIO.read(isleft1);

            InputStream isleft2 = getClass().getClassLoader().getResourceAsStream("player/boy_left_2.png");
            left2 = ImageIO.read(isleft2);

            InputStream isright1 = getClass().getClassLoader().getResourceAsStream("player/boy_right_1.png");
            right1 = ImageIO.read(isright1);

            InputStream isright2 = getClass().getClassLoader().getResourceAsStream("player/boy_right_2.png");
            right2 = ImageIO.read(isright2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void update () {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if (keyH.upPressed == true) {
                direction = "up";
                y = y - speed;
            } else if (keyH.downPressed == true) {
                direction = "down";
                y = y + speed;
            } else if (keyH.leftPressed == true) {
                direction = "left";
                x = x - speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                x = x + speed;
            }


            spriteCounter++;
            if (spriteCounter > 12){
                if (spriteNum == 1){
                    spriteNum =2;
                }
                else if (spriteNum == 2){
                    spriteNum =1;
                }
                spriteCounter=0;
            }
        }}

        public void draw (Graphics2D g2){
            BufferedImage image = null;
            switch (direction) {
                case "up":
                    if(spriteNum == 1){
                        image =up1;
                    }
                    if(spriteNum == 2){
                    image =up2;
                }

                    break;
                case "down":
                    if(spriteNum == 1){
                        image =down1;
                    }
                    if(spriteNum == 2){
                        image =down2;
                    }
                    break;
                case "left":
                    if(spriteNum == 1){
                        image =left1;
                    }
                    if(spriteNum == 2){
                        image =left2;
                    }

                    break;
                case "right":
                    if(spriteNum == 1){
                        image =right1;
                    }
                    if(spriteNum == 2){
                        image =right2;
                    }
                    break;
            }
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }
    }
