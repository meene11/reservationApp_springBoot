package zerobase.reservation.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zerobase.reservation.Domain.Auth;
import zerobase.reservation.Domain.Member;
import zerobase.reservation.Repository.MemberRepository;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public
class MemberService {
    private final MemberRepository memberRepository;

/*
    public MemberEntity register(Auth.SignUp member){
        boolean exists = this.memberRepository.existsByUsername(member.getUsername());
        if(exists){
            throw new AlreadyExistUserException();
        }

        member.setPassword(this.passwordEncoder.encode(member.getPassword()));
        var result = this.memberRepository.save(member.toEntity());

        return result;
    }

 */
    public Member register(Member member){

        Auth.SignUp request = new Auth.SignUp();
        request.setUserid(member.getUserid());
        request.setPwd(member.getPwd());
        request.setRoleuser(member.getRoleuser());
        String checkId = request.getUserid();

        if(memberRepository.findByUserid(checkId) != null){
            System.out.println(" 중복확인 ! ");
            throw new RuntimeException("이미 존재하는 ID 입니다");
        } else {
            var result = this.memberRepository.save(request.toEntity());
            return (Member) result;
        }
    }

    /*
     var user = this.memberRepository.findByUsername(member.getUsername())
                .orElseThrow(()-> new RuntimeException("존재하지 않는 ID 입니다"));

        if(!this.passwordEncoder.matches(member.getPassword(), user.getPassword())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }
        return user;

     */
    public Member authIn(Member member){
        System.out.println(" 로그인 서비스 진입");
        Auth.SignUp request = new Auth.SignUp();
        request.setUserid(member.getUserid());
        request.setPwd(member.getPwd());



        if(memberRepository.findByUserid(member.getUserid()) == null){
            throw new RuntimeException("존재하지 않는 ID 입니다");
        }

        System.out.println(" 체크 1 " + member.getPwd());
        System.out.println(" 체크 2 " + request.getPwd());


        if ((memberRepository.findByUserid(member.getUserid()).getPwd()).matches(request.getPwd())){
            System.out.println(" 비밀번호 체크 ");

        } else {
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }

        int seq = memberRepository.findByUserid(member.getUserid()).getSeq();
        request.setSeq(memberRepository.findByUserid(member.getUserid()).getSeq());

        System.out.println(" 로그인 서비스에서 seq 찾기!!! " + seq);






        request.setRoleuser(memberRepository.findByUserid(member.getUserid()).getRoleuser());

        return request.toEntity();

    }


}
