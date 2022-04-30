/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproj;

import com.sun.j3d.utils.behaviors.mouse.MouseBehavior;
import com.sun.j3d.utils.geometry.Box;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Random;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

/**
 *
 * @author PRC RYZEN RTX GAMING
 */
public class Painting extends Box {
    class MickeyMouse extends MouseBehavior{
Painting painter;
     public MickeyMouse(Painting painter){
         this.painter=painter;
     }

        @Override
        public void mouseClicked(MouseEvent me) {
            painter.randomColor();
        }
        @Override
        public void mousePressed(MouseEvent me2){
            painter.paintProcess(me2.getLocationOnScreen());
        }

        @Override
        public void initialize() {
//            WakeupCriterion[] events = new WakeupCriterion[2];
//            events[0]=new WakeupOnAWTEvent(Event.MOUSE_DOWN);
//            events[1]=new WakeupOnAWTEvent(Event.MOUSE_DRAG);
//            wakeupOn(new WakeupOr(events));
        }

        @Override
        public void processStimulus(Enumeration e) {
//            WakeupCriterion event = (WakeupCriterion) e.nextElement();
//            if(event.equals(new WakeupOnAWTEvent(Event.MOUSE_DOWN))){
//                randomColor();
//            }else{
//                
//            }
        }
        
    }
    private Appearance ap ;
    private Color3f color;
    private TransformGroup tg;
    private BranchGroup root;
    public Painting(BranchGroup root){
        
        setAP(new Appearance());
        setRoot(root);
        setTG(new TransformGroup());
        setColor(new Color3f(Color.black));
       //ap.getColoringAttributes().setColor(getColor());
        root.addChild(getTG());
    }
    public void setColor(Color3f color){
        this.color=color;
        
    }
    public Color3f getColor(){
        return color;
    }
    public void setTG(TransformGroup tg){
        this.tg=tg;
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tg.addChild(this);
    }
    public TransformGroup getTG(){
        return tg;
    }
    public void paintProcess(Point pt){
        //drop new collored boxes in the scene at mouse location
        double x = pt.getX();
        double y = pt.getY();
        TransformGroup tgNew = new TransformGroup();
        tgNew.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	tgNew.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        Appearance apNew = new Appearance();
        apNew.getColoringAttributes().setColor(getColor());
        Box ink = new Box();
        ink.setAppearance(apNew);
        Transform3D pos = new Transform3D();
        pos.setTranslation(new Vector3d(x,y,0f));
        tgNew.setTransform(pos);
        tgNew.addChild(new Box());
        root.addChild(tgNew);
    }
    public void randomColor(){
        Random rand = new Random();
            int r = rand.nextInt(257);
            int g = rand.nextInt(257);
            int b = rand.nextInt(257);
            setColor(new Color3f((float)r,(float)g,(float)b));
            
    }
    public void setRoot(BranchGroup root){
        this.root=root;
    }
    public BranchGroup getRoot(){
        return root;
    }
    public Appearance getAP(){
        return ap;
    }
    public void setAP(Appearance ap){
        this.ap =ap;
        this.setAppearance(getAP());
    }
 
}
