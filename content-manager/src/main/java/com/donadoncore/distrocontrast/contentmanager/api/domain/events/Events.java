package com.donadoncore.distrocontrast.contentmanager.api.domain.events;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "distro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Events {

    @Id
    private UUID uuid;

    private String kind;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "is_published")
    private Boolean isPublished;

    private String log;
}
