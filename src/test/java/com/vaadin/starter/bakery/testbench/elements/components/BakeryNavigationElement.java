package com.vaadin.starter.bakery.testbench.elements.components;

import com.vaadin.starter.bakery.testbench.elements.core.PaperTabElement;
import com.vaadin.starter.bakery.testbench.elements.ui.DashboardViewElement;
import com.vaadin.starter.bakery.testbench.elements.ui.LoginViewElement;
import com.vaadin.starter.bakery.testbench.elements.ui.ProductsViewElement;
import com.vaadin.starter.bakery.testbench.elements.ui.UsersViewElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element("bakery-navigation")
public class BakeryNavigationElement extends TestBenchElement {

	public DashboardViewElement navigateToDashboard() {
		return navigateTo("dashboard", DashboardViewElement.class);
	}

	public UsersViewElement navigateToUsers() {
		return navigateTo("users", UsersViewElement.class);
	}

	public ProductsViewElement navigateToProducts() {
		return navigateTo("products", ProductsViewElement.class);
	}

	public LoginViewElement logout() {
		$(PaperTabElement.class).last().click();
		return $(LoginViewElement.class).onPage().waitForFirst();
	}

	private <T extends TestBenchElement> T navigateTo(String pageId, Class<T> landingPage) {
		$(PaperTabElement.class).attribute("page-id", pageId).first().click();
		return $(landingPage).onPage().waitForFirst();
	}
}