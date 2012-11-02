package com.homeki.reportweb;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HomekireportwebServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
