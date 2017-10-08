import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.tools.GetConf;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
import org.apache.hadoop.mapreduce.lib.map.TokenCounterMapper;;

public class countingDriver {
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf= new Configuration();
		Job job = Job.getInstance(conf, "countword");
		
		
		job.setMapperClass(TokenCounterMapper.class);
		job.setReducerClass(IntSumReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		if(!job.waitForCompletion(false))
			return;
			
	}
}
