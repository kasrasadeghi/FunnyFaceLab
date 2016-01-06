/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funnyfacelab;

import apcscvm.CVMProgram;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DSTIGANT
 */
public class FunnyFaceLab
{

    public static Face getNewFace( String faceClass, int ulcx, int ulcy, int w )
    {
        try
        {
            Class fc = Class.forName( "funnyfacelab." + faceClass );
            Constructor constr = fc.getConstructor( int.class, int.class, int.class );
            return (Face) constr.newInstance( ulcx, ulcy, w );
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(FaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex)
        {
            Logger.getLogger(FaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex)
        {
            Logger.getLogger(FaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            Logger.getLogger(FaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(FaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(FaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(FaceView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        FunnyFaceGUI.main( args );
        /*
        ArrayList<Face> m = new ArrayList<>();
        m.add( new Face(50, 50, 100) );
        FaceView v = new FaceView();
        new CVMProgram( "Funny Face", 800, 600, v, v, m ).start();
        */
    }
}
