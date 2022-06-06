package spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChangePasswordService {

    private MemberDao memberDao;

    public ChangePasswordService(@Autowired MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Transactional
    public void changePassword(String email, String oldPwd, String newPwd){
        Member member = memberDao.selectByEmail(email);
        if(member == null) throw new MemberNotFoundException();

        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }

}
