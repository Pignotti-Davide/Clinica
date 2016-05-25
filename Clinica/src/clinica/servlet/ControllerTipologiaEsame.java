package clinica.servlet;

import java.io.IOException;
import java.util.HashMap;
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

@WebServlet("/controllerTipologiaEsame")
public class ControllerTipologiaEsame extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo e manipolo i parametri
		String nome = request.getParameter("nome_Esame").toUpperCase();
		String descrizione=request.getParameter("descrizione");
		String num = request.getParameter("num_requisiti");
		int numero = Integer.parseInt(num);
		
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

		tip.setPrerequisiti(creaMappaRequisiti(numero,request));
		tip.setNome(nome);
		tip.setDescrizione(descrizione);


		System.out.println("prima");

		new TipologiaEsameDaoJPA().create(tip);
	
		System.out.println("dopo");

		
		ServletContext application  = getServletContext();
		HttpSession session= request.getSession();
		session.setAttribute("tip", tip);
		String urlNextPage = response.encodeURL("/tipologiainserita.jsp");
		RequestDispatcher rd = application.getRequestDispatcher(urlNextPage);
		rd.forward(request, response);
		
	}
	public Map<String, String> creaMappaRequisiti(int numero,HttpServletRequest request){
		Map<String, String> creaMappaRequisiti = new HashMap<>();
		for(int i=1; i<=numero; i++){
			
			creaMappaRequisiti.put(request.getParameter("requisito"+i), request.getParameter("descrizione_requisito"+i));
		}
		return creaMappaRequisiti;
	}
//	public String [] creaDescrizione(String s){
//		String[] coppia = new String[2];
//		String nome="";
//		String descrizione="";
//		for(int i =0; i<s.length(); i++){
//			if(s.charAt(i) ==':'){
//				nome=s.substring(0, i-1);
//				descrizione = s.substring(i+1);
//			}
//		}
//		coppia[0]=nome;
//		coppia[1]=descrizione;
//		return coppia;
//	}

}
