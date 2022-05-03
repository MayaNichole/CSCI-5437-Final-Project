
import static com.sun.j3d.utils.geometry.Primitive.GEOMETRY_NOT_SHARED;
import com.sun.j3d.utils.geometry.Sphere;
import java.awt.Color;
import javax.media.j3d.Appearance;
import static javax.media.j3d.Appearance.ALLOW_MATERIAL_READ;
import static javax.media.j3d.Appearance.ALLOW_MATERIAL_WRITE;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import static javax.media.j3d.Shape3D.ALLOW_GEOMETRY_WRITE;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PRC RYZEN RTX GAMING
 */
public class Tree extends BranchGroup{
       public float radius;
       Material mat = new Material(new Color3f(Color.red),new Color3f(Color.black), new Color3f(Color.red), new Color3f(Color.orange),80f);
       Appearance ap = new Appearance();
       Sphere sphere = new Sphere(.25f );
       TransformGroup tg;
       public final Color3f[] colors3d={new Color3f(Color.BLACK),new Color3f(Color.BLUE),new Color3f(Color.GREEN),new Color3f(Color.MAGENTA),new Color3f(Color.ORANGE),new Color3f(Color.white)};
       public Tree(){
        ap.setCapability(ALLOW_MATERIAL_WRITE);
        ap.setCapability(ALLOW_MATERIAL_READ);
        ap.setMaterial(mat);
        sphere.setAppearance(ap);
        sphere.setCapability(GEOMETRY_NOT_SHARED);
        tg = new TransformGroup();
        tg.setCapability( TransformGroup.ALLOW_TRANSFORM_READ );
        tg.setCapability( TransformGroup.ALLOW_TRANSFORM_WRITE );
        sphere.getShape().getGeometry().setCapability(ALLOW_GEOMETRY_WRITE);
        sphere.getShape().getGeometry().setCapability(ALLOW_GEOMETRY_WRITE);
        tg.addChild(sphere);
        this.addChild(tg);
        PointLight light = new PointLight(new Color3f(Color.white),new Point3f(1f,1f,1f), new Point3f(.5f,0.1f,0f));
         //light leaf node cpomponent
         BoundingSphere bounds = new BoundingSphere();
         light.setInfluencingBounds(bounds);
         this.addChild(light);
         Background background = new Background(0,0,1.0f);
         background.setApplicationBounds(bounds);
         this.addChild(background);
         
       }
       public Tree(float radius){
           this.radius = radius;
           sphere= new Sphere(this.radius);
              ap.setCapability(ALLOW_MATERIAL_WRITE);
        ap.setCapability(ALLOW_MATERIAL_READ);
        ap.setMaterial(mat);
        sphere.setAppearance(ap);
        sphere.setCapability(GEOMETRY_NOT_SHARED);
        TransformGroup tg = new TransformGroup();
        tg.setCapability( TransformGroup.ALLOW_TRANSFORM_READ );
        tg.setCapability( TransformGroup.ALLOW_TRANSFORM_WRITE );
        sphere.getShape().getGeometry().setCapability(ALLOW_GEOMETRY_WRITE);
        sphere.getShape().getGeometry().setCapability(ALLOW_GEOMETRY_WRITE);
        tg.addChild(sphere);
        this.addChild(tg);
        PointLight light = new PointLight(new Color3f(Color.white),new Point3f(1f,1f,1f), new Point3f(.5f,0.1f,0f));
         //light leaf node cpomponent
         BoundingSphere bounds = new BoundingSphere();
         light.setInfluencingBounds(bounds);
         this.addChild(light);
         Background background = new Background(0,0,1.0f);
         background.setApplicationBounds(bounds);
         this.addChild(background);
       }
    }
