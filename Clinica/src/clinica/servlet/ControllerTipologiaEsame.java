package clinica.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clinica.model.TipologiaEsame;
import clinica.persistence.TipologiaEsameDaoJPA;

@WebServlet("/controllerTipologia")
public class ControllerTipologiaEsame extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo e manipolo i parametri
		String nome = request.getParameter("importo").toUpperCase();
		String num = request.getParameter("rate");
		int numero = Integer.parseInt(num);
		String [] requisiti= new String[numero];
		for(int i=1; i<=numero; i++){
			requisiti[i-1] =request.getParameter("rata"+i);
		}
		//  verifico i dati

		boolean erroriPresenti = false;
		String nextPage=null;
		
		if(nome.equals("")){
			erroriPresenti=true;
			request.setAttribute("nomeError", "Campo obbligatorio");
		}
		if(erroriPresenti){
			nextPage  = "/nuovaTipologiaEsame.jsp";
		}
		// tutti i dati corretti
		TipologiaEsame tip = new TipologiaEsame();
//		tip.setPrerequisiti(creaMappaRequisiti(requisiti));
		tip.setNome(nome);
		new TipologiaEsameDaoJPA().create(tip);
		ServletContext application  = getServletContext();
		HttpSession session= request.getSession();
		session.setAttribute("tip", tip);
		String urlNextPage = response.encodeURL("/tipologiainserita.jsp");
		RequestDispatcher rd = application.getRequestDispatcher(urlNextPage);
		rd.forward(request, response);
		return; 
	}
	public Map<String, String> creaMappaRequisiti(String [] s){
		Map<String, String> creaMappaRequisiti = new HashMap<>();
	
		for(String elem: s){
			System.out.println(elem);
			String [] array = creaDescrizione(elem);
			creaMappaRequisiti.put(array[0], array[1]);
		}
		return creaMappaRequisiti;
	}
	public String [] creaDescrizione(String s){
		String[] coppia = new String[2];
		String nome="";
		String descrizione="";
		for(int i =0; i<s.length(); i++){
			if(s.charAt(i) ==':'){
				nome=s.substring(0, i-1);
				descrizione = s.substring(i+1);
			}
		}
		coppia[0]=nome;
		coppia[1]=descrizione;
		return coppia;
	}
	
}
