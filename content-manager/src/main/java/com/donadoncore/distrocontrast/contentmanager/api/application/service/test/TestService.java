package com.donadoncore.distrocontrast.contentmanager.api.application.service.test;

import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestFormRequest;
import com.donadoncore.distrocontrast.contentmanager.api.domain.test.TestResponse;

import java.util.List;

public interface TestService {

    TestResponse insert(Long deviceId, TestFormRequest formRequest);

    TestResponse getById(String id);

    List<TestResponse> getByDeviceId(Long deviceId);

    List<TestResponse> getByDistro(String distroName);

}
