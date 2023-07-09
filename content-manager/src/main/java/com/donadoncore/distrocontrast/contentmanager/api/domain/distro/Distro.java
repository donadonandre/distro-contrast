package com.donadoncore.distrocontrast.contentmanager.api.domain.distro;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Document(collection = "distros")
public class Distro {

    private String id;

    private String name;

    private String basedOn;

    private Boolean usable = false;
}
