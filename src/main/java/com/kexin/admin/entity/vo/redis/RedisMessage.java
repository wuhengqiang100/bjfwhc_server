package com.kexin.admin.entity.vo.redis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisMessage {

    private Integer machineId;//设备id

    private String logType;//报警级别 1,2,3 最高三级

    private String note;//报警信息描述 "设备"+"描述"


}
