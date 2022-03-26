package peng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import peng.service.UserService;
import peng.service.Impl.UserServiceImpl;
import peng.bean.User;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us = new UserServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		// �û�ע��
		boolean b = us.regist(new User(null, username, password, email));
		if(b) {
			//regist success, return success regist html redirect
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else {
			//regist failed, return regist html request dispatch
			request.setAttribute("msg", "Username already exists!");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
