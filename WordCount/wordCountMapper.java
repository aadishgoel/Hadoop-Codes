import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class wordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

	private final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {

		StringTokenizer itr = new StringTokenizer(value.toString());
		while(itr.hasMoreTokens()){
			word.set(itr.nextToken());
			context.write(word, one);
		}
		
		
	}

}
