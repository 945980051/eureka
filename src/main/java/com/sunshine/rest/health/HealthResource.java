package com.sunshine.rest.health;

import com.netflix.discovery.DiscoveryManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zwy
 * @CreateDate: 19-1-31-下午3:34
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/health")
public class HealthResource {

    public static final String KEY = "1571619600000";

    @GetMapping("/check")
    public String healthCheck() {
        return "service is running sunshine";
    }

    @DeleteMapping("/offline/{key}")
    public String offLine(@PathVariable String key) {
        if (ObjectUtils.equals(KEY, key)) {
            log.error(" 触发系统自动下线");
            System.exit(1);
            return "下线成功";
        } else {
            return "下线失败,秘钥错误";
        }
    }

}
