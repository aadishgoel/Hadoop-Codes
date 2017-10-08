import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MaxTempMapper extends Mapper<Object, Text, Text, FloatWritable> {

	public void map(Object ikey, Text ivalue, Context context)
			throws IOException, InterruptedException {
		
		String line = ivalue.toString();
		
		if (!(line.length()==0)){
			String year = line.substring(6, 10);
			float avg = Float.parseFloat(line.substring(54,62).trim());
			context.write(new Text(year),new FloatWritable(avg));
			
		}
		

	}

}
