package com.shupan.oms.fw.infra.util;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.*;

/**
 * es boolean 检索工具类
 * @author ChenQuanAn
 * @date 1.0 2020/12/3 11:07 下午
 */
public class EsBoolQueryUtil {

    /**
     * 字符串"and"短语查询
     * 1. field类型为keyword: value需要与field值完全一致才能匹配成功
     * 2. field类型为text: value需要是field值的一部分才能匹配成功
     * @param builder
     * @param field
     * @param value
     * @return
     */
    public static BoolQueryBuilder andPhraseQuery(BoolQueryBuilder builder, String field, String value) {
        if(StringUtils.isNotBlank(value)) {
            builder = builder.must(new MatchPhraseQueryBuilder(field, value.trim()));
        }
        return builder;
    }
}
