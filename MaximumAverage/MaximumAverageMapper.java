import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MaximumAverageMapper extends
		Mapper<Object, Text, Text, FloatWritable> {

	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		String [] a = line.split(" ");
		System.out.println(line);
		int sum=0;
		for(String i:a){
			sum += Integer.parseInt(i);
		}
		float avg = sum/a.length;
		System.out.println(avg);
		context.write(new Text("maxavg"),new FloatWritable(avg) );
		
	}

}
