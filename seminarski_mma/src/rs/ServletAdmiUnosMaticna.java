package rs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAdmiUnosMaticna
 */
@WebServlet("/ServletAdmiUnosMaticna")
public class ServletAdmiUnosMaticna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdmiUnosMaticna() {
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
		String cena = request.getParameter("cena");
		String socket = request.getParameter("socket");
		String maxMemorija = request.getParameter("maxMemorija");

		String slika = request.getParameter("slika");
		String garancija = request.getParameter("garancija");
		String akcija = request.getParameter("akcija");
		
		if(sifra !=null && sifra.length()>0&&proizvodjac !=null&& proizvodjac.length()>0&&	model !=null && model.length()>0&&cena !=null&& cena.length()>0
				&&socket !=null&& socket.length()>0&&maxMemorija !=null&& maxMemorija.length()>0&& slika != null && slika.length()>0 &&garancija !=null&& garancija.length()>0
				&&	akcija !=null && akcija.length()>0){
			try {
				float c2 = Float.parseFloat(cena);
				int gar2=Integer.parseInt(garancija);
				
				maticnaPloca ma = new maticnaPloca(sifra,proizvodjac,model,socket,maxMemorija,akcija,slika,gar2,c2);
				AdminDAO ud = new AdminDAO();
				ud.insertmaticnaPloca(ma);
				request.setAttribute("msg9", "Uspesno unesen artikal Matična ploča!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				request.setAttribute("msg9", "Cena,garancija i akcija moraju biti broj!!!");
				request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
			}
			
			
		}else{
			request.setAttribute("msg9", "Morate popuniti sva polja!!!");
			request.getRequestDispatcher("UnosAdminProizvod.jsp").forward(request, response);
	
	
	}

		
	}

}
