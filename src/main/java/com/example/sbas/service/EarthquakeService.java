package com.example.sbas.service;


import com.example.sbas.dto.EarthquakeDTO;
import com.example.sbas.entity.EarthquakeEntity;
import com.example.sbas.repository.EarthquakeRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EarthquakeService {

    private final EarthquakeRepository earthquakeRepository;
    public static final String COLLECTION_EQ_NAME="earthquake";

    public Long save(EarthquakeDTO earthquakeDTO){
        EarthquakeEntity earthquake = EarthquakeEntity.toEarthquakeEntity(earthquakeDTO);

        EarthquakeEntity entity = earthquakeRepository.save(earthquake);
        return entity.getId();
    }

    public String findList(){
        List<EarthquakeEntity> dbList = earthquakeRepository.findAll();

        return dbList.toString();
    }

    public void saveFD(Long id){
        EarthquakeEntity earthquakeEntity = null;
        Firestore db = FirestoreClient.getFirestore();
        Optional<EarthquakeEntity> list = earthquakeRepository.findById(id);
        if(list.isPresent()){
            earthquakeEntity = list.get();
            ApiFuture<WriteResult> collectionApiFuture =
                    db.collection(COLLECTION_EQ_NAME)
                            .document(earthquakeEntity.getId().toString())
                            .set(earthquakeEntity);
        }

    }
}
