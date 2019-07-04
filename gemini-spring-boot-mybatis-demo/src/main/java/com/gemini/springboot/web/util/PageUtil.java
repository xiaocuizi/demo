package com.gemini.springboot.web.util;


import com.gemini.springboot.web.common.dto.PageDto;
import com.gemini.springboot.web.common.page.Paging;

/**
 *
 */
public class PageUtil {

    public static Paging initPage(Integer pagNum, Integer countEachPage) {
        Paging page = null;
        if (pagNum != null && countEachPage != null) {
            page = new Paging(countEachPage, (pagNum - 1) * countEachPage);
        }
        return page;
    }

    /**
     * 初始化转换分页Dto to Po
     * @param pageDto
     * @return
     */
    public static  Paging initPage(PageDto pageDto) {
        if(pageDto != null){
            return initPage(pageDto.getPageNum(),pageDto.getCountEachPage());
        }
        return null;
    }

    /**
     * 校验传入分页参数是否正确,不正确默认查询第一页，每页十条信息
     * @author yuanshou
     * @date 2018-1-5 15:43
     * @param
     * @return
     */
    public static Boolean checkPageInfo(PageDto pageDto){
        if(pageDto == null || pageDto.getPageNum() == null || pageDto.getCountEachPage() == null){
            pageDto = new PageDto();
            Integer PAGE_NUM_DEFULT = Integer.valueOf(0);
            Integer EACHPAGE_COUNT_DEFULT = Integer.valueOf(10);
            pageDto.setPageNum(PAGE_NUM_DEFULT);
            pageDto.setCountEachPage(EACHPAGE_COUNT_DEFULT);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 返回分页信息
     * @author yuanshou
     * @date 2018-1-5 16:26
     * @param
     * @return
     */
    public static PageDto initReturnPage(Integer count){
        PageDto pageReturnDto = new PageDto();
        pageReturnDto.setCount(count);
        return pageReturnDto;
    }
}
