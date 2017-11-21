import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class testReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int count=0;
		//System.out.println(key.toString());
		for (IntWritable val : values) {
			count+=1;
		}
		context.write(key, new IntWritable(count));
	}

}
