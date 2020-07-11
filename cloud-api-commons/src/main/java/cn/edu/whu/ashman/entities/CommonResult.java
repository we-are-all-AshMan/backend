package cn.edu.whu.ashman.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共json数据返回类
 *
 * @author Zhuyuhan
 * @date 2020-07-11 14:30
 */
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //错误码：404
    private Integer code;
    //状态信息
    private String message;
    //json数据对象
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}