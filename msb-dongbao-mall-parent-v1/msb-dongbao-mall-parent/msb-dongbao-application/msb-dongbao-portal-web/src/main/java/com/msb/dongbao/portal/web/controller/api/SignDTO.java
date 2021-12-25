package com.msb.dongbao.portal.web.controller.api;

import lombok.Data;

@Data
public class SignDTO {

    private String appId;

    private String name;

    private String sign;

    private long timestamp;

    public SignDTO() {
    }

    public SignDTO(String appId, String name, String sign, long timestamp) {
        this.appId = appId;
        this.name = name;
        this.sign = sign;
        this.timestamp = timestamp;
    }

}
