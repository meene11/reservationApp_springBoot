package zerobase.reservation.Controller;

import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import zerobase.reservation.Domain.Book;
import zerobase.reservation.Domain.Bookconfirm;
import zerobase.reservation.Domain.Store;
import zerobase.reservation.Service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 예약폼 페이지
    @GetMapping("/book/storeName={storeName}&storeId={storeId}&storeSeq={storeSeq}")
    public String bookForm(@PathVariable("storeName") String storeName, @PathVariable("storeId") String id, @PathVariable("storeSeq") String storeSeq, Model model) {
        //${store.name}
        System.out.println(" 예약폼 가게명:"+ storeName + " 가게id"+ id);
        System.out.println(" 예약폼 storeSeq :"+ storeSeq );
        model.addAttribute("id", id);
        model.addAttribute("storeName", storeName);
        model.addAttribute("storeSeq", storeSeq);

        System.out.println("예약폼 페이지 ! ");

        return "bookForm";
    }

    // 예약하기
    @PostMapping("/book")
    public String book(HttpServletRequest request, Model model) {
        System.out.println("예약하기 ! ");

        String userid = request.getParameter("userid");
        String phone = request.getParameter("phone");
        String bookDate = request.getParameter("bookDate");
        String storeName = request.getParameter("storeName");
        String storeId = request.getParameter("storeId");
        String mngId = request.getParameter("mngId");

        String str = bookDate+":00.248";
//      String str = "2021-11-05 13:47:13.248";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        System.out.println(dateTime);


        Book bk = new Book();
        bk.setUserid(userid);
        bk.setUserPhone(phone);
        bk.setStoreName(storeName);
        bk.setBookDate(dateTime);
        bk.setStoreId(Integer.parseInt(storeId));
        bk.setMngId(Integer.parseInt(mngId));


        // 서비스
        int bkId = bookService.bookInsert(bk);
        Book book = bookService.getBookvo(bkId);
        System.out.println(" book " + book);
        model.addAttribute("book", book);


        System.out.println("getHour() = " + dateTime.getHour());
        System.out.println("getMinute() = " + dateTime.getMinute());

        String strTime = "";
        String strMin = "";
        if(dateTime.getHour()<10){
            System.out.println("시 10 이전?");
            strTime = "0"+dateTime.getHour();
        } else {
            System.out.println("시 10 이후?");
            strTime = String.valueOf(dateTime.getHour());
        }

        if(dateTime.getMinute()<10){
            System.out.println(" 분 10 이전?");
            strMin = "0"+dateTime.getMinute();
        } else {
            System.out.println(" 분 10 이후?");
            strMin = String.valueOf(dateTime.getMinute());
        }

        String strBkTime =  strTime+":"+strMin;
        LocalTime localBkTime = LocalTime.parse(strBkTime);
        System.out.println("예약시간 convert Locatime : " + localBkTime);


        // 15:17:08.497
        LocalTime todayLocalTime = LocalTime.now();
        System.out.println("현재 시간: " + todayLocalTime);

        LocalTime thirtyMinutesAfterLocalTime = todayLocalTime.plusMinutes(10);
        System.out.println("30분 뒤: " + thirtyMinutesAfterLocalTime);

        LocalTime tenMinutesAfterLocalTime = localBkTime.plusMinutes(10);
        System.out.println(" bookTime 10분 뒤: " + tenMinutesAfterLocalTime);
        model.addAttribute("aftTemMin", tenMinutesAfterLocalTime);

        return "bookConfirmForm";
    }

    // 방문 확정 by uniqId
    @GetMapping("/bookVisit/uniqId={uniqId}&mngId={mngId}&aftTemMin={aftTemMin}")
    public String bookVisit(@PathVariable("uniqId") int uniqId, @PathVariable("mngId") int mngId, @PathVariable("aftTemMin") String aftTemMin, Model model) {

        System.out.println("uniqId " +uniqId + " aftTemMin:"+aftTemMin );

        LocalTime bookTime = LocalTime.parse(aftTemMin);

        // 현재시각
        LocalTime todayLocalTime = LocalTime.now();
        System.out.println("현재 시간: " + todayLocalTime);

        boolean isBeforeResult1 = bookTime.isBefore(todayLocalTime);
        boolean EqualsResult1 = bookTime.equals(todayLocalTime);
        boolean isAfterResult1 = bookTime.isAfter(todayLocalTime);

        System.out.println("isBeforeResult1 " +isBeforeResult1 );
        System.out.println("EqualsResult1 " + EqualsResult1);
        System.out.println("isAfterResult1" +  isAfterResult1);

        // 1)예약시간~ 10분 그사이에 2)현재시각:클릭 시점 비교
        String resultUrl = "";
        if(EqualsResult1 == true || isAfterResult1 == true){
            // 성공 방문가능
            System.out.println("방문성궁!!!! 리뷰 ㄱㄱ !");
            int bkConfirmId = bookService.saveBkConfirm(uniqId, mngId);
            model.addAttribute("bkConfirmId", bkConfirmId);

            Bookconfirm bkcf = bookService.reviewWriteInfo(bkConfirmId);
            String storeName = bkcf.getStoreName();
            int bkId = bkcf.getDeptId();

            model.addAttribute("storeName", storeName);
            model.addAttribute("bkId", bkId);

            resultUrl = "reviewWrite";
        } else if(isBeforeResult1 == true || isAfterResult1 == false){
            // 실패 방문 불가능
            System.out.println("방문실패!");
            resultUrl = "failVisit";
        }






        return resultUrl;

    }

    // 예약정보 리스트 페이지
    @GetMapping("/frMngBkList/{userSeq}")
    public String frMngBkList(@PathVariable("userSeq") int userSeq, Model model){

        // 매니저아이디로 예약reserve table 에서 목록
        List<Book> bkList = bookService.reserveList(userSeq);
        model.addAttribute("bkList", bkList);

        return "bookList";
    }

    // 매장도착정보목록
    @GetMapping("/frMngBkConfirmList/{userSeq}")
    public String frMngBkConfirmList(@PathVariable("userSeq") int userSeq, Model model){

        List<Bookconfirm> bkList = bookService.bookconfirmList(userSeq);

        model.addAttribute("bkList", bkList);


        return "bookConfirmList";
    }





}
