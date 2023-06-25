package com.donadoncore.distrocontrast.contentquery.application.tests;

import com.donadoncore.distrocontrast.contentquery.domain.tests.DeviceMessage;
import com.donadoncore.distrocontrast.contentquery.infrastructure.persistence.tests.TestsRepository;
import com.donadoncore.distrocontrast.contentquery.domain.tests.TestsDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestsServiceImpl implements TestsService {

    private TestsRepository testsRepository;

    @Override
    public void insertTest(DeviceMessage deviceMessage) {
        Optional<TestsDocument> testsFromUserWithDevice = testsRepository.findByUserAndDevice(deviceMessage.getRelatedId(), deviceMessage.getDevice().getId());

        if (testsFromUserWithDevice.isPresent()) {
            var testsDocument = testsFromUserWithDevice.get();
            // testsDocument.getTests().addAll(TestsMapper.toEntity(deviceMessage.getTests()));
            testsRepository.save(testsDocument);
        }
        else {
            testsRepository.insert(TestsMapper.toDocumentFrom(deviceMessage));
        }
    }
}
