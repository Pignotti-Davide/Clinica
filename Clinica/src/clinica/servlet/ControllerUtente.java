package clinica.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clinica.facade.FacadeAutenticazione;
import clinica.model.Utente;

@WebServlet("/j_security_check")
public class ControllerUtente extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		FacadeAutenticazione autenticazione = new FacadeAutenticazione();
		autenticazione.setEm(null);
		
		Utente u = autenticazione.login(request.getParameter("j_username"),request.getParameter("j_password"));
		String nextPage=null;
		if(u==null)
			nextPage = "/error.jsp";
		else{
			if(u.getRole().equals("admin"))
				nextPage = "/protected/homeAdmin.jsp";
			else
				if(u.getRole().equals("utente"))
					nextPage="/protected/homeUtente.jsp";
		}
		ServletContext application  = getServletContext();
		HttpSession session= request.getSession();
		session.setAttribute("utente", u);
		String urlNextPage = response.encodeURL(nextPage);
		RequestDispatcher rd = application.getRequestDispatcher(urlNextPage);
		rd.forward(request, response);
	}
}
