package slt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String no = request.getParameter("no");//从页面中获取参数值
        String password = request.getParameter("password");
        User user = new User();//封装数据
        user.setUserNo(no);
        user.setUserPassword(password);

        HttpSession session = request.getSession();

        new UserDao();
        User ruser = UserDao.checkUser(user);//接收查询结果
        if (ruser != null) {
            System.out.println("匹配成功");
            if (ruser.getUserPassword().equals(password) && ruser.getUserNo().equals(no)) {
                if (ruser.getUserType().equals("student")) {//用户身份是student
                    System.out.println("student " + ruser.getUserNo() + " " + ruser.getUserPassword() + " " + ruser.getUserName());

                    session.setAttribute("no", ruser.getUserNo());
                    session.setAttribute("password", ruser.getUserPassword());
                    session.setAttribute("type", ruser.getUserType());
                    session.setAttribute("name", ruser.getUserName());
                    //将送回页面的数据写入session

                    request.getRequestDispatcher("/student/index.jsp").forward(request, response); //响应页面跳转，去index
                } else if (ruser.getUserType().equals("admin")) {//用户身份是admin
                    System.out.println("admin " + ruser.getUserNo() + " " + ruser.getUserPassword());

                    session.setAttribute("no", ruser.getUserNo());
                    session.setAttribute("password", ruser.getUserPassword());
                    session.setAttribute("type", ruser.getUserType());
                    session.setAttribute("name", ruser.getUserName());

                    request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
                } else if (ruser.getUserType().equals("teacher")) {//用户身份是teacher
                    System.out.println("teacher " + ruser.getUserNo() + " " + ruser.getUserPassword());

                    session.setAttribute("no", ruser.getUserNo());
                    session.setAttribute("password", ruser.getUserPassword());
                    session.setAttribute("type", ruser.getUserType());
                    session.setAttribute("name", ruser.getUserName());

                    request.getRequestDispatcher("/teacher/index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("Err", "密码或用户名错误");
                System.out.println("无法登录");
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("Err", "密码或用户名错误");
            System.out.println("密码或名字错误");
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }
    }

}
