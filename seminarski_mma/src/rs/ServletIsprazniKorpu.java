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
 * Servlet implementation class ServletIsprazniKorpu
 */
@WebServlet("/ServletIsprazniKorpu")
public class ServletIsprazniKorpu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIsprazniKorpu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesija=request.getSession();
		
		ArrayList<ramMemorija> listram=new ArrayList<ramMemorija>();
		ArrayList<Procesor> listproc=new ArrayList<Procesor>();
		ArrayList<hardDisk> listhard=new ArrayList<hardDisk>();
		ArrayList<Tastatura> listtas=new ArrayList<Tastatura>();
		ArrayList<Mis> listmis=new ArrayList<Mis>();
		ArrayList<maticnaPloca> listmp=new ArrayList<maticnaPloca>();
		ArrayList<Monitor> listmon=new ArrayList<Monitor>();
		ArrayList<flashMemorija> listfm=new ArrayList<flashMemorija>();
		ArrayList<grafickaKartica> listgk=new ArrayList<grafickaKartica>();
		
		try {
			
		
		listram=(ArrayList<ramMemorija>) sesija.getAttribute("listram");
		listproc=(ArrayList<Procesor>) sesija.getAttribute("listproc");
		listhard=(ArrayList<hardDisk>) sesija.getAttribute("listhard");
		listtas=(ArrayList<Tastatura>) sesija.getAttribute("listtas");
		listmp=(ArrayList<maticnaPloca>) sesija.getAttribute("listmp");
		listmis=(ArrayList<Mis>) sesija.getAttribute("listmis");
		listfm=(ArrayList<flashMemorija>) sesija.getAttribute("listfm");
		listmon=(ArrayList<Monitor>) sesija.getAttribute("listmon");
		listgk=(ArrayList<grafickaKartica>) sesija.getAttribute("listgk");
		
		
		listram.removeAll(listram);
		listhard.removeAll(listhard);
		listproc.removeAll(listproc);
		listtas.removeAll(listtas);
		listmp.removeAll(listmp);
		listmis.removeAll(listmis);
		listfm.removeAll(listfm);
		listmon.removeAll(listmon);
		listgk.removeAll(listgk);
		
		sesija.setAttribute("listproc", listproc); 
		sesija.setAttribute("listram", listram); 
		sesija.setAttribute("listhard", listhard); 
		sesija.setAttribute("listtas", listtas);
		sesija.setAttribute("listmp", listmp);
		sesija.setAttribute("listmis", listmis);
		sesija.setAttribute("listfm", listfm);
		sesija.setAttribute("listmon", listmon);
		sesija.setAttribute("listgk", listgk);
		
		response.sendRedirect("korpa.jsp"); 
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("index.jsp"); 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
