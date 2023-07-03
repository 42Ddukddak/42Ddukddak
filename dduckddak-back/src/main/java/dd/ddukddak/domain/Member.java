package dd.ddukddak.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "user_id")
  private Long id;

  private String name;
}
