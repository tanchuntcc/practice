package test;

/**
 * @author 谭春
 * Date: 2020/4/22
 * Description:
 */
public enum ItsmExceptionCode {

    EXCEPTION_CODE1(200001L, "传入数据为空", ""),
    EXCEPTION_CODE2(200002L, "项目编码不能为空", ""),
    EXCEPTION_CODE3(200003L, "组编码不能为空", ""),
    EXCEPTION_CODE4(200004L, "人员编码不能为空", ""),
    EXCEPTION_CODE5(200005L, "项目在租户下不存在", ""),
    EXCEPTION_CODE6(200006L, "人员在租户下不存在", ""),
    EXCEPTION_CODE7(200007L, "组在项目下不存在", "");

    //错误代码
    private Long code;
    //错误码含义
    private String value;
    //描述说明
    private String description;

    public static ItsmExceptionCode getValueByCode(String type) {
        for (ItsmExceptionCode ItsmExceptionCode : ItsmExceptionCode.values()) {
            if (ItsmExceptionCode.getCode().toString().equals(type)) {
                return ItsmExceptionCode;
            }
        }
        return null;
    }

    ItsmExceptionCode(Long code, String value, String description) {
        this.code = code;
        this.value = value;
        this.description = description;
    }

    public Long getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}

