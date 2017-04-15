/**
 * 
 */
package org.bzu.ction;


import org.bzu.reset.FiguresResetContext;
import org.bzu.reset.ResetStrategy;
import org.jhotdraw.app.action.ActionUtil;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.AbstractSelectedAction;
import org.jhotdraw.util.ResourceBundleUtil;


/**
 * @author Ahd
 *
 */
public abstract class ResetAction extends AbstractSelectedAction {

	private  String id = "edit.reset";
	
	private FiguresResetContext resetContext = new FiguresResetContext();
	
	public ResetAction(DrawingEditor editor, ResetStrategy strategy) {
		super(editor);
		ResourceBundleUtil labels = ResourceBundleUtil
				.getBundle("resources.org.bzu.Labels");
		labels.configureAction(this, getId());
		putValue(ActionUtil.SUBMENU_KEY, "Reset using Strategy DP");
		
		updateEnabledState();
		getResetContext().setResetStrategy(strategy);
	}

	protected void updateEnabledState() {
		if (getView() != null) {
			setEnabled(getView().getSelectedFigures().size() > 1);
		} else {
			setEnabled(false);
		}
	}

	public String getId() {
		return id;
	}
	
	public FiguresResetContext getResetContext() {
		return resetContext;
	}
}
