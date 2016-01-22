package rs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAdminUnosTastatura
 */
@WebServlet("/ServletAdminUnosTastatura")
public class ServletAdminUnosTastatura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminUnosTastatura() {
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
	
		
		String sifra = request.getParameter("sifra");
		String proizvodjac = request.getParameter("proizvodjac");
		String model = request.getParameter("model");
		String tip = request.getParameter("tip");
		String akcija = request.getParameter("akcija");
		String slika = request.getParameter("slika");
		String cena = request.getParameter("cena");
		String garancija = request.getParameter("garancija");
		
		
		if(sifra !=null && sifra.length()>0&&proizvodjac !=null&& proizvodjac.length()>0&&	model !=null && model.length()>0&&cena !=null&& cena.length()>0
				&&tip !=null&& tip.length()>0&& slika != null && slika.length()>0 &&garancija !=null&& garancija.length()>0
				&&	akcija !=null && akcija.length()>0){
			try {
				float c5 = Float.parseFloat(cena);
				int gar5=Integer.parseInt(garancija);
				
				Tastatura t = new Tastatura(sifra,proizvodjac,model,tip,akcija,slika,c5,gar5);
				AdminDAO ud = new AdminDAO();
				
				ud.inserttastatura(t);
				request.setAttribute("msg3", "Uspesno unesen artikal tastatura!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				request.setAttribute("msg3", "Cena,garancija i akcija moraju biti broj!!!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
			}
			
			
		}else{
			request.setAttribute("msg3", "Morate popuniti sva polja!!!");
			request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
	
	}
		
	}

}
