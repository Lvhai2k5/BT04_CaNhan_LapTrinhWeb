package vn.iotstar.controller;

import vn.iotstar.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("account") != null) {
            User user = (User) session.getAttribute("account");

            switch (user.getRole()) {
                case "ADMIN" -> req.getRequestDispatcher("/views/admin.jsp").forward(req, resp);
                case "STAFF" -> req.getRequestDispatcher("/views/staff.jsp").forward(req, resp);
                default -> req.getRequestDispatcher("/views/customer.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
