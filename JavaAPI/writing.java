import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;


public class writing {
	public static void main(String[] args) throws IOException{
		String uri="hdfs://localhost:9000/";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		
		FSDataOutputStream out=null;
		out = fs.create(new Path(uri+"hello.txt"));
		out.writeBytes("Hello, World!");
		IOUtils.closeStream(out);
	
	}
}
