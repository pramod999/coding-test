package com.monsanto.mbt;

import java.util.Comparator;
import java.util.Date;


public class Widget {
    private int serialNumber;
    private String color;
    private Date productionDate;

    public Widget(int serialNumber, String color, Date productionDate) {
        this.serialNumber = serialNumber;
        this.color = color;
        this.productionDate = productionDate;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    
    
    
    @Override
	public String toString() {
		return "Widget [serialNumber=" + serialNumber + ", color=" + color + ", productionDate=" + productionDate + "]";
	}



	public static Comparator<Widget> WIDGET_COLOR_COMPARATOR = new Comparator<Widget>() {
		public int compare(Widget w1, Widget w2) {
			return w1.getColor().compareTo(w2.getColor());
		}
    	 };
    	 
    public static Comparator<Widget> WIDGET_DATE_COMPARATOR = new Comparator<Widget>() {
    			public int compare(Widget w1, Widget w2) {
    				if (w1.getProductionDate().before(w2.getProductionDate())) {
    		            return -1;
    		        } else if (w1.getProductionDate().after(w2.getProductionDate())) {
    		            return 1;
    		        } else {
    		            return 0;
    		        }        
    			}
    	    	 };	 
}