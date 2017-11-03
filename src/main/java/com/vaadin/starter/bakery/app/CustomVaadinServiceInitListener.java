package com.vaadin.starter.bakery.app;

import com.vaadin.server.ServiceInitEvent;
import com.vaadin.server.VaadinServiceInitListener;
import com.vaadin.shared.ui.Dependency;
import com.vaadin.shared.ui.LoadMode;
import org.springframework.stereotype.Component;

@Component
public class CustomVaadinServiceInitListener implements VaadinServiceInitListener {

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.addBootstrapListener(new CustomBootstrapListener());
        event.addDependencyFilter((dependencies, filterContext) -> {
            if (filterContext.getService().getDeploymentConfiguration().isProductionMode()) {
                dependencies.removeIf(e -> e.getType().equals(Dependency.Type.HTML_IMPORT));
                dependencies.add(new Dependency(Dependency.Type.HTML_IMPORT,
                        "src/app/bakery-app.html", LoadMode.EAGER));
            }
            return dependencies;
        });
    }
}