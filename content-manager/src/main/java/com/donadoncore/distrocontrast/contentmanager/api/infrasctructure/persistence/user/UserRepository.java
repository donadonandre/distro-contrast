package com.donadoncore.distrocontrast.contentmanager.api.infrasctructure.persistence.user;

import com.donadoncore.distrocontrast.contentmanager.api.domain.device.Device;
import com.donadoncore.distrocontrast.contentmanager.api.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'id' : ?0, 'devices.sharedId' : ?1 }")
    Device findUserDevice(String id, String deviceSharedId);

    @Query("{ 'id' : ?0 }")
    List<Device> findUserDevices(String id);

    @Query(value = "{ 'id' : ?0, 'devices.name' : ?1 }", exists = true)
    boolean existsDeviceByNameAndUserId(String userId, String name);

}
