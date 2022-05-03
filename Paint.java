
import assignment6.Assignment6;
import com.sun.j3d.utils.applet.MainFrame;
import static com.sun.j3d.utils.geometry.Primitive.GEOMETRY_NOT_SHARED;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.media.j3d.Appearance;
import static javax.media.j3d.Appearance.ALLOW_MATERIAL_READ;
import static javax.media.j3d.Appearance.ALLOW_MATERIAL_WRITE;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import static javax.media.j3d.Shape3D.ALLOW_GEOMETRY_WRITE;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PRC RYZEN RTX GAMING
 */
public class Paint extends Applet{
    public static void main(String[] args){
     //fix to prevent blank screen
        System.setProperty("sun.awt.noerasebackground", "true");
        //load scene
        new MainFrame(new Paint(), 640, 480);
    }
    public void init() {
    GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
    Canvas3D cv = new Canvas3D(gc);
    Tree tree = new Tree();
    BranchGroup seed = new BranchGroup();
    tree.compile();
    seed.compile();
    cv.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            //change color
            System.out.println("uh");
            Random rand = new Random();
            int i = rand.nextInt(tree.colors3d.length);
            tree.sphere.getAppearance().setMaterial(new Material(tree.colors3d[i],new Color3f(Color.black),tree.colors3d[i],new Color3f(Color.black),80f));
            
            //change size
            
            
        }
        @Override
        public void mouseEntered(MouseEvent e) {
           //snap sphere to mouse
            System.out.println("um");
           Transform3D tr = new Transform3D();
           
           tr.setTranslation(new Vector3d(-(double)e.getXOnScreen(),-(double)e.getYOnScreen(), 0.0));
           tree.tg.setTransform(tr);
        }
        @Override
        public void mouseMoved(MouseEvent e){
             System.out.println("er");
            //sphere to pointer
            Transform3D tr = new Transform3D();
           
           tr.setTranslation(new Vector3d(-(double)e.getXOnScreen(),-(double)e.getYOnScreen(), 0.0));
           tree.tg.setTransform(tr);
        }
        @Override
        public void mouseDragged(MouseEvent e){
             System.out.println("yo");
            //paint
        }
    });
    setLayout(new BorderLayout());
    add(cv, BorderLayout.CENTER);
    
    
    SimpleUniverse su = new SimpleUniverse(cv);
    su.getViewingPlatform().setNominalViewingTransform();
    su.addBranchGraph(tree);
    su.addBranchGraph(seed);
  }
}
   
   

