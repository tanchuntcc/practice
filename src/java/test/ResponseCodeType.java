package test;

/**
 * description
 * 返回数据编码类型
 *
 * @author liquan.teng@hand-china.com
 * @date 2019/10/16
 */
public enum ResponseCodeType {
    RESPONSE_300001(300001L, "跨服务异常", ""),
    RESPONSE_200001(200001L, "当前登录没有租户权限", "租户操作权限"),
    RESPONSE_200002(200002L, "组织编码只允许字母或者数字，请检查", ""),
    RESPONSE_200003(200003L, "组织编码最多15个字符", ""),
    RESPONSE_200004(200004L, "组织名称最多15个字符", ""),
    RESPONSE_200005(200005L, "组织描述最多30个字符", ""),
    RESPONSE_200006(200006L, "组织的上层组织不能是自己", ""),
    RESPONSE_200007(200007L, "组织编码不能为空", ""),
    RESPONSE_200008(200008L, "组织名称不能为空", ""),
    RESPONSE_200009(200009L, "该组织下有子组织，无法失效", ""),
    RESPONSE_200010(200010L, "岗位编码只允许字母或者数字，请检查", ""),
    RESPONSE_200011(200011L, "岗位编码最多15个字符", ""),
    RESPONSE_200012(200012L, "岗位名称最多15个字符", ""),
    RESPONSE_200013(200013L, "岗位描述最多30个字符", ""),
    RESPONSE_200014(200014L, "组织名称为必填", ""),
    RESPONSE_200015(200015L, "岗位的上层岗位不能是自己", ""),
    RESPONSE_200016(200016L, "岗位编码不能为空", ""),
    RESPONSE_200017(200017L, "岗位名称不能为空", ""),
    RESPONSE_200018(200018L, "该岗位下有子岗位，无法停用", ""),
    RESPONSE_200019(200019L, "岗位不存在", ""),
    RESPONSE_200020(200020L, "组织不存在", ""),
    RESPONSE_200022(200022L, "成员编码为空", ""),
    RESPONSE_200023(200023L, "成员姓名为空", ""),
    RESPONSE_200024(200024L, "邮箱与联系电话为空", ""),
    RESPONSE_200025(200025L, "成员状态为空", ""),
    RESPONSE_200026(200026L, "成员类型为空", ""),
    RESPONSE_200027(200027L, "性别为空", ""),
    RESPONSE_200028(200028L, "邮箱格式不正确", ""),
    RESPONSE_200029(200029L, "成员编码不符合规则", ""),
    RESPONSE_200030(200030L, "成员编码已存在", ""),
    RESPONSE_200031(200031L, "联系电话长度不符合", ""),
    RESPONSE_200032(200032L, "登录名已存在", ""),
    RESPONSE_200033(200033L, "手机号在该租户下已存在", ""),
    RESPONSE_200034(200034L, "日期格式不符合要求", ""),
    RESPONSE_200035(200035L, "证件类型不存在", ""),
    RESPONSE_200036(200036L, "性别类型不存在", ""),
    RESPONSE_200037(200037L, "成员类型不存在", ""),
    RESPONSE_200038(200038L, "成员状态不存在", ""),
    RESPONSE_200039(200039L, "公司名称不存在", ""),
    RESPONSE_200040(200040L, "邮箱地址在该租户下已存在", ""),
    RESPONSE_200041(200041L, "当前扩展字段不存在", ""),
    RESPONSE_200042(200042L, "成员邀请状态格式错误", ""),
    RESPONSE_200043(200043L, "成员姓名字数超出", ""),
    RESPONSE_200044(200044L, "账户插入失败", ""),
    RESPONSE_200045(200045L, "成员编码数据重复", ""),
    RESPONSE_200046(200046L, "项目不存在", ""),
    RESPONSE_200047(200047L, "项目下组不存在", ""),
    RESPONSE_210001(210001L, "数据来源异常", ""),
    RESPONSE_210002(210002L, "客户唯一标识为空", ""),
    RESPONSE_210003(210003L, "客户名称姓名为空", ""),
    RESPONSE_210004(210004L, "门店代码为空", ""),
    RESPONSE_210005(210005L, "个人客户编码重复", ""),
    RESPONSE_210006(210006L, "门店代码数据重复", ""),
    RESPONSE_210007(210007L, "客户编码不符合规则", ""),
    RESPONSE_210008(210008L, "邮箱不符合规则", ""),
    RESPONSE_210009(210009L, "客户编码在该租户下已存在", ""),
    RESPONSE_210010(210010L, "手机号在该租户下已存在", ""),
    RESPONSE_210011(210011L, "邮箱地址在该租户下已存在", ""),
    RESPONSE_210012(210012L, "客户编码在该租户下已存在", ""),
    RESPONSE_210013(210013L, "未配置扩展字段", ""),

    RESPONSE_200001X(200001L,"传入数据为空",""),
    RESPONSE_200002X(200002L,"项目编码不能为空",""),
    RESPONSE_200003X(200003L,"组编码不能为空",""),
    RESPONSE_200004X(200004L,"人员编码不能为空",""),
    RESPONSE_200005X(200005L,"项目在租户下不存在",""),
    RESPONSE_200006X(200006L,"人员在租户下不存在",""),
    RESPONSE_200007X(200007L,"组在项目下不存在","");

    //错误代码
    private Long code;
    //错误码含义
    private String value;
    //描述说明
    private String description;

    public static ResponseCodeType getByType(String type) {
        for (ResponseCodeType responseCodeType : ResponseCodeType.values()) {
            if (responseCodeType.toString().equals(type)) {
                return responseCodeType;
            }
        }
        return null;
    }
    public static ResponseCodeType getValueByCode(String type) {
        for (ResponseCodeType responseCodeType : ResponseCodeType.values()) {
            if (responseCodeType.getCode().toString().equals(type)) {
                return responseCodeType;
            }
        }
        return null;
    }


    ResponseCodeType(Long code, String value, String description) {
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
