package zerobase.reservation.Service;

import org.springframework.stereotype.Service;
import zerobase.reservation.Domain.Review;
import zerobase.reservation.Repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void reviewSave(Review rv){

        reviewRepository.save(rv);

    }

    public List<Review> rvList(){
        List<Review> list = reviewRepository.findAll();

        System.out.println(" 리뷰 서비스 :" + list);

        return list;
    }

    public Review rvDetail(int reviewId){
        return reviewRepository.findByReviewId(reviewId);
    }

}
