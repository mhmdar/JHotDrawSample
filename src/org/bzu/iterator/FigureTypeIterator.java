package org.bzu.iterator;

import org.bzu.sample.figure.FigureType;

public class FigureTypeIterator implements Iterator {

    int index;

    @Override
    public boolean hasNext() {
    
       if(index < FigureType.values().length){
          return true;
       }
       return false;
    }

    @Override
    public FigureType next() {
    
       if(this.hasNext()){
          return FigureType.values()[index++];
       }
       return null;
    }		
 }
