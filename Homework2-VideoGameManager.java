import java.util.Scanner;
import java.io.*;

public class VideoGameManager {
	
	//private VideoGame[] videogames;
	private GenLL<VideoGame> videogames;
	private GenLL<VideoGame> searchlist;
	
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;
	
	public VideoGameManager() {
		videogames = new GenLL<VideoGame>();
		searchlist = new GenLL<VideoGame>();
	}

	public void addVideoGame(VideoGame aVideoGame) {
		if(aVideoGame == null)
			return;
		videogames.add(aVideoGame);
	}
	
	public void addGameToSearch(VideoGame aVideoGame) {
		if(aVideoGame == null)
			return;
		searchlist.add(aVideoGame);
	}
	
	public void writeVideoGameFile(String aFileName, String aAppend) {
		String append = aAppend;
		boolean appendB = false;
		if(append.equalsIgnoreCase("true"))
			appendB = true;
		
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aFileName, appendB));

			searchlist.reset();
			while(searchlist.hasMore()) {
				VideoGame t = searchlist.getCurrent();
				fileWriter.println(t.getName()+DELIM+t.getConsole());
				searchlist.gotoNext();
			}
			
			fileWriter.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void readVideoGameFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			
			//Read the file
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine(); //read the line
				String[] splitLine = fileLine.split(DELIM); //Split the line
				if(splitLine.length == BODY_FIELD_AMT) { //check the line
					//Process - create a videogame and add it to the array
					String name = splitLine[0];
					String console = splitLine[1];
					
					VideoGame aVideoGame = new VideoGame(name,console);
					this.addVideoGame(aVideoGame);
				}
			}
			fileScanner.close(); //Do not forget this
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printVideoGames() {
		videogames.print();
	}
	
	public void printSearchList() {
		searchlist.print();
	}
	
	
	public void searchByGame(String aGameName, String aConsoleName) {
		//System.out.println("ConsoleName"+aConsoleName);
		String gameName = aGameName;
		String consoleName = aConsoleName;
		
		if(gameName == null || consoleName == null) {
			return;
		}
		//System.out.println(gameName+" "+consoleName);
		
		videogames.reset(); //Sets current to head
		
		while(videogames.hasMore()) {
			//No WildCard
			if(videogames.getCurrent().getName().toLowerCase().contains(gameName.toLowerCase()) && 
					videogames.getCurrent().getConsole().toLowerCase().contains(consoleName.toLowerCase())) {
				System.out.println(videogames.getCurrent());
				this.addGameToSearch(videogames.getCurrent());
			}
			
			//WildCard in gameName
			else if(gameName.equals("*") && videogames.getCurrent().getConsole().toLowerCase().contains(consoleName.toLowerCase())) {
				System.out.println(videogames.getCurrent());
				this.addGameToSearch(videogames.getCurrent());
			}
			
			//WildCard in consoleName
			else if (videogames.getCurrent().getName().toLowerCase().contains(gameName.toLowerCase()) && consoleName.equals("*")) {
				System.out.println(videogames.getCurrent());
				this.addGameToSearch(videogames.getCurrent());
			}
			else if(consoleName.equals("*") && gameName.equals("*")) {
				System.out.println(videogames.getCurrent());
				this.addGameToSearch(videogames.getCurrent());
			}
			
			videogames.gotoNext();
		}
	}
}
