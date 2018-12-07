package com.monsanto.mbt;

import java.util.List;

public class Shipment {
	
	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", widgets=" + widgets + ", custId=" + custId + ", shipmentDate="
				+ shipmentDate + "]";
	}
	String shipmentId;
	List<Widget> widgets;
	String custId;
	String shipmentDate;
	
	public Shipment(String shipmentId, List<Widget> widgets, String custId, String shipmentDate) {
		this.shipmentId = shipmentId;
		this.widgets = widgets;
		this.custId = custId;
		this.shipmentDate = shipmentDate;
	}
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	public List<Widget> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	
}
