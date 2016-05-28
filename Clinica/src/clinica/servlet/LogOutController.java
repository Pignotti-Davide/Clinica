package clinica.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userLogout")
public class LogOutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// gestione della RICHIESTA

		// metto i valori nella sessione
		HttpSession session = request.getSession();
		String nextUrl = "/index.html";
		if(session!=null) {
			session.invalidate();
		}

		// inoltro :)
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextUrl);
		rd.forward(request, response);
		return; 
	}

}