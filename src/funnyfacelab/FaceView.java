/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funnyfacelab;

import apcscvm.DefaultControl;
import apcscvm.Mouse;
import apcscvm.View;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DSTIGANT
 */
public class FaceView extends DefaultControl<ArrayList<Face>> implements View<ArrayList<Face>>
{
    private Integer ULCx, ULCy;
    private String faceClass;
    
    public FaceView()
    {
        ULCx = null;
        ULCy = null;
        faceClass = "Face";
    }
    
    public void setFaceClass( String s )
    {
        faceClass = s;
    }
    
    
    
    @Override
    public void paint(ArrayList<Face> m, Graphics g, int w, int h)
    {
        for ( Face f : m )
        {
            f.paint( g );
        }
        
        if ( ULCx != null )
        {
            int curx = Mouse.getX();
            int cury = Mouse.getY();
            
            Graphics2D g2D = (Graphics2D)g;
            g.setColor( Color.BLACK );
            float [] dashes = { 10, 10 };
            g2D.setStroke( new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dashes, 0 ));
            int width = Math.max( Math.abs(curx-ULCx), Math.abs( cury -ULCy ) );
            g.drawRect( Math.min(ULCx, curx), Math.min(ULCy, cury), width, width );
        }
    }
    
    @Override
    public void handleTimePassage( ArrayList<Face> m, int ea, int dt )
    {
        for ( Face f : m )
        {
            f.update( dt );
        }
    }
    
    public void handleMouseClick( ArrayList<Face> m, int ea, MouseEvent me )
    {
        if ( ULCx == null )
        {
            ULCx = me.getX();
            ULCy = me.getY();
        }
        else
        {
            int curx = Mouse.getX();
            int cury = Mouse.getY();
            
            int ulcx = Math.min( curx, ULCx );
            int ulcy = Math.min( cury, ULCy );
            int width = Math.max( Math.abs(curx-ULCx), Math.abs( cury -ULCy ) );

            Face f = FunnyFaceLab.getNewFace( faceClass, ulcx, ulcy, width );
            if ( f != null )
            {
                m.add( f );
            }
            ULCx = null;
            ULCy = null;
        }
        
    }
    
}
