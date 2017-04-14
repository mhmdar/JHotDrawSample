/**
 * 
 */
package org.bzu.sample.figure;

import org.jhotdraw.draw.Figure;


public interface FigureFactory {

	/**
	 * Return a default figure instance according to the passed figure type.
	 * @param type
	 * @return
	 */
	Figure getFigure(FigureType type);
	

}
