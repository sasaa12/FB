package rs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesija=request.getSession();
		sesija.invalidate();
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String korisnickoime=request.getParameter("username");
		String sifra=request.getParameter("pass");
	
	
		
		if (korisnickoime!=null && korisnickoime.length()>0 && sifra!=null && sifra.length()>0) {

			AdminDAO ad=new AdminDAO ();
			
			if(ad.existAdmin(korisnickoime, sifra)==true)
			{

				Admin admin=new Admin (korisnickoime,sifra);
				HttpSession sesija=request.getSession();
				//Ovde dolazi sama funkcija(srz problema nazvana os :D)
				sesija.setAttribute("ad", admin);
				request.setAttribute("msg",admin.getKorisnickoime());
				request.getRequestDispatcher("indexAdminLog.jsp").forward(request, response);
				
				}else{
				request.setAttribute("msg", "Ne postoji korisnik sa ovim podacima!");
				request.getRequestDispatcher("adminLogIn.jsp").forward(request, response);
			
				} }else  {
			
			request.setAttribute("msg", "Morate popuniti sva polja!");
			request.getRequestDispatcher("adminLogIn.jsp").forward(request, response);
			
		}
	}
}