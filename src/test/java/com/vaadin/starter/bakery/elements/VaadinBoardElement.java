package com.vaadin.starter.bakery.elements;

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

import java.util.List;

@Element("vaadin-board")
public class VaadinBoardElement extends TestBenchElement {

	public List<VaadinBoardRowElement> getRows() {
		return $(VaadinBoardRowElement.class).all();
	}
}