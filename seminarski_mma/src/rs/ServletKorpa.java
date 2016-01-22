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
 * Servlet implementation class ServletKorpa
 */
@WebServlet("/ServletKorpa")
public class ServletKorpa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletKorpa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesija=request.getSession();
		ProizvodiDAO pdao=new ProizvodiDAO();
		
		hardDisk hd=new hardDisk();
		ramMemorija ram1=new ramMemorija();
		Procesor pr=new Procesor();
		Tastatura ts=new Tastatura ();
		Mis mis=new Mis ();
		maticnaPloca mp=new maticnaPloca ();
		flashMemorija fm=new flashMemorija ();
		Monitor mon=new Monitor ();
		grafickaKartica gk=new grafickaKartica ();
		
		ArrayList<ramMemorija> listram1=new ArrayList<ramMemorija>();
		ArrayList<Procesor> listproc=new ArrayList<Procesor>();
		ArrayList<hardDisk> listhard=new ArrayList<hardDisk>();
		ArrayList<Tastatura> listtas=new ArrayList<Tastatura>();
		ArrayList<Mis> listmis=new ArrayList<Mis>();
		ArrayList<maticnaPloca> listmp=new ArrayList<maticnaPloca>();
		ArrayList<flashMemorija> listfm=new ArrayList<flashMemorija>();
		ArrayList<Monitor> listmon=new ArrayList<Monitor>();
		ArrayList<grafickaKartica> listgk=new ArrayList<grafickaKartica>();
		
		
		String psifra=request.getParameter("psifra");
		String rsifra=request.getParameter("rsifra");
		String hsifra=request.getParameter("hsifra");
		String tsifra=request.getParameter("tsifra");
		String msifra=request.getParameter("msifra");
		String mpsifra=request.getParameter("mpsifra");
		String fsifra=request.getParameter("fsifra");
		String monsifra=request.getParameter("monsifra");
		String gsifra=request.getParameter("gsifra");
		
		
		try{
				if(rsifra!=null && rsifra.length()>0){
				listram1=(ArrayList<ramMemorija>) sesija.getAttribute("listram");
				
				ram1=pdao.getRamMemorijaID(rsifra);

				
				listram1.add(ram1);
				sesija.setAttribute("listram", listram1); 
				
				} else if(psifra!= null && psifra.length()>0){
					
					listproc=(ArrayList<Procesor>) sesija.getAttribute("listproc");
					
					pr=pdao.getProcesorID(psifra);
					
					
					
					listproc.add(pr);
					 
					 
					sesija.setAttribute("listproc", listproc); 
				} else if (hsifra!=null && hsifra.length()>0) {
					
					listhard=(ArrayList<hardDisk>) sesija.getAttribute("listhard");
					
					hd=pdao.getHardDiskID(hsifra);
					listhard.add(hd);
					sesija.setAttribute("listhard", listhard);
					
				} else if (tsifra!=null && tsifra.length()>0) {
					
					listtas=(ArrayList<Tastatura>) sesija.getAttribute("listtas");
					
					ts=pdao.getTastaturaID(tsifra);
					listtas.add(ts);
					sesija.setAttribute("listtas", listtas);
					} 
				
				else if (msifra!=null && msifra.length()>0) {
						listmis=(ArrayList<Mis>) sesija.getAttribute("listmis");
						
						mis=pdao.getMisID(msifra);
						listmis.add(mis);
						sesija.setAttribute("listmis", listmis);
						
						
						
					} else if (mpsifra!=null && mpsifra.length()>0) {
						listmp=(ArrayList<maticnaPloca>) sesija.getAttribute("listmp");
						
						mp=pdao.getMaticnaPlocaID(mpsifra);
						listmp.add(mp);
						sesija.setAttribute("listmp", listmp);
					} 
					else if (monsifra!=null && monsifra.length()>0) {
						listmon=(ArrayList<Monitor>) sesija.getAttribute("listmon");
						
						mon=pdao.getMonitorID(monsifra);
						listmon.add(mon);
						sesija.setAttribute("listmon", listmon);
					}
					else if (fsifra!=null && fsifra.length()>0) {
						listfm=(ArrayList<flashMemorija>) sesija.getAttribute("listfm");
						
						fm=pdao.getFLASHMemorijaID(fsifra);
						listfm.add(fm);
						sesija.setAttribute("listfm", listfm);
					}
					else if (gsifra!=null && gsifra.length()>0) {
						listgk=(ArrayList<grafickaKartica>) sesija.getAttribute("listgk");
						
						gk=pdao.getGrafickaKarticaID(gsifra);
						listgk.add(gk);
						sesija.setAttribute("listgk", listgk);
					}
				

				response.sendRedirect("korpa.jsp"); 
			
		}
		
		catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("index.jsp"); 
		}
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp"); 
	}

}
