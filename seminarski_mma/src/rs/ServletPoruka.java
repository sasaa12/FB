package rs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPoruka
 */
@WebServlet("/ServletPoruka")
public class ServletPoruka extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPoruka() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ime =request.getParameter("name");
		String email = request.getParameter("email");
		String tema = request.getParameter("tema");
		String  poruka = request.getParameter("coment");
		
		if(ime !=null && ime.length()>0 && email!= null && email.length()>0 
		&&  tema !=null && tema.length()>0 && poruka !=null && poruka.length()>0  ){
			
			Poruka p = new Poruka(ime,email,tema,poruka);			
			PorukaDAO por = new PorukaDAO();
			por.insertPoruka(p);
			
			request.setAttribute("msg", "Poruka je uspesno poslata");
			request.getRequestDispatcher("kontakt.jsp").forward(request, response);
			
		}else{
			request.setAttribute("msg","Da bi ste poslali poruku morate popuniti sva polja");
			request.getRequestDispatcher("kontakt.jsp").forward(request, response);
		}
		
	}

}
