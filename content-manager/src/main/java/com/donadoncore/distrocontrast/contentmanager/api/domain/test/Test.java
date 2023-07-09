package com.donadoncore.distrocontrast.contentmanager.api.domain.test;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tests")
public class Test  {

    @Id
    private String id;

    private String userId;

    private String deviceId;

    private LocalDate date;

    private Distro distro;

    private String version;

    private String desktopEnvironment;

    private String kernel;

    private String valueDescription;

    private BigDecimal value;
}
