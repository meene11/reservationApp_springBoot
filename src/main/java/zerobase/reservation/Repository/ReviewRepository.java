package zerobase.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.reservation.Domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Review findByReviewId(int reviewId);
}
