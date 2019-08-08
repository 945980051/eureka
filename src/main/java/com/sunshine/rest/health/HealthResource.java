package com.sunshine.rest.health;

import com.netflix.discovery.DiscoveryManager;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 张健
 * @CreateDate: 19-1-31-下午3:34
 * @Version: 1.0
 */
@RestController
@RequestMapping("/health")
public class HealthResource {

    public static final String KEY = "018ee962eab6431393540d5eb3370a12";

    @GetMapping("/check")
    public String healthCheck() {
        return "service is running sunshine";
    }

    @DeleteMapping("/offline/{key}")
    public String offLine(@PathVariable String key) {
        if (ObjectUtils.equals(KEY, key)) {
            DiscoveryManager.getInstance().shutdownComponent();
            return "下线成功";
        } else {
            return "下线失败,秘钥错误";
        }
    }

}
