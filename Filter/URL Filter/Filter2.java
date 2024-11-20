package com;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Filter2
 */
@WebFilter("/Filter2")
public class Filter2 implements Filter {

    /**
     * Default constructor. 
     */
    public Filter2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	private FilterConfig filterConfig;

	  public void doFilter (ServletRequest request,
	              ServletResponse response,
	              FilterChain chain)
	  {

	    try
	    {
	      System.out.print ("Within Second Filter ... ");
	      System.out.println ("Filtering the Request ...");

	      chain.doFilter (request, response);

	      System.out.print ("Within Second Filter ... ");
	      System.out.println ("Filtering the Response ...");

	    } catch (IOException io) {
	      System.out.println ("IOException raised in Filter2 Filter");
	    } catch (ServletException se) {
	      System.out.println ("ServletException raised in Filter2 Filter");
	    }
	  }

	  public FilterConfig getFilterConfig()
	  {
	    return this.filterConfig;
	  }

	  public void setFilterConfig (FilterConfig filterConfig)
	  {
	    this.filterConfig = filterConfig;
	  }
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
