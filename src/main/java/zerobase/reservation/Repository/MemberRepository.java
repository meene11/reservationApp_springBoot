package zerobase.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.reservation.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{

    Member findByUserid(String userid);

    Member findByPwd(String pwd);


    boolean existsByUserid(String userid);
}
