import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.log4j.BasicConfigurator;


public class reading{
	public static void main(String[] args) throws IOException{
		
		String uri = "hdfs://localhost:9000/aag.txt";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		
		FSDataInputStream in = null;
		in = fs.open(new Path(uri));
		try{
			IOUtils.copyBytes(in, System.out, 4096, false);
		}
		finally{
			IOUtils.closeStream(in);
		}

	
	}
}
