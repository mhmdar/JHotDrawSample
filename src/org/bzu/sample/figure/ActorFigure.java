package org.bzu.sample.figure;

import static org.jhotdraw.draw.AttributeKeys.COMPOSITE_ALIGNMENT;
import static org.jhotdraw.draw.AttributeKeys.STROKE_COLOR;
import static org.jhotdraw.draw.AttributeKeys.STROKE_TYPE;
import static org.jhotdraw.draw.AttributeKeys.TEXT_ALIGNMENT;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.GraphicalCompositeFigure;
import org.jhotdraw.draw.ImageFigure;
import org.jhotdraw.draw.LineConnectionFigure;
import org.jhotdraw.draw.TextAreaFigure;
import org.jhotdraw.draw.connector.Connector;
import org.jhotdraw.draw.layouter.VerticalLayouter;
import org.jhotdraw.geom.Dimension2DDouble;
import org.jhotdraw.geom.Insets2D;

public class ActorFigure extends GraphicalCompositeFigure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConnectionFigure conn;

	private TextAreaFigure txtArFg;

	 public ActorFigure(){
			
	 }

	public ConnectionFigure getConnectionFigure() {
		return conn;
	}

	   @Override
	    public void draw(Graphics2D g) {
	        drawPresentationFigure(g);
	        BufferedImage bimg = null;
			try {
				java.net.URL imgURL = getClass().getResource("../images/use_case_actor.png");
				bimg = ImageIO.read(imgURL);
			} catch (Exception e) {
				System.out
						.println("birzeit.edu.editor.objects.EmployeeFigure.buildFigure():"
								+ e);
			}

			ImageFigure imf = new ImageFigure();
			imf.setBufferedImage(bimg);
			imf.set(STROKE_COLOR, Color.BLACK);
	 		imf.setBounds(new Point2D.Double(0, 0), new Point2D.Double(160, 70));

			TextAreaFigure txtArFg = new TextAreaFigure();
			Dimension2DDouble dim = txtArFg.getPreferredTextSize(150);
			Insets2D.Double insets = txtArFg.getInsets();
			txtArFg.setBounds(
					new Point2D.Double(0, 0),
					new Point2D.Double(Math.max(150, dim.width) + insets.left
							+ insets.right, dim.height + insets.top + insets.bottom));
			txtArFg.set(STROKE_COLOR, Color.BLACK);
			// txtArFg.set(FILL_COLOR, null);
			txtArFg.set(TEXT_ALIGNMENT, AttributeKeys.Alignment.BLOCK);

			 
			this.setLayouter(new VerticalLayouter());
			this.set(COMPOSITE_ALIGNMENT, AttributeKeys.Alignment.CENTER);
	        super.draw(g);
	    }

	 

	/**
	 * @return the txtArFg
	 */
	public TextAreaFigure getTxtArFg() {
		return txtArFg;
	}

	/**
	 * @param txtArFg
	 *            the txtArFg to set
	 */
	public void setTxtArFg(TextAreaFigure txtArFg) {
		this.txtArFg = txtArFg;
	}

	// *********** SmartConnectionFigure Class
	private static class SmartConnectionFigure extends LineConnectionFigure {
		private static final long serialVersionUID = 13424234L;

		public SmartConnectionFigure() {
			setAttributeEnabled(STROKE_TYPE, false);
		}

		@Override
		public void handleConnect(Connector start, Connector end) {
		
			setAttributeEnabled(STROKE_TYPE, true);
			willChange();
			set(STROKE_TYPE,
					(start.getOwner() == end.getOwner()) ? AttributeKeys.StrokeType.DOUBLE
							: AttributeKeys.StrokeType.BASIC);
			changed();
			setAttributeEnabled(STROKE_TYPE, false);
		}

		@Override
		public void handleDisconnect(Connector start, Connector end) {
			setAttributeEnabled(STROKE_TYPE, true);
			willChange();
			set(STROKE_TYPE, AttributeKeys.StrokeType.BASIC);
			changed();
			setAttributeEnabled(STROKE_TYPE, false);
		}
	}
}
