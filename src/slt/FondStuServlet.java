package slt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.StuDao;

/**
 * Servlet implementation class Fond
 */
@WebServlet("/FondStuServlet")
public class FondStuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FondStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String type = request.getParameter("type");
        List<Map<String, Object>> list = new AdminDao().fondstu(type);

        request.setAttribute("stu", list);

        if (type.equals("stu")) {
            request.getRequestDispatcher("admin/stu_list.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("admin/tea_list.jsp").forward(request, response);
        }
        return;
    }

}
