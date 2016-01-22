package rs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRandom
 */
@WebServlet("/ServletRandom")
public class ServletRandom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRandom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProizvodiDAO od=new ProizvodiDAO();
		
		Procesor p=od.getRProcesor();
	    request.setAttribute("procesor", p);
	    
	    ramMemorija rm=od.getRramMemorija();
	    request.setAttribute("rammemorija", rm);
	    
	    hardDisk hd=od.getRhardDisk();
	    request.setAttribute("harddisk", hd);
	    
	    Tastatura tas=od.getRTastatura();
	    request.setAttribute("tastatura", tas);
	 
	    Mis mis=od.getRMis();
	    request.setAttribute("mis", mis);
	    
	    maticnaPloca mp=od.getRmaticnaPloca();
	    request.setAttribute("maticna", mp);
	    
	    Monitor mon=od.getRMonitor();
	    request.setAttribute("monitor", mon);
	    
	    grafickaKartica graf=od.getRGrafickaKartica();
	    request.setAttribute("grafickakartica", graf);
	    
	    flashMemorija fm=od.getRFlasMemorija();
	    request.setAttribute("flashmemorija", fm);
	    
	    request.getRequestDispatcher("pocetna.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
