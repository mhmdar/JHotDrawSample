/**
 * 
 */
package org.bzu.sample;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URI;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import org.jhotdraw.app.AbstractView;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.gui.PlacardScrollPaneLayout;
import org.jhotdraw.gui.URIChooser;

/**
 * A drawing view needed by the jhotdraw to run the application.
 * <p/>
 * @author Mohammad Shawahneh
 *
 */
public class DrawingView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     */
    private DrawingEditor editor;
    
    
    /**
     * 
     */
    private DefaultDrawingView view;
    
	/**
	 * 
	 */
	public DrawingView() {
		JScrollPane scrollPane = new JScrollPane();
        view = new DefaultDrawingView();

        setLayout(new BorderLayout());

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(view);
        add(scrollPane, BorderLayout.CENTER);
        
        scrollPane.setLayout(new PlacardScrollPaneLayout());
        scrollPane.setBorder(new EmptyBorder(0,0,0,0));
        
        setEditor(getEditor());
        Drawing drawing = new QuadTreeDrawing();
        view.setDrawing(drawing);
      
	}

	/**
	 * @see org.jhotdraw.app.View#clear()
	 */
	@Override
	public void clear() {

	}
	
	/**
	 * @see org.jhotdraw.app.View#write(java.net.URI, org.jhotdraw.gui.URIChooser)
	 */
	@Override
	public void write(URI uri, URIChooser chooser) throws IOException {

	}

	/**
	 * @see org.jhotdraw.app.View#read(java.net.URI, org.jhotdraw.gui.URIChooser)
	 */
	@Override
	public void read(URI uri, URIChooser chooser) throws IOException {

	}

	 /**
     * Sets a drawing editor for the view.
     */
    public void setEditor(DrawingEditor newValue) {
        if (editor != null) {
            editor.remove(view);
        }
        editor = newValue;
        if (editor != null) {
            editor.add(view);
        }
    }
    public DrawingEditor getEditor() {
		return editor;
	}
}
