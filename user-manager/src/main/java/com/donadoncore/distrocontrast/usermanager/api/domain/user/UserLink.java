package com.donadoncore.distrocontrast.usermanager.api.domain.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLink {

    private String key;

    private String link;

}
