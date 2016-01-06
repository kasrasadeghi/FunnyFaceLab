/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funnyfacelab;

import apcscvm.GraphicsUtilityFunctions;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author DSTIGANT
 */
public class DemoFace extends Face
{
    private BasicStroke dashedStroke;
    private Font font;
    
    public DemoFace(int x, int y, int w) {
        super(x, y, w);
        
        float [] dashes = { 5, 3 };
        dashedStroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dashes, 0 );
        
        font = GraphicsUtilityFunctions.getFont( 20 );
    }
    
    protected void paintDottedRectangle( Graphics g, Rectangle r, String tag, Rectangle tr, int dir )
    {
        Graphics2D g2D = (Graphics2D)g;
        Stroke s = g2D.getStroke();
        g2D.setStroke( dashedStroke );
        g.setColor( Color.RED );
        
        g.drawRect( r.x, r.y, r.width, r.height );
        //g.drawRect( tr.x, tr.y, tr.width, tr.height );
        g2D.setStroke( s );
        
        g.setColor( Color.BLACK );
        GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, tag, font, tr.x, tr.y, tr.width, tr.height );
        
        int sx, sy, ex, ey;
        if ( dir == 0 )
        {
            sx = r.x + r.width/2;
            sy = r.y;
            ex = tr.x + tr.width/2;
            ey = tr.y + tr.height;
        }
        else if ( dir == 1 )
        {
            sx = r.x + r.width;
            sy = r.y;
            ex = tr.x;
            ey = tr.y + tr.height;
        }
        else if ( dir == 2 )
        {
            sx = r.x + r.width;
            sy = r.y + r.height/2;
            ex = tr.x;
            ey = tr.y + tr.height/2;
        }
        else if ( dir == 3 )
        {
            sx = r.x + r.width;
            sy = r.y + r.height;
            ex = tr.x;
            ey = tr.y;
        }
        else if ( dir == 4 )
        {
            sx = r.x + r.width/2;
            sy = r.y + r.height;
            ex = tr.x + tr.width/2;
            ey = tr.y;
        }
        else if ( dir == 5 )
        {
            sx = r.x;
            sy = r.y + r.height;
            ex = tr.x + tr.width;
            ey = tr.y;
        }
        else if ( dir == 6 )
        {
            sx = r.x;
            sy = r.y + r.height/2;
            ex = tr.x + tr.width;
            ey = tr.y + tr.height/2;
        }
        else
        {
            sx = r.x;
            sy = r.y;
            ex = tr.x + tr.width;
            ey = tr.y + tr.height;
        }
        
        g.drawLine( sx, sy, ex, ey );
    }
    
    public void paintHead( Graphics g )
    {
        super.paintHead( g );
        Rectangle r = getHeadLocation();
        paintDottedRectangle( g, r, "Head", new Rectangle(r.x + r.width + 10, r.y + r.height + 10, 80, 20), 3 );
    }
    
    public void paintMouth( Graphics g )
    {
        super.paintMouth( g );
        Rectangle r = getMouthLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Mouth", new Rectangle(hr.x + hr.width/2 - 40, hr.y + hr.height + 20, 80, 20), 4 );
    }
    
    public void paintLeftEye( Graphics g )
    {
        super.paintLeftEye( g );
        Rectangle r = getLeftEyeLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Left Eye", new Rectangle(hr.x - 110, r.y + r.height/2 - 15, 100, 20), 6 );
    }
    
    public void paintRightEye( Graphics g )
    {
        super.paintRightEye( g );
        Rectangle r = getRightEyeLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Right Eye", new Rectangle( hr.x + hr.width + 10, r.y + r.height/2 - 15, 100, 20 ), 2 );
    }
    
    public void paintNose( Graphics g )
    {
        super.paintNose( g );
        Rectangle r = getNoseLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Nose", new Rectangle( hr.x + hr.width + 10, r.y + r.height/2, 50, 20 ), 2 );
    }
    
    public void paintLeftIris( Graphics g )
    {
        super.paintLeftIris( g );
        Rectangle r = getLeftIrisLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Left Iris", new Rectangle(hr.x - 110, r.y + r.height/2 + 15, 100, 20), 5 );
    }
    
    public void paintRightIris( Graphics g )
    {
        super.paintRightIris( g );
        Rectangle r = getRightIrisLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Right Iris", new Rectangle(hr.x + hr.width + 10, r.y + r.height/2 + 15, 100, 20), 3 );
    }
    
    public void paintLeftEyebrow( Graphics g )
    {
        super.paintLeftEyebrow( g );
        Rectangle r = getLeftEyebrowLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Left Eyebrow", new Rectangle( hr.x - 80, hr.y - 30, 130, 20 ), 0 );
    }
    
    public void paintRightEyebrow( Graphics g )
    {
        super.paintRightEyebrow( g );
        Rectangle r = getRightEyebrowLocation();
        Rectangle hr = getHeadLocation();
        paintDottedRectangle( g, r, "Right Eyebrow", new Rectangle( hr.x + hr.width/2, hr.y - 30, 130, 20 ), 0 );
    }
    
    
}
