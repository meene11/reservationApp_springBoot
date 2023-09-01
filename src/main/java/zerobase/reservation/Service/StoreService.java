package zerobase.reservation.Service;

import org.springframework.stereotype.Service;
import zerobase.reservation.DTO.StoreListDto;
import zerobase.reservation.Domain.Store;
import zerobase.reservation.Repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void storeInsert(Store str){
        storeRepository.save(str);
    }

    public List<Store> storeList(){
        List<Store> list = storeRepository.findAll();
        return list;
    }


    public Store storeDetail(int id) {
        Store store = storeRepository.findById(id);

        System.out.println(" in sertvid :" + store);

        return store;
    }

    public Store storeDetailByName(String name) {
        Store store = storeRepository.findByName(name);

        System.out.println(" in sertvid :" + store);

        return store;
    }

    // 디폴트
    public List<StoreListDto> getJoinInfo() {
        List<StoreListDto> list = storeRepository.getJoinInfo();
        List<StoreListDto> list2 = new ArrayList<>();

        for(StoreListDto dto : list){
            Integer star = dto.getStar();
            System.out.println("서비스 별점: " + star);
            if(star == null){
                dto.setStar(-1);
            }
            list2.add(dto);
        }
        return list2;
    }

    // 별점
    public List<StoreListDto> getJoinStarInfo() {
        List<StoreListDto> list = storeRepository.getJoinStarInfo();
        List<StoreListDto> list2 = new ArrayList<>();

        for(StoreListDto dto : list){
            Integer star = dto.getStar();
            System.out.println("서비스 별점: " + star);
            if(star == null){
                dto.setStar(-1);
            }
            list2.add(dto);
        }
        return list2;
    }

    // 가게명
    public List<StoreListDto> getJoinNameInfo() {
        List<StoreListDto> list = storeRepository.getJoinNameInfo();
        List<StoreListDto> list2 = new ArrayList<>();

        for(StoreListDto dto : list){
            Integer star = dto.getStar();
            System.out.println("서비스 별점: " + star);
            if(star == null){
                dto.setStar(-1);
            }
            list2.add(dto);
        }
        return list2;
    }

    // 위치명
    public List<StoreListDto> getJoinPlaceInfo() {
        List<StoreListDto> list = storeRepository.getJoinPlaceInfo();
        List<StoreListDto> list2 = new ArrayList<>();

        for(StoreListDto dto : list){
            Integer star = dto.getStar();
            System.out.println("서비스 별점: " + star);
            if(star == null){
                dto.setStar(-1);
            }
            list2.add(dto);
        }
        return list2;
    }


}
