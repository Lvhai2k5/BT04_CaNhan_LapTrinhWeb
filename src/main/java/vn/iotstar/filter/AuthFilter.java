package vn.iotstar.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.iotstar.model.User;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getServletPath();
        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("account") : null;

        boolean loggedIn = (user != null);
        boolean allow = path.startsWith("/login") || path.startsWith("/register") || path.contains("css");

        if (!loggedIn && !allow) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
