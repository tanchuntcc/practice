package test;

import java.util.List;

/**
 * @author 谭春
 * Date: 2020/2/10
 * Description:
 */
public class ResultInfo {
    private List<String> messages;
    private Boolean result;
    private List<RegReturn> regReturn;
    private List<PartsRet> partsRet;
    private List<AnalysisRet> analysisRet;

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }


    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public void setRegReturn(List<RegReturn> regReturn) {
        this.regReturn = regReturn;
    }

    public List<RegReturn> getRegReturn() {
        return regReturn;
    }

    public List<PartsRet> getPartsRet() {
        return partsRet;
    }

    public void setPartsRet(List<PartsRet> partsRet) {
        this.partsRet = partsRet;
    }

    public List<AnalysisRet> getAnalysisRet() {
        return analysisRet;
    }

    public void setAnalysisRet(List<AnalysisRet> analysisRet) {
        this.analysisRet = analysisRet;
    }
}

