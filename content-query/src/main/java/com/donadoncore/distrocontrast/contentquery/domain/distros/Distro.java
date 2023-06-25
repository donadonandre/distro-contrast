package com.donadoncore.distrocontrast.contentquery.domain.distros;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "distros")
public class Distro {

    @Id
    private String id;

    private String name;

    private String basedOn;

}
