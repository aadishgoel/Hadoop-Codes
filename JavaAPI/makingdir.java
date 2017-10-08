import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class makingdir {
	public static void main(String[] args) throws IOException {
		String uri= "hdfs://localhost:9000/makingdir";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		
		boolean flag = fs.mkdirs(new Path(uri));
		System.out.println(flag);
	}
}
