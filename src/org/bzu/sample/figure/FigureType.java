/**
 * 
 */
package org.bzu.sample.figure;

import org.bzu.iterator.FigureTypeIterator;
import org.bzu.iterator.Iterator;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.DiamondFigure;
import org.jhotdraw.draw.EllipseFigure;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.RectangleFigure;
import org.jhotdraw.draw.RoundRectangleFigure;
import org.jhotdraw.draw.TextFigure;
import org.jhotdraw.draw.TriangleFigure;
import org.jhotdraw.draw.decoration.ArrowTip;
import org.jhotdraw.util.ResourceBundleUtil;


public enum FigureType {
	RECTANGLE("edit.createRectangle",RectangleFigure.class),
	TEXT("edit.createText", TextFigure.class),
	ELLIPSE("edit.createEllipse", EllipseFigure.class),
	ACTOR("edit.createActor", ActorFigure.class),
	ARROW("edit.createArrow", LineFigure.class),
;
	/**
	 * Default jhotdraw framework ResourceBundleutil
	 */
	private static ResourceBundleUtil jhotdrawLabels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

	/**
	 * Design patterns demo custom resource bundle.
	 */
    private static ResourceBundleUtil simpleEditorLabels = ResourceBundleUtil.getBundle("resources.org.bzu.Labels");
    
    /**
     * Label text of the given figure, to be used for its creation icon and tooltip
     */
	private String figureLabel;
	
	/**
	 * Figure class to support reflection in the factory.
	 */
	@SuppressWarnings("rawtypes")
	private Class figureClass;
	
	/**
	 * Construct a figure type.
	 * @param figureLabel
	 * @param figureClass
	 */
	@SuppressWarnings("rawtypes")
	private FigureType(String figureLabel,Class figureClass) {
		this.figureLabel = figureLabel;
		this.figureClass = figureClass;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFigureLabel() {
		return figureLabel;
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Class getFigureClass() {
		return figureClass;
	}
	
	/**
	 * Get the resource bundle util according to the figure type.
	 * @return
	 */
	public ResourceBundleUtil getLabelBundleUtil() {
		if(ordinal() == ACTOR.ordinal() ){
			return simpleEditorLabels;
		}

		return jhotdrawLabels;
	}
	 public static Iterator getIterator() {
	      return new FigureTypeIterator();
	   }
	@Override
	public String toString() {
		return name()+" Used label "+getFigureLabel();
	}
}
