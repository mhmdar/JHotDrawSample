/**
 * 
 */
package org.bzu.sample.figure;

import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.RectangleFigure;


public class FigureFactoryImp implements FigureFactory {

	/**
	 * @see org.simpleeditor.figure.FigureFactory#getFigure(org.simpleeditor.figure.FigureType)
	 */
	@Override
	public Figure getFigure(FigureType type) {
		try {
			return (Figure) type.getFigureClass().newInstance();
		} catch (Exception e2) {
			System.err
					.println("Unknown exception creating class return default Figure, rectangle figure");
		}
		return new RectangleFigure();
	}



}
