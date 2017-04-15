package org.bzu.ction;

import java.util.LinkedList;

import org.bzu.reset.ResetPlaceStrategy;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;

/**
 * This action class is responsible for changing layout of the given
 * figures,
 * The user can reset the figure place (origin point) , or he can reset the size to
 * The default size of the figure.
 * <br>
 * figures.
 * <p> 
 * @author Ahd 
 */
public class FigureResetPlaceAction extends ResetAction {
	private static final long serialVersionUID = 1L;

	public FigureResetPlaceAction(DrawingEditor editor) {
		this(editor, true);
	}

	/** Creates a new instance. */
	public FigureResetPlaceAction(DrawingEditor editor,
			boolean canChangeLayout) {
		super(editor,new ResetPlaceStrategy());
	}

	@Override
	protected void updateEnabledState() {
			setEnabled(true);
	}


	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		final DrawingView view = getView();

		final LinkedList<Figure> figures = new LinkedList<Figure>(
				view.getSelectedFigures());
		
		getResetContext().reset(figures);

	}

	@Override
	public String getId() {
		return "edit.reset.place";
	}

}
