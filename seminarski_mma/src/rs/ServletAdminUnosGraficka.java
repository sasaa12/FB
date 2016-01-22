package rs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAdminUnosGraficka
 */
@WebServlet("/ServletAdminUnosGraficka")
public class ServletAdminUnosGraficka extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminUnosGraficka() {
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
		
		String sifra = request.getParameter("sifra");
		String proizvodjac = request.getParameter("proizvodjac");
		String model = request.getParameter("model");
		String cena = request.getParameter("cena");
		String memorija = request.getParameter("memorija");

		String slika = request.getParameter("slika");
		String garancija = request.getParameter("garancija");
		String akcija = request.getParameter("akcija");
		
		if(sifra !=null && sifra.length()>0&&proizvodjac !=null&& proizvodjac.length()>0
			&&	model !=null && model.length()>0&&cena !=null&& cena.length()>0
			&&memorija !=null&& memorija.length()>0
			&& slika != null && slika.length()>0 &&garancija !=null&& garancija.length()>0
			&&	akcija !=null && akcija.length()>0){
			
			try {
				float c8 = Float.parseFloat(cena);
				int gar8=Integer.parseInt(garancija);
				
				grafickaKartica gr = new grafickaKartica(sifra,proizvodjac,model,memorija,akcija,slika,gar8,c8);
				AdminDAO ud = new AdminDAO();
				ud.insertgrafickaKartica(gr);
				request.setAttribute("msg6", "Uspesno unesen artikal Graficka kartica!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				request.setAttribute("msg6", "Cena,garancija i akcija moraju biti broj!!!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
			}
			
			
		}else{
			request.setAttribute("msg6", "Morate popuniti sva polja!!!");
			request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
		}
		
		
	}

	

}
