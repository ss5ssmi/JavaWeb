package slt;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Xing on 2017/6/14.
 */
@WebServlet("/StuInfoServlet")
public class StuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        User user=new User();
        user.setUserNo(request.getParameter("no"));
        user.setUserType(request.getParameter("type").toString());

        System.out.println("Info "+request.getParameter("no")+" "+request.getParameter("type").toString());

        User fUser=new UserDao().fond(user);

        request.setAttribute("no",request.getParameter("no"));
        request.setAttribute("name",fUser.getUserName());
        request.setAttribute("type",fUser.getUserType());
        request.setAttribute("sex",fUser.getSex());
        request.setAttribute("age", fUser.getAge());
        request.setAttribute("phone", fUser.getPhone());
        request.setAttribute("add", fUser.getAdd());

        request.getRequestDispatcher("/admin/changeStuInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
