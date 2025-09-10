package vn.iotstar.controller;

import vn.iotstar.model.Category;
import vn.iotstar.model.User;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.CategoryServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/category")
@MultipartConfig
public class CategoryController extends HttpServlet {
    public static final long serialVersionUID=1L;
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User u = (User) req.getSession().getAttribute("account");
        String action = req.getParameter("action");
        if (action == null) action = "list";

        if ("ADMIN".equals(u.getRole())) {
            switch (action) {
                case "new" -> req.getRequestDispatcher("/views/category-form.jsp").forward(req, resp);
                case "edit" -> {
                    int id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("category", service.findById(id));
                    req.getRequestDispatcher("/views/category-form.jsp").forward(req, resp);
                }
                case "delete" -> {
                    int id = Integer.parseInt(req.getParameter("id"));
                    service.delete(id);
                    resp.sendRedirect(req.getContextPath() + "/category");
                }
                default -> {
                    req.setAttribute("list", service.findAll());
                    req.getRequestDispatcher("/views/category-list.jsp").forward(req, resp);
                }
            }
        } else if ("STAFF".equals(u.getRole())) {
            req.setAttribute("list", service.findAll());
            req.getRequestDispatcher("/views/category-list.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Bạn không có quyền truy cập!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User u = (User) req.getSession().getAttribute("account");
        if (!"ADMIN".equals(u.getRole())) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String desc = req.getParameter("description");

        // Lấy file upload
        Part filePart = req.getPart("image");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("/uploads");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();
            filePart.write(uploadPath + File.separator + fileName);
        }

        Category c = new Category();
        c.setName(name);
        c.setDescription(desc);
        if (fileName != null) c.setImage("uploads/" + fileName);

        if (idStr != null && !idStr.isEmpty()) {
            c.setId(Integer.parseInt(idStr));
            service.update(c);
        } else {
            service.insert(c);
        }

        resp.sendRedirect(req.getContextPath() + "/category");
    }
}
