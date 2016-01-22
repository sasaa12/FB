package rs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAkcija
 */
@WebServlet("/ServletAkcija")
public class ServletAkcija extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAkcija() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProizvodiDAO da=new ProizvodiDAO ();
		
		ArrayList<Procesor> procesor=da.akcijaProcesor();
		request.setAttribute("procesor", procesor);
		
		ArrayList<ramMemorija> rm=da.akcijaRamMemorija();
		request.setAttribute("rammemorija", rm);
		
		ArrayList<hardDisk> hd=da.akcijaHardDisk();
		request.setAttribute("harddisk", hd);
		
		ArrayList<Tastatura> ts=da.akcijaTastatura();
		request.setAttribute("tastatura", ts);
		
		ArrayList<Mis> ms=da.akcijaMis();
		request.setAttribute("mis", ms);
		
		ArrayList<maticnaPloca> mp=da.akcijaMaticnaPloca();
		request.setAttribute("maticnaploca", mp);
		
		ArrayList<Monitor> mon=da.akcijaMonitor();
		request.setAttribute("monitor", mon);
		
		ArrayList<grafickaKartica> grk=da.akcijaGrafickaKartica();
		request.setAttribute("grafickakartica", grk);
		
		ArrayList<flashMemorija> fm=da.akcijaFlashMemorija();
		request.setAttribute("flesmemorija", fm);
		
		request.getRequestDispatcher("akcija.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
