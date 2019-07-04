package com.gemini.springboot.web.ext;

import com.gemini.springboot.web.common.page.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.ext
 * @classname: BaseMapper
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/6 23:02
 */
public interface BaseMapper {
    Integer queryForCount(@Param("search") Object search);

    List queryForList(@Param("search") Object search, @Param("page") Paging page);

    List queryForIds(@Param("search") Object search, @Param("page") Paging page);
}
