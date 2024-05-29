package filters;


import dao.DbDao;
import dao.DbDaoImplementation;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticateFilter implements Filter {

    private DbDao dbDao;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        dbDao = new DbDaoImplementation();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validUser = dbDao.validateUser(username, password);
        if (validUser) {
            HttpSession session = ((HttpServletRequest) request).getSession();
            session.setAttribute("uname", username);

            chain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            httpServletResponse.sendRedirect("error.jsp");
        }
    }
}
