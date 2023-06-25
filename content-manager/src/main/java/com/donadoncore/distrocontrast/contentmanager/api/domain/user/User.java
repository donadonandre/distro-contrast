package com.donadoncore.distrocontrast.contentmanager.api.domain.user;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    @OneToMany
    private List<Device> devices;
}
