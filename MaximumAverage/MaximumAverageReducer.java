import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MaximumAverageReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	public void reduce(Text key, Iterable<FloatWritable> values, Context context)
			throws IOException, InterruptedException {

		float max=0;
		for (FloatWritable val : values) {
			if(val.get()>max){
				max=val.get();
			}
			
		}
		context.write(key, new FloatWritable(max));
	}

}
