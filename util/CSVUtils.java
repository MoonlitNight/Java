import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class CSVUtils {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CSVUtils.class);
	
	private static final String COMMA = ",";
	
	private static final String DEFAULT_CHARSET = "GBK";
	
	private static final String FILE_SUFFIX = ".csv";
	
	private static final String EMPTY = "";
	
	/**
	 * 
	 * @param data 数据 
	 * @param path 文件路径
	 * @param filename 文件名(不包含后缀)
	 */
	public static boolean write(List<List<String>> data,String path,String filename) {
		Assert.notEmpty(data, "data must not be null or empty.");
		Assert.hasLength(path, "path must not be null.");
		Assert.hasLength(filename, "path must not be null.");
		Boolean result = Boolean.FALSE;
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		String absolutePath = path.concat(filename).concat(FILE_SUFFIX);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(absolutePath), DEFAULT_CHARSET));
			int length = data.size();
			for (int index = 0; index < length; index++) {
				List<String> list = data.get(index);
				int len = list.size();
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < len; i++) {
					String str = list.get(i);
					buffer.append(str==null?EMPTY:str);
					if(i==len-1)
						break;
					buffer.append(COMMA);
				}
				writer.write(buffer.toString());
				if(index==len-1)
					break;
				writer.newLine();
			}
			result = Boolean.TRUE;
		} catch (Exception e) {
			LOGGER.error("csv file write failure",e);
		} finally {
			try {
				if(writer!=null)
					writer.close();
			} catch (IOException e) {
				writer = null;
				LOGGER.error("close OutputStream failure",e);
			}
		}
		return result;
	}
	
}
