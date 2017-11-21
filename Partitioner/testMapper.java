import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class testMapper extends Mapper<Object, Text, Text, IntWritable> {

		
	public void map(Object key, Text line, Context context)
			throws IOException, InterruptedException {
		
		String[] data = line.toString().split(" ");
		
		String[] outdate = data[2].split(":"); 
		
		int hour = Integer.parseInt(outdate[0]);
		int minute = Integer.parseInt(outdate[1]);
		int second = Integer.parseInt(outdate[2]);
		int date = Integer.parseInt(data[1].split("-")[0]);
	
		if (hour>=9 && hour<17 || (hour==17 && minute==0 && second==0 )){
			context.write(new Text(data[3]),new IntWritable(date));
			
		}
		
		
	}

}
