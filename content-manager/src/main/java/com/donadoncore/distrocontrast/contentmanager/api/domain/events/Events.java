package com.donadoncore.distrocontrast.contentmanager.api.domain.events;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Events {

    @Id
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private EventKind kind;

    @Column(name = "is_done")
    private Boolean isDone;

    private String payload;
}
