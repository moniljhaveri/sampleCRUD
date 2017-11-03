package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import Dao.ServerConnection;
import Bean.Patient;

/**
 * Servlet implementation class ViewPatientController
 */
public class ViewPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ArrayList = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		ServerConnection sC = new ServerConnection();  
		ArrayList<Patient> vP = new ArrayList<Patient>();
		try {
			vP = sC.viewPatient();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		session.setAttribute("vP", vP);
		response.sendRedirect("./jsp/viewPatients.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
