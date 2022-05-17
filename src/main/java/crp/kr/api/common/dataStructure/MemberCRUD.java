package crp.kr.api.common.dataStructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberCRUD {
    public static void main(String[] args) {
    }
    @Data
    @NoArgsConstructor
    static class Member{
        private String userid, name, password, profileImg, phone, email;

        public Member (Builder builder){
            this.userid = builder.userid;
            this.name = builder.name;
            this.password = builder.password;
            this.profileImg = builder.profileImg;
            this.phone = builder.phone;
            this.email = builder.email;
        }
        static class Builder{
            private String userid, name, password, profileImg, phone, email;
            public Builder (String userid) { this.userid = userid; }
            public Builder name(String name) { this.name = name; return this; }
            public Builder password(String password) { this.password = userid; return this; }
            public Builder profileImg(String profileImg) { this.profileImg = profileImg; return this; }
            public Builder phone(String phone) { this.phone = phone; return this; }
            public Builder email(String email) { this.email = email; return this; }
            Member build() { return new Member(this); }
        }

    @Override
    public String toString() {
        return String.format("[사용자 스펙] userid : %s, name : %s, password : %s, profileImg : %s, phone : %s, email : %s",
                userid, name, password, profileImg, phone, email);

    }
    }

    interface MemberService{
        void save(Member member);
        void update(Member member);
        void delete(Member member); // CUD는 consumer
        Member findById(String id);
        List<Member> findByName(String name);
        List<Member> findAll();
        int count();
        boolean existsById(String id);
    }
    static class MemberServiceImpl implements MemberService{
        private final Map<String, Member> map;

        MemberServiceImpl() {
            map = new HashMap<>();
        }

        @Override
        public void save(Member member) {
            map.put(member.getUserid(), member);
        }

        @Override
        public void update(Member member) {
            map.replace(member.getUserid(), member);
        }

        @Override
        public void delete(Member member) {
            map.remove(member.getUserid());
        }

        @Override
        public Member findById(String id) {
            return null;
        }

        @Override
        public List<Member> findByName(String name) {
            return null;
        }

        @Override
        public List<Member> findAll() {
            return null;
        }

        @Override
        public int count() {
            return 0;
        }

        @Override
        public boolean existsById(String id) {
            return false;
        }
    }
}
