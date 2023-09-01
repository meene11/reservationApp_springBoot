package zerobase.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zerobase.reservation.Domain.Book;
import zerobase.reservation.Domain.Bookconfirm;

import java.util.List;

@Repository
public interface BookConfirmRepository extends JpaRepository<Bookconfirm, Integer> {
    Bookconfirm findByDeptId(int deptId);

    @Query("select r.uniqId, r.userid, r.userPhone, r.storeName, r.bookDate from reserve r inner join bookconfirm cn on r.uniqId = cn.deptId where cn.mngId = :mngId")
    List<Object[]> getbkCmList(@Param("mngId") int mngId);

    List<Bookconfirm> findBookconfirmsByMngId(int mngId);

    Bookconfirm findById(int uniqSeq);

}
