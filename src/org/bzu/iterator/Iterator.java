package org.bzu.iterator;

import org.bzu.sample.figure.FigureType;

public interface Iterator {
   public boolean hasNext();
   public FigureType next();
}
