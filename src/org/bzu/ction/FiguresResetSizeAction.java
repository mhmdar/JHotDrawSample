package org.bzu.ction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.bzu.reset.FiguresResetContext;
import org.bzu.reset.ResetPlaceStrategy;
import org.bzu.reset.ResetSizeStrategy;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.GraphicalCompositeFigure;
import org.jhotdraw.draw.ListFigure;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.draw.layouter.HorizontalLayouter;
import org.jhotdraw.draw.layouter.Layouter;
import org.jhotdraw.draw.layouter.VerticalLayouter;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * This action class is responsible for changing layout of the given
 * figures, it will collect them in a composite figure then using strategy pattern to
 * change them initially to vertical layout
 * After that will update the layout according to the previously used layout
 * <br>
 * This action will be enabled only on more than one item selection or on composite
 * figures.
 * <p> 
 * @author Ahmad Zarour
 * @author Mohammad Shawahneh
 */
public class FiguresResetSizeAction extends ResetAction {
	private static final long serialVersionUID = 1L;


	public FiguresResetSizeAction(DrawingEditor editor) {
		this(editor, true);
	}

	/** Creates a new instance. */
	public FiguresResetSizeAction(DrawingEditor editor,
			boolean canChangeLayout) {
		super(editor,new ResetSizeStrategy());
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
		return "edit.reset.size";
	}
}
