import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@WebServlet(name = "AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ads adsDao = DaoFactory.getAdsDao();

        List<Ad> currentAds = adsDao.all();
        request.setAttribute("allAds", currentAds);
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}
