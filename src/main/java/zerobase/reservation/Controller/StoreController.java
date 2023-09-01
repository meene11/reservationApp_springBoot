package zerobase.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zerobase.reservation.Domain.Store;
import zerobase.reservation.Service.StoreService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // 상점등록페이지
    @GetMapping("/store")
    public String storeApply() {
        return "storeApply";
    }

    // 상점 추가
    @PostMapping("/store")
    public String storeInsert(HttpServletRequest request, Model model) {
        System.out.println("/storeInsert 진입");
        String stName = request.getParameter("name");
        String stPlace = request.getParameter("place");
        String stDetail = request.getParameter("detail");
        String userSeq = request.getParameter("userSeq");

        System.out.println("체크: " + stName + stPlace + stDetail);
        System.out.println("체크2 컨트롤러 : " + userSeq);

        Store str = new Store();
        str.setName(stName);
        str.setPlace(stPlace);
        str.setDetail(stDetail);
        str.setStoreSeq(Integer.parseInt(userSeq));

        storeService.storeInsert(str);

        List<Store> list = storeService.storeList();
        model.addAttribute("list", list);

        return "storeList";
    }

    // 상점 목록
    @GetMapping("/storeList")
    public String storeList(Model model) {
        List<Store> list = storeService.storeList();
        model.addAttribute("list", list);
        return "storeList";
    }

    // // 상점 목록 by 예약자
    @GetMapping("/storeList/{roleuser}")
    public String storeList(Model model, @PathVariable("roleuser") String roleuser) {
        List<Store> list = storeService.storeList();
        model.addAttribute("list", list);
        model.addAttribute("roleuser", roleuser);

        return "storeList";
    }


    // 상점 디테일 by Id
    @GetMapping("/storeDetail/id={id}&roleuser={roleuser}")
    public String storeDetail(@PathVariable("id") int id, @PathVariable("roleuser") String roleuser, Model model) {
        model.addAttribute("roleuser", roleuser);
        Store store = storeService.storeDetail(id);


        model.addAttribute("store", store);
        return "storeDetail";
    }

    // 상점 디테일 by Name
    @PostMapping("/storeDetail")
    public String storeDetailByName(HttpServletRequest request, Model model) {
        String name = request.getParameter("schStrName");
        System.out.println(" search 검색 : "+ name);
        Store store =  storeService.storeDetailByName(name);

        String roleuser = request.getParameter("roleuser");
        System.out.println(" 가게명 서치: roleuser" + roleuser);
        model.addAttribute("roleuser", roleuser);

        if(store == null ){
            return "test";
        }

        model.addAttribute("store", store);


        return "storeDetail";
    }


}