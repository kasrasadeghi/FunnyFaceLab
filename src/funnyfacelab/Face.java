/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funnyfacelab;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author DSTIGANT
 */
public class Face 
{
    private int ULCx, ULCy, width;
    
    public Face( int x, int y, int w )
    {
        ULCx = x;
        ULCy = y;
        width = w;
        
        
    }
    
    public void update(int dt)
    {
        
    }

    public int getULCx() { return ULCx; }
    public int getULCy() { return ULCy; }
    public int getWidth() { return width; }
    
    static protected void paintOutlinedCircle( Rectangle r, Color c, Graphics g )
    {
        g.setColor( c );
        g.fillOval( r.x, r.y, r.width, r.height );
        g.setColor( Color.BLACK );
        g.drawOval( r.x, r.y, r.width, r.height );
    }
    
    static protected void paintOutlinedRectangle( Rectangle r, Color c, Graphics g )
    {
        g.setColor( c );
        g.fillRect( r.x, r.y, r.width, r.height );
        g.setColor( Color.BLACK );
        g.drawRect( r.x, r.y, r.width, r.height );
    }
    
    static protected void paintOutlinedPolygon( int [] xs, int [] ys, Color c, Graphics g )
    {
        g.setColor( c );
        g.fillPolygon( xs, ys, xs.length );
        g.setColor( Color.BLACK );
        g.drawPolygon( xs, ys, xs.length );
    }
    
    protected Color getEyeColor()
    {
        return Color.BLUE;
    }
    
    protected Color getScleraColor()
    {
        return Color.WHITE;
    }
    
    protected Rectangle getLeftEyeLocation()
    {
        return new Rectangle( (int)(ULCx + .2*width), (int)(ULCy + .2*width), (int)(.2*width), (int)(.2*width) );
    }
    
    protected Rectangle getLeftIrisLocation()
    {
        Rectangle r = getLeftEyeLocation();
        return new Rectangle( r.x + r.width / 3, r.y + r.height / 3, r.width/3, r.height/3 );
    }
    
    protected void paintLeftIris( Graphics g )
    {
        Rectangle r = getLeftIrisLocation();
        paintOutlinedCircle( r, getEyeColor(), g );
    }
    
    protected void paintLeftEye( Graphics g )
    {
        paintOutlinedCircle( getLeftEyeLocation(), getScleraColor(), g );
        paintLeftIris( g );
    }

    protected Rectangle getRightIrisLocation()
    {
        Rectangle r = getRightEyeLocation();
        return new Rectangle( r.x + r.width / 3, r.y + r.height / 3, r.width/3, r.height/3 );
    }
    
    protected Rectangle getRightEyeLocation()
    {
        return new Rectangle( (int)(ULCx + .6*width), (int)(ULCy + .2*width), (int)(.2*width), (int)(.2*width) );
    }
    
    protected void paintRightIris( Graphics g )
    {
        Rectangle r = getRightIrisLocation();
        paintOutlinedCircle( r, getEyeColor(), g );
    }
    
    protected void paintRightEye( Graphics g )
    {
        paintOutlinedCircle( getRightEyeLocation(), getScleraColor(), g );
        paintRightIris( g );
    }
    
    protected Rectangle getLeftEyebrowLocation()
    {
        Rectangle rle = getLeftEyeLocation();
        return new Rectangle( rle.x, rle.y - width/20, rle.width, width / 40 );
    }
    
    protected Rectangle getRightEyebrowLocation()
    {
        Rectangle rle = getRightEyeLocation();
        return new Rectangle( rle.x, rle.y - width/20, rle.width, width / 40 );
    }
    
    protected Color getEyebrowColor()
    {
        return Color.BLACK;
    }
    
    protected void paintLeftEyebrow( Graphics g )
    {
        Rectangle reb = getLeftEyebrowLocation();
        g.setColor( getEyebrowColor() );
        g.fillRect( reb.x, reb.y, reb.width, reb.height );
    }
    
    protected void paintRightEyebrow( Graphics g )
    {
        Rectangle reb = getRightEyebrowLocation();
        g.setColor( getEyebrowColor() );
        g.fillRect( reb.x, reb.y, reb.width, reb.height );
    }
    
    protected Rectangle getNoseLocation()
    {
        return new Rectangle( ULCx + 2*width/5, ULCy + 2*width/5, width/5, width/5 );
    }
    
    protected Color getNoseColor()
    {
        return Color.ORANGE;
    }
    
    protected void paintNose( Graphics g )
    {
        paintOutlinedCircle( getNoseLocation(), getNoseColor(), g );
    }
    
    protected Rectangle getMouthLocation()
    {
        return new Rectangle( ULCx + width/4, ULCy + 27*width/40, width/2, width/5 );
    }
    
    protected Color getMouthColor()
    {
        return Color.BLACK;
    }
    
    protected void paintMouth( Graphics g)
    {
        g.setColor( getMouthColor() );
        Rectangle rm = getMouthLocation();
        g.fillArc( rm.x, rm.y - rm.height, rm.width, 2*rm.height, 180, 180 );
    }
    
    protected Rectangle getHeadLocation()
    {
        return new Rectangle(ULCx, ULCy, width, width);
    }
    
    protected Color getHeadColor()
    {
        return Color.YELLOW;
    }
    
    protected void paintHead( Graphics g )
    {
        paintOutlinedCircle( getHeadLocation(), getHeadColor(), g );
    }
    
    public void paint(Graphics g)
    {
        paintHead( g );
        paintLeftEye(g);
        paintRightEye(g);
        paintRightEyebrow(g);
        paintLeftEyebrow(g);
        paintNose(g);
        paintMouth( g );
    }
    
}
