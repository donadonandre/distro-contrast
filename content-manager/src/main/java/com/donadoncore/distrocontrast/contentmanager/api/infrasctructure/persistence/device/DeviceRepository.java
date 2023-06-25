package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.device;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query(value = "SELECT * FROM device WHERE user_id = ? ORDER BY id DESC", nativeQuery = true)
    List<Device> findAllDevicesByUserId(Long userId);

}
