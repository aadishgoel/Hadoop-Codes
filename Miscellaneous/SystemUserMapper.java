import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class SystemUserMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	Scanner scan = new Scanner(System.in);
	String[] indate = scan.nextLine().split("-");
	int idate = Integer.parseInt(indate[0]);
	int imonth = Integer.parseInt(indate[1]);
	int iyear = Integer.parseInt(indate[2]);
	
	public void map(Object key, Text line, Context context)
			throws IOException, InterruptedException {
		
		String[] data = line.toString().split(" ");
		String[] outdate = data[1].split("-"); 
		
		int odate = Integer.parseInt(outdate[0]);
		int omonth = Integer.parseInt(outdate[1]);
		int oyear = Integer.parseInt(outdate[2]);
		boolean ans = (oyear>iyear?true:(omonth>imonth?true:(odate>=idate?true:false)));
		if (ans){
			context.write(new Text(data[0]),new IntWritable(1));
		}
		
	}
	
	

}
