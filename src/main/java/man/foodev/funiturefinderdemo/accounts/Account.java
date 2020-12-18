package man.foodev.funiturefinderdemo.accounts;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of ="id")
public class Account {
    @Id @GeneratedValue
    private Integer id;

    private String password;

    private String nickname;

    private int point;

    private int postWriteNumber;



}
