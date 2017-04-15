package org.bzu.reset;
/**
 * 
 */


import java.util.List;

import org.jhotdraw.draw.Figure;

/**
 * @author Ahd
 *
 */
public class FiguresResetContext {

	private ResetStrategy resetStrategy;

	/**
	 * @param sortStrategy the sortStrategy to set
	 */
	public void setResetStrategy(ResetStrategy sortStrategy) {
		this.resetStrategy = sortStrategy;
	}
	
	public void reset(List<Figure> figures){
		this.resetStrategy.resetFigures(figures);
	}

}
