/**
 * 
 */
package org.bzu.sample;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JToolBar;

import org.jhotdraw.app.AbstractApplicationModel;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.DefaultMenuBuilder;
import org.jhotdraw.app.MenuBuilder;
import org.jhotdraw.app.View;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.EllipseFigure;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineConnectionFigure;
import org.jhotdraw.draw.RectangleFigure;
import org.jhotdraw.draw.TextAreaFigure;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.tool.ConnectionTool;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.tool.TextAreaCreationTool;
import org.jhotdraw.samples.pert.figures.DependencyFigure;
import org.jhotdraw.samples.pert.figures.TaskFigure;
import org.jhotdraw.util.ResourceBundleUtil;
import org.bzu.iterator.Iterator;
import org.bzu.sample.figure.FigureFactory;
import org.bzu.sample.figure.FigureFactoryImp;
import org.bzu.sample.figure.FigureType;

/**
 * The application model responsible for preparing the toolbars, action menus
 * and comprises the model in the MVC architecture used by the jhotdraw framework.
 * <p/> 
 */

public class AppModel extends AbstractApplicationModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private DefaultDrawingEditor editor;

	//private FigureFactory figureFactory;

	public AppModel() {
	//	figureFactory = new DefaultFigureFactory();
	}

	@Override
	public void initView(Application app, View view) {
		((DrawingView) view).setEditor(getEditor());
	}

	@Override
	public List<JToolBar> createToolBars(Application app, View pr) {
		ResourceBundleUtil labels = ResourceBundleUtil
				.getBundle("org.jhotdraw.draw.Labels");

		LinkedList<JToolBar> list = new LinkedList<JToolBar>();
		JToolBar tb;
		tb = new JToolBar();
		addCreationButtonsTo(tb, getEditor());
		tb.setName(labels.getString("window.drawToolBar.title"));
		list.add(tb);
		return list;
	}

	private void addCreationButtonsTo(JToolBar tb, DrawingEditor editor) {
		Collection<Action> menuActions = new LinkedList<Action>();
		// Add separator
		ApplicationModelFacade appFacad = new ApplicationModelFacade();
		appFacad.addDefaultCreationButtonsTo(tb, editor,
				ButtonFactory.createDrawingActions(editor), menuActions);
		
		
	}


	/**
	 * @return the editor
	 */
	public DefaultDrawingEditor getEditor() {
		if (editor == null) {
			editor = new DefaultDrawingEditor();
		}
		return editor;
	}

	@Override
	public ActionMap createActionMap(Application a, View v) {
		return new ActionMap();
	}

	@Override
	public MenuBuilder getMenuBuilder() {
		return new DefaultMenuBuilder();
	}
}
