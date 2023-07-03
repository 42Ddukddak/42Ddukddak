package dd.ddukddak.controller;

import dd.ddukddak.DTO.MemberDTO;
import dd.ddukddak.domain.Member;
import dd.ddukddak.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
  private final MemberRepository memberRepository;

  @GetMapping("/members/new")
  public String createNew(){
    return "/members/new";
  }
  @PostMapping("/members/new")
  public String create(@RequestParam("name") String name){
    Member member = new Member();
    member.setName(name);
    memberRepository.save(member);
    return "redirect:/members";
  }

  @GetMapping("/members")
  public String list(Model model) {
    // 입력, 조회 -> db 확인을 위해 필요한 부분.
    //근데 조회를 하려면 담은 domain이 필요하네? 만들어..
    // 근데.. 담은 domain을 전체적으로 조회하려면 repository를 조회하는 함수가 또 필요하네? 만들어..
    List<Member> members = memberRepository.findAll();
    model.addAttribute("members", members);
    return "/members/memberList";
  }
}
