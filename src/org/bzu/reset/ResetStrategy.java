package org.bzu.reset;


import java.util.List;

import org.jhotdraw.draw.Figure;

/**
 * 
 * @author Ahd
 *
 */
public interface ResetStrategy {
	
	/**
	 * Reset the figures according to the defined strategy, strategy pattern will be
	 * responsible for defining the target strategy according to the user input.
	 * <p>
	 * @param figureToSort
	 * 
	 */
	public void resetFigures(List<Figure> figuresToReset);
	
}
