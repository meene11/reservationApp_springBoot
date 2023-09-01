package zerobase.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import zerobase.reservation.Domain.Review;
import zerobase.reservation.Domain.Store;
import zerobase.reservation.Service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰폼 페이지
    @GetMapping("/review")
    public String reviewWriteForm() {
        //${store.name}
        return "reviewWrite";
    }

    // 리뷰쓰기
    @PostMapping("/review")
    public String book(HttpServletRequest request, Model model) {
        System.out.println("리뷰쓰기 ! ");

        String userid = request.getParameter("userid");
        String storeName = request.getParameter("storeName");
        String star = request.getParameter("star");
        String title = request.getParameter("title");
        String article = request.getParameter("article");
        String storeId = request.getParameter("storeId");
        String visitConfirm = request.getParameter("visitConfirm");

        System.out.println(" 리뷰 contorller~~~~ ");


        Review rv = new Review();
        rv.setUserid(userid);
        rv.setStoreName(storeName);
        rv.setStar(Integer.parseInt(star));
        rv.setArticle(article);
        rv.setTitle(title);
        rv.setStoreId(Integer.parseInt(storeId));
        rv.setVisitConfirm(Integer.parseInt(visitConfirm));

        reviewService.reviewSave(rv);

        List<Review> rvList = reviewService.rvList();
        model.addAttribute("rvList", rvList);

        return "reviewList";
    }

    // 리뷰 리스트
    @GetMapping("/reviewList")
    public String rvList(Model model){

        List<Review> rvList = reviewService.rvList();
        model.addAttribute("rvList", rvList);

        return "reviewList";
    }

    // 리뷰 디테일 by Id
    @GetMapping("/reviewDetail/id={id}")
    public String reviewDetail(@PathVariable("id") int id, Model model) {
        Review rv = reviewService.rvDetail(id);
        model.addAttribute("rv", rv);
        return "reviewDetail";
    }




}
