package zerobase.reservation.Domain;

import lombok.Data;
import zerobase.reservation.Domain.Member;

public class Auth {

    @Data
    public static  class SignIn{
        private String userid;
        private String pwd;
        private int seq;
    }

    @Data
    public static  class SignUp{
        private String userid;
        private String pwd;
        private int seq;
        private String roleuser;

        public Member toEntity(){
            return Member.builder()
                    .userid(this.userid)
                    .pwd(this.pwd)
                    .seq(this.seq)
                    .roleuser(this.roleuser)
                    .build();
        }
    }

}
