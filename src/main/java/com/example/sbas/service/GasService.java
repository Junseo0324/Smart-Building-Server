package com.example.sbas.service;


import com.example.sbas.dto.GasDTO;
import com.example.sbas.entity.GasEntity;
import com.example.sbas.repository.GasRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GasService {

    public static final String COLLECTION_GAS_NAME = "gas";
    private final GasRepository gasRepository;

    public Long save(GasDTO gasDTO){
        GasEntity gasEntity = GasEntity.togasEntity(gasDTO);
        GasEntity entity = gasRepository.save(gasEntity);
        return entity.getId();

    }

    public String findList() {

        List<GasEntity> dbList = gasRepository.findAll();

        return dbList.toString();
    }
    public void saveFD(Long id){
        GasEntity gasEntity = null;
        Firestore db = FirestoreClient.getFirestore();
        Optional<GasEntity> list = gasRepository.findById(id);
        if(list.isPresent()){
            gasEntity = list.get();
            ApiFuture<WriteResult> collectionApiFuture =
                    db.collection(COLLECTION_GAS_NAME)
                            .document(gasEntity.getId().toString())
                            .set(gasEntity);
        }
    }
}
