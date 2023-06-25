package com.donadoncore.distrocontrast.contentmanager.api.domain.distro;

import com.donadoncore.distrocontrast.contentmanager.api.domain.test.Test;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "distro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Distro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "based_on")
    private String basedOn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "test_rel",
            joinColumns = @JoinColumn(name = "test_id"))
    private List<Test> testList;

}
