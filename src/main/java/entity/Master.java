package entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Master {
    long id;
    String name;
    String photoPath;
    String description;
    int cost;
}


