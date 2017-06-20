package slt;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xing on 2017/6/15.
 */
@WebServlet("/DelUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String type = request.getParameter("type");
        String no = request.getParameter("no");
        System.out.println("Del "+type+" "+no);
        new UserDao().DelUser(no);
        new UserDao().ChangeUserSta(no,type);

        if (type.equals("stu")) {
            request.getRequestDispatcher("FondStuServlet?type=stu").forward(request, response);
        } else {
            request.getRequestDispatcher("FondStuServlet?type=tea").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
