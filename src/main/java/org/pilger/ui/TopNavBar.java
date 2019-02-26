package org.pilger.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import org.pilger.ui.view.*;

public class TopNavBar extends Div implements RouterLayout {
	
	private static final long serialVersionUID = 1L;
	
	private final String TITLE = "Pilger";

	private HorizontalLayout topNavigation;
	private RouterLink homeLink;
	private RouterLink accessDeniedLink;
	private RouterLink microserviceLink;
	
	public TopNavBar() {
		addClassName("main-layout__header");
		
		homeLink = new RouterLink(null, Home.class);
		homeLink.add(new Icon(VaadinIcon.HOME), new Text("Home"));
		homeLink.addClassName("main-layout__top-nav-item");
		homeLink.setHighlightCondition(HighlightConditions.sameLocation());

		microserviceLink= new RouterLink(null, MicroServ.class);
		microserviceLink.add(new Icon(VaadinIcon.POWER_OFF), new Text("MicroService"));
		microserviceLink.addClassName("main-layout__top-nav-item");
		microserviceLink.setHighlightCondition(HighlightConditions.sameLocation());

		accessDeniedLink = new RouterLink(null, AccessDenied.class);
		accessDeniedLink.add(new Icon(VaadinIcon.POWER_OFF), new Text("AccessDenied"));
		accessDeniedLink.addClassName("main-layout__top-nav-item");
		accessDeniedLink.setHighlightCondition(HighlightConditions.sameLocation());

		topNavigation = new HorizontalLayout();
		topNavigation.addClassName("main-layout__top-nav");
		topNavigation.add(homeLink, microserviceLink, accessDeniedLink);

		H2 title = new H2(TITLE);
		title.addClassName("main-layout__title");

		add(title, topNavigation);
	}
	

	public HorizontalLayout getTopNavigation() {
		return topNavigation;
	}


	public void setTopNavigation(HorizontalLayout topNavigation) {
		this.topNavigation = topNavigation;
	}


}
