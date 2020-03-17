package com.gemini.valid;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 验证示例VO
 */
@Data
public class ValidatorVo {

    @NotNull(message = "不能为空")
    @Size(max = 16, min = 6, message = "字符串长度需要在6-16之间")
    private String name;
    @Max(value = 100, message = "最大100")
    @Min(value = 18, message = "最小18")
    private String age;
}

