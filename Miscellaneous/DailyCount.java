import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DailyCount extends Mapper<Object, Text, Text, IntWritable> {
	public void map(Object key, Text line, Context context)
			throws IOException, InterruptedException {
		
		String[] data = line.toString().split(" ");
		context.write(new Text(data[1]), new IntWritable(1));
			
	}
}
