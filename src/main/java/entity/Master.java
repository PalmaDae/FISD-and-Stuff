package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Master {
    long id;
    String name;
    String photoPath;
    String description;
    int cost;

}


