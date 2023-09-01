package zerobase.reservation.Service;

import org.springframework.stereotype.Service;
import zerobase.reservation.Domain.Store;
import zerobase.reservation.Repository.StoreRepository;

import java.util.List;

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


}
