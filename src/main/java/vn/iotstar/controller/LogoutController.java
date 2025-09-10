package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
	public static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Hủy session
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Xóa cookie "remember" (nếu có)
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("remember".equals(c.getName())) {
                    c.setValue("");
                    c.setMaxAge(0);     // hết hạn ngay
                    c.setPath("/");     // quan trọng: phải set path mới xoá được
                    resp.addCookie(c);
                }
            }
        }

        // Chuyển hướng tới logout.jsp để hiển thị thông báo
        req.getRequestDispatcher("/views/logout.jsp").forward(req, resp);
    }
}
