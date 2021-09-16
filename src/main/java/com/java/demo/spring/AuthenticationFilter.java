package com.java.demo.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component("requestFilter")
public class AuthenticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String authType = req.getHeader("authType");
		String sessionId = req.getHeader("session-id");
		if (authType == null || sessionId == null || !isValidSession(authType, sessionId)) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid request");
		}

		if (sessionId != null && authType != null) {
			try {
				if (SecurityContextHolder.getContext().getAuthentication() == null) {
					if (isValidSession(authType, sessionId)) {
						// TODO call to get user details
						List<GrantedAuthority> authList = new ArrayList<>();
						// authList.add(new
						// SimpleGrantedAuthority("ROLE_APIUSER"));
						String username = "rajeshjaiswal";

						UsernamePasswordAuthenticationToken usernameandroles = new UsernamePasswordAuthenticationToken(
								username, null, authList);
						usernameandroles.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

						SecurityContextHolder.getContext().setAuthentication(usernameandroles);
					}
				}
			} catch (Exception e) {
				System.out.println("Unable to validate session, possibly expired");
			}
		}

		chain.doFilter(request, response);
	}

	private boolean isValidSession(String authType, String sessionId) {
		// TODO Call to validate redis session
		return true;
	}

}