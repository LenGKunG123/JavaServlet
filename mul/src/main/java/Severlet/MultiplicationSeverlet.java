package Severlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MultiplicationServlet", value = "/multiplication_table")
public class MultiplicationSeverlet extends HttpServlet {

    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberStr = request.getParameter("number");
        if (numberStr==null || numberStr.length()==0|| !isNumber(numberStr)){
            request.setAttribute("error","invalid number or parameter !!!");
        }
        request.getRequestDispatcher("/multiplication_table.jsp").forward(request, response);
    }


    private static boolean isNumber(String nStr){
        for (int i =0; i<nStr.length(); i++){
            if (!Character.isDigit(nStr.charAt(i))){
                return false;
            }
        }
        return true;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
