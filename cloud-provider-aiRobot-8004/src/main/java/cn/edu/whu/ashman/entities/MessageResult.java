package cn.edu.whu.ashman.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageResult<T> {
    //错误码：404
    private Integer code;
    //状态信息
    private String message;
    //json数据对象
    private T data;
    public MessageResult(Integer code,String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }
    public MessageResult(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
