package org.pilger.ui.view;

import org.pilger.ui.MainView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.context.SecurityContextHolder;

@Route(value = "home", layout = MainView.class)
public class Home extends Div {
 
	private static final long serialVersionUID = 1L;

	public Home() {
		add(new H1("Hello "+ SecurityContextHolder.getContext().getAuthentication().getName()));
	}
}
