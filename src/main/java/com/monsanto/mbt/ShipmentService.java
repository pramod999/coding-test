package com.monsanto.mbt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/*
 * Function takes care of getting widgets from warehouse
 * create shipments based on criteria's and move to customer
 * 
 */
public class ShipmentService {

	public static void main(String[] args) {
		List<Widget> widgets = getAllWidgets();

		// without any sort
		createShipment(widgets);

		// after color Sort
		sortByColorAscending(widgets);
		createShipment(widgets);

		// after date Sort
		//currently supports ascending can be customized to make it desc etc.
		sortByDateAscending(widgets);
		createShipment(widgets);

	}

	// can be enhanced to send options for sort , widgets size in shipment etc.
	// can be made more generic with automated uuid based shipment nuumbers etc.
	private static void createShipment(List<Widget> widgets) {

		List<Widget> shipWidgets = new ArrayList<Widget>();
		int i = 1;
		int shipmentCount = 0;
		for (; i <= widgets.size(); i++) {
			shipWidgets.add(widgets.get(i - 1));
			if (i % 10 == 0) {
				shipmentCount += 1;
				Shipment shipment = new Shipment("S" + shipmentCount, shipWidgets, "C1", new DateTime().toString());
				System.out.println("Shipment created " + shipment);
				shipWidgets.clear();
			}
		}
		if (shipWidgets.size() > 0) {
			shipmentCount += 1;
			Shipment shipment = new Shipment("S" + shipmentCount, shipWidgets, "C1", new DateTime().toString());
			System.out.println("Shipment created " + shipment);
		}

	}

	private static void sortByColorAscending(List<Widget> widgets) {
		Collections.sort(widgets, Widget.WIDGET_COLOR_COMPARATOR);
	}

	private static void sortByDateAscending(List<Widget> widgets) {
		Collections.sort(widgets, Widget.WIDGET_DATE_COMPARATOR);
	}

	private static List<Widget> getAllWidgets() {

		List<Widget> widgets = new ArrayList<Widget>();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");

		Widget widget1 = new Widget(1, "Red", formatter.parseDateTime("1/1/2006").toDate());
		Widget widget2 = new Widget(2, "Blue", formatter.parseDateTime("2/1/2007").toDate());
		Widget widget3 = new Widget(3, "Red", formatter.parseDateTime("3/1/2006").toDate());
		Widget widget4 = new Widget(4, "Green", formatter.parseDateTime("4/1/2009").toDate());
		Widget widget5 = new Widget(5, "Green", formatter.parseDateTime("5/1/2011").toDate());
		Widget widget6 = new Widget(1, "Red", formatter.parseDateTime("1/1/2006").toDate());
		Widget widget7 = new Widget(2, "Blue", formatter.parseDateTime("2/1/2007").toDate());
		Widget widget8 = new Widget(3, "Red", formatter.parseDateTime("3/1/2006").toDate());
		Widget widget9 = new Widget(4, "Green", formatter.parseDateTime("4/1/2009").toDate());
		Widget widget10 = new Widget(5, "Green", formatter.parseDateTime("5/1/2011").toDate());
		Widget widget11 = new Widget(5, "Green", formatter.parseDateTime("5/1/2011").toDate());

		widgets.add(widget1);
		widgets.add(widget2);
		widgets.add(widget3);
		widgets.add(widget4);
		widgets.add(widget5);
		widgets.add(widget6);
		widgets.add(widget7);
		widgets.add(widget8);
		widgets.add(widget9);
		widgets.add(widget10);
		widgets.add(widget11);
		return widgets;
	}
}
