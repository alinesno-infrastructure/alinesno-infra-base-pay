package com.alinesno.infra.base.pay.dto;

import lombok.Data;

@Data
public class PayChannelDto {

    private long projectId;
    private String channelType ;
    private String channelDesc ;
    private String channelCode ;

}
