package rs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletKupovina
 */
@WebServlet("/ServletKupovina")
public class ServletKupovina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletKupovina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
			try {
				
				HttpSession sesija=request.getSession();
				Narudzbenica nar=new Narudzbenica();
				nar=(Narudzbenica) sesija.getAttribute("nar");
				
				ProizvodiDAO pdao=new ProizvodiDAO();
				if (nar!=null) {
					
					pdao.insertNarudzbenica(nar);
					request.setAttribute("msg", "Uspešna kupovina."); 
					
					request.getRequestDispatcher("korpa.jsp").forward(request, response);
					
				} else {
					request.setAttribute("msg", " Korpa je prazna!"); 
					
					request.getRequestDispatcher("korpa.jsp").forward(request, response); 
					
					
				}
				
				
				
			} catch (Exception e) {
				request.setAttribute("msg", " Korpa je prazna!"); 
				
				request.getRequestDispatcher("korpa.jsp").forward(request, response); 
			}
		
		
		
	
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
