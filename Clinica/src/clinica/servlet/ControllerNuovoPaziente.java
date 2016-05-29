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

import clinica.facade.FacadeDati;
import clinica.model.Paziente;
import clinica.persistence.PazienteDaoJPA;

/**
 * Servlet implementation class ControllerNuovoPaziente
 */
@WebServlet("/ControllerNuovoPaziente")
public class ControllerNuovoPaziente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerNuovoPaziente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePaziente=request.getParameter("nome_Paziente");
		String cognomePaziente=request.getParameter("cognome_Paziente");
		
		boolean erroriPresenti = false;
		String nextPage=null;

		if(nomePaziente.equals("")){
			erroriPresenti=true;
			request.setAttribute("nomeError", "Campo obbligatorio");
		}
		if(cognomePaziente.equals("")){
			erroriPresenti=true;
			request.setAttribute("cognomeError", "Campo obbligatorio");
		}
		if(erroriPresenti){
			nextPage  = "/nuovoPaziente.jsp";
		}
		// tutti i dati corretti
		Paziente p=new Paziente();
		p.setNome(nomePaziente);
		p.setCognome(cognomePaziente);

		new FacadeDati().salvaPaziente(p);
	
		ServletContext application  = getServletContext();
		HttpSession session= request.getSession();
		session.setAttribute("paz", p);
		String urlNextPage = response.encodeURL("/protected/pazienteInserito.jsp");
		RequestDispatcher rd = application.getRequestDispatcher(urlNextPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
