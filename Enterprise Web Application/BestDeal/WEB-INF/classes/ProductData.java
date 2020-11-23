	
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@WebServlet("/ProductData")
public class ProductData extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{

PrintWriter pw= response.getWriter();
response.setContentType("text/html");			
 pw.println("<html>");
 pw.println("<body>");

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		pw.print("<tr>");
		pw.print("<td><div id='shop_item'>");
			Product data= (Product)request.getAttribute("data");
			pw.print("<h3>"+data.getproductName()+"</h3>");
			pw.print("<ul>");
			
			System.out.println(data.getProductType().toLowerCase());
			pw.print("<ul><li id='item'><img src='images/"+data.getProductType().toLowerCase().replaceAll("\\s+","")+"/"+data.getproductImage()+"' alt='' style='width:150px;height:150px;'/></li>");
			pw.print("<strong>"+ "$" + data.getproductPrice() + "</strong>");
			pw.print("<ul><li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+data.getId()+"'>"+
					"<input type='hidden' name='type' value='"+data.getProductType().toLowerCase().replaceAll("\\s+","")+"'>"+
					"<input type='hidden' name='maker' value='"+data.getproductManufacturer()+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li></ul>");
			pw.print("<ul><li><form method='post' action='WriteReview'>"+
					"<input type='hidden' name='name' value='"+data.getId()+"'>"+
					"<input type='hidden' name='type' value='"+data.getProductType()+"'>"+
					"<input type='hidden' name='maker' value='"+data.getproductManufacturer()+"'>"+
					"<input type='hidden' name='price' value='"+data.getproductPrice()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li></ul>");
			pw.print("<ul><li><form method='post' action='ViewReview'>"+
					"<input type='hidden' name='name' value='"+data.getId()+"'>"+
					"<input type='hidden' name='type' value='"+data.getProductType()+"'>"+
					"<input type='hidden' name='maker' value='"+data.getproductManufacturer()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li></ul>");
			pw.print("</ul></div></td></tr>");


			pw.print("</table></div></div></div>");		
			utility.printHtml("Footer.html");
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void destroy()	{
      // do nothing.
	}
	

}