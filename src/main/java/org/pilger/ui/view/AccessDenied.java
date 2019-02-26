package org.pilger.ui.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.pilger.ui.MainView;



@Route(value = "forbidden", layout = MainView.class)
public class AccessDenied extends HorizontalLayout {
    public AccessDenied() {
        add(new H1("Forbidden"));
    }
}
