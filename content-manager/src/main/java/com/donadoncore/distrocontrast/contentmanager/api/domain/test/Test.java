package com.donadoncore.distrocontrast.contentmanager.api.domain.test;

import com.donadoncore.distrocontrast.contentmanager.api.domain.distro.Distro;
import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "test")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test  {

    @Id
    private UUID id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "distro_id")
    private Distro distro;

    private String version;

    @Column(name = "desktop_environment")
    private String desktopEnvironment;

    private String kernel;

    private String kind;

    private String value;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
