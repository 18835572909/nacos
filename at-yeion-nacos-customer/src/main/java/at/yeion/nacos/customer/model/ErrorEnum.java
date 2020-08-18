package at.yeion.nacos.customer.model;

/**
 * @Author:     rhb
 * @Date:    2020/8/17 16:47
 * @Description:
 */
public enum ErrorEnum{
    /*
    * 错误信息
    * */
    E_200(200, "操作成功"),
    E_201(201,"对象创建成功"),
    E_202(202,"请求已经被接受"),
    E_400(400,"参数列表错误（缺少，格式不匹配）"),
    E_401(401,"未授权"),
    E_403(403,"访问受限，授权过期"),
    E_404(404,"资源，服务未找到"),
    E_500(404,"服务异常");

    private Integer Code;
    private String Msg;
    ErrorEnum(Integer Code, String Msg) {
        this.Code = Code;
        this.Msg = Msg;
    }
    public Integer getCode() {
        return Code;
    }
    public String getMsg() {
        return Msg;
    }
}