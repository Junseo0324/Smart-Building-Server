package com.example.sbas.service;


import com.example.sbas.dto.FireDTO;
import com.example.sbas.entity.FireEntity;
import com.example.sbas.repository.FireRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


@Service
@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할

public class FireService {

    public static final String COLLECTION_FIRE_NAME="fire";
    private final FireRepository fireRepository; // 먼저 jpa, mysql dependecy 추가

    public Long save(FireDTO fireDTO){
        FireEntity fireEntity = FireEntity.tofireEntity(fireDTO);

        FireEntity entity = fireRepository.save(fireEntity);
        return entity.getId();
    }


    public String findList(){
        List<FireEntity> dbList = fireRepository.findAll();

        return dbList.toString();

    }

//    public List<FireEntity> getUsers() throws ExecutionException,InterruptedException{
//        return fireDao.getUsers();
//    }


    public void saveFD(Long id) {
        FireEntity fireEntity = null;
        Firestore db = FirestoreClient.getFirestore();
        Optional<FireEntity> list= fireRepository.findById(id);
        if(list.isPresent()){
             fireEntity = list.get();
            ApiFuture<WriteResult> collectionApiFuture =
                    db.collection(COLLECTION_FIRE_NAME)
                            .document(fireEntity.getId().toString())
                            .set(fireEntity);
        }


    }
}
