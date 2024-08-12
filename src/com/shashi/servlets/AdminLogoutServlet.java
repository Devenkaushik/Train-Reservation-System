package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.constant.UserRole;
import com.shashi.utility.TrainUtil;

@SuppressWarnings("serial")
@WebServlet("/adminlogout")
public class AdminLogoutServlet extends HttpServlet {

    /**
     * 
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        // Add CSS styles
        pw.println("<style>");
        pw.println("body, html { height: 100%; margin: 0; display: flex; justify-content: center; align-items: center; font-family: Arial, sans-serif; }");
        pw.println(".tab { display: flex; justify-content: center; align-items: center; height: 100%; }");
        pw.println(".menu { font-size: 24px; font-weight: bold; color: white; background-color: orange; padding: 20px; border-radius: 10px; text-align: center; }");
        pw.println("</style>");
        
        if (TrainUtil.isLoggedIn(req, UserRole.ADMIN)) {
            TrainUtil.logout(res);
            RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
            rd.include(req, res);
            pw.println("<div class='tab'><p class='menu'>You have been successfully logged out!</p></div>");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
            rd.include(req, res);
            pw.println("<div class='tab'><p class='menu'>You are already logged out!</p></div>");
        }
    }
}
