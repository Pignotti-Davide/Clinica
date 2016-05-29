package clinica.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clinica.facade.FacadeDati;
import clinica.model.Esame;
import clinica.model.Medico;
import clinica.model.Paziente;
import clinica.model.TipologiaEsame;
import clinica.persistence.MedicoDaoJPA;
import clinica.persistence.PazienteDaoJPA;
import clinica.persistence.TipologiaEsameDaoJPA;

/**
 * Servlet implementation class ControllerNuovoEsame
 */
@WebServlet("/ControllerNuovoEsame")
public class ControllerNuovoEsame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerNuovoEsame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipologiaEsame t=new FacadeDati().trovaTipologiaEsame(Long.parseLong(request.getParameter("tipologiaEsame")));
		Paziente p=new FacadeDati().trovaPaziente(Long.parseLong(request.getParameter("paziente")));
		Medico m=new FacadeDati().trovaMedico(Long.parseLong(request.getParameter("medico")));
		
		Esame e=new Esame();
		e.setMedico(m);
		e.setPaziente(p);
		e.setTipologiaEsame(t);
		e.setPrenotazione(Date.valueOf(LocalDate.now()));
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
