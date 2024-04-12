//package com.example.sbas.dao;
//
//import com.example.sbas.entity.FireEntity;
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.QueryDocumentSnapshot;
//import com.google.cloud.firestore.QuerySnapshot;
//import com.google.cloud.firestore.WriteResult;
//import com.google.firebase.cloud.FirestoreClient;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//import static com.example.sbas.service.FireService.COLLECTION_FIRE_NAME;
//
//@Repository
//@Slf4j
//public class FireDao {
//
//
//    public List<FireEntity> getUsers() throws ExecutionException,InterruptedException{
//        List<FireEntity> entityList = new ArrayList<>();
//        Firestore db = FirestoreClient.getFirestore();
////        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_FIRE_NAME).get();
//        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//        for(QueryDocumentSnapshot document : documents){
//            entityList.add(document.toObject(FireEntity.class));
//        }
//        return entityList;
//    }
//}
