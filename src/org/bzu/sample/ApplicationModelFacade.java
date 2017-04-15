package org.bzu.sample;

import java.util.Collection;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.JToolBar;
import javax.tools.Tool;

import org.bzu.iterator.Iterator;
import org.bzu.sample.figure.FigureFactory;
import org.bzu.sample.figure.FigureFactoryImp;
import org.bzu.sample.figure.FigureType;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineConnectionFigure;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.tool.ConnectionTool;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.util.ResourceBundleUtil;

public class ApplicationModelFacade  {
 public ApplicationModelFacade(){
	 
 }
 
public void addDefaultCreationButtonsTo(JToolBar tb,
			final DrawingEditor editor, Collection<Action> drawingActions,
			Collection<Action> selectionActions) {

		// Add the selection tool to toolbar
		ButtonFactory.addSelectionToolTo(tb, editor, drawingActions,
				selectionActions);
        FigureFactory figureFactory = new FigureFactoryImp();
         tb.addSeparator();
         Figure drawingFigure;
         FigureType figureType = null;
         for(Iterator iter = FigureType.getIterator(); iter.hasNext();){
        	figureType = iter.next();
 	       drawingFigure = figureFactory.getFigure(figureType);
 	
 		this.addSingleCreationButtonsTo(tb, editor, new CreationTool(
 					drawingFigure), figureType.getFigureLabel(), figureType
 					.getLabelBundleUtil());
 		}
         addSingleCreationButtonsTo(tb, editor, new ConnectionTool(
 					new LineConnectionFigure()), "edit.createLineConnection", figureType
 					.getLabelBundleUtil());

         
	}

	public void addSingleCreationButtonsTo(JToolBar tb, DrawingEditor editor, org.jhotdraw.draw.tool.Tool connectionTool, String labelKey,
			ResourceBundleUtil labels) {
		
		ButtonFactory.addToolTo(tb, editor, (org.jhotdraw.draw.tool.Tool) connectionTool, labelKey, labels);
	
}

 
}
