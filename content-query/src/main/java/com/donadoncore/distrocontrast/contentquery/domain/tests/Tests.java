package com.donadoncore.distrocontrast.contentquery.domain.tests;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder
@Document(collection = "tests")
public class Tests {

    private String id;

    private String userId;

    private String deviceId;

    private List<Test> testList;
}
