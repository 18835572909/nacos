package at.yeion.nacos.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: rhb
 * @Date: 2020/8/17 17:00
 * @Description:
 */
@Data
@ApiModel("请求响应")
public class ResultResponse {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("数据")
    private Object data;
    @ApiModelProperty("提示语")
    private String msg;

    public ResultResponse(Object data, String msg) {
        this.code = ErrorEnum.E_200.getCode();
        this.data = data;
        this.msg = msg;
    }

    public ResultResponse(String msg) {
        this.code =  ErrorEnum.E_200.getCode();
        this.data = null;
        this.msg = msg;
    }

    public static ResultResponse newInstance(String msg){
        return  new ResultResponse(msg);
    }

    public static ResultResponse newInstance(Object data){
        return  new ResultResponse(data,"操作成功");
    }
}
