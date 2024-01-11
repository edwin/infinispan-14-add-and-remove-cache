package com.edw.helper;

import com.edw.bean.User;
import jakarta.annotation.PostConstruct;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * <pre>
 *     com.edw.helper.GenerateCacheHelper
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 11 Jan 2024 10:45
 */
@Service
public class GenerateCacheHelper {

    @Autowired
    private RemoteCacheManager cacheManager;

    List<String> listOfUuid = new ArrayList<>();

    @PostConstruct
    public void prepareData () {
        for (int i = 0; i < 5000; i ++) {
            listOfUuid.add(UUID.randomUUID().toString());
        }
    }

    public void addData() {
        final RemoteCache cache = cacheManager.getCache("user-cache");
        for (String uuid: listOfUuid) {
            cache.put(uuid, new User(UUID.randomUUID().toString(), new Random().nextInt(100), "Jakarta"));
        }
    }

    public void removeData() {
        final RemoteCache cache = cacheManager.getCache("user-cache");
        for (String uuid: listOfUuid) {
            cache.remove(uuid);
        }
    }
}
