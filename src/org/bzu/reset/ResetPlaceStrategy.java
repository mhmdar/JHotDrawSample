package org.bzu.reset;
/**
 * 
 */

import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.List;

import org.jhotdraw.draw.Figure;

/**
 * @author Ahd
 *
 */
public class ResetPlaceStrategy implements ResetStrategy {

	/**
	 * 
	 */
	public ResetPlaceStrategy() {
	}

	@Override
	public  void resetFigures(List<Figure> figuresToReset) {
		
        for(Iterator<Figure> itarator =  figuresToReset.iterator(); itarator.hasNext();){
			Figure figure= itarator.next();
			figure.willChange();
					figure.setBounds(  new Point2D.Double(10,10) , 
							new Point2D.Double(figure.getBounds().getWidth(),figure.getBounds().getHeight()));
					figure.changed();
        
        }
}
}
