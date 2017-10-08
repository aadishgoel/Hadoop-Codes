import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import sun.nio.ch.IOUtil;


public class all {
	public static void main(String[] args) throws IOException {
		Scanner scan= new Scanner(System.in);
		String uri="hdfs://localhost:9000";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri),conf);
		
		fs.mkdirs(new Path(uri+"/Aadish/MyWork"));
		fs.copyFromLocalFile(new Path("/home/aadish/haha.txt"),new Path(uri+"/Aadish/MyWork/"));
		FSDataInputStream in = null;
		FSDataOutputStream out =  fs.create(new Path(uri+"/hdfs_data.txt"));
		in = fs.open(new Path(uri+"/Aadish/MyWork/haha.txt"));
		
		try{
			IOUtils.copyBytes(in, System.out, conf);
			int n = scan.nextInt();
			for(int i=1;i<=10;i++)	out.writeBytes(n+" x "+i+" = "+(n*i)+"\n");
		}
		finally{
			IOUtils.closeStream(in);
			IOUtils.closeStream(out);
		}
		
	}
}
