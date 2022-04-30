package finalproj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.TextArea;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class model extends JFrame {

public model() {
	GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
	Canvas3D cv = new Canvas3D(gc);
	Container pane = this.getContentPane();
	pane.add(cv, BorderLayout.CENTER);
	TextArea ta = new TextArea("",3,30,TextArea.SCROLLBARS_NONE);
	ta.setText("Translation: Drag with right button\n");
	ta.setEditable(false);
	add(ta, BorderLayout.SOUTH);
	BranchGroup bg = createSceneGraph();
	bg.compile();
	SimpleUniverse su = new SimpleUniverse(cv);
	su.getViewingPlatform().setNominalViewingTransform();
	su.addBranchGraph(bg);                                           
}

public BranchGroup createSceneGraph() {
	BranchGroup root = new BranchGroup();
	// Transform group
	Painting painter = new Painting(root);
	
	// Lights
	PointLight light = new PointLight(new Color3f(Color.RED),
									  new Point3f(1f,1f,1f),
									  new Point3f(1f,0.1f,0f));
	BoundingSphere bounds = new BoundingSphere();
	light.setInfluencingBounds(bounds);
	root.addChild(light);
	// Background
	Background bg = new Background(new Color3f(Color.WHITE));
	bg.setApplicationBounds(bounds);
	root.addChild(bg);
	return root;
}

  //Appearance createAppearance(){
	    //Appearance ap = new Appearance();
	    //return ap;
  //}

public static void main(String[] args) {
	System.setProperty("sun.awt.noerasebackground", "true");
	JFrame frame = new model();
	frame.setBounds(100, 100, 640, 480);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
}