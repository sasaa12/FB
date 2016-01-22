package rs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogIn
 */
@WebServlet("/ServletLogIn")
public class ServletLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesija=request.getSession();
		Osoba o=(Osoba) sesija.getAttribute("osoba");
		Admin a=(Admin) sesija.getAttribute("admin");
		sesija.invalidate();
		
		response.sendRedirect("ServletRandom");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ramMemorija> list=new ArrayList<ramMemorija>();
		ArrayList<Procesor> listproc=new ArrayList<Procesor>();
		ArrayList<hardDisk> listhard=new ArrayList<hardDisk>();
		ArrayList<Tastatura> listtas=new ArrayList<Tastatura>();
		ArrayList<Mis> listmis=new ArrayList<Mis>();
		ArrayList<maticnaPloca> listmp=new ArrayList<maticnaPloca>();
		ArrayList<Monitor> listmon=new ArrayList<Monitor>();
		ArrayList<flashMemorija> listfm=new ArrayList<flashMemorija>();
		ArrayList<grafickaKartica> listgk=new ArrayList<grafickaKartica>();
		
		String korisnickoIme=request.getParameter("korisnickoIme");
		String sifra=request.getParameter("sifra");
		String email=request.getParameter("email");
	
		
		if (korisnickoIme!=null && korisnickoIme.length()>0 && sifra!=null && sifra.length()>0) {

			OsobaDAO da=new OsobaDAO ();
			AdminDAO ad=new AdminDAO ();
			
			if(da.existOsoba(korisnickoIme, sifra)==true)
			{

				Osoba osoba=new Osoba (korisnickoIme,email,sifra);
				HttpSession sesija=request.getSession();
				
				sesija.setAttribute("listram", list);
				sesija.setAttribute("listproc", listproc);
				sesija.setAttribute("listhard", listhard);
				sesija.setAttribute("listtas", listtas);
				sesija.setAttribute("listmp", listmp);
				sesija.setAttribute("listmis", listmis);
				sesija.setAttribute("listfm", listfm);
				sesija.setAttribute("listmon", listmon);
				sesija.setAttribute("listgk", listgk);
				
				sesija.setAttribute("os", osoba);
				
				
				
				response.sendRedirect("ServletRandom");
				
				}else if(ad.existAdmin(korisnickoIme, sifra)==true){
					
					Admin a=new Admin(korisnickoIme, sifra);
					HttpSession sesija=request.getSession();
					sesija.setAttribute("admin", a);
					
					
					
					response.sendRedirect("adminMeni.jsp");
					
				} else{
					request.setAttribute("msg", "Ne postoji korisnik sa ovim podacima, morate se prvo registrovati!");
					request.getRequestDispatcher("LogIn.jsp").forward(request, response);
				
				}
			
				 }else  {
			
			request.setAttribute("msg", "Morate popuniti sva polja!");
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		}
	}
}

