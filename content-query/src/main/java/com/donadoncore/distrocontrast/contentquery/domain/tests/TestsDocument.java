package com.donadoncore.distrocontrast.contentquery.domain.tests;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder
@Document(collection = "tests")
public class TestsDocument {

    @Id
    private String id;

    private TestUser user;

    private TestDevice device;

    private List<Test> tests;

}
