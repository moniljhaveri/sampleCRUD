package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import Dao.ServerConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Patient;

/**
 * Servlet implementation class CreatePatientController
 */
public class CreatePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method
		ServerConnection sC = new ServerConnection(); 
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName"); 
		String a = request.getParameter("age");
		System.out.println(a);
		Integer age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender"); 
		Patient newPatient = new Patient(firstName, lastName, age, gender); 
		
		try {
			sC.addPatient(newPatient);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("./WelcomePageController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
