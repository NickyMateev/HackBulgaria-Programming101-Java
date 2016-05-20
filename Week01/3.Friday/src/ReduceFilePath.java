
public class ReduceFilePath {

	public static String reduce_file_path(String path) throws Exception {

		if (path.length() == 0) 
			throw new Exception("Invalid path!");
		else if (path.charAt(0) != '/')
			throw new Exception("Invalid path!");
		
		
		StringBuilder result = new StringBuilder();
		int lastSlashIndex = -1;

		for (int i = 0; i < path.length(); i++) {

			if (i != path.length() - 1) {

				if (path.charAt(i) == '.') {

					if (path.charAt(i + 1) == '.') {
						result.delete(lastSlashIndex + 1, result.length());
					}
					  else
						continue;
				} else if (path.charAt(i) == '/') {

					if (path.charAt(i + 1) == '/')
						continue;
					else if (i > 0 && path.charAt(i - 1) == '.')
						continue;
					else
						result.append('/');

				} else // else if it's any other character
					result.append(path.charAt(i));

			} else {

				if (path.charAt(i) == '.')
					continue;
				else
					result.append(path.charAt(i));
			}
			
			if(result.length() > 1)	{
				if(result.charAt(result.length() - 1) == '/' && result.charAt(result.length() - 2) == result.charAt(result.length() - 1))
					result.deleteCharAt(result.length() - 1);
			}
		}

		if(result.charAt(result.length() - 1) == '/' && result.length() > 1)
			result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}

	public static void main(String[] args) throws Exception {

		System.out.println(reduce_file_path("/"));
		System.out.println(reduce_file_path("/srv/../"));
		System.out.println(reduce_file_path("/srv/www/htdocs/wtf/"));
		System.out.println(reduce_file_path("/srv/www/htdocs/wtf"));
		System.out.println(reduce_file_path("/srv/./././././"));
		System.out.println(reduce_file_path("/etc//wtf/"));
		System.out.println(reduce_file_path("/etc/../etc/../etc/../"));
		System.out.println(reduce_file_path("//////////////"));
		System.out.println(reduce_file_path("/../"));
	}

}
