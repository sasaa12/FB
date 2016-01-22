package rs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletReg
 */
@WebServlet("/ServletReg")
public class ServletReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String korisnickoIme=request.getParameter("korisnickoIme");
		String email=request.getParameter("email");
		String sifra=request.getParameter("sifra");
		String signup=request.getParameter("signup");
		
		OsobaDAO od=new OsobaDAO ();
		
		if (korisnickoIme!=null && korisnickoIme.length()>0 && email!=null && email.length()>0 && sifra!=null && sifra.length()>0) {
			
			if (signup.equals("SignUp")) {
				
			if (od.getKorisnickoIme(korisnickoIme)==false) {
					
					Osoba o=new Osoba (korisnickoIme,email,sifra);
					
					od.insertOsoba(o);
					
					request.setAttribute("msg", "Uspesna registarcija, molimo ulogujte se!");
					request.getRequestDispatcher("SignUp.jsp").forward(request, response);
				}
				
				 else {
				
				request.setAttribute("msg","Osoba sa tim korisnickim imenom vec postoji!");
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			}
			
			} } else {
			
			request.setAttribute("msg","Morate popuniti sva polja!");
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			
		} }
		
		
	

}
