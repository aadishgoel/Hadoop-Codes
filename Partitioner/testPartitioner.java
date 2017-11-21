import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class testPartitioner extends
Partitioner<Text, IntWritable> {

	public int getPartition(Text key, IntWritable value, int numReduceTasks){
		
		return value.get()%numReduceTasks ;
	}
	
}
