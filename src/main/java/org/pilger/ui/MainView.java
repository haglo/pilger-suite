package org.pilger.ui;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

@HtmlImport("frontend://styles/shared-styles.html")
@Route("")
public class MainView extends Div implements RouterLayout {

	private static final long serialVersionUID = 1L;
	private TopNavBar topNavBar;
	
    public MainView() {
    	topNavBar = new TopNavBar();
    	
    	add(topNavBar);

    }


}

