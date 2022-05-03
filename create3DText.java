
import java.awt.Font;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Font3D;
import javax.media.j3d.FontExtrusion;
import javax.media.j3d.Material;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Text3D;
import static javax.media.j3d.Text3D.ALLOW_STRING_WRITE;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PRC RYZEN RTX GAMING
 */
public class create3DText extends BranchGroup {
    String text ="";
     Text3D text3d;
     String[] response = {"You will survive finals week","You will meet your match in life", "You will be sombody", "You will save the world", "You will make the world a better place", "You will better your life", "You will make someone's life better"};
    public create3DText(String text) {
        this.text=text;
        Appearance ap = new Appearance();
         ap.setMaterial(new Material());
         Font3D font = new Font3D(new Font("SansSerif", Font.BOLD, 1),new FontExtrusion());
         text3d = new Text3D(font, text);
         text3d.setCapability(ALLOW_STRING_WRITE);
         //Shape3D leaf node
          Shape3D shape = new Shape3D(text3d, ap);
         //transformation group node
         Transform3D tr = new Transform3D();
         tr.setScale(0.1);
         tr.setTranslation(new Vector3f(-.78f, -0.32f, 0f));
         TransformGroup tg = new TransformGroup(tr);
         tg.addChild(shape);
         this.addChild(tg);
         
         
    }
    public void setText(String text){
        this.text=text;
        text3d.setString(text);
    }
    
}
