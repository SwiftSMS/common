package com.swift.io.net.cookies;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MyCookieManager extends CookieManager {

	public MyCookieManager(final CookieStore store, final CookiePolicy cookiePolicy) {
		super(store, cookiePolicy);
	}

	@Override
	public void put(final URI uri, final Map<String, List<String>> responseHeaders) throws IOException {
		final HashMap<String, List<String>> headers = new HashMap<>(responseHeaders);
		final List<String> validCookies = new ArrayList<>();
		
		for (final Entry<String, List<String>> entry : headers.entrySet()) {
			final String headerName = entry.getKey();
			if ("Set-Cookie".equals(headerName)) {
				for (final String headerValue : entry.getValue()) {
					List<HttpCookie> cookies = HttpCookie.parse(headerValue);
					for (final HttpCookie cookie : cookies) {
						if (!cookie.hasExpired()) {
							validCookies.add(toRFC2965HeaderString(cookie));
						}
					}
				}
				entry.setValue(validCookies);
			}
		}
		super.put(uri, headers);
	}

    /*
     * Constructs a string representation of this cookie. The string format is
     * as RFC 2965/2109, but without leading "Cookie:" token.
     */
    private String toRFC2965HeaderString(final HttpCookie cookie) {
        final StringBuilder sb = new StringBuilder();

        sb.append(cookie.getName()).append("=").append(cookie.getValue());
        sb.append("; Path=").append("/");
        
        if (cookie.getDomain() != null)
            sb.append("; Domain=").append(cookie.getDomain());
        if (cookie.getPortlist() != null)
            sb.append("; Port=").append(cookie.getPortlist());

        return sb.toString();
    }

}
