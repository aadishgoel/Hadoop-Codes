import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class putting {

	public static void main(String[] args) throws IOException{
		String uri="hdfs://localhost:9000";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		fs.copyFromLocalFile(new Path(uri+"/haha.txt"), new Path("/home/aadish"));
	
	}
}
