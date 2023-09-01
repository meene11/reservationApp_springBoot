package zerobase.reservation.Service;

import org.springframework.stereotype.Service;
import zerobase.reservation.Domain.Book;
import zerobase.reservation.Domain.Bookconfirm;
import zerobase.reservation.Domain.Store;
import zerobase.reservation.Repository.BookConfirmRepository;
import zerobase.reservation.Repository.BookRepository;
import zerobase.reservation.Repository.StoreRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookConfirmRepository bookConfirmRepository;
    private final StoreRepository storeRepository;

    public BookService(BookRepository bookRepository, BookConfirmRepository bookConfirmRepository, StoreRepository storeRepository) {
        this.bookRepository = bookRepository;
        this.bookConfirmRepository = bookConfirmRepository;
        this.storeRepository = storeRepository;
    }

    public int bookInsert(Book bk){
        int bkId = bookRepository.save(bk).getUniqId();
        return bkId;

    }

   public Book getBookvo(int bkId){
       System.out.println("서비스에서 bookget vo ");

        Book bkvo = bookRepository.findByUniqId(bkId);
        return bkvo;
   }

   public int saveBkConfirm(int deptId, int mngId){

//       uniqId = deptId
       Book book = bookRepository.findByUniqId(deptId);
       String userId = book.getUserid();
       String userPhone =book.getUserPhone();
       String storeName = book.getStoreName();
       LocalDateTime bookDate = book.getBookDate();

       Bookconfirm bkCf = new Bookconfirm();
       bkCf.setDeptId(deptId);
       bkCf.setStatus("confirm");
       bkCf.setMngId(mngId);

       bkCf.setUserid(userId);
       bkCf.setUserPhone(userPhone);
       bkCf.setStoreName(storeName);
       bkCf.setBookDate(bookDate);

       System.out.println(" 서비스. 방문확정! 매니저id 확인!!!~~~   " + mngId);

       int bkConfirmId = bookConfirmRepository.save(bkCf).getUniqSeq();


       return bkConfirmId;

   }

   public Bookconfirm reviewWriteInfo(int uniqSeq){
       return bookConfirmRepository.findById(uniqSeq);
   }

   public List<Book> reserveList(int mngId){
       List<Book> list = bookRepository.findByMngId(mngId);

       return  list;
   }

/*
    public List<Book> getbkConfirmList(int mngId) {
        List<Object[]> result = bookConfirmRepository.getbkCmList(mngId);
        for(Object[] arr : result){
            System.out.println(Arrays.toString(arr));
        }


        return  list;
    }
*/


    public List<Bookconfirm> bookconfirmList(int mngId){
        List<Bookconfirm> list = bookConfirmRepository.findBookconfirmsByMngId(mngId);
        return list;
    }


}
