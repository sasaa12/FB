package rs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPretraga
 */
@WebServlet("/ServletPretraga")
public class ServletPretraga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPretraga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search");
		ProizvodiDAO da=new ProizvodiDAO();
		
		ArrayList<Procesor>p=da.pretragaProcesor(search);
		request.setAttribute("procesor", p);
		
		ArrayList<ramMemorija>rm=da.pretragaRamMemorija(search);
		request.setAttribute("rammemorija", rm);
		
		ArrayList<hardDisk>hd=da.pretragaHardDisk(search);
		request.setAttribute("harddisk", hd);
		
		ArrayList<Tastatura>ts=da.pretragaTastatura(search);
		request.setAttribute("tastatura", ts);
		
		ArrayList<Mis>ms=da.pretragaMis(search);
		request.setAttribute("mis", ms);
		
		ArrayList<maticnaPloca>mp=da.pretragaMaticnaPloca(search);
		request.setAttribute("maticnaploca", mp);
		
		ArrayList<Monitor>mon=da.pretragaMonitor(search);
		request.setAttribute("monitor", mon);
		
		ArrayList<flashMemorija>fm=da.pretragaFlesMemorija(search);
		request.setAttribute("flesmemorija", fm);
		
		ArrayList<grafickaKartica>grk=da.pretragaGrafickaKartica(search);
		request.setAttribute("grafickakartica", grk);
		
		
		request.getRequestDispatcher("pretraga.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
