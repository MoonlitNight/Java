
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

/**
 * <p>货币格式化标签</p>
 * <p>默认以当前语言环境格式化货币单位，保留两位小数点</p>
 * <table border="1">
 * <tr><th style="border:0">语言环境</th><th style="border:0">代码</th></tr>
 * <tr><td style="border:0">中国</td><td style="border:0">zh_CN</td></tr>
 * <tr><td style="border:0">美国</td><td style="border:0">en_US</td></tr>
 * <tr><td style="border:0">印尼</td><td style="border:0">in_ID</td></tr>
 * </table>
 * <p>更多地理位置详见{@link java.util.Locale#getAvailableLocales()}</p>
 * @author jin.wang
 *
 */
public class CurrencyFormatTag extends TagSupport{

    /**
     * 
     */
    private static final long serialVersionUID = -2033612850884089170L;
    
    private static final Log LOGGER = LogFactory.getLog(CurrencyFormatTag.class);
    
    private static final String BLANK=" ";
    
    private static final String COMMA=".";
    
    private static final String INDONESIA="in_ID";
    
    /**
     * 默认保留两位小数
     */
    private static final int DEFAULT_FRACTION = 2;

    private String value;
    
    /**
     * 语言环境
     */
    private String locale;
    
    /**
     * 小数位
     */
    private int fraction = DEFAULT_FRACTION;
    
    @Override
    public int doStartTag() throws JspException{
        Locale currentLocale = locale==null?pageContext.getRequest().getLocale():StringUtils.parseLocaleString(locale);
        NumberFormat currencyFormat = NumberFormat.getNumberInstance(currentLocale);
        currencyFormat.setMaximumFractionDigits(fraction);
        String str = currencyFormat.format(new BigDecimal(value));
        String symbol = currencyFormat.getCurrency().getSymbol(currentLocale);
        //对印度尼西亚盾特殊处理
        str = INDONESIA.equals(currentLocale.toString())?symbol.concat(COMMA).concat(BLANK).concat(str):symbol.concat(str);
        try{
            pageContext.getOut().write(str);
        }catch (IOException e){
            LOGGER.error("write result error.", e);
        }
        return SKIP_BODY;
    }
    
    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getLocale(){
        return locale;
    }

    public void setLocale(String locale){
        this.locale = locale;
    }
    
    public int getFraction(){
        return fraction;
    }
    
    public void setFraction(int fraction){
        this.fraction = fraction;
    }
    
}
