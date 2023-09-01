package zerobase.reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zerobase.reservation.DTO.StoreListDto;
import zerobase.reservation.Domain.Store;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findByName(String name);

    Store findById(int id);

    @Query("select new zerobase.reservation.DTO.StoreListDto(s.id, s.name, s.place, nullif(round((r.star)), 0) as star) from store s left join review r on s.name = r.storeName group by s.name")
    List<StoreListDto> getJoinInfo();

    //별점순
    @Query("select new zerobase.reservation.DTO.StoreListDto(s.id, s.name, s.place, nullif(round((r.star)), 0) as star) from store s left join review r on s.name = r.storeName group by s.name order by star desc")
    List<StoreListDto> getJoinStarInfo();

    // 이름순
    @Query("select new zerobase.reservation.DTO.StoreListDto(s.id, s.name, s.place, nullif(round((r.star)), 0) as star) from store s left join review r on s.name = r.storeName group by s.name order by s.name")
    List<StoreListDto> getJoinNameInfo();

    // 위치명
    @Query("select new zerobase.reservation.DTO.StoreListDto(s.id, s.name, s.place, nullif(round((r.star)), 0) as star) from store s left join review r on s.name = r.storeName group by s.name order by s.place")
    List<StoreListDto> getJoinPlaceInfo();
}
