package org.pilger.ui.view;

import org.pilger.ui.MainView;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * https://www.mediaevent.de/xhtml/iframe.html
 */

@Route(value = "microServ", layout = MainView.class)
public class MicroServ extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public MicroServ() {

    }

    private void initView() {
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
    }

}
