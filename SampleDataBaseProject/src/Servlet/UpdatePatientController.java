package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ServerConnection;
import Bean.Patient;

/**
 * Servlet implementation class UpdatePatientController
 */
public class UpdatePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		response.sendRedirect("./jsp/UpdatePatient.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServerConnection sC = new ServerConnection(); 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName"); 
		String a = request.getParameter("age");
		Integer age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender"); 
		Patient newPatient = new Patient(firstName, lastName, age, gender); 
		Integer id = Integer.parseInt(request.getParameter("dropdown")); 
		System.out.println(id);
		newPatient.setId(id);
		try {
			sC.updatePatient(newPatient);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("./WelcomePageController");
	}

}
