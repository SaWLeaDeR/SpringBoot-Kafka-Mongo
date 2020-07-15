package com.example.devicedataconsumer.domain.repository;

import com.example.devicedataconsumer.domain.model.document.DeviceDataDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<DeviceDataDocument, String> {

}
