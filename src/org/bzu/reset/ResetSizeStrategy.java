package org.bzu.reset;


import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.List;


import org.jhotdraw.draw.Figure;

/**
 * @author Ahd
 *
 */
public class ResetSizeStrategy implements ResetStrategy {

	/**
	 * 
	 */
	public ResetSizeStrategy() {
	}

	@Override

	public void resetFigures(List<Figure> figuresToReset) {
        for(Iterator<Figure> itarator =  figuresToReset.iterator(); itarator.hasNext();){
				Figure figure= itarator.next();
				figure.willChange();
						figure.setBounds(  
								new Point2D.Double(figure.getBounds().getMinX(),figure.getBounds().getMinY()) , 
								new Point2D.Double(figure.getBounds().getMinX()+180.0,figure.getBounds().getMinY()+50.0));
						
		figure.changed();				
        }
	
}
}

