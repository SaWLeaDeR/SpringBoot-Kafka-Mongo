package com.example.deviceapi.domain.repository;

import com.example.deviceapi.domain.model.document.DeviceDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<DeviceDocument, String> {

}
