package controller;

import java.io.IOException;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UserDao;
import models.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 6135120049380996083L;  // domanda per Stefano

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		
		// verifico l'identità
		if(userDao.checkIdentity(username, password)) {
			// prendo tutti gli utenti
			List<User> userList = userDao.getAllUsers();
			
			req.setAttribute("username", username);
			req.setAttribute("userList", userList);
			// rimando a welcome e mostro in formato tabulare tutti gli utenti
			RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/welcome.jsp");
			dispatcher.forward(req, resp);
			
		} else {
			// rimando a login nel caso di errore
			req.setAttribute("errorMessage", "CREDENZIALI ERRATE");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/login.jsp");
			requestDispatcher.forward(req, resp);
		}

		
	}

	
}
