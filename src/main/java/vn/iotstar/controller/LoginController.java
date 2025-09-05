package vn.iotstar.controller;

import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);

            // Điều hướng theo vai trò
            String role = user.getRole();
            if ("ADMIN".equalsIgnoreCase(role)) {
                resp.sendRedirect(req.getContextPath() + "/views/admin.jsp");
            } else if ("STAFF".equalsIgnoreCase(role)) {
                resp.sendRedirect(req.getContextPath() + "/views/staff.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/views/customer.jsp");
            }

        } else {
            req.setAttribute("alert", "Sai tài khoản hoặc mật khẩu!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
