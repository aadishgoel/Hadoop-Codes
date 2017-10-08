import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;


public class listing {
	public static void main(String[] args) throws IOException{
		
		String uri = "hdfs://localhost:9000/";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		
		FileStatus[] files= fs.listStatus(new Path(uri));
		
		for(FileStatus file: files){
			System.out.println(file.getPath().getName());
			
			
		}
		
		
		
	}
	
}
