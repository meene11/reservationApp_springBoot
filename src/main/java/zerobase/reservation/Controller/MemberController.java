package zerobase.reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zerobase.reservation.Domain.Auth;
import org.springframework.web.bind.annotation.RequestBody;
import zerobase.reservation.Domain.Auth;
import zerobase.reservation.Domain.Member;
import zerobase.reservation.Domain.Store;
import zerobase.reservation.Service.MemberService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 첫대문
    @GetMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        if(cookies != null){ // 쿠키가 한개라도 있으면 실행
            for(int i=0; i< cookies.length; i++){
                cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
                response.addCookie(cookies[i]); // 응답 헤더에 추가
            }
        }

        System.out.println("첫화면 ! ");


        return "index";
    }

    // 회원가입페이지
    @GetMapping("/member")
    public String memberSignUp() {
        System.out.println("member signUp ! ");
        return "memSignUp";
    }

    // 회원가입등록
    @PostMapping("/member")
    public String memberRegister(HttpServletRequest request) {
        System.out.println("member signUp 비번:" );

        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");
        String role = request.getParameter("role");

        System.out.println("체크: " + userid + pwd + role );

        Member mem = new Member();
        mem.setUserid(userid);
        mem.setPwd(pwd);
        mem.setRoleuser(role);

        memberService.register(mem);


        return "memSignIn";
    }

    // 로그인페이지
    @GetMapping("/memSignIn")
    public String memSingIn() {
        System.out.println("member signIn");
        return "memSignIn";
    }

    // 로그인 기능
    @PostMapping("/memSignIn")
    public String memSingInLog(HttpServletRequest request, Model model, HttpServletResponse response) {
        System.out.println(" controller 로그인 기능 쪽 " );
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");
        Member mem = new Member();
        mem.setUserid(userid);
        mem.setPwd(pwd);

        Member member = memberService.authIn(mem);

        System.out.println("member memSingInlog 로그인 성공  로그인한 유저id:" + member.getUserid());
        System.out.println("member memSingInlog 로그인 성공  로그인한 유저의 롤도 알수잇을까:" + member.getRoleuser());
        System.out.println("member seq  로그인 성공  로그인한 유저의 롤도 알수잇을까:" + member.getSeq());


        model.addAttribute("member", member);

        //쿠키에 시간 정보를 주지 않으면 세션 쿠키가 된다. (브라우저 종료시 모두 종료)
        Cookie idCookie = new Cookie("userid", String.valueOf(member.getUserid()));
        Cookie seqCookie = new Cookie("seq", String.valueOf(member.getSeq()));

        response.addCookie(idCookie);
        response.addCookie(seqCookie);

        String seq = seqCookie.getValue();
        model.addAttribute("seq", seq);

        return "manual";
    }

}
