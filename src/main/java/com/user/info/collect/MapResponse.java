package com.user.info.collect;

import com.user.info.collect.entity.Boss;
import lombok.Data;

import java.util.List;

@Data
public class MapResponse {
    private List<Boss> content;
    private List<String> hot_city;
}
