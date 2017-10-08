 import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MaxTempReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	public void reduce(Text key, Iterable<FloatWritable> values, Context context)
			throws IOException, InterruptedException {
		
		float max = 0;
		
		for(FloatWritable value:values ){
	
			if(max < value.get()){
				max=value.get();
				
			}
			
		}
		
		context.write(key, new FloatWritable(max));
		
	}

}
