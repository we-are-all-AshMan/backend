package cn.edu.whu.ashman.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回前端json数据和异常的泛型类
 *
 * @author Zhuyuhan
 * @date 2020-07-09 19:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //错误码：404
    private Integer code;
    //状态信息
    private String message;
    //json数据对象
    private T data;
    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
