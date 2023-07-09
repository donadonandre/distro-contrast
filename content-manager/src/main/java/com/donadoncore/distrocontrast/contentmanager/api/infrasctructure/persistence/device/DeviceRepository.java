package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {

//    @Query(value = "SELECT * FROM device WHERE user_id = ? ORDER BY id DESC", nativeQuery = true)
//    List<Device> findAllDevicesByUserId(Long userId);

}
