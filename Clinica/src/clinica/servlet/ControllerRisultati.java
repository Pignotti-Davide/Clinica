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

import clinica.model.Esame;
import clinica.model.Medico;
import clinica.persistence.MedicoDaoJPA;

@WebServlet("/controllerRisultati")
public class ControllerRisultati extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo e manipolo i parametri
		String nome = request.getParameter("code");
		//  verifico i dati

		boolean erroriPresenti = false;
		String nextPage="/protected/listaRisultati.jsp";
		System.out.println(nome);
		if(nome.isEmpty()){
			erroriPresenti=true;
			
			request.setAttribute("codeError", "Campo obbligatorio");
		}
		
		if(erroriPresenti){
			nextPage  = "/protected/risultatiPaziente.jsp";
		}
		// tutti i dati corretti
//		Esame esame = new Esame();
//		esame.set.. bla bla
//	

		ServletContext application  = getServletContext();
		HttpSession session= request.getSession();
		session.setAttribute("med", null);
		String urlNextPage = response.encodeURL(nextPage);
		RequestDispatcher rd = application.getRequestDispatcher(urlNextPage);
		rd.forward(request, response);
		
	}
	

}