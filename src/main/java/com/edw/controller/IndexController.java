package com.edw.controller;

import com.edw.helper.GenerateCacheHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 11 Jan 2024 10:46
 */
@RestController
public class IndexController {

    @Autowired
    private GenerateCacheHelper generateCacheHelper;

    @GetMapping(path = "/add-all")
    public String addAll() {
        generateCacheHelper.addData();
        return "good";
    }


    @GetMapping(path = "/remove-all")
    public String removeAll() {
        generateCacheHelper.removeData();
        return "good";
    }

}
