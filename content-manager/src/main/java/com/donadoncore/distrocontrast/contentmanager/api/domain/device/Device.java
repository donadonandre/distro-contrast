package com.donadoncore.distrocontrast.contentmanager.api.domain.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.test.Test;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "device")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DeviceType type;

    private String brand;

    private String model;

    private String processor;

    @Column(name = "ram_memory")
    private String ramMemory;

    private String disk;

    @Column(name = "card_video")
    private String cardVideo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private List<Test> tests;

    public void setUser(User user) {
        this.user = user;
    }

}
