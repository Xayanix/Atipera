package pl.xayanix.atipera.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Repository {

    String name;
    GitHubUser owner;
    List<Branch> branches;
    boolean fork;

}
