package finalproj;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.media.j3d.Background;
import javax.media.j3d.ImageComponent2D;
import javax.vecmath.Color3f;

public class ColoringPage extends Background{
    public ColoringPage(){
        genPic();
    }
    public void genPic(){
    ImageComponent2D[] images = new ImageComponent2D[5];
try{
    BufferedImage image1 = ImageIO.read(new URL("https://www.crayola.com/-/media/Crayola/Coloring-Page/coloring_pages2014/21-Monsters.png"));
    BufferedImage image2 = ImageIO.read(new File("finalproj/Dragonsketch.png"));
    BufferedImage image3 = ImageIO.read(new File("finalproj/Free-Star-Wars-Mandelorian-Coloring-Page.png"));
    BufferedImage image4 = ImageIO.read(new File("finalproj/Mulan-Coloring-Page-Free-Disney-Princess-Coloring-Sheet.png"));
    BufferedImage image5 = ImageIO.read(new File("ComputerGraphics/src/finalproj/ColoringPages/1408.gif"));
     images[0] = new ImageComponent2D(1,image1);
     images[1] = new ImageComponent2D(1,image2);
     images[2] = new ImageComponent2D(1,image3);
     images[3] = new ImageComponent2D(1,image4);
     images[4] = new ImageComponent2D(1,image5);
    }catch(IOException ex){
    ex.printStackTrace();
    this.setColor(new Color3f(1,1,1));
    }
//    }catch(URISyntaxException ex1){
//        System.out.println(ex1.getMessage());
//    }
//random number
Random random = new Random();
int i = random.nextInt(images.length);
this.setImage(images[0]);

//setbackground
   }
}