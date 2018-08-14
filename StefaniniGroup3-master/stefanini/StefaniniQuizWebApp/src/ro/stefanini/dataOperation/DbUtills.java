package ro.stefanini.dataOperation;

public class DbUtills {
	public static void closeQuietly(AutoCloseable closeable) {
		if(closeable != null) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
