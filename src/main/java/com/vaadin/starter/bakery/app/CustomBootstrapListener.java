package com.vaadin.starter.bakery.app;

import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import org.jsoup.nodes.Element;

public class CustomBootstrapListener implements BootstrapListener {
	public void modifyBootstrapPage(BootstrapPageResponse response) {
		final Element head = response.getDocument().head();

		// manifest needs to be prepended before scripts or it won't be loaded
		head.prepend("<meta name=\"theme-color\" content=\"#227aef\">");
		head.prepend("<link rel=\"manifest\" href=\"/manifest.json\">");

		addFavIconTags(head);
		injectInlineCustomStyles(head);
	}

	private void addFavIconTags(Element head) {
		head.append("<link rel=\"shortcut icon\" href=\"icons/favicon.ico\">");
		head.append("<link rel=\"icon\" sizes=\"192x192\" href=\"icons/icon-192.png\">");
		head.append("<link rel=\"icon\" sizes=\"96x96\" href=\"icons/icon-96.png\">");
		head.append("<link rel=\"apple-touch-icon\" sizes=\"512x512\" href=\"icons/icon-512.png\">");
		head.append("<link rel=\"apple-touch-icon\" sizes=\"192x192\" href=\"icons/icon-192.png\">");
		head.append("<link rel=\"apple-touch-icon\" sizes=\"96x96\" href=\"icons/icon-96.png\">");
	}

	private void injectInlineCustomStyles(Element head) {
		head.append(
				"<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes\">");
		head.append("<!-- Add any global styles for body, document, etc. -->\n" +
                "    <custom-style>\n" +
                "      <style is=\"custom-style\" include=\"valo-color valo-typography\"></style>\n" +
                "    </custom-style>");
	}
}
