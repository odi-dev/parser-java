package com.odi.parser.model.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class AddressMeta {

    private Integer total_count;
    private Integer pageable_count;
    private Boolean is_end;

}
