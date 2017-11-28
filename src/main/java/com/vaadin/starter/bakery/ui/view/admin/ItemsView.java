package com.vaadin.starter.bakery.ui.view.admin;

import com.vaadin.flow.model.TemplateModel;
import com.vaadin.starter.bakery.ui.components.BakerySearch;
import com.vaadin.starter.bakery.ui.components.FilterChanged;
import com.vaadin.ui.Tag;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.common.HasClickListeners;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.event.ComponentEventListener;
import com.vaadin.ui.polymertemplate.PolymerTemplate;

@Tag("items-view")
@HtmlImport("src/elements/items-view.html")
public class ItemsView extends PolymerTemplate<ItemsView.Model> {

	public interface Model extends TemplateModel {
		void setEditing(Boolean editing);
	}

	private BakerySearch searchBar;

	public ItemsView() {
		searchBar = new BakerySearch();
		searchBar.getElement().setAttribute("slot", "item-search");
		searchBar.setPlaceHolder("Search");

		getElement().appendChild(searchBar.getElement());
	}

	public void addFilterChangeListener(ComponentEventListener<FilterChanged> listener) {
		searchBar.addFilterChangeListener(listener);
	}

	public void addActionClickListener(ComponentEventListener<HasClickListeners.ClickEvent<Button>> listener) {
		searchBar.addActionClickListener(listener);
	}

	public void setActionText(String actionText) {
		searchBar.setActionText(actionText);
	}

	public String getFilter() {
		return searchBar.getFilter();
	}

	public void openDialog(boolean open) {
		getModel().setEditing(open);
	}
}